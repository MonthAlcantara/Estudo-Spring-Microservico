package io.github.monthalcantara.hrpayroll.controller;

import io.github.monthalcantara.hrpayroll.model.Payment;
import io.github.monthalcantara.hrpayroll.model.WorkerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    /*
    * hr-worker.host foi a variável criada no applicattion.properties informando a url base da aplicação a qual será feita a requisição
    * com @Value, o valor da variável é colocada em workerHost
    * */
    @Value("${hr-worker.host}")
    private String workerHost;

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity findPayment(@PathVariable("id") Long id,
                                      @PathVariable("days") @PositiveOrZero @Max(31) Integer days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", id.toString());
        /*
        *Como será feito um Get, foi usado o método getForObject passando a url base declarada no application properties
        * concatenado com o restante da url mais o id. O id poderia ter sido concatenado com + id (aproveitando o próprio id passado no path
        * porém foi usada outra abordagem onde foi utilizado um mapa para fazer a interpolação com o {id} da url, sen necessario passar no
        * getForObject, no ultimo parametro, de onde seria tirado os dados para a interpolaçãoa. caso fosse feito da outra forma
        * apenas a url e o tipo da Classe esperada na resposta seria informado.
        * */
        WorkerResponse response = restTemplate.getForObject(workerHost + "/workers/{id}", WorkerResponse.class, uriVariables);
        return ResponseEntity.ok(new Payment(response.getName(), response.getDailyIncome(), days));
    }
}

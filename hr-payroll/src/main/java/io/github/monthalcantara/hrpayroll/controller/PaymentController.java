package io.github.monthalcantara.hrpayroll.controller;

import io.github.monthalcantara.hrpayroll.feignclients.WorkerFeignClient;
import io.github.monthalcantara.hrpayroll.model.Payment;
import io.github.monthalcantara.hrpayroll.model.WorkerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;

//3
@Validated
@RestController
@RequestMapping("/payments")
public class PaymentController {

    //1
    @Autowired
    private WorkerFeignClient feignClient;

    //1
    @GetMapping("/{id}/days/{days}")
    public ResponseEntity<Payment> findPayment(@PathVariable("id") Long id,
                                               @PathVariable("days") @PositiveOrZero @Max(31) Integer days) {
        /*
         *  O findById retorna um ResponseEntity<WorkerResponse>. O corpo do ResponseEntity contém o Objeto WorkerResponse
         * Dessa forma para pegar o objeto e atribuir a variável response, utilizei o getBody
         * */
        //1
        WorkerResponse response = feignClient.findById(id).getBody();
        return new ResponseEntity<Payment>(new Payment(response.getName(), response.getDailyIncome(), days), HttpStatus.OK);
    }
}

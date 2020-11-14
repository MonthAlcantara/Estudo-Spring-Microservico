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

    @Value("${hr-worker.host}")
    private String workerHost;

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity findPayment(@PathVariable("id") Long id,
                                      @PathVariable("days") @PositiveOrZero @Max(31) Integer days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", id.toString());
        WorkerResponse response = restTemplate.getForObject(workerHost + "/workers/{id}", WorkerResponse.class, uriVariables);
        return ResponseEntity.ok(new Payment(response.getName(), response.getDailyIncome(), days));
    }

    //teste commit merge
}

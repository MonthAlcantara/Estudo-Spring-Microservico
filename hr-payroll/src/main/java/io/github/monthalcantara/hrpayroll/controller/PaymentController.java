package io.github.monthalcantara.hrpayroll.controller;

import io.github.monthalcantara.hrpayroll.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Validated
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping("/{id}/days/{days}")
    public ResponseEntity findPayment(@PathVariable("id") Long id,
                                      @PathVariable("days") @PositiveOrZero @Max(31) Integer days) {
        return ResponseEntity.ok(new Payment("Bob", BigDecimal.valueOf(300.00), days));
    }

}

package io.github.monthalcantara.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// @RibbonClient(name="hr-payroll") Como o Eureka ja possui balanceamento de Carga, não preciso mais utilizar o Ribbon
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrPayrollApplication.class, args);
    }

}

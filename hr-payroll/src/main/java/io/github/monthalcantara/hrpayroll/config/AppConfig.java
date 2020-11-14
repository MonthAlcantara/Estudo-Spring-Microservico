package io.github.monthalcantara.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    /*
    * Dessa forma o Spring poderá gerir e injetar o restTemplate na minha aplicação
    * */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

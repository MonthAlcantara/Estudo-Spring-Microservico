package io.github.monthalcantara.hrpayroll.feignclients;

import io.github.monthalcantara.hrpayroll.model.WorkerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker",  path = "/workers")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<WorkerResponse> findById(@PathVariable("id") Long id);

}

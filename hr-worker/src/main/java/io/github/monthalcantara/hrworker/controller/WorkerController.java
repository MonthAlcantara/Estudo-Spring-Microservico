package io.github.monthalcantara.hrworker.controller;

import io.github.monthalcantara.hrworker.dto.response.WorkerResponse;
import io.github.monthalcantara.hrworker.model.Worker;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

//3
@RestController
@RequestMapping("/workers")
public class WorkerController {

    @PersistenceContext
    private EntityManager manager;

    public WorkerController(EntityManager manager) {
        this.manager = manager;
    }

    @GetMapping
    public ResponseEntity findAll() {
        Query query = manager.createQuery("select w from Worker w");
        //1
        List<Worker> list = query.getResultList();
        //2
        List<WorkerResponse> listResponse = list.stream().map(w -> w.toResponse()).collect(Collectors.toList());
        return ResponseEntity.ok(listResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Worker worker = manager.find(Worker.class, id);
        //1
        Assert.isTrue(worker != null, "Resource not found");
        return ResponseEntity.ok(worker.toResponse());
    }

}

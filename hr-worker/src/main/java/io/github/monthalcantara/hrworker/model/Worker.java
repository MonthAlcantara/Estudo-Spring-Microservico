package io.github.monthalcantara.hrworker.model;

import io.github.monthalcantara.hrworker.dto.response.WorkerResponse;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

//1
@Entity
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal dailyIncome;

    @Deprecated
    public Worker() {
    }

    public Worker(String name, BigDecimal dailyIncome) {
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    //1
    public WorkerResponse toResponse() {
        return new WorkerResponse(this.name, this.dailyIncome);
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id.equals(worker.id) &&
                name.equals(worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

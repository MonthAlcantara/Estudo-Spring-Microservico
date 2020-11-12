package io.github.monthalcantara.hrworker.dto.request;

import io.github.monthalcantara.hrworker.model.Worker;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

//1
public class WorkerRequest implements Serializable {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal dailyIncome;

    @Deprecated
    public WorkerRequest() {
    }

    public WorkerRequest(@NotBlank String name, @NotNull BigDecimal dailyIncome) {
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    //1
    public Worker toModel() {
        return new Worker(this.name, this.dailyIncome);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(BigDecimal dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}

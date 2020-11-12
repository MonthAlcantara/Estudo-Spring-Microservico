package io.github.monthalcantara.hrworker.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;

public class WorkerResponse implements Serializable {

    private String name;

    private BigDecimal dailyIncome;

    @Deprecated
    public WorkerResponse() {
    }

    public WorkerResponse(String name, BigDecimal dailyIncome) {
        this.name = name;
        this.dailyIncome = dailyIncome;
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

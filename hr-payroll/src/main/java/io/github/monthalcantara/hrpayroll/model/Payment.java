package io.github.monthalcantara.hrpayroll.model;

import org.springframework.util.Assert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

public class Payment implements Serializable {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal dailyIncome;

    @PositiveOrZero
    @Max(31)
    private Integer days;

    @Deprecated
    public Payment() {
    }

    public Payment(@NotBlank String name, @NotNull BigDecimal dailyIncome, @PositiveOrZero @Max(31) Integer days) {
        Assert.isTrue(days >= 0, "The number of days cannot be negative");
        Assert.isTrue(days < 31, "The number of days cannot be greater than 31");
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }

    public BigDecimal getTotal() {
        return this.dailyIncome.multiply(BigDecimal.valueOf(this.days));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDailyIncome() {
        return dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

}

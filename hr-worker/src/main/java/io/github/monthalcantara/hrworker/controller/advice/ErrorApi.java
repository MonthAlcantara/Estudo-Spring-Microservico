package io.github.monthalcantara.hrworker.controller.advice;

import java.util.List;

public class ErrorApi {

    private List<String> errors;

    public ErrorApi(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

package io.github.monthalcantara.hrworker.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorApi illegalArgumentExceptionHandle(IllegalArgumentException e){
        return new ErrorApi(Arrays.asList(e.getMessage()));
    }
}

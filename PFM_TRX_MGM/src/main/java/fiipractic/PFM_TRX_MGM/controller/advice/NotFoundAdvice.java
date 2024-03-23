package fiipractic.PFM_TRX_MGM.controller.advice;

import fiipractic.PFM_TRX_MGM.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String badRequestHandler(NotFoundException ex) {
        return ex.getMessage();
    }
}

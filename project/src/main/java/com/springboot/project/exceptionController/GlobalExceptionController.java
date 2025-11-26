package com.springboot.project.exceptionController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import com.springboot.project.costomException.ProductException;
import com.springboot.project.costomException.ProductIsNotAvailable;

@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(ProductIsNotAvailable.class)
    public ResponseEntity<ProductException> productIsNotAvailable(ProductIsNotAvailable ex) {
        System.out.println("ProductIsNotAvailable exception handled globally.");
        ProductException productException = new ProductException();
        productException.setMessage(ex.getMessage());
        System.out.println(ex.getMessage());
        productException.setStatusCode("404");
        return new ResponseEntity<ProductException>(productException, HttpStatus.NOT_FOUND);
    }

}

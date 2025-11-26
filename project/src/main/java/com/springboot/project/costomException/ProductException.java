package com.springboot.project.costomException;

public class ProductException {
    private String message;
    private String statusCode;

    public void setMessage(String message) {
        this.message = message;
    }  
    public String getMessage() {
        return message;
    }
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    public String getStatusCode() {
        return statusCode;

    }
}
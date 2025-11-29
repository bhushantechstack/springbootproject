package com.springboot.project.costomException;

public class MultipleProductFoundWithThisName extends RuntimeException {
    public MultipleProductFoundWithThisName(String message) {
        super(message);
    }

}

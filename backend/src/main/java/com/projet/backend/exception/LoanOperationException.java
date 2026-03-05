package com.projet.backend.exception;

public class LoanOperationException extends RuntimeException {
    public LoanOperationException(String message) {
        super(message);
    }
}

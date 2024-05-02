package org.example.inventorymanagementsystem.exceptions;

public class InvalidTransactionIdException extends RuntimeException{
    public InvalidTransactionIdException(String message) {
        super(message);
    }
}

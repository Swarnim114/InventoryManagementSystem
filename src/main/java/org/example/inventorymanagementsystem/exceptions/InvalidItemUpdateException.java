package org.example.inventorymanagementsystem.exceptions;

public class InvalidItemUpdateException extends RuntimeException{
    public InvalidItemUpdateException(String message) {
        super(message);
    }
}

package com.example.kyrgyzpatentbackend.db.exceptions;

public class BadCredentialException extends RuntimeException {
    public BadCredentialException(){
    }
    public BadCredentialException(String message){
    super(message);
    }
}
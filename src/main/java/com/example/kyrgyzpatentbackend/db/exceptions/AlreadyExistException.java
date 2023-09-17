package com.example.kyrgyzpatentbackend.db.exceptions;

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(){

    }
    public AlreadyExistException(String message ){
    super(message);
    }
}

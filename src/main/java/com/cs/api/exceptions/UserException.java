package com.cs.api.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends RuntimeException{

    private final int status;

    public UserException(int status , String message){
        super(message);
        this.status = status;
    }
}
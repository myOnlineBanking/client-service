package com.cs.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorClass {

    private int status;
    private String error;
    private String path;

}

package com.cs.api.entity;

import lombok.Data;

@Data
public class Recipient {
    private String groupName;
    private String accountNumber;
    private String name;
    private String phone;
    private String email;
    private String salary;
}

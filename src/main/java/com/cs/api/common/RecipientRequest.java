package com.cs.api.common;

import lombok.Data;

@Data
public class RecipientRequest {
    private String groupName;
    private String accountNumber;
    private String name;
    private String phone;
    private String email;
    private String salary;
    private String userId;
}

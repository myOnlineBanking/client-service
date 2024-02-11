package com.cs.api.mapper;


import com.cs.api.common.RecipientRequest;
import com.cs.api.entity.Recipient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipientMapper {

    public RecipientRequest map(Recipient recipient) {

        RecipientRequest recipientRequest = new RecipientRequest();
        recipientRequest.setPhone(recipient.getPhone());
        recipientRequest.setEmail(recipient.getEmail());
        recipientRequest.setAccountNumber(recipient.getAccountNumber());
        recipientRequest.setGroupName(recipient.getGroupName());
        recipientRequest.setName(recipient.getName());
        recipientRequest.setSalary(recipient.getSalary());

        return recipientRequest;
    }

    public Recipient map(RecipientRequest recipientRequest) {

        Recipient recipient = new Recipient();

        recipient.setPhone(recipientRequest.getPhone());
        recipient.setEmail(recipientRequest.getEmail());
        recipient.setAccountNumber(recipientRequest.getAccountNumber());
        recipient.setGroupName(recipientRequest.getGroupName());
        recipient.setName(recipientRequest.getName());
        recipient.setSalary(recipientRequest.getSalary());

        return recipient;
    }
    public List<RecipientRequest> map(List<Recipient> recipients) {

        return  recipients
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public List<Recipient> toMap(List<RecipientRequest> recipientRequests) {

        return  recipientRequests
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
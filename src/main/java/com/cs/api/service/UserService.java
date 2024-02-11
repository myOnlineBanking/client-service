package com.cs.api.service;

import com.cs.api.common.AccountRequest;
import com.cs.api.common.RecipientRequest;
import com.cs.api.entity.Recipient;
import com.cs.api.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface UserService  extends Serializable {

    User getUser(String id);

    boolean enableOrDisableUser(String id, boolean block);

    User addCompteToUser(AccountRequest accountRequest);

    List<User> getUsers();

    User updateUser(User user);

    Recipient addRecipient(RecipientRequest recipientRequest);

    Set<Recipient> getUserRecipients(String userId);
}

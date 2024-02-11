package com.cs.api.service;

import com.cs.api.common.AccountRequest;
import com.cs.api.common.RecipientRequest;
import com.cs.api.entity.Recipient;
import com.cs.api.entity.User;
import com.cs.api.exceptions.UserException;
import com.cs.api.mapper.RecipientMapper;
import com.cs.api.repository.UserRepository;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipientMapper recipientMapper;

    public User getUser(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean enableOrDisableUser(String id, boolean block) {
        User user = userRepository.findById(id).get();
        user.setEnabled(block ? false : true);
        userRepository.save(user);
        return user.isEnabled();
    }

    @Override
    @Transactional
    public User addCompteToUser(AccountRequest accountRequest) {

        User user = getUser(accountRequest.getUserId());
        if (user != null) {
            user.getAccounts().add(accountRequest.getAccountId());
            return userRepository.save(user);
        }
        return null;

    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        existingUser.setEnabled(user.isEnabled());
        existingUser.setAddress(user.getAddress());
        existingUser.setBirthday(user.getBirthday());
        existingUser.setCin(user.getCin());
        existingUser.setAgencyId(user.getAgencyId());
        existingUser.setDeleted(user.isDeleted());
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setPhone(user.getPhone());

        return userRepository.save(existingUser);
    }

    @Override
    public Recipient addRecipient(RecipientRequest recipientRequest) {
        try {
            User user = userRepository.findById(recipientRequest.getUserId()).orElse(null);
            Objects.requireNonNull(user).getRecipients().add(recipientMapper.map(recipientRequest));
            userRepository.save(user);
            return recipientMapper.map(recipientRequest);
        } catch (Exception e) {
            throw new UserException(HttpStatus.SC_FORBIDDEN, e.getMessage());
        }
    }

    @Override
    public Set<Recipient> getUserRecipients(String userId) {
        try {
            User user = userRepository.findById(userId).orElse(null);
            return Objects.requireNonNull(user).getRecipients();

        } catch (Exception e) {
            throw new UserException(HttpStatus.SC_FORBIDDEN, e.getMessage());
        }
    }
}

package com.cs.api.controller;

import java.util.List;
import java.util.Set;

import com.cs.api.common.AccountRequest;
import com.cs.api.common.RecipientRequest;
import com.cs.api.entity.Recipient;
import com.cs.api.entity.User;
import com.cs.api.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

   @Autowired
   private UserServiceImpl userServiceImpl;


   @GetMapping()
   public List<User> getUsers() {
      return userServiceImpl.getUsers();
   }

   @GetMapping(value = "/{id}")
   public User getUser(@PathVariable(value = "id", required = true) String id) {
      return userServiceImpl.getUser(id);
   }

   @PutMapping(value = "/{id}/activer")
   public boolean enableUser(@PathVariable(value = "id", required = true) String id) {
      return userServiceImpl.enableOrDisableUser(id, false);
   }

   @PutMapping(value = "/{id}/disactiver")
   public boolean disableUser(@PathVariable(value = "id", required = true) String id) {
      return userServiceImpl.enableOrDisableUser(id, true);
   }

   @PutMapping(value = "/update")
   public User updateUser(@RequestBody User user) {
      return userServiceImpl.updateUser(user);
   }

   @PostMapping(value = "/comptes")
   public User addCompteToUser(@RequestBody AccountRequest accountRequest  )  {
      return userServiceImpl.addCompteToUser(accountRequest);
   }

   @PostMapping(value = "/addRecipient")
   public Recipient addRecipient(@RequestBody RecipientRequest recipientRequest )  {
      return userServiceImpl.addRecipient(recipientRequest);
   }

   @GetMapping(value = "/getUserRecipients")
   public Set<Recipient> getUserRecipients(@RequestParam String userId )  {
      return userServiceImpl.getUserRecipients(userId);
   }
}

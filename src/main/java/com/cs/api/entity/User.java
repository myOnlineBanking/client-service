package com.cs.api.entity;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  private boolean isDeleted = false;
  private boolean isEnabled = false;

  private String firstname;
  private String lastname;
  private String phone;
  private String address;
  private String cin;
  private String birthday;
  private String agencyId;
  private Set<Recipient> recipients =  new HashSet<>() ;;


  private Set<String> accounts = new HashSet<>() ;

}
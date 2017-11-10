package com.rf.learning.mongodbspringbootapp.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User
{
  @Id
  private String id;
  private String name;
  private String email;
  private boolean disabled;

  public User()
  {
  }

  public User(String id, String name, String email, boolean disabled)
  {
    this.id = id;
    this.name = name;
    this.email = email;
    this.disabled = disabled;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public boolean isDisabled()
  {
    return disabled;
  }

  public void setDisabled(boolean disabled)
  {
    this.disabled = disabled;
  }
}

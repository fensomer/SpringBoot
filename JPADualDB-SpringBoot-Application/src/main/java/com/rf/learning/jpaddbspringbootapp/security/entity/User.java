package com.rf.learning.jpaddbspringbootapp.security.entity;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  private boolean disabled = false;

  public User()
  {
  }

  public User(Integer id, String name, String email, boolean disabled)
  {
    this.id = id;
    this.name = name;
    this.email = email;
    this.disabled = disabled;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
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

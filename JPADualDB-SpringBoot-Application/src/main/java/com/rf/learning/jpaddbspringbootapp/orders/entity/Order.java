package com.rf.learning.jpaddbspringbootapp.orders.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false, name = "cust_name")
  private String customerName;

  @Column(nullable = false, name = "cust_email")
  private String customerEmail;

  public Order() {}

  public Order(Integer id, String customerName, String customerEmail)
  {
    this.id = id;
    this.customerName = customerName;
    this.customerEmail = customerEmail;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getCustomerName()
  {
    return customerName;
  }

  public void setCustomerName(String customerName)
  {
    this.customerName = customerName;
  }

  public String getCustomerEmail()
  {
    return customerEmail;
  }

  public void setCustomerEmail(String customerEmail)
  {
    this.customerEmail = customerEmail;
  }
}

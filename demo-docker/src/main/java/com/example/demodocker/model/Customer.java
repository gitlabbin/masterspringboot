package com.example.demodocker.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Employee. ")
public class Customer {

  @ApiModelProperty(notes = "The customer ID")
  private int id;

  @ApiModelProperty(notes = "The customer name")
  private String name;

  public Customer(int id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}

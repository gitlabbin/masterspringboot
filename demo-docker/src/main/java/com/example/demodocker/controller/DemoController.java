package com.example.demodocker.controller;

import com.example.demodocker.model.Customer;
import io.swagger.annotations.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Api(
    value = "IDM Management System",
    description = "Operations pertaining to employee in IDM Management System")
public class DemoController {

  @ApiOperation(
      value = "View a list of available customer",
      response = List.class,
      authorizations = {@Authorization(value = "apiKey")})
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
      })
  @GetMapping("/customers")
  public List<Customer> findAll() {
    List<Customer> customerList = new ArrayList<Customer>();
    customerList.add(new Customer(1, "frank"));
    customerList.add(new Customer(2, "john"));
    return customerList;
  }

  @ApiOperation(
      value = "Add new customer",
      response = Customer.class,
      authorizations = {@Authorization(value = "apiKey")})
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
      })
  @PostMapping("/customer")
  public Customer addCustomer(Customer customer) {
    return new Customer(3, "Albert");
  }

  @ApiOperation(
      value = "Update customer",
      response = Customer.class,
      authorizations = {@Authorization(value = "apiKey")})
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
      })
  @PutMapping("/customer")
  public Customer updateCustomer(Customer customer) {
    return customer;
  }

  @ApiOperation(
      value = "Delete customer",
      response = String.class,
      authorizations = {@Authorization(value = "apiKey")})
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(
            code = 403,
            message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
      })
  @DeleteMapping("/customer")
  public String deleteCustomer(String customerId) {
    return "Albert";
  }
}

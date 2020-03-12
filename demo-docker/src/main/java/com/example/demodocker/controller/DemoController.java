package com.example.demodocker.controller;

import com.example.demodocker.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Api(
    value = "IDM Management System",
    description = "Operations pertaining to employee in IDM Management System")
public class DemoController {

  @ApiOperation(value = "View a list of available customer", response = List.class)
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
}

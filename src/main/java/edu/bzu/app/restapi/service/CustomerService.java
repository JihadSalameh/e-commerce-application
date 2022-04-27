package edu.bzu.app.restapi.service;

import edu.bzu.app.restapi.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
}

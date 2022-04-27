package edu.bzu.app.restapi.service.impl;

import edu.bzu.app.restapi.dto.CategoryDto;
import edu.bzu.app.restapi.dto.CustomerDto;
import edu.bzu.app.restapi.entity.Category;
import edu.bzu.app.restapi.entity.Customer;
import edu.bzu.app.restapi.repository.CustomerRepository;
import edu.bzu.app.restapi.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){this.customerRepository=customerRepository;}
    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map(customer -> mapToDTO(customer)).collect(Collectors.toList());
    }

    private CustomerDto mapToDTO(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFull_name(customerDto.getFull_name());
        customerDto.setEmail(customerDto.getEmail());
        customerDto.setPassword(customerDto.getPassword());
        customerDto.setPhone(customerDto.getPhone());
        return customerDto;
    }

    // convert DTO to entity
    private Category mapToEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setIsActive(categoryDto.getIsActive());
        category.setCreatedBy(categoryDto.getCreatedBy());
        category.setCreationDate(categoryDto.getCreationDate());
        return category;
    }
}

package edu.bzu.app.restapi.controller;

import edu.bzu.app.restapi.dto.CategoryDto;
import edu.bzu.app.restapi.dto.CustomerDto;
import edu.bzu.app.restapi.exception.BadRequestException;
import edu.bzu.app.restapi.service.CategoryService;
import edu.bzu.app.restapi.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
/**
 * Author: Mohammed Kharma
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    //    @Autowired //@Autowired annotation is used for dependency injection.In spring boot application, all loaded beans are eligible for auto wiring to another bean. The annotation @Autowired in spring boot is used to auto-wire a bean into another bean.
    private CustomerService customerService; //the use of interface rather than class is important for loose coupling

    // Constructor based  injection
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers()); //ResponseEntity represents an HTTP response, including headers, body, and status.
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(
            @PathVariable(name = "id") long id) {
        return ResponseEntity.ok(customerService.get(id));
    }*/

    /**
     * When Spring Boot finds an argument annotated with @Valid,
     * it automatically bootstraps the default JSR 380 implementation — Hibernate Validator — and
     * validates the argument. When the target argument fails to pass the validation,
     * Spring Boot throws a MethodArgumentNotValidException exception.
     *
     * @param categoryDto
     * @return
     */
    /*@PostMapping
    public ResponseEntity<CategoryDto> createCategory
    (@Valid @RequestBody CategoryDto categoryDto) {
        if (categoryDto.getId() != null) {
            log.error("Cannot have an ID {}", categoryDto);
            throw new BadRequestException(CategoryResource.class.getSimpleName(),
                    "Id");
        }
        return new ResponseEntity(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory
            (@Valid @RequestBody CategoryDto categoryDto
                    , @PathVariable(name = "id") long id) {
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto, id), HttpStatus.OK);
    }

    //    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(name = "id") long id) {
        categoryService.deleteCategoryById(id);
//        return ResponseEntity.ok().headers(<add warnings....>).build();
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }*/
}

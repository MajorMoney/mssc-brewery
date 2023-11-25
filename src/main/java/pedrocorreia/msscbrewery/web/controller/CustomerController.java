package pedrocorreia.msscbrewery.web.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedrocorreia.msscbrewery.service.CustomerService;
import pedrocorreia.msscbrewery.web.model.BeerDto;
import pedrocorreia.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
        return  new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void handlePost(@RequestBody CustomerDto customerDto, HttpServletResponse response){

        CustomerDto newDto = customerService.saveNewCustomer(customerDto);
        response.addHeader("Location","/api/v1/customer" + " => Header Worked");

    }

    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId,customerDto);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomer(customerId);
    }

}

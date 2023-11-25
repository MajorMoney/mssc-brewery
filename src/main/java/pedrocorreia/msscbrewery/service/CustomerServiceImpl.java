package pedrocorreia.msscbrewery.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pedrocorreia.msscbrewery.web.model.CustomerDto;

import java.util.UUID;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return new CustomerDto().builder().customerID(UUID.randomUUID())
                .name("John Doe")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        log.debug("Customer Saved");
        return customerDto;
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Customer Updated");
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Costumer Deleted");
    }
}

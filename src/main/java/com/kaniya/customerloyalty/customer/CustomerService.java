package com.kaniya.customerloyalty.customer;

import com.kaniya.customerloyalty.loyalty.Loyalty;
import com.kaniya.customerloyalty.loyalty.LoyaltyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final LoyaltyRepo loyaltyRepo;

    public List<Customer> getAllCustomers() {
        return  customerRepo.findAll();
    }

    public void createCustomer(CustomerRequest customerRequest) {

        Customer customer = customerRepo.save(
                Customer.builder()
                        .firstname(customerRequest.getFirstname())
                        .lastname(customerRequest.getLastname())
                        .address(customerRequest.getAddress())
                        .build()
        );

        var loyalty = Loyalty.builder()
                .customer(customer)
                .totalpoints(0.00)
                .totalredeem(0.00)
                .build();

        loyaltyRepo.save(loyalty);

    }
}

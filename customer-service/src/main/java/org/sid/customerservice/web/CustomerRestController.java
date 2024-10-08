package org.sid.customerservice.web;

import lombok.RequiredArgsConstructor;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {
    private final CustomerRepository customerRepository;
    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    @GetMapping("/customers/{id}")

    public Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
}

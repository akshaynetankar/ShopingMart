package com.shoppingMart.services;

import com.shoppingMart.entities.Customer;
import com.shoppingMart.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer register(Customer customer){
        //check for duplicate email
        if(customerRepository.findByEmail(customer.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already registered");
        }
        // password strength validation can be handled here
        return customerRepository.save(customer);
    }


    public Optional<Customer> login(String email, String password){
        return customerRepository.findByEmail(email)
                .filter(customer -> password.equals(customer.getPassword()));

    }

}

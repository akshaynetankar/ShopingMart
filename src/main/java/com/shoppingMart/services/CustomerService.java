package com.shoppingMart.services;

import com.shoppingMart.entities.Customer;
import com.shoppingMart.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Customer> login(String email, String password){
        return customerRepository.findByEmail(email)
                .filter(customer -> passwordEncoder.matches(password, customer.getPassword()));
    }

    public Customer register(Customer customer){
        //check for duplicate email
        if(customerRepository.findByEmail(customer.getEmail()).isPresent()){
            throw new IllegalArgumentException("Email already registered");
        }
        // password strength validation can be handled here
        //Ensure password is encoded before saving
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }


}

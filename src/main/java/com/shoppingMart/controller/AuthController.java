package com.shoppingMart.controller;

import com.shoppingMart.entities.Customer;
import com.shoppingMart.entities.LoginRequest;
import com.shoppingMart.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer) {
        try{
            customerService.register(customer);
                return ResponseEntity.ok("Registeration Successful.....!");
            }
        catch (IllegalArgumentException e){
                return ResponseEntity.badRequest().body(e.getMessage());

            }
        }

        //Login method
    @PostMapping("/login")
    public ResponseEntity<String>login(@RequestBody LoginRequest loginRequest){
        Optional<Customer> customer =customerService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if(customer.isPresent()) {
            return ResponseEntity.ok("Login Successful. ");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

    }
        @PostMapping("/logout")
        public ResponseEntity<String> logout(){

        //Implement session invalidation logic here
            return ResponseEntity.ok("Logged out Successfully..!");

        }




    }






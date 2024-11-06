package com.shoppingMart.controller;

import com.shoppingMart.entities.Customer;
import com.shoppingMart.services.AdminService;
import com.shoppingMart.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdminService adminService;
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

        @PostMapping("/logout")
        public ResponseEntity<String> logout(){

        //Implement session invalidation logic here
            return ResponseEntity.ok("Logged out Successfully..!");



        }




    }






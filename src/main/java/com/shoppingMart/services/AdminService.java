package com.shoppingMart.services;


import com.shoppingMart.entities.Admin;
import com.shoppingMart.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.oauth2.client.OAuth2ClientSecurityMarker;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> login(String email, String password){

        return adminRepository.findByEmail(email)
                .filter(admin -> password.equals(admin.getPassword()));
    }
}

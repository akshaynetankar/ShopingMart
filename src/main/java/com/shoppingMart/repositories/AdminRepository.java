package com.shoppingMart.repositories;

import com.shoppingMart.entities.Admin;
import com.shoppingMart.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
}

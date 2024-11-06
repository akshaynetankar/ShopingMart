package com.shoppingMart.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;



}

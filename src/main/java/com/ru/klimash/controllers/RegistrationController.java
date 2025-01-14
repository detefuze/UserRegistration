package com.ru.klimash.controllers;

import com.ru.klimash.entities.Customer;
import com.ru.klimash.repositories.CustomersRepository;
import com.ru.klimash.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/main_menu/registration_api")
public class RegistrationController {


    private final CustomersRepository customersRepository;
    private final CustomersService customersService;

    @Autowired
    public RegistrationController(CustomersService customersService,
                                  CustomersRepository customersRepository) {
        this.customersService = customersService;
        this.customersRepository = customersRepository;
    }

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration-form";
    }

    @GetMapping("/registration_success")
    public String registrationComplete() {
        return "registration-success";
    }

    @PostMapping("/registration/new_customer")
    public String registration(@RequestParam String fio,
                               @RequestParam String email,
                               @RequestParam String password) {
        
        Customer customer = new Customer();
        customer.setFio(fio);
        customer.setEmail(email);
        customer.setPassword(password);
        customersRepository.save(customer);
        return "redirect:http://localhost:8081/main_menu/registration_api" +
                "/registration_success";
    }
}
package com.ru.klimash.controllers;

import com.ru.klimash.entities.Customer;
import com.ru.klimash.repositories.CustomersRepository;
import com.ru.klimash.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/main_menu/registration_api")
public class RegistrationController {


    private CustomersRepository customersRepository;
    private CustomersService customersService;

    @Autowired
    public RegistrationController(CustomersService customersService,
                                  CustomersRepository customersRepository) {
        this.customersService = customersService;
        this.customersRepository = customersRepository;
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        List<Customer> customersList = customersService.getFioAndEmail();
        model.addAttribute("customers", customersList);
        return "registration-form";
    }

    @PostMapping("/registration/new_customer")
    public String registration(@RequestParam String fio,
                               @RequestParam String email,
                               @RequestParam String password) {
        customersRepository.save(new Customer(fio, email, password));
        return "redirect:/main_menu/registration_api/registration";
    }
}

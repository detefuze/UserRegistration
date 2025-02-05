package com.ru.klimash.services;

import com.ru.klimash.dto.CustomerDTO;
import com.ru.klimash.entities.Customer;
import com.ru.klimash.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersService {

    private final CustomersRepository customersRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomersService(CustomersRepository customersRepository, RestTemplate restTemplate) {
        this.customersRepository = customersRepository;
        this.restTemplate = restTemplate;
    }

    public String registrateNewCustomer(Customer customer) {
        try {
            if (!customersRepository.findCustomerByEmail(customer.getEmail()).isPresent())
                customersRepository.save(customer);
            else
                throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("Такой пользователь уже существует");
            return "redirect:http://localhost:8081/main_menu/registration_api" +
                    "/registration_regret";
        }

        String uiServiceUrl = "http://userinterface:8080/main_menu";
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFio(customer.getFio());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setBalance(customer.getBalance());

        ResponseEntity<String> registrationResponse = restTemplate.postForEntity(uiServiceUrl,
                customerDTO,
                String.class);

        return "redirect:http://localhost:8081/main_menu/registration_api" +
                "/registration_success";
    }

}

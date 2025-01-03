package com.ru.klimash.services;

import com.ru.klimash.entities.Customer;
import com.ru.klimash.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersService {

    private CustomersRepository customersRepository;

    @Autowired
    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customer> getFioAndEmail() {
        return customersRepository.findAll();
    }

}

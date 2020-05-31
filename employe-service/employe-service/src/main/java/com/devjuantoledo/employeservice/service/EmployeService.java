package com.devjuantoledo.employeservice.service;

import com.devjuantoledo.employeservice.repository.entity.Client;

import java.util.List;

public interface EmployeService {
    List<Client> findCustomerAll();
    Client createClient(Client customer);
}

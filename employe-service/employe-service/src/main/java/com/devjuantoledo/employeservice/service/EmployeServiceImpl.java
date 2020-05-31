package com.devjuantoledo.employeservice.service;

import com.devjuantoledo.employeservice.repository.EmployeRespository;
import com.devjuantoledo.employeservice.repository.entity.Client;
import com.devjuantoledo.employeservice.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    EmployeRespository employeRespository;

    @Override
    public List<Client> findCustomerAll() {
        return employeRespository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        Client clientDB = employeRespository.findByNumberID(client.getNumberID());
        if (clientDB != null) {
            return clientDB;
        }
        client.setState(Constant.STATE_CREATED);
        client.setCreatedBy("admin");
        clientDB = employeRespository.save(client);
        return clientDB;
    }
}

package com.devjuantoledo.employeservice.controller;

import com.devjuantoledo.employeservice.repository.entity.Client;
import com.devjuantoledo.employeservice.service.EmployeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clients")
public class EmployeRest {

    @Autowired
    EmployeService employeService;

    @GetMapping
    public ResponseEntity<List<Client>> listAllCustomers(@RequestParam(name = "regionId" , required = false) Long regionId ) {
        return  ResponseEntity.ok(employeService.findCustomerAll());
    }
}

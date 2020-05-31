package com.devjuantoledo.employeservice.repository;

import com.devjuantoledo.employeservice.repository.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeRespository extends JpaRepository<Client, Long> {

    Client findByNumberID(String numberID);

    List<Client> findByLastName(String lastName);
}

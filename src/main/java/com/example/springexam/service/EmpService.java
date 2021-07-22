package com.example.springexam.service;

import com.example.springexam.entity.EmpEntity;

import java.util.List;
import java.util.Optional;


public interface EmpService {
    List<EmpEntity> getAllEmp();
    Optional<EmpEntity> findById(Integer id);
    EmpEntity save(EmpEntity emp);
    public void deleteById(Integer id);
}


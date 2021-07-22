package com.example.springexam.service;

import com.example.springexam.entity.EmpEntity;
import com.example.springexam.repo.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    EmpRepository empRepository;

    @Override
    public List<EmpEntity> getAllEmp() {
        List<EmpEntity> emp = empRepository.findAll();
        return emp;
    }

    @Override
    public Optional<EmpEntity> findById(Integer id) {
        return empRepository.findById(id);
    }

    @Override
    public EmpEntity save(EmpEntity emp) {
        return empRepository.save(emp);
    }

    @Override
    public void deleteById(Integer id) {
        empRepository.deleteById(id);
    }
}

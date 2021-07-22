package com.example.springexam.repo;

import com.example.springexam.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Integer>{
}

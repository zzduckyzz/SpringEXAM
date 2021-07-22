package com.example.springexam.repo;

import com.example.springexam.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findUserEntityByUsername(String username);
}

package com.example.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aws.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

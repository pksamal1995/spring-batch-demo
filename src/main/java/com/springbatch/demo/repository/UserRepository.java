package com.springbatch.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbatch.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

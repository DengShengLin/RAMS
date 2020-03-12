package com.mumu.springbootvue.repository;

import com.mumu.springbootvue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}

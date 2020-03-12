package com.mumu.springbootvue.repository;

import com.mumu.springbootvue.entity.Ball;
import com.mumu.springbootvue.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BallRepository extends JpaRepository<Ball,Integer> {
}

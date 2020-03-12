package com.mumu.springbootvue.controller;

import com.mumu.springbootvue.entity.Ball;
import com.mumu.springbootvue.entity.Room;
import com.mumu.springbootvue.repository.BallRepository;
import com.mumu.springbootvue.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dsl
 * @date 2020/3/3 14:22
 * @description
 */
@RestController
@RequestMapping("/ball")
public class BallHandler {

    @Autowired
    private BallRepository ballRepository;

    @GetMapping("/findAll")
    public List<Ball> findAll() {

        return ballRepository.findAll();
    }
}

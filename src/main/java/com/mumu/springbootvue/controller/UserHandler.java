package com.mumu.springbootvue.controller;

import com.mumu.springbootvue.entity.CommonResult;
import com.mumu.springbootvue.entity.User;
import com.mumu.springbootvue.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author dsl
 * @date 2020/3/3 14:22
 * @description
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserHandler {

    @Resource
    private UserRepository userRepository;

    /*
     * @Description //TODO 查询全部
     **/
    @GetMapping(value = "/list")
    public CommonResult findAll() {
        List<User> userList = userRepository.findAll();
        if (userList != null) {
            return new CommonResult(200, "查询数据成功", userList);
        }else {
            return new CommonResult(444, "查询无记录");
        }
    }
    /*
     * @Description //TODO 查询全部/分页
     **/
    @GetMapping(value = "/list/{page}/{size}")
    public CommonResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        Page<User> users = userRepository.findAll(request);

        if (users != null) {
            return new CommonResult(200, "查询数据成功", users);
        }else {
            return new CommonResult(444, "查询无记录");
        }
    }

    /*
     * @Description //TODO 获取指定id的用户
     **/
    @GetMapping(value = "/get/{id}")
    public CommonResult get(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById(id);
        if (user != null) {
            log.info("*************OK:" + user.toString());
            return new CommonResult(200, "查询数据成功，查询id："+id, user);
        }else {
            return new CommonResult(444, "查询无记录，查询id："+id);
        }
    }

    /*
     * @Description //TODO 保存用户
     **/
    @Transactional
    @PostMapping(value = "/save")
    public CommonResult save(User user) {
        User newuser = userRepository.save(user);
        if (newuser != null) {
            return new CommonResult(200, "保存数据成功", newuser);
        }else {
            return new CommonResult(444, "保存数据失败");
        }
    }




}

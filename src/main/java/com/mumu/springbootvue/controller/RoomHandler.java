package com.mumu.springbootvue.controller;

import com.mumu.springbootvue.entity.CommonResult;
import com.mumu.springbootvue.entity.Room;
import com.mumu.springbootvue.entity.User;
import com.mumu.springbootvue.repository.RoomRepository;
import com.mumu.springbootvue.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author dsl
 * @date 2020/3/3 14:22
 * @description
 */
@RestController
@RequestMapping("/room")
@Slf4j
public class RoomHandler {

    @Resource
    private RoomRepository roomRepository;


    /*
     * @Description //TODO 查询全部球馆
     **/
    @GetMapping(value = "/list")
    public CommonResult findAll() {
        List<Room> roomList = roomRepository.findAll();
        if (roomList != null) {
            return new CommonResult(200, "查询数据成功", roomList);
        } else {
            return new CommonResult(444, "查询无记录");
        }
    }

    /*
     * @Description //TODO 按id查询
     **/
    @GetMapping(value = "/get/{id}")
    public CommonResult get(@PathVariable("id") Integer id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room != null) {
            return new CommonResult(200, "查询到数据，id："+id, room);
        }else {
            return new CommonResult(444,"为查询到数据，查询id："+id);
        }
    }

    /*
     * @Description //TODO 新增、更新球馆
     **/
    @Transactional
    @PostMapping(value = "/save")
    public CommonResult save(Room room){
        Room newroom = roomRepository.save(room);
        if (newroom != null) {
            return new CommonResult(200,"保存数据成功", newroom);
        }else {
            return new CommonResult(444,"保存数据失败");
        }
    }

    @GetMapping(value = "/get/name/{name}")
    public CommonResult findByName(@PathVariable("name") String name){
        List<Room> roomList = roomRepository.findByRoomNameContaining(name);
        if (!roomList.isEmpty()) {
            return new CommonResult(200,"", roomList);
        }else {
            return new CommonResult(444,"未查询符合条件的球馆");
        }
    }

}

package com.mumu.springbootvue.repository;

import com.mumu.springbootvue.entity.Room;
import com.mumu.springbootvue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findByRoomNameContaining(String name);
}

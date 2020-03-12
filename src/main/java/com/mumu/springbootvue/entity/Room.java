package com.mumu.springbootvue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author dsl
 * @date 2020/3/12 17:18
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@JsonIgnoreProperties({"ballList"})
@Table(name = "room")
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "room_tel")
    private String roomTel;
    @Column(name = "room_address")
    private String roomAddress;
    @Column(name = "room_describe")
    private String roomDescribe;
    @Column(name = "room_photo")
    private String roomPhoto;

/*    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端*/
    @OneToMany(targetEntity = Ball.class)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private List<Ball> ballList;//球类列表


}

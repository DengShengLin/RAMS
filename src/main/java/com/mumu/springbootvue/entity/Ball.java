package com.mumu.springbootvue.entity;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author dsl
 * @date 2020/3/3 14:04
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "ball")
public class Ball implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "ball_id")
    private Integer ballId;
//    private Integer roomId;
    @Column(name = "ball_sort")
    private Integer ballSort;
    //将不需要序列化的属性前添加注解@transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。
    @Transient
    private String ballSortStr;
    @Column(name = "ball_cost")
    private double ballCost;
    @Column(name = "ball_time_interval")
    private Integer ballTimeInterval;
    @Transient
    private String ballTimeIntervalStr;
    @Column(name = "ball_amount")
    private Integer ballAmount;

    @ManyToOne(targetEntity = Room.class)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    private Room room;

     public String getBallSortStr() {
        if (ballSort == 1) {
            this.ballSortStr = "足球";

        } else if (ballSort == 2) {
            this.ballSortStr = "篮球";

        } else if (ballSort == 3) {
            this.ballSortStr = "排球";

        } else if (ballSort == 4) {
            this.ballSortStr = "羽毛球";

        } else if (ballSort == 5) {
            this.ballSortStr = "乒乓球";

        } else if (ballSort == 6) {
            this.ballSortStr = "网球";

        } else if (ballSort == 7) {
            this.ballSortStr = "台球";

        } else if (ballSort == 8) {
            this.ballSortStr = "保龄球";

        } else {
            this.ballSortStr = "其他";
        }
        return ballSortStr;
    }

    public String getBallTimeIntervalStr() {
        if (ballTimeInterval >= 0 && ballTimeInterval < 23){
            this.ballTimeIntervalStr = ballTimeInterval+":00~"+(ballTimeInterval+1)+":00";
        }else if (ballTimeInterval == 23){
            this.ballTimeIntervalStr = ballTimeInterval.toString()+":00~00:00";
        }
        return ballTimeIntervalStr;
    }


}

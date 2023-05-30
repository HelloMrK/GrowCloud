package indi.likai.growcloud.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;


public class ResponseData {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer sensorValue;
    private Double percentageValue;
    @TableField("currenttime")
    private LocalDateTime currentTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(Integer sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Double getPercentageValue() {
        return percentageValue;
    }

    public void setPercentageValue(Double percentageValue) {
        this.percentageValue = percentageValue;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
}

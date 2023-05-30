package indi.likai.growcloud.data;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseData {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer sensorValue;
    private Double percentageValue;
    private LocalDateTime currentTime;
}

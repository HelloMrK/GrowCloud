package indi.likai.growcloud.service;



import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import indi.likai.growcloud.config.GrowConfig;
import indi.likai.growcloud.entity.ResponseData;
import indi.likai.growcloud.mapper.ResponseDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ResponseDataService extends ServiceImpl<ResponseDataMapper, ResponseData> {


    @Autowired
    private GrowConfig growConfig;
    public ResponseData getCurrResponseData(){
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(growConfig.getApiUrl(), String.class);
        JSONObject jsonObject = JSONObject.parseObject(response);

        ResponseData responseData = new ResponseData();
        responseData.setSensorValue(jsonObject.getInteger("sensorValue"));
        responseData.setPercentageValue(jsonObject.getDouble("percentageValue"));
        String dateTimeString = jsonObject.getString("currentTime");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        responseData.setCurrentTime(dateTime);
        return responseData;
    }
}
package indi.likai.growcloud.task;

import com.alibaba.fastjson.JSONObject;
import indi.likai.growcloud.entity.ResponseData;
import indi.likai.growcloud.service.ResponseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class SchedulerTask {
    private static final String API_URL = "http://10.0.0.231/";

    private final ResponseDataService responseDataService;

    @Autowired
    public SchedulerTask(ResponseDataService responseDataService) {
        this.responseDataService = responseDataService;
    }

    @Scheduled(cron = "0 0 * * * *") // 每小时执行一次
    public void fetchDataAndSave() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(API_URL, String.class);
        JSONObject jsonObject = JSONObject.parseObject(response);

        ResponseData responseData = new ResponseData();
        responseData.setSensorValue(jsonObject.getInteger("sensorValue"));
        responseData.setPercentageValue(jsonObject.getDouble("percentageValue"));
        String dateTimeString = jsonObject.getString("currentTime");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        responseData.setCurrentTime(dateTime);

        responseDataService.save(responseData);
    }
}
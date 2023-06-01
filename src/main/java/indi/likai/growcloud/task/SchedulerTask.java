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
    private final ResponseDataService responseDataService;

    @Autowired
    public SchedulerTask(ResponseDataService responseDataService) {
        this.responseDataService = responseDataService;
    }

    @Scheduled(cron = "0 0 * * * *") // 每小时执行一次
    public void fetchDataAndSave() {
        ResponseData responseData= responseDataService.getCurrResponseData();
        responseDataService.save(responseData);
    }
}
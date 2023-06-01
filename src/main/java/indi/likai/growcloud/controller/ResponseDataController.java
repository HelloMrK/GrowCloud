package indi.likai.growcloud.controller;

import indi.likai.growcloud.entity.ResponseData;
import indi.likai.growcloud.service.ResponseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResponseDataController {
    private final ResponseDataService responseDataService;

    @Autowired
    public ResponseDataController(ResponseDataService responseDataService) {
        this.responseDataService = responseDataService;
    }

    @GetMapping("/getCurrResponseData")
    public ResponseData getCurrResponseData(){
        ResponseData responseData=responseDataService.getCurrResponseData();
        return responseData;
    }
    @GetMapping("/responseData")
    public List<ResponseData> getResponseDataList(@RequestParam("count") int count) {
        List<ResponseData> responseDataList = responseDataService.list();
        int startIndex = Math.max(0, responseDataList.size() - count);
        return responseDataList.subList(startIndex, responseDataList.size());
    }
}

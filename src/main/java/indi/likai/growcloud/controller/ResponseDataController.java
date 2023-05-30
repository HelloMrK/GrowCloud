package indi.likai.growcloud.controller;

import indi.likai.growcloud.entity.ResponseData;
import indi.likai.growcloud.service.ResponseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/responseData")
    public List<ResponseData> getResponseDataList() {
        return responseDataService.list();
    }
}

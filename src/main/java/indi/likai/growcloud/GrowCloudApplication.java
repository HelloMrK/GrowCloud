package indi.likai.growcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GrowCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(GrowCloudApplication.class, args);
    }

}

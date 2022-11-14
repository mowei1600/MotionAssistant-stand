package com.itmowei.motionassistantstand;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MotionAssistantStandApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotionAssistantStandApplication.class, args);
        log.info("运动助手项目启动成功，by：莫威");
    }

}

package com.itmowei.motionassistantstand.controller;

import com.itmowei.motionassistantstand.common.R;
import com.itmowei.motionassistantstand.service.MotionAssistantStandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MotionAssistantStandController {

    @Autowired
    private MotionAssistantStandService motionAssistantStandService;

    /**
     * 提交
     *
     * @param user
     * @param password
     * @return
     */
    @RequestMapping("mi")
    public R submit(String user, String password, String steps) {
        return motionAssistantStandService.submit(user, password, steps);
    }

    @GetMapping
    public String test() {
        return "运动助手状态正常！";
    }
}

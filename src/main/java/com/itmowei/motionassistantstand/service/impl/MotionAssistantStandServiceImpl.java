package com.itmowei.motionassistantstand.service.impl;

import com.itmowei.motionassistantstand.common.R;
import com.itmowei.motionassistantstand.service.MotionAssistantStandService;
import com.itmowei.motionassistantstand.util.XiaomiApi;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.regex.Pattern;

@Service
public class MotionAssistantStandServiceImpl implements MotionAssistantStandService {
    @Override
    public R submit(String user, String password, String steps) {
        if (!validateMobilePhone(user)) {
            R.error("账号格式不正确");
        }
        if (password.length() < 8) {
            R.error("密码低于8位");
        }

        Map<String, Object> map = XiaomiApi.mainHandler(user, password, steps);
        boolean flag = (boolean) map.get("flag");
        if (flag) {
            return R.success("提交成功，本次为你刷了：" + map.get("msg") + "步");
        } else {
            return R.error("提交失败！用户名或密码错误!");
        }
    }

    /**
     * 校验手机号码、邮箱号
     * 正则：手机号正则 + 邮箱号正则
     *
     * @param user
     * @return
     */
    public boolean validateMobilePhone(String user) {
        String phoneRegExp = "^1[3|4|5|7|8][0-9]{9}$";
        String mailboxRegExp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        boolean matches1 = Pattern.matches(phoneRegExp, user);
        boolean matches2 = Pattern.matches(mailboxRegExp, user);
        if (matches1 || matches2) {
            return true;
        } else {
            return false;
        }
    }
}

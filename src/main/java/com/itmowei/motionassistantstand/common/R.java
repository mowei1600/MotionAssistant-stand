package com.itmowei.motionassistantstand.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author MoWei
 */
@Data
public class R<T> implements Serializable {
    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private String by;

    public static <T> R<T> success(String msg) {
        R<T> r = new R<T>();
        r.code = 200;
        r.msg = msg;
        r.by = "感谢使用运动助手！";
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 501;
        r.by = "感谢使用运动助手！";
        return r;
    }

}

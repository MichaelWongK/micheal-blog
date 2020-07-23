package com.michealwang.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * @author micheal.wang
 * @date 2020/7/23 1:11
 * @Email:wangmk13@163.com
 * @Description 统一结果封装
 */
@Data
public class ResultJson implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public ResultJson(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultJson success(Object data) {
        return new ResultJson(200, "操作成功", data);
    }

    public static ResultJson success(int code, String msg, Object data) {
        return new ResultJson(code, msg, data);
    }

    public static ResultJson fail(String msg) {
        return new ResultJson(-1, msg, null);
    }

    public static ResultJson fail(String msg, Object data) {
        return new ResultJson(-1, msg, data);
    }

    public static ResultJson fail(int code, String msg, Object data) {
        return new ResultJson(code, msg, data);
    }



}

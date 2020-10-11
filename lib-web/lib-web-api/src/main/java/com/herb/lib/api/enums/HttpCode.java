package com.herb.lib.api.enums;

/**
 * @author 油炸小波
 * @version 1.0
 * @date 2020/10/11 8:08
 * @Desc
 */
public enum HttpCode {

    /**
     * 成功且有数据
     */
    SUCCESS(1, "成功"),

    /**
     * 成功无数据
     */
    FAIL(-1, "失败"),

    /**
     * 系统异常
     */
    EXCEPTION(500, "系统异常");

    private int code;

    private String msg;

    HttpCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

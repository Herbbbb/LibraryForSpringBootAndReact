package com.herb.lib.api.constants;

import lombok.Data;

/**
 * 基本返回数据结构
 * @author 油炸小波
 * @version 1.0
 * @date 2020/10/11 8:01
 */
@Data
public class ResultDTO {

    private String system;

    private int code;

    private String msg;

    private Object data;

    public ResultDTO(int code, String msg) {
        this.system = "lib";
        this.code = code;
        this.msg = msg;
    }

    public ResultDTO(int code, String msg, Object data) {
        this.system = "lib";
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

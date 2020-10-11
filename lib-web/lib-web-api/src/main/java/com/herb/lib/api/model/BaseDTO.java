package com.herb.lib.api.model;

import com.herb.lib.api.enums.ValidFlagEnum;
import lombok.Data;

import java.sql.Date;

/**
 * 实体类父类
 * @author 油炸小波
 * @version 1.0
 * @date 2020/10/9 20:54
 */

@Data
public class BaseDTO {
    /**
     * 数据ID
     */
    private int id;

    /**
     * 临时字段1
     */
    private String tmp1;

    /**
     * 临时字段2
     */
    private  String tmp2;

    /**
     * 入库时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 数据有效性
     */
    private ValidFlagEnum validFlag;
}

package com.herb.lib.api.model.book;

import com.herb.lib.api.model.BaseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * 书籍分类实体类
 * @author 油炸小波
 * @version 1.0
 * @date 2020/10/9 20:56
 */
@Data
public class BookClassDTO extends BaseDTO implements Serializable{

    private static final long serialVersionUID = 6109911930620603904L;

    /**
     * 分类名称
     */
    private String name;
}

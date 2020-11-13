package com.herb.lib.api.service.book;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.model.book.BookDTO;

/**
 * @author 油炸小波
 * @version 1.0
 * @date 2020/10/12 19:38
 * @Desc
 */
public interface BookService {
    /**
     * 根据名称模糊查询全部书籍信息
     * @param name  分类名称
     * @return 匹配的数据集
     */
    ResultDTO findListByName(String name);

    /**
     * 根据ID查找数据
     * @param id 数据ID
     * @return 查找的数据集
     */
    ResultDTO findById(int id);

    /**
     * 新增
     * @param entity 实体类(不包含ID)
     * @return 影响行数
     */
    ResultDTO insert(BookDTO entity);

    /**
     * 更新
     * @param entity 实体类(包含ID)
     * @return  影响行数
     */
    ResultDTO update(BookDTO entity);

    /**
     * 删除
     * @param id 数据主键
     * @return 影响行数
     */
    ResultDTO delete(int id);
}

package com.herb.lib.dao.mapper.book;

import com.herb.lib.api.model.book.BookDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 书籍实体信息接口
 * @author 油炸小波
 * @version 1.0
 * @date 2020/10/12 19:35
 */
@Mapper
public interface BookMapper {

    /**
     * 根据名称模糊查询全部书籍信息
     * @param name  分类名称
     * @return 匹配的数据集
     */
    List<BookDTO> findListByName(String name);

    /**
     * 根据ID查找数据
     * @param id 数据ID
     * @return 查找的数据集
     */
    BookDTO findById(int id);

    /**
     * 新增
     * @param entity 实体类(不包含ID)
     * @return 影响行数
     */
    int insert(BookDTO entity);

    /**
     * 更新
     * @param entity 实体类(包含ID)
     * @return  影响行数
     */
    int update(BookDTO entity);

    /**
     * 删除
     * @param id 数据主键
     * @return 影响行数
     */
    int delete(int id);
}

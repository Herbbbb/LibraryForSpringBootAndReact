package com.herb.lib.dao.mapper.borrow;

import com.herb.lib.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 借书还书接口层
 * @author 油炸小波
 * @version 1.0
 * @date 2020/11/4 20:00
 */
@Mapper
public interface BookBorrowMapper {

    /**
     * 新增借书信息
     * @param bookBorrowDTO 借书信息实体类
     */
    int insertBorrow(BookBorrowDTO bookBorrowDTO);

    /**
     * 根据数据主键查找数据
     * @param id
     * @return
     */
    BookBorrowDTO findById(int id);

    /**
     * 更新借书实体类信息
     * @param localBookBorrowDTO    借书信息实体类
     */
    int update(BookBorrowDTO localBookBorrowDTO);
}

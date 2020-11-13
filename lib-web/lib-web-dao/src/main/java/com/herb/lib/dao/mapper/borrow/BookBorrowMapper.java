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

    int insertBorrow(BookBorrowDTO bookBorrowDTO);
}

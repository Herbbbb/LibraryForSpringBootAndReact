package com.herb.lib.dao.mapper.reback;

import com.herb.lib.api.model.borrow.BookBorrowDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 还书接口类
 * @author 油炸小波
 * @version 1.0
 * @date 2020/11/14 7:57
 */
@Mapper
public interface RebackMapper {

    /**
     * 更新借书信息
     * @param bookBorrowDTO
     */
    int updateBorrowInfo(BookBorrowDTO bookBorrowDTO);
}

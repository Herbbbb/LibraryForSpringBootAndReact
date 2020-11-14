package com.herb.lib.api.service.reback;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.model.borrow.BookBorrowDTO;

/**
 * @author 油炸小波
 * @version 1.0
 * @date 2020/11/14 8:02
 * @Desc
 */
public interface RebackService {
    /**
     * 更新借书信息
     * @param bookBorrowDTO
     */
    ResultDTO updateBorrowInfo(BookBorrowDTO bookBorrowDTO);
}

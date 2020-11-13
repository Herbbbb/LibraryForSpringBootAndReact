package com.herb.lib.api.service.borrow;

import com.herb.lib.api.constants.ResultDTO;

import java.util.Date;

/**
 * @author 油炸小波
 * @version 1.0
 * @date 2020/11/4 20:06
 * @Desc
 */
public interface BookBorrowService {

    ResultDTO doBorrow(int bookId, Date startDate, Date endDate, int borrowCount, int userId, String userName, boolean vipFlag);
}

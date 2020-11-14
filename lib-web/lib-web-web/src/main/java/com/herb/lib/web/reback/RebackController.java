package com.herb.lib.web.reback;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.enums.HttpCode;
import com.herb.lib.api.model.borrow.BookBorrowDTO;
import com.herb.lib.api.service.reback.RebackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 油炸小波
 * @version 1.0
 * @date 2020/11/14 8:27
 * @Desc
 */
@RestController
@RequestMapping("/reback")
public class RebackController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RebackService rebackService;

    @RequestMapping("/doBack")
    public ResultDTO rebackBook(@RequestBody BookBorrowDTO bookBorrowDTO) {
        try {
            return rebackService.updateBorrowInfo(bookBorrowDTO);
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}

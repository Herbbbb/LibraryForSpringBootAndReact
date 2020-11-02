package com.herb.lib.web.book;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.enums.HttpCode;
import com.herb.lib.api.model.book.BookDTO;
import com.herb.lib.api.service.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 油炸小波
 * @version 1.0
 * @date 2020/10/12 19:43
 * @Desc
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    /**
     * 根据名称查找分类信息
     *
     * @param bookDTO 更新实体
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(@RequestBody BookDTO bookDTO) {
        try {
            return bookService.findListByName(bookDTO.getBookName());
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据Id查找数据
     *
     * @param bookDTO 更新实体
     */
    @RequestMapping("/findById")
    public ResultDTO findById(@RequestBody BookDTO bookDTO) {
        try {
            return bookService.findById(bookDTO.getId());
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 新增
     *
     * @param bookDTO 新增实体
     */
    @RequestMapping("/insert")
    public ResultDTO insert(@RequestBody BookDTO bookDTO) {
        try {
            return bookService.insert(bookDTO);
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 新增
     *
     * @param bookDTO 更新实体
     */
    @RequestMapping("/update")
    public ResultDTO update(@RequestBody BookDTO bookDTO) {
        try {
            return bookService.update(bookDTO);
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据Id删除数据
     *
     * @param bookDTO 更新实体
     */
    @RequestMapping("/delete")
    public ResultDTO delete(@RequestBody BookDTO bookDTO) {
        try {
            return bookService.delete(bookDTO.getId());
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}

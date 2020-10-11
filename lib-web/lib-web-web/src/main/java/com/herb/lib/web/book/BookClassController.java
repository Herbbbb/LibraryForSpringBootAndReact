package com.herb.lib.web.book;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.enums.HttpCode;
import com.herb.lib.api.model.book.BookClassDTO;
import com.herb.lib.api.service.BookClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 书籍分类访问层
 *
 * @author 油炸小波
 * @version 1.0
 * @date 2020/10/11 8:25
 */
@RestController
@RequestMapping("/bookClass")
public class BookClassController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookClassService bookClassService;

    /**
     * 根据名称查找分类信息
     *
     * @param name 分类名
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(String name) {
        try {
            return bookClassService.findListByName(name);
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据Id查找数据
     *
     * @param id 数据主键
     */
    @RequestMapping("/findById")
    public ResultDTO findById(int id) {
        try {
            return bookClassService.findById(id);
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 新增
     *
     * @param bookClassDTO 新增实体
     */
    @RequestMapping("/insert")
    public ResultDTO insert(BookClassDTO bookClassDTO) {
        try {
            return bookClassService.insert(bookClassDTO);
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 新增
     *
     * @param bookClassDTO 更新实体
     */
    @RequestMapping("/update")
    public ResultDTO update(BookClassDTO bookClassDTO) {
        try {
            return bookClassService.update(bookClassDTO);
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据Id删除数据
     *
     * @param id 数据主键
     */
    @RequestMapping("/delete")
    public ResultDTO delete(int id) {
        try {
            return bookClassService.delete(id);
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}

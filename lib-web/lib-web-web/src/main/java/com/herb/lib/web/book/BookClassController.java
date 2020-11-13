package com.herb.lib.web.book;

import com.herb.lib.api.constants.ResultDTO;
import com.herb.lib.api.enums.HttpCode;
import com.herb.lib.api.model.book.BookClassDTO;
import com.herb.lib.api.service.book.BookClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * @param bookClassDTO 书籍分类实体类
     */
    @RequestMapping("/findListByName")
    public ResultDTO findListByName(@RequestBody BookClassDTO bookClassDTO) {
        try {
            return bookClassService.findListByName(bookClassDTO.getName());
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }

    /**
     * 根据Id查找数据
     * TODO:基础数据类型int会导致请求方式为form表单的形式
     * @param bookClassDTO 书籍分类实体类
     */
    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public ResultDTO findById(@RequestBody BookClassDTO bookClassDTO) {
        try {
            return bookClassService.findById(bookClassDTO.getId());
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
    public ResultDTO insert(@RequestBody BookClassDTO bookClassDTO) {
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
    public ResultDTO update(@RequestBody BookClassDTO bookClassDTO) {
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
     * @param bookClassDTO 书籍分类实体类
     */
    @RequestMapping("/delete")
    public ResultDTO delete(@RequestBody BookClassDTO bookClassDTO) {
        try {
            return bookClassService.delete(bookClassDTO.getId());
        } catch (Exception e) {
            logger.error("系统异常：" + e);
            return new ResultDTO(HttpCode.EXCEPTION.getCode(), "系统异常");
        }
    }
}

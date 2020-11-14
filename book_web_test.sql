/*
Navicat MySQL Data Transfer

Source Server         : YZXB
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : book_web_test

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-11-14 09:17:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `book_name` varchar(128) DEFAULT NULL COMMENT '书籍名称',
  `book_class_id` int(11) DEFAULT NULL COMMENT '分类主键',
  `book_price` decimal(10,2) DEFAULT NULL COMMENT '书籍价格',
  `book_count` int(12) DEFAULT NULL COMMENT '书籍数量',
  `book_publish` varchar(128) DEFAULT NULL COMMENT '出版社名称',
  `book_author` varchar(128) DEFAULT NULL COMMENT '作者',
  `book_img` varchar(128) DEFAULT NULL COMMENT '书籍图片(img1;img2)',
  `publish_date` datetime DEFAULT NULL COMMENT '出版日期(yyyy-MM-dd)',
  `tmp1` varchar(256) DEFAULT NULL COMMENT '临时字段1',
  `tmp2` varchar(256) DEFAULT NULL COMMENT '临时字段2',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入库时间',
  `update_date` datetime DEFAULT NULL COMMENT '最近一次更新时间',
  `valid_flag` varchar(12) DEFAULT NULL COMMENT '标识数据有效性(ENABLE:有效数据DISABLE:无效数据)',
  PRIMARY KEY (`id`),
  KEY `boook_book_class_prk` (`book_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '好热血', '1', '1.20', '6', '测试', '测试', '213124.jpg', '2020-10-09 20:39:35', null, null, '2020-11-14 08:59:06', '2020-11-14 00:59:06', 'ENABLE');
INSERT INTO `book` VALUES ('2', '油炸小波', '1', '12.00', '7', '小波出版社', '小波', 'https://timgsa.baidu.com/timg', '2020-10-12 00:00:00', null, null, '2020-11-04 19:42:27', null, 'DISABLE');
INSERT INTO `book` VALUES ('3', '油炸小波', '1', '12.00', '8', '小波出版社', '小波', 'https://timgsa.baidu.com/timg', '2020-10-12 00:00:00', null, null, '2020-11-04 19:42:28', null, 'ENABLE');
INSERT INTO `book` VALUES ('4', '油炸小波', '1', '12.00', '9', '小波出版社', '小波', 'https://timgsa.baidu.com/timg', '2020-10-12 00:00:00', null, null, '2020-11-04 19:42:30', null, 'ENABLE');

-- ----------------------------
-- Table structure for `book_borrow`
-- ----------------------------
DROP TABLE IF EXISTS `book_borrow`;
CREATE TABLE `book_borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(128) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL COMMENT '本价',
  `trade_fee` decimal(8,2) DEFAULT NULL COMMENT '实际成交价格',
  `tmp1` varchar(256) DEFAULT NULL,
  `tmp2` varchar(256) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `valid_flag` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book_borrow
-- ----------------------------
INSERT INTO `book_borrow` VALUES ('1', '1', '油炸小波', '1', '好热血', '0', '2020-11-07 16:00:00', '2020-11-10 16:00:00', '3.00', '0.00', '6', 'Sat Nov 14 08:59:06 CST 2020', '2020-11-08 02:37:59', null, 'DISABLE');

-- ----------------------------
-- Table structure for `book_class`
-- ----------------------------
DROP TABLE IF EXISTS `book_class`;
CREATE TABLE `book_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '数据主键',
  `name` varchar(64) DEFAULT NULL COMMENT '分类名称',
  `tmp1` varchar(256) DEFAULT NULL COMMENT '临时字段1',
  `tmp2` varchar(256) DEFAULT NULL COMMENT '临时字段2',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '入库时间',
  `update_date` datetime DEFAULT NULL COMMENT '最近一次更新时间',
  `valid_flag` varchar(12) DEFAULT NULL COMMENT '标识数据有效性(ENABLE:有效数据\nDISABLE:无效数据)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='书籍分类信息表';

-- ----------------------------
-- Records of book_class
-- ----------------------------
INSERT INTO `book_class` VALUES ('1', null, null, null, '2020-11-02 21:36:31', null, 'DISABLE');
INSERT INTO `book_class` VALUES ('2', '科幻', null, null, '2020-10-11 09:25:51', null, 'DISABLE');
INSERT INTO `book_class` VALUES ('9', '文学2', null, null, '2020-10-11 09:26:46', null, 'ENABLE');
INSERT INTO `book_class` VALUES ('10', '科幻2', null, null, '2020-10-11 09:26:57', null, 'ENABLE');
INSERT INTO `book_class` VALUES ('11', '油炸小波', null, null, '2020-10-12 20:38:21', null, null);
INSERT INTO `book_class` VALUES ('12', '1', null, null, '2020-10-12 20:39:04', null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '用户名',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(128) DEFAULT NULL COMMENT '加密手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `type` char(1) DEFAULT NULL COMMENT '1-学生 2-教师 3-图书管理员 4-系统管理员',
  `img` varchar(128) DEFAULT NULL COMMENT '头像',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `valid_flag` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '油炸小波', '123456!123', '15869541235', '18946131@163.com', '1', null, '2020-11-04 19:25:27', null, 'ENABLE');

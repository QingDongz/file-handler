/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : file

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2018-09-19 00:00:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_file
-- ----------------------------
DROP TABLE IF EXISTS `tb_file`;
CREATE TABLE `tb_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dir` varchar(255) CHARACTER SET utf8 NOT NULL,
  `file_name` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26897 DEFAULT CHARSET=latin1;

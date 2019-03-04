/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : mysql_ample_one

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-18 17:26:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_other` int(11) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES ('1', '1', 'true');
INSERT INTO `demo` VALUES ('2', '2', 'true');
INSERT INTO `demo` VALUES ('3', '3', 'true');

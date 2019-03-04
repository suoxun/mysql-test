/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : mysql_ample_three

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-04-18 17:33:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_one
-- ----------------------------
DROP TABLE IF EXISTS `demo_one`;
CREATE TABLE `demo_one` (
  `id_one` int(11) NOT NULL AUTO_INCREMENT,
  `id_one_name01` varchar(255) DEFAULT NULL,
  `id_one_name02` varchar(255) DEFAULT NULL,
  `id_one_name03` varchar(255) DEFAULT NULL,
  `id_one_name04` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_one`),
  KEY `id_one_name01` (`id_one_name01`),
  KEY `id_one_name03,id_one_name04` (`id_one_name03`,`id_one_name04`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_one
-- ----------------------------
INSERT INTO `demo_one` VALUES ('1', '小明01', '小明01', '小明01', '小明01');
INSERT INTO `demo_one` VALUES ('2', '小红01', '小红01', '小红01', '小红01');
INSERT INTO `demo_one` VALUES ('3', '小刚01', '小刚01', '小刚01', '小刚01');

-- ----------------------------
-- Table structure for demo_two
-- ----------------------------
DROP TABLE IF EXISTS `demo_two`;
CREATE TABLE `demo_two` (
  `id_two` int(11) NOT NULL AUTO_INCREMENT,
  `id_one` int(11) DEFAULT NULL,
  `id_two_name01` varchar(255) DEFAULT NULL,
  `id_two_name02` varchar(255) DEFAULT NULL,
  `id_two_name03` varchar(255) DEFAULT NULL,
  `id_two_name04` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_two`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo_two
-- ----------------------------
INSERT INTO `demo_two` VALUES ('1', '1', '小明02', '小明02', '小明02', '小明02');
INSERT INTO `demo_two` VALUES ('2', '2', '小红02', '小红02', '小红02', '小红02');
INSERT INTO `demo_two` VALUES ('3', '3', '小刚02', '小刚02', '小刚02', '小刚02');

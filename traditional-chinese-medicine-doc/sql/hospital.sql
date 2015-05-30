/*
Navicat MySQL Data Transfer

Source Server         : 192.168.11.133
Source Server Version : 50173
Source Host           : 192.168.11.133:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2015-05-24 23:53:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dbxzpatient
-- ----------------------------
DROP TABLE IF EXISTS `dbxzpatient`;
CREATE TABLE `dbxzpatient` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '病人姓名',
  `age` int(11) NOT NULL DEFAULT '0' COMMENT '年龄',
  `sex` tinyint(4) DEFAULT '0' COMMENT '性别',
  `symptom` varchar(500) DEFAULT NULL COMMENT '症状',
  `contact` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbxzpatjpre
-- ----------------------------
DROP TABLE IF EXISTS `dbxzpatjpre`;
CREATE TABLE `dbxzpatjpre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patientid` int(11) NOT NULL COMMENT '病人编号',
  `prescriptionid` int(11) NOT NULL COMMENT '方药编号',
  `deleted` tinyint(4) NOT NULL DEFAULT '0',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbxzprescription
-- ----------------------------
DROP TABLE IF EXISTS `dbxzprescription`;
CREATE TABLE `dbxzprescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medication` varchar(100) NOT NULL COMMENT '方药名',
  `use` varchar(500) DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `DataChange_LastTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_medication` (`medication`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbxzsystemuser
-- ----------------------------
DROP TABLE IF EXISTS `dbxzsystemuser`;
CREATE TABLE `dbxzsystemuser` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL COMMENT '管理员用户名',
  `password` varchar(500) NOT NULL COMMENT '密码',
  `deleted` tinyint(4) NOT NULL DEFAULT '0',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dbxztreatrecord
-- ----------------------------
DROP TABLE IF EXISTS `dbxztreatrecord`;
CREATE TABLE `dbxztreatrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `patientid` int(11) NOT NULL COMMENT '病人id',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '就诊状态（0排队,1就诊,2已就诊,3预约,4已取消）',
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `deleted` tinyint(4) NOT NULL DEFAULT '0',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Loginfo
-- ----------------------------
DROP TABLE IF EXISTS `Loginfo`;
CREATE TABLE `Loginfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patientid` int(11) NOT NULL,
  `diagnosticTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `patientid` (`patientid`),
  CONSTRAINT `loginfo_ibfk_1` FOREIGN KEY (`patientid`) REFERENCES `Patient` (`patientid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Patient
-- ----------------------------
DROP TABLE IF EXISTS `Patient`;
CREATE TABLE `Patient` (
  `patientid` int(11) NOT NULL AUTO_INCREMENT,
  `patientNum` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `diagnosis` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `prescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patientid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for Prescription
-- ----------------------------
DROP TABLE IF EXISTS `Prescription`;
CREATE TABLE `Prescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medicineName` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `hospital`.`dbxzsystemuser` (`id`, `username`, `password`, `deleted`, `DataChange_LastTime`) VALUES ('1', 'admin', 'admin', '0', '0000-00-00 00:00:00');

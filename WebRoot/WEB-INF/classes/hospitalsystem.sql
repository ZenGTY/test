/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : hospitalsystem

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-30 12:15:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `billId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '单据编号',
  `clientId` bigint(20) unsigned NOT NULL COMMENT '所属客户编号',
  `employeeId` bigint(20) unsigned NOT NULL COMMENT '开单据employee编号',
  `departmentId` int(10) unsigned NOT NULL COMMENT '所属科室编号',
  `clinicId` int(10) unsigned NOT NULL COMMENT '所属门诊编号',
  `category` varchar(50) NOT NULL DEFAULT '' COMMENT '医生开单(doctorBill),费用清单(fundBill)',
  `totalCost` double unsigned NOT NULL COMMENT '总支出',
  `totalPrice` double unsigned NOT NULL COMMENT '总收入',
  `datetime` datetime NOT NULL COMMENT '开单所属时间',
  `status` smallint(6) NOT NULL COMMENT '开单的支付情况(0:已支付; 1:未支付; -1:已作废)',
  PRIMARY KEY (`billId`),
  KEY `FKab8srry8g2qy281nan435u6di` (`clientId`),
  KEY `FKn2y1kc4x9yhsy0pgj95lecidb` (`clinicId`),
  KEY `FKheo3p6bf3q8u84puhnkdrlqtt` (`departmentId`),
  KEY `FKdlhjt2o1w7g2mvh65mwn3pji3` (`employeeId`),
  CONSTRAINT `FKab8srry8g2qy281nan435u6di` FOREIGN KEY (`clientId`) REFERENCES `client` (`clientId`),
  CONSTRAINT `FKdlhjt2o1w7g2mvh65mwn3pji3` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  CONSTRAINT `FKheo3p6bf3q8u84puhnkdrlqtt` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `FKn2y1kc4x9yhsy0pgj95lecidb` FOREIGN KEY (`clinicId`) REFERENCES `clinic` (`clinicId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('20', '1', '1', '1', '1', 'doctorBill', '0', '500', '2017-10-29 22:05:05', '0');
INSERT INTO `bill` VALUES ('22', '1', '1', '1', '1', 'doctorBill', '0', '500', '2017-10-29 22:06:01', '0');
INSERT INTO `bill` VALUES ('23', '1', '2', '2', '1', 'doctorBill', '0', '800', '2017-10-29 22:07:01', '0');
INSERT INTO `bill` VALUES ('24', '1', '2', '2', '1', 'doctorBill', '0', '800', '2017-10-29 22:07:05', '0');
INSERT INTO `bill` VALUES ('27', '1', '3', '3', '2', 'doctorBill', '0', '1300', '2017-10-29 22:10:25', '0');
INSERT INTO `bill` VALUES ('28', '1', '3', '3', '2', 'doctorBill', '0', '1300', '2017-10-29 22:10:26', '0');
INSERT INTO `bill` VALUES ('29', '1', '4', '4', '2', 'doctorBill', '0', '1000', '2017-10-29 22:11:18', '0');
INSERT INTO `bill` VALUES ('30', '1', '4', '4', '2', 'doctorBill', '0', '1000', '2017-10-29 22:11:18', '0');
INSERT INTO `bill` VALUES ('31', '1', '1', '1', '1', 'fundBill', '200', '100', '2017-10-20 00:00:00', '0');
INSERT INTO `bill` VALUES ('32', '1', '1', '2', '1', 'fundBill', '100', '200', '2017-10-20 00:00:00', '0');
INSERT INTO `bill` VALUES ('33', '1', '1', '3', '2', 'fundBill', '400', '300', '2017-10-20 00:00:00', '0');
INSERT INTO `bill` VALUES ('34', '1', '1', '4', '2', 'fundBill', '300', '400', '2017-10-20 00:00:00', '0');
INSERT INTO `bill` VALUES ('35', '1', '1', '1', '1', 'fundBill', '300', '400', '2017-10-20 00:00:00', '0');

-- ----------------------------
-- Table structure for billproject
-- ----------------------------
DROP TABLE IF EXISTS `billproject`;
CREATE TABLE `billproject` (
  `billId` bigint(20) unsigned NOT NULL COMMENT '单据编号',
  `projectId` bigint(20) unsigned NOT NULL COMMENT '费用项目编号',
  `number` smallint(5) unsigned NOT NULL COMMENT '如果是治疗项目记录次数 否则为0 ',
  `price` double unsigned NOT NULL COMMENT '总价格',
  `deadline` datetime DEFAULT NULL COMMENT '治疗项目记录截至日期  否则设为空',
  `extraInfo` varchar(255) DEFAULT '' COMMENT '额外信息',
  PRIMARY KEY (`billId`,`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of billproject
-- ----------------------------
INSERT INTO `billproject` VALUES ('20', '1', '10', '100', '2017-12-10 10:10:10', '额外信息');
INSERT INTO `billproject` VALUES ('20', '2', '20', '400', '2017-12-10 10:10:12', '额外信息2');
INSERT INTO `billproject` VALUES ('22', '1', '10', '100', '2017-12-10 10:10:10', '额外信息');
INSERT INTO `billproject` VALUES ('22', '2', '20', '400', '2017-12-10 10:10:12', '额外信息2');
INSERT INTO `billproject` VALUES ('23', '1', '20', '200', '2017-12-10 10:10:10', '额外信息');
INSERT INTO `billproject` VALUES ('23', '2', '30', '600', '2017-12-10 10:10:12', '额外信息2');
INSERT INTO `billproject` VALUES ('24', '1', '20', '200', '2017-12-10 10:10:10', '额外信息');
INSERT INTO `billproject` VALUES ('24', '2', '30', '600', '2017-12-10 10:10:12', '额外信息2');
INSERT INTO `billproject` VALUES ('27', '2', '20', '400', '2017-12-10 10:10:10', '额外信息');
INSERT INTO `billproject` VALUES ('27', '5', '30', '900', '2017-12-10 10:10:12', '额外信息2');
INSERT INTO `billproject` VALUES ('28', '2', '20', '400', '2017-12-10 10:10:10', '额外信息');
INSERT INTO `billproject` VALUES ('28', '5', '30', '900', '2017-12-10 10:10:12', '额外信息2');
INSERT INTO `billproject` VALUES ('29', '1', '10', '100', '2017-12-10 10:10:10', '额外信息');
INSERT INTO `billproject` VALUES ('29', '5', '30', '900', '2017-12-10 10:10:12', '额外信息2');
INSERT INTO `billproject` VALUES ('30', '1', '10', '100', '2017-12-10 10:10:10', '额外信息');
INSERT INTO `billproject` VALUES ('30', '5', '30', '900', '2017-12-10 10:10:12', '额外信息2');
INSERT INTO `billproject` VALUES ('31', '3', '0', '100', null, '收费收入项目摘要一');
INSERT INTO `billproject` VALUES ('31', '4', '0', '200', null, '收费支出项目摘要二');
INSERT INTO `billproject` VALUES ('32', '3', '0', '200', null, '收费收入项目摘要一');
INSERT INTO `billproject` VALUES ('32', '4', '0', '100', null, '收费支出项目摘要二');
INSERT INTO `billproject` VALUES ('33', '7', '0', '300', null, '收费收入项目摘要一');
INSERT INTO `billproject` VALUES ('33', '8', '0', '400', null, '收费支出项目摘要二');
INSERT INTO `billproject` VALUES ('34', '7', '0', '400', null, '收费收入项目摘要一');
INSERT INTO `billproject` VALUES ('34', '8', '0', '300', null, '收费支出项目摘要二');
INSERT INTO `billproject` VALUES ('35', '7', '0', '400', null, '收费收入项目摘要一');
INSERT INTO `billproject` VALUES ('35', '8', '0', '300', null, '收费支出项目摘要二');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `clientId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `identity` varchar(18) DEFAULT '' COMMENT '身份证',
  `age` smallint(5) unsigned DEFAULT NULL COMMENT '年龄',
  `sex` smallint(5) unsigned DEFAULT NULL COMMENT '男(0),女(1)',
  `phone` varchar(20) DEFAULT '' COMMENT '客户联系电话',
  `address` varchar(255) DEFAULT '' COMMENT '客户住址',
  `birthdate` datetime DEFAULT NULL COMMENT '出身日期',
  `birthplace` varchar(255) DEFAULT '' COMMENT '出身地',
  `nation` varchar(50) DEFAULT '' COMMENT '名族',
  `marriage` smallint(5) unsigned DEFAULT NULL COMMENT '未婚(0);已婚(1)',
  `occupation` varchar(50) DEFAULT '' COMMENT '职业',
  `company` varchar(255) DEFAULT '' COMMENT '公司名称',
  `registerTime` datetime NOT NULL COMMENT '注册时间',
  `status` smallint(6) NOT NULL COMMENT '客户类型(-1:黑名单客户; 0:普通客户 ; 1: 普通会员客户; 2 :超级会员客户 ;)',
  PRIMARY KEY (`clientId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', '客户一', '', '20', '0', '', '', '2017-10-24 09:24:13', '', '', '1', '', '', '2017-10-24 09:23:22', '0');

-- ----------------------------
-- Table structure for clienttreatmentinfo
-- ----------------------------
DROP TABLE IF EXISTS `clienttreatmentinfo`;
CREATE TABLE `clienttreatmentinfo` (
  `clientTreatmentInfoId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '客户执行治疗记录编号',
  `clientTreatmentProjectId` bigint(20) unsigned NOT NULL COMMENT '客户治疗项目编号',
  `clientId` bigint(20) unsigned NOT NULL COMMENT '客户编号',
  `employeeId` bigint(20) unsigned NOT NULL COMMENT '执行治疗项目employee编号',
  `departmentId` int(10) unsigned NOT NULL COMMENT '所属科室',
  `clinicId` int(10) unsigned NOT NULL COMMENT '所属门诊',
  `treatTime` datetime NOT NULL COMMENT '治疗时间',
  PRIMARY KEY (`clientTreatmentInfoId`),
  KEY `FKcf9qjg54h0sypaqvv6mwpkgb0` (`clientId`),
  KEY `FKp577lwwqqfd1s1484wi0wqv7i` (`clientTreatmentProjectId`),
  KEY `FK6ycjp9lxs1r9m5ueiejxkvk2v` (`clinicId`),
  KEY `FKnxkek4n2j074txpaak68pxbei` (`departmentId`),
  KEY `FKf46110xv21ufyjrhqdlmyylh9` (`employeeId`),
  CONSTRAINT `FK6ycjp9lxs1r9m5ueiejxkvk2v` FOREIGN KEY (`clinicId`) REFERENCES `clinic` (`clinicId`),
  CONSTRAINT `FKcf9qjg54h0sypaqvv6mwpkgb0` FOREIGN KEY (`clientId`) REFERENCES `client` (`clientId`),
  CONSTRAINT `FKf46110xv21ufyjrhqdlmyylh9` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  CONSTRAINT `FKnxkek4n2j074txpaak68pxbei` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `FKp577lwwqqfd1s1484wi0wqv7i` FOREIGN KEY (`clientTreatmentProjectId`) REFERENCES `clienttreatmentproject` (`clientTreatmentProjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clienttreatmentinfo
-- ----------------------------

-- ----------------------------
-- Table structure for clienttreatmentproject
-- ----------------------------
DROP TABLE IF EXISTS `clienttreatmentproject`;
CREATE TABLE `clienttreatmentproject` (
  `clientTreatmentProjectId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '客户治疗项目表编号',
  `clientId` bigint(20) unsigned NOT NULL COMMENT '客户编号',
  `billId` bigint(20) unsigned NOT NULL COMMENT '单据编号',
  `projectId` bigint(20) unsigned NOT NULL COMMENT '治疗项目编号',
  `unitPrice` double unsigned NOT NULL COMMENT '治疗一次的价格',
  `totalNumber` smallint(5) unsigned NOT NULL COMMENT '治疗项目需要执行的总次数',
  `restNumber` smallint(5) unsigned NOT NULL COMMENT '治疗项目剩下治疗次数',
  `startTime` datetime NOT NULL COMMENT '开始时间',
  `deadline` date NOT NULL COMMENT '截至时间',
  `status` smallint(6) NOT NULL COMMENT '(0:正常; -1:次数用完; -2:过期;)',
  PRIMARY KEY (`clientTreatmentProjectId`),
  KEY `FKhqnnhxo32jafia50k6n4e3wnn` (`billId`),
  KEY `FKr3rj3ybcp0rn4vhcwvqy3ocd2` (`clientId`),
  KEY `FKfxfpvihkatxtv90pcj6l7flbp` (`projectId`),
  CONSTRAINT `FKfxfpvihkatxtv90pcj6l7flbp` FOREIGN KEY (`projectId`) REFERENCES `project` (`projectId`),
  CONSTRAINT `FKhqnnhxo32jafia50k6n4e3wnn` FOREIGN KEY (`billId`) REFERENCES `bill` (`billId`),
  CONSTRAINT `FKr3rj3ybcp0rn4vhcwvqy3ocd2` FOREIGN KEY (`clientId`) REFERENCES `client` (`clientId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clienttreatmentproject
-- ----------------------------
INSERT INTO `clienttreatmentproject` VALUES ('8', '1', '20', '1', '10', '10', '10', '2017-10-29 22:05:06', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('9', '1', '20', '2', '20', '20', '20', '2017-10-29 22:05:06', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('10', '1', '22', '1', '10', '10', '10', '2017-10-29 22:06:01', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('11', '1', '22', '2', '20', '20', '20', '2017-10-29 22:06:01', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('12', '1', '23', '1', '10', '20', '20', '2017-10-29 22:07:02', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('13', '1', '23', '2', '20', '30', '30', '2017-10-29 22:07:02', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('14', '1', '24', '1', '10', '20', '20', '2017-10-29 22:07:05', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('15', '1', '24', '2', '20', '30', '30', '2017-10-29 22:07:05', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('20', '1', '27', '2', '20', '20', '20', '2017-10-29 22:10:25', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('21', '1', '27', '5', '30', '30', '30', '2017-10-29 22:10:25', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('22', '1', '28', '2', '20', '20', '20', '2017-10-29 22:10:26', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('23', '1', '28', '5', '30', '30', '30', '2017-10-29 22:10:26', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('24', '1', '29', '1', '10', '10', '10', '2017-10-29 22:11:18', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('25', '1', '29', '5', '30', '30', '30', '2017-10-29 22:11:18', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('26', '1', '30', '1', '10', '10', '10', '2017-10-29 22:11:18', '2017-12-10', '0');
INSERT INTO `clienttreatmentproject` VALUES ('27', '1', '30', '5', '30', '30', '30', '2017-10-29 22:11:18', '2017-12-10', '0');

-- ----------------------------
-- Table structure for clinic
-- ----------------------------
DROP TABLE IF EXISTS `clinic`;
CREATE TABLE `clinic` (
  `clinicId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `employeeId` bigint(20) unsigned NOT NULL COMMENT '门诊负责人编号',
  `creatorId` bigint(20) unsigned NOT NULL COMMENT '创建门诊employee的编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '门诊名称',
  `address` varchar(255) DEFAULT '' COMMENT '门诊地址',
  `phone` varchar(20) DEFAULT '' COMMENT '门诊电话',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`clinicId`),
  KEY `FKhq87kared1ta89jshnh6o02j5` (`creatorId`),
  KEY `FKeyxre93si7s7spb31w16iagq0` (`employeeId`),
  CONSTRAINT `FKeyxre93si7s7spb31w16iagq0` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  CONSTRAINT `FKhq87kared1ta89jshnh6o02j5` FOREIGN KEY (`creatorId`) REFERENCES `employee` (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clinic
-- ----------------------------
INSERT INTO `clinic` VALUES ('1', '1', '1', '门诊一', '门诊一地址', '15623060123', '2017-10-24 09:21:34');
INSERT INTO `clinic` VALUES ('2', '1', '1', '门诊二', '门诊二地址', '15626330333', '2017-10-28 13:08:59');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '科室编号',
  `clinicId` int(10) unsigned NOT NULL COMMENT '所属门诊编号',
  `employeeId` bigint(20) unsigned NOT NULL COMMENT '科室负责人编号',
  `creatorId` bigint(20) unsigned NOT NULL COMMENT '创建科室emoloyee的编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '科室名称',
  `phone` varchar(20) DEFAULT '' COMMENT '科室电话',
  `createTime` datetime NOT NULL COMMENT '科室创建日期',
  PRIMARY KEY (`departmentId`),
  KEY `FKgjfsn0tvmky29ytylxpeaihfv` (`clinicId`),
  KEY `FKsay4eh6fji9tgtmvonjj7m16i` (`creatorId`),
  KEY `FK86c29vj31mfeu5e1342i81yd1` (`employeeId`),
  CONSTRAINT `FK86c29vj31mfeu5e1342i81yd1` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  CONSTRAINT `FKgjfsn0tvmky29ytylxpeaihfv` FOREIGN KEY (`clinicId`) REFERENCES `clinic` (`clinicId`),
  CONSTRAINT `FKsay4eh6fji9tgtmvonjj7m16i` FOREIGN KEY (`creatorId`) REFERENCES `employee` (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '1', '1', '1', '科室一', '15623030433', '2017-10-24 09:20:46');
INSERT INTO `department` VALUES ('2', '1', '1', '1', '科室二', '15626030452', '2017-10-28 13:09:23');
INSERT INTO `department` VALUES ('3', '2', '1', '1', '科室三', '15626030455', '2017-10-29 22:00:07');
INSERT INTO `department` VALUES ('4', '2', '1', '1', '科室四', '15626030458', '2017-10-29 22:00:24');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `positionId` int(10) unsigned NOT NULL COMMENT '所属职位Id ',
  `departmentId` int(10) unsigned DEFAULT NULL COMMENT '所属科室编号',
  `clinicId` int(10) unsigned DEFAULT NULL COMMENT '所属门诊编号',
  `account` varchar(50) NOT NULL DEFAULT '' COMMENT '登录账号',
  `pwd` varchar(50) NOT NULL DEFAULT '' COMMENT '登录密码',
  `name` varchar(50) DEFAULT '' COMMENT '姓名',
  `identity` varchar(18) DEFAULT '' COMMENT '身份证',
  `age` smallint(5) unsigned DEFAULT NULL COMMENT '员工年龄',
  `sex` smallint(5) unsigned DEFAULT NULL COMMENT '男(0),女(1)',
  `phone` varchar(20) DEFAULT '',
  `address` varchar(255) DEFAULT '' COMMENT '住址',
  `birthdate` date DEFAULT NULL COMMENT '出身日期',
  `birthplace` varchar(255) DEFAULT '' COMMENT '出身地',
  `nation` varchar(50) DEFAULT '' COMMENT '名族',
  `marriage` smallint(5) unsigned DEFAULT NULL COMMENT '未婚(0);已婚(1)',
  `billCost` double DEFAULT NULL COMMENT '开单抽成所占总价格百分比(10.23:表示占10.23%)',
  `registerTime` datetime NOT NULL,
  `loginTime` datetime DEFAULT NULL,
  `status` smallint(6) NOT NULL COMMENT '账号状态;(0:在线; 1:不在线; -1:禁止登陆)',
  `isOnJob` smallint(5) unsigned NOT NULL COMMENT '在职(0);离职(1)',
  PRIMARY KEY (`employeeId`),
  KEY `FK59jkxrxslbghc9lkq9v6kbg8` (`clinicId`),
  KEY `FKqrxujpcl9722pv7acfm7s8wyq` (`departmentId`),
  KEY `FK4kag5qxy2x0csnq71fy65brhk` (`positionId`),
  CONSTRAINT `FK4kag5qxy2x0csnq71fy65brhk` FOREIGN KEY (`positionId`) REFERENCES `position` (`positionId`),
  CONSTRAINT `FK59jkxrxslbghc9lkq9v6kbg8` FOREIGN KEY (`clinicId`) REFERENCES `clinic` (`clinicId`),
  CONSTRAINT `FKqrxujpcl9722pv7acfm7s8wyq` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '1', '1', '1', 'pis', '123123', 'pismery', '', null, null, '', '', null, '', '', null, null, '2017-10-24 09:19:50', null, '0', '0');
INSERT INTO `employee` VALUES ('2', '1', '2', '1', 'acc', '123123', 'account', '', null, null, '', '', null, '', '', null, null, '2017-10-28 09:34:58', null, '0', '0');
INSERT INTO `employee` VALUES ('3', '1', '3', '2', 'acc3', '123123', 'account3', '', null, null, '', '', null, '', '', null, null, '2017-10-29 22:14:06', null, '0', '0');
INSERT INTO `employee` VALUES ('4', '1', '4', '2', 'acc4', '123123', 'account4', '', null, null, '', '', null, '', '', null, null, '2017-10-29 22:15:10', null, '0', '0');

-- ----------------------------
-- Table structure for hospitalization
-- ----------------------------
DROP TABLE IF EXISTS `hospitalization`;
CREATE TABLE `hospitalization` (
  `hospitalizationId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '住院信息编号',
  `clientId` bigint(20) unsigned NOT NULL COMMENT '住院客户编号',
  `departmentId` int(10) unsigned NOT NULL COMMENT '所属科室编号',
  `codeICD` varchar(50) DEFAULT '' COMMENT '国际疾病分类编号',
  `enterDiagnosis` varchar(255) DEFAULT '' COMMENT '入院时诊断',
  `leaveDiagnosis` varchar(255) DEFAULT '' COMMENT '出院时诊断',
  `enterSituation` varchar(255) DEFAULT '' COMMENT '入院时患者情况',
  `leaveSituation` varchar(255) DEFAULT '' COMMENT '出院患者情况',
  `enterTime` datetime NOT NULL,
  `leaveTime` datetime DEFAULT NULL,
  PRIMARY KEY (`hospitalizationId`),
  KEY `FKdr8sxqwkuq9fumj9a3n92el8l` (`clientId`),
  KEY `FK57ru56h21oir0se3hp962waru` (`departmentId`),
  CONSTRAINT `FK57ru56h21oir0se3hp962waru` FOREIGN KEY (`departmentId`) REFERENCES `department` (`departmentId`),
  CONSTRAINT `FKdr8sxqwkuq9fumj9a3n92el8l` FOREIGN KEY (`clientId`) REFERENCES `client` (`clientId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hospitalization
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `logId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `employeeId` bigint(20) unsigned NOT NULL COMMENT '操作人员编号',
  `content` varchar(500) NOT NULL DEFAULT '' COMMENT '操作具体内容',
  `operate` varchar(50) NOT NULL DEFAULT '' COMMENT '操作方式',
  `operateTime` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`logId`),
  KEY `FKkmb2g1yp2vfvrmr5avarrxtxy` (`employeeId`),
  CONSTRAINT `FKkmb2g1yp2vfvrmr5avarrxtxy` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permissionId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限名称',
  PRIMARY KEY (`permissionId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '创建员工');
INSERT INTO `permission` VALUES ('2', '查询员工');
INSERT INTO `permission` VALUES ('3', '修改员工');
INSERT INTO `permission` VALUES ('4', '创建门诊');
INSERT INTO `permission` VALUES ('5', '查询门诊');
INSERT INTO `permission` VALUES ('6', '创建科室');
INSERT INTO `permission` VALUES ('7', '查询科室');
INSERT INTO `permission` VALUES ('8', '创建治疗项目');
INSERT INTO `permission` VALUES ('9', '查看治疗项目');
INSERT INTO `permission` VALUES ('10', '修改治疗项目');
INSERT INTO `permission` VALUES ('11', '创建客户');
INSERT INTO `permission` VALUES ('12', '查看客户');
INSERT INTO `permission` VALUES ('13', '修改客户');
INSERT INTO `permission` VALUES ('14', '创建病例');
INSERT INTO `permission` VALUES ('15', '查看病例');
INSERT INTO `permission` VALUES ('16', '修改病例');
INSERT INTO `permission` VALUES ('17', '创建职位');
INSERT INTO `permission` VALUES ('18', '查看职位');
INSERT INTO `permission` VALUES ('19', '修改职位');
INSERT INTO `permission` VALUES ('20', '创建治疗项目单据');
INSERT INTO `permission` VALUES ('21', '查看治疗项目单据');
INSERT INTO `permission` VALUES ('22', '修改治疗项目单据');
INSERT INTO `permission` VALUES ('23', '创建费用单据');
INSERT INTO `permission` VALUES ('24', '查看费用单据');
INSERT INTO `permission` VALUES ('25', '修改费用单据');
INSERT INTO `permission` VALUES ('26', '查看报表');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `positionId` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `creatorId` bigint(20) unsigned NOT NULL COMMENT '创建职位employee的编号',
  `name` varchar(50) NOT NULL DEFAULT '',
  `description` varchar(255) DEFAULT '' COMMENT '职位描述',
  `rank` smallint(5) unsigned NOT NULL COMMENT '职位等级 (1:员工级；2：科室级；3:门诊级；4：企业级; 5:超级管理员级;) （创建职位、设置员工职位都只能是设置低于所属等级的职位）',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`positionId`),
  KEY `FK9uo46gc84wag8nnlrht761c78` (`creatorId`),
  CONSTRAINT `FK9uo46gc84wag8nnlrht761c78` FOREIGN KEY (`creatorId`) REFERENCES `employee` (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES ('1', '1', '超级管理员', '具有最高权限', '4', '2017-10-24 09:29:01');

-- ----------------------------
-- Table structure for positionpermission
-- ----------------------------
DROP TABLE IF EXISTS `positionpermission`;
CREATE TABLE `positionpermission` (
  `positionId` int(10) unsigned NOT NULL COMMENT '职位编号',
  `permissionId` int(10) unsigned NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`positionId`,`permissionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of positionpermission
-- ----------------------------
INSERT INTO `positionpermission` VALUES ('1', '1');
INSERT INTO `positionpermission` VALUES ('1', '2');
INSERT INTO `positionpermission` VALUES ('1', '3');
INSERT INTO `positionpermission` VALUES ('1', '4');
INSERT INTO `positionpermission` VALUES ('1', '5');
INSERT INTO `positionpermission` VALUES ('1', '6');
INSERT INTO `positionpermission` VALUES ('1', '7');
INSERT INTO `positionpermission` VALUES ('1', '8');
INSERT INTO `positionpermission` VALUES ('1', '9');
INSERT INTO `positionpermission` VALUES ('1', '10');
INSERT INTO `positionpermission` VALUES ('1', '11');
INSERT INTO `positionpermission` VALUES ('1', '12');
INSERT INTO `positionpermission` VALUES ('1', '13');
INSERT INTO `positionpermission` VALUES ('1', '14');
INSERT INTO `positionpermission` VALUES ('1', '15');
INSERT INTO `positionpermission` VALUES ('1', '16');
INSERT INTO `positionpermission` VALUES ('1', '17');
INSERT INTO `positionpermission` VALUES ('1', '18');
INSERT INTO `positionpermission` VALUES ('1', '19');
INSERT INTO `positionpermission` VALUES ('1', '20');
INSERT INTO `positionpermission` VALUES ('1', '21');
INSERT INTO `positionpermission` VALUES ('1', '22');
INSERT INTO `positionpermission` VALUES ('1', '23');
INSERT INTO `positionpermission` VALUES ('1', '24');
INSERT INTO `positionpermission` VALUES ('1', '25');
INSERT INTO `positionpermission` VALUES ('1', '26');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `projectId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '费用项目编号',
  `creatorId` bigint(20) unsigned NOT NULL COMMENT '创建项目员工的唯一标识',
  `category` varchar(255) NOT NULL DEFAULT '' COMMENT '治疗项目(treatmentProject);表示其他项目(fundProject)',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '项目名称',
  `unitPrice` bigint(20) unsigned NOT NULL COMMENT '治疗项目一次治疗价格（费用项目如果是治疗项目）否则为0',
  `introduction` varchar(255) DEFAULT '' COMMENT '项目介绍',
  `suggestNumber` smallint(5) unsigned NOT NULL COMMENT ':建议治疗次数 （费用项目如果是治疗项目）否则为0',
  `type` smallint(5) unsigned NOT NULL COMMENT '收入(0),支出(1)',
  `status` smallint(5) unsigned NOT NULL COMMENT '已启用(0);已禁止(1)',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`projectId`),
  KEY `FKa5sgkskkujuj4asnsmhxg44qd` (`creatorId`),
  CONSTRAINT `FKa5sgkskkujuj4asnsmhxg44qd` FOREIGN KEY (`creatorId`) REFERENCES `employee` (`employeeId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1', '1', 'treatmentProject', '治疗项目一', '10', '治疗项目介绍', '10', '0', '0', '2017-10-24 09:26:58');
INSERT INTO `project` VALUES ('2', '1', 'treatmentProject', '治疗项目二', '20', '治疗项目介绍二', '20', '0', '0', '2017-10-26 15:24:51');
INSERT INTO `project` VALUES ('3', '1', 'fundProject', '费用收入项目一', '0', '费用收入项目介绍一', '0', '0', '0', '2017-10-27 16:25:19');
INSERT INTO `project` VALUES ('4', '1', 'fundProject', '费用支出项目二', '0', '费用支出项目介绍二', '0', '1', '0', '2017-10-27 16:26:01');
INSERT INTO `project` VALUES ('5', '1', 'treatmentProject', '治疗项目三', '30', '治疗项目介绍三', '30', '0', '0', '2017-10-29 22:01:45');
INSERT INTO `project` VALUES ('6', '1', 'treatmentProject', '治疗项目四', '40', '治疗项目介绍四', '40', '0', '0', '2017-10-29 22:29:32');
INSERT INTO `project` VALUES ('7', '1', 'fundProject', '费用收入项目三', '0', '费用收入项目三介绍', '0', '0', '0', '2017-10-30 09:43:37');
INSERT INTO `project` VALUES ('8', '1', 'fundProject', '费用支出项目四', '0', '费用支出项目四介绍', '0', '1', '0', '2017-10-30 09:44:49');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '病例记录编号',
  `employeeId` bigint(20) unsigned NOT NULL COMMENT '诊断医生编号',
  `clientId` bigint(20) unsigned NOT NULL COMMENT '被诊断客户编号',
  `complain` varchar(500) DEFAULT '' COMMENT '主诉',
  `presentIllness` varchar(500) DEFAULT '' COMMENT '现病史',
  `pastIllness` varchar(500) DEFAULT '' COMMENT '既往史',
  `physicalExamination` varchar(500) DEFAULT '' COMMENT '查体',
  `basis` varchar(500) DEFAULT '' COMMENT '诊断依据',
  `antidiastole` varchar(500) DEFAULT '' COMMENT '鉴别诊断',
  `preliminaryDiagnosis` varchar(500) DEFAULT '' COMMENT '初步诊断',
  `diagnosisPlan` varchar(500) DEFAULT '' COMMENT '诊断计划',
  `treatmentPlan` varchar(500) DEFAULT '' COMMENT '治疗计划',
  `createTime` datetime NOT NULL COMMENT '问诊时间',
  PRIMARY KEY (`recordId`),
  KEY `FK8nves8xbjaq0uxthyo1hrpdrl` (`clientId`),
  KEY `FK1nd4ws8v53uajwpgi0ilktrni` (`employeeId`),
  CONSTRAINT `FK1nd4ws8v53uajwpgi0ilktrni` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`employeeId`),
  CONSTRAINT `FK8nves8xbjaq0uxthyo1hrpdrl` FOREIGN KEY (`clientId`) REFERENCES `client` (`clientId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

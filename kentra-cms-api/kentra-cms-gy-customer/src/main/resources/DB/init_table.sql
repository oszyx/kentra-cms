/*
SQLyog v10.2
MySQL - 5.5.27 : Database - das-master
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_gy_fvs` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_gy_fvs`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '用户密码',
  `sex` varchar(100) DEFAULT NULL COMMENT '性别',
  `national` varchar(100) DEFAULT NULL COMMENT '国籍',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `photo` varchar(1000) DEFAULT NULL COMMENT '头像',
  `document_type` varchar(100) DEFAULT NULL COMMENT '证件类型',
  `document_num` varchar(100) DEFAULT NULL COMMENT '证件号码',
  `link_telphone1` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '联系方式1 手机',
  `link_telphone2` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '联系方式2 座机',
  `link_address` varchar(1000) DEFAULT NULL COMMENT '联系地址',
  `drive_num` varchar(100) DEFAULT NULL COMMENT '驾驶证号码',
  `drive_type` varchar(100) DEFAULT NULL COMMENT '准驾车型',
  `evidence_start` datetime DEFAULT NULL COMMENT '初次领证日期',
  `effective_start` datetime DEFAULT NULL COMMENT '有效期开始日期',
  `effective_end` datetime DEFAULT NULL COMMENT '有效期结束日期',
  `expiration_date` varchar(100) DEFAULT NULL COMMENT '有效期限',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `customer_status` varchar(100) DEFAULT NULL COMMENT '客户状态（1：正常；2：黑名单；3：白名单',
  `driver_license` varchar(1000) DEFAULT NULL COMMENT '驾驶证图片',
  `extends1` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `extends2` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  `extends3` varchar(100) DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */


/*Table structure for table `driving_license` */

DROP TABLE IF EXISTS `driving_license`;

CREATE TABLE `driving_license` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '行驶证ID',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `customer_level` varchar(100) DEFAULT NULL COMMENT '优先等级',
  `license_num` varchar(100) DEFAULT NULL COMMENT '车牌号码',
  `driving_num` varchar(50) DEFAULT NULL COMMENT '行驶证号码',
  `car_type` varchar(100) DEFAULT NULL COMMENT '车辆类型',
  `owner` varchar(100) DEFAULT NULL COMMENT '所有人',
  `house_address` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '家庭住址',
  `car_usetype` varchar(100) DEFAULT NULL COMMENT '使用性质',
  `car_vehicle` varchar(100) DEFAULT NULL COMMENT '车辆品牌型号',
  `car_indetcode` varchar(100) DEFAULT NULL COMMENT '车辆识别代号',
  `car_framenumber` varchar(100) DEFAULT NULL COMMENT '发动机号码',
  `register_date` datetime DEFAULT NULL COMMENT '注册日期',
  `issue_date` datetime DEFAULT NULL COMMENT '发证日期',
  `file_num` varchar(100) DEFAULT NULL COMMENT '档案编号',
  `author_num` varchar(100) DEFAULT NULL COMMENT '核定载人数',
  `total_mass` varchar(100) DEFAULT NULL COMMENT '总质量',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `driving_license` varchar(1000) DEFAULT NULL COMMENT '行驶证图片',
  `extends1` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `extends2` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  `extends3` varchar(100) DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

/*Data for the table `driving_license` */


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
-- ----------------------------
-- Table structure for `行驶轨迹表`
-- ----------------------------
DROP TABLE IF EXISTS `driving_track`;
CREATE TABLE `driving_track` (
  `id` int(20) NOT NULL auto_increment COMMENT '主键',
  `driving_record` varchar(100) default NULL COMMENT '行驶记录ID',
  `license_num` varchar(100) default NULL COMMENT '车牌号码',
  `device_gis_x` varchar(100) default NULL COMMENT '设备GISX',
  `device_gis_y` varchar(100) default NULL COMMENT '设备GISY',
  `through_time` datetime default NULL COMMENT '通过时间',
  `device_address` varchar(100) default NULL COMMENT '地址',
  `lane_num` varchar(100) default NULL COMMENT '车道编号',
  `equipment_number` varchar(100) default NULL COMMENT '设备编号',
  `extends1` varchar(100) default NULL COMMENT '备用字段(01:未结束行程02结束行程)',
  `extends2` varchar(100) default NULL COMMENT '备用字段(数据来源01采集设备02站口数据)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `行驶记录表`
-- ----------------------------
DROP TABLE IF EXISTS `driving_record`;
CREATE TABLE `driving_record` (
  `id` int(20) NOT NULL auto_increment COMMENT '主键',
  `driving_record` varchar(100) default NULL COMMENT '行驶记录ID',
  `license_num` varchar(100) default NULL COMMENT '车牌号码',
  `lane_num` varchar(100) default NULL COMMENT '车道编号',
  `entrance_time` datetime default NULL COMMENT '进站口时间',
  `exit_time` datetime default NULL COMMENT '出站口时间',
  `entrance_name` varchar(100) default NULL COMMENT '进站口名称',
  `exit_name` varchar(100) default NULL COMMENT '出站口名称',
  `create_time` datetime default NULL COMMENT '统计时间',
  `mileage` varchar(100) default NULL COMMENT '里程',
  `equipment_number` varchar(100) default NULL COMMENT '设备编号',
  `export_longitude` varchar(100) default NULL COMMENT '出口经度',
  `export_latitudes` varchar(100) default NULL COMMENT '出口纬度',
  `entrance_longitude` varchar(100) default NULL COMMENT '入口经度',
  `entrance_latitudes` varchar(100) default NULL COMMENT '入口纬度',
  `instation_code` varchar(100) default NULL COMMENT '进站口标识',
  `outstation_code` varchar(100) default NULL COMMENT '出站口标识',
  `extends1` varchar(100) default NULL COMMENT '备用字段1',
  `extends2` varchar(100) default NULL COMMENT '备用字段2',
  `extends3` varchar(100) default NULL COMMENT '备用字段3',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `缴费记录表`
-- ----------------------------
CREATE TABLE `pay_record` (
  `id` int(20) NOT NULL auto_increment COMMENT '主键',
  `license_num` varchar(100) default NULL COMMENT '车牌号码',
  `driving_record` varchar(100) default NULL COMMENT '行驶记录ID',
  `entrance_name` varchar(100) default NULL COMMENT '进站名称',
  `entrance_time` datetime default NULL COMMENT '进站时间',
  `exit_name` varchar(100) default NULL COMMENT '出站名称',
  `exit_time` datetime default NULL COMMENT '出站时间',
  `receivables` double(100,2) default '0.00' COMMENT '应缴费用',
  `pay_count` double(100,2) default '0.00' COMMENT '已缴费用',
  `expenses_paid` double(100,2) default '0.00' COMMENT '补缴费用',
  `pay_status` varchar(100) default NULL COMMENT '缴费类型（payment_type_0：已缴费，payment_type_1：待缴费，payment_type_2：补缴费）',
  `is_pay` varchar(100) default NULL COMMENT '是否缴费（payment_state_0：完成缴费，payment_state_1：未完成缴费）',
  `pay_time` datetime default NULL COMMENT '创建日期',
  `extends1` varchar(100) default NULL COMMENT '备用字段1',
  `extends2` varchar(100) default NULL COMMENT '备用字段2',
  `extends3` varchar(100) default NULL COMMENT '备用字段3',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `违规处理表`
-- ----------------------------
DROP TABLE IF EXISTS `break_record`;
CREATE TABLE `break_record` (
  `id` int(20) NOT NULL auto_increment COMMENT '主键',
  `driving_record` varchar(100) default NULL COMMENT '行驶记录ID',
  `license_num` varchar(100) default NULL COMMENT '车牌号码',
  `entrance_time` datetime default NULL COMMENT '行驶时间起',
  `exit_time` datetime default NULL COMMENT '行驶时间止',
  `entrance_name` varchar(100) default NULL COMMENT '行驶段起名称',
  `exit_name` varchar(100) default NULL COMMENT '行驶段止名称',
  `pay_money` varchar(100) default '0' COMMENT '待缴费金额',
  `remake_type` varchar(100) default NULL COMMENT '违规类型',
  `remake_content` varchar(1000) default NULL COMMENT '违规备注',
  `audit_status` varchar(100) default NULL COMMENT '审核状态（01：审核中 02：审核通过 03：审核不通过）',
  `create_time` datetime default NULL COMMENT '创建日期',
  `update_time` datetime default NULL COMMENT '更新日期',
  `extends1` varchar(100) default '0' COMMENT '应缴费金额',
  `extends2` varchar(100) default '0' COMMENT '已缴费金额',
  `extends3` varchar(100) default NULL COMMENT '备用字段3',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `收费规则表`
-- ----------------------------
DROP TABLE IF EXISTS `pay_rule`;
CREATE TABLE `pay_rule` (
  `id` int(20) NOT NULL auto_increment COMMENT '主键',
  `device_id_star` varchar(100) default NULL COMMENT '起点设备ID',
  `device_star_x` varchar(100) default NULL COMMENT '起点GISX',
  `device_star_y` varchar(100) default NULL COMMENT '起点GISY',
  `device_id_end` varchar(100) default NULL COMMENT '终点设备ID',
  `device_end_x` varchar(100) default NULL COMMENT '终点GISX',
  `device_end_y` varchar(100) default NULL COMMENT '终点GISY',
  `pay_type` varchar(100) default NULL COMMENT '收费类型(01:标准收费，02：罚款收费)',
  `pay_money` varchar(100) default NULL COMMENT '收费标准',
  `create_time` datetime default NULL COMMENT '创建日期',
  `update_time` datetime default NULL COMMENT '跟新日期',
  `extends1` varchar(100) default NULL COMMENT '备用字段1',
  `extends2` varchar(100) default NULL COMMENT '备用字段2',
  `extends3` varchar(100) default NULL COMMENT '备用字段3',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `支付记录`
-- ----------------------------
DROP TABLE IF EXISTS `payment_record`;
CREATE TABLE `payment_record` (
  `id` int(20) NOT NULL auto_increment COMMENT '主键',
  `customer_id` int(20) default NULL COMMENT '客户ID',
  `order_number` varchar(100) default NULL COMMENT '订单号',
  `payment_amount` varchar(100) default NULL COMMENT '支付金额',
  `payment_time` datetime default NULL COMMENT '支付时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `卡口数据图片`
-- ----------------------------
DROP TABLE IF EXISTS `card_port_data`;

CREATE TABLE `card_port_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `lane_num` varchar(100) DEFAULT NULL COMMENT '车道编号',
  `driving_record` varchar(100) DEFAULT NULL COMMENT '行驶记录id',
  `license_num` varchar(100) DEFAULT NULL COMMENT '车牌号',
  `pass_time` datetime DEFAULT NULL COMMENT '通过时间',
  `station_name` varchar(100) DEFAULT NULL COMMENT '站点名称',
  `img_url` varchar(200) DEFAULT NULL COMMENT '卡口数据图片路径',
  `status` varchar(20) DEFAULT NULL COMMENT '状态(01:未完成行程02结束行程)',
  `point_gis_x` varchar(100) DEFAULT NULL COMMENT '卡口经度',
  `point_gis_y` varchar(100) DEFAULT NULL COMMENT '卡口纬度',
  `point_code` varchar(100) DEFAULT NULL COMMENT '卡口标识',
  `extends1` varchar(100) DEFAULT NULL COMMENT '备用字段1',
  `extends2` varchar(100) DEFAULT NULL COMMENT '备用字段2',
  `extends3` varchar(100) DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `收费站表`
-- ----------------------------
DROP TABLE IF EXISTS `toll_station`;
CREATE TABLE `toll_station` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `toll_station_code` varchar(100) DEFAULT NULL COMMENT '收费站编码（车道）',
  `toll_station_name` varchar(100) DEFAULT NULL COMMENT '收费站名称',
  `longitude` varchar(100) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(100) DEFAULT NULL COMMENT '纬度',
  `status` varchar(100) DEFAULT NULL COMMENT '状态（01：启用 02：禁用）',
  `extends1` varchar(100) CHARACTER SET utf32 DEFAULT NULL COMMENT '备用字段1',
  `extends2` varchar(100) CHARACTER SET utf32 DEFAULT NULL COMMENT '备用字段2',
  `extends3` varchar(100) CHARACTER SET utf32 DEFAULT NULL COMMENT '备用字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='收费站表';


-- ----------------------------
-- Table structure for `sys_month`
-- ----------------------------
DROP TABLE IF EXISTS `sys_month`;
CREATE TABLE `sys_month` (
  `monthNum` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_month
-- ----------------------------
INSERT INTO `sys_month` VALUES ('1');
INSERT INTO `sys_month` VALUES ('2');
INSERT INTO `sys_month` VALUES ('3');
INSERT INTO `sys_month` VALUES ('4');
INSERT INTO `sys_month` VALUES ('5');
INSERT INTO `sys_month` VALUES ('6');
INSERT INTO `sys_month` VALUES ('7');
INSERT INTO `sys_month` VALUES ('8');
INSERT INTO `sys_month` VALUES ('9');
INSERT INTO `sys_month` VALUES ('10');
INSERT INTO `sys_month` VALUES ('11');
INSERT INTO `sys_month` VALUES ('12');

-- ----------------------------
-- Table structure for `sys_state`
-- ----------------------------
DROP TABLE IF EXISTS `sys_state`;
CREATE TABLE `sys_state` (
  `state` varchar(30) NOT NULL COMMENT '设备状态 只有01、02、 03、 04 四个'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='5.8G数据统计辅助表';

-- ----------------------------
-- Records of sys_state
-- ----------------------------
INSERT INTO `sys_state` VALUES ('equipment_state_0');
INSERT INTO `sys_state` VALUES ('equipment_state_1');
INSERT INTO `sys_state` VALUES ('equipment_state_2');
INSERT INTO `sys_state` VALUES ('equipment_state_3');


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
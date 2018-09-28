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

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL auto_increment COMMENT '菜单id',
  `menu_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `menu_code` varchar(20) NOT NULL COMMENT '菜单code',
  `menu_url` varchar(255) default NULL COMMENT '菜单访问路径',
  `menu_parent_id` bigint(20) default NULL COMMENT '父级菜单id',
  `menu_target` varchar(50) default NULL COMMENT '菜单打开方式',
  `menu_style` varchar(20) default NULL COMMENT '菜单样式',
  `menu_order` varchar(20) default NULL COMMENT '菜单顺序',
  `rely_system` varchar(20) default NULL COMMENT '菜单从属：所属系统',
  `status` varchar(20) default NULL COMMENT '菜单状态',
  `create_time` timestamp NULL default NULL COMMENT '创建时间',
  `update_time` timestamp NULL default NULL COMMENT '更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


/*Table structure for table `role` */
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(25) DEFAULT NULL COMMENT '角色名',
  `role_code` varchar(25) DEFAULT NULL COMMENT '角色code',
  `rely_system` int(2) DEFAULT NULL COMMENT '角色从属：所属系统',
  `desc` varchar(100) DEFAULT NULL COMMENT '角色信息描述',
  `status` int(2) DEFAULT NULL COMMENT '角色状态',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
   `role_parent_id` BIGINT(20) DEFAULT NULL COMMENT '角色父节点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


/*Table structure for table `role_menu` */
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色_菜单_id',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `telphone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '出生日期',
  `identity_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `rely_system` int(2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '用户状态',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `ext1` varchar(20) DEFAULT NULL COMMENT '扩展字段',
  `ext2` varchar(20) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;


/*Table structure for table `user_role` */
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户_角色_id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;


/*Table structure for table `dict` */

DROP TABLE IF EXISTS `dict`;

CREATE TABLE `dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dict_name` varchar(255) DEFAULT NULL,
  `dict_code` varchar(255) DEFAULT NULL,
  `dict_parent_id` bigint(255) DEFAULT NULL,
  `dict_level` int(11) DEFAULT NULL,
  `dict_desc` varchar(2000) DEFAULT NULL,
  `dict_status` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `updator` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=288 DEFAULT CHARSET=utf8;

/*Data for the table `user` */


CREATE TABLE `sys_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `v_id` varchar(20) NOT NULL COMMENT '版本号',
  `v_name` varchar(50) NOT NULL COMMENT '版本名称',
  `v_downloadUrl` varchar(255) NOT NULL COMMENT '下载地址',
  `v_state` varchar(255) NOT NULL COMMENT '版本状态(0:不可用,1:可用）',
  `v_forcedUpdate` varchar(255) NOT NULL COMMENT '是否强制更新(0:不强制,1:强制）',
  `v_releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `v_createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `v_extends` varchar(255) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='版本控制表';


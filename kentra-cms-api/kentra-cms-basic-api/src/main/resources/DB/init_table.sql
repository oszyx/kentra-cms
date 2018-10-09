CREATE DATABASE `db_kms_zipkin`;
USE `db_kms_zipkin`;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(1) DEFAULT NULL COMMENT '性别：0-女 1-男',
  `telphone` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `user_rights` varchar(1000) DEFAULT NULL COMMENT '用户权限',
  `user_status` int(2) DEFAULT NULL COMMENT '用户状态 0：禁用 1：可用',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `role_code` varchar(20) DEFAULT NULL COMMENT '角色码',
  `role_rights` varchar(1000) DEFAULT NULL COMMENT '角色权限',
  `role_status` int(2) DEFAULT '1' COMMENT '角色状态: 0-不可用 1-正常',
  `role_pid` bigint(20) DEFAULT NULL COMMENT '角色分组',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `menu_code` varchar(20) DEFAULT NULL COMMENT '菜单code',
  `menu_name` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `menu_icon` varchar(20) DEFAULT NULL COMMENT '菜单icon',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单访问路径',
  `menu_spread` tinyint(1) DEFAULT '0' COMMENT '是否展开(0:闭合 1:展开)',
  `menu_leaf` tinyint(1) DEFAULT '1' COMMENT '叶子节点(0:主干 1:叶子)',
  `menu_order` tinyint(2) DEFAULT NULL COMMENT '菜单顺序',
  `menu_status` tinyint(1) DEFAULT '1' COMMENT '菜单状态(0:禁用 1:可用)',
  `menu_desc` varchar(100) DEFAULT NULL COMMENT '菜单描述',
  `menu_pid` bigint(20) DEFAULT NULL COMMENT '父级菜单id',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `dict_name` varchar(6000) DEFAULT NULL COMMENT '字典名称',
  `dict_code` varchar(765) DEFAULT NULL COMMENT '字典code',
  `dict_order` int(3) DEFAULT NULL COMMENT '字典排序',
  `dict_pid` bigint(255) DEFAULT NULL COMMENT '字典父id',
  `dict_desc` varchar(6000) DEFAULT NULL COMMENT '字典描述',
  `dict_status` int(11) DEFAULT NULL COMMENT '字典状态',
  `has_child` int(1) DEFAULT NULL COMMENT '是否有子节点',
  `creator` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updator` bigint(20) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

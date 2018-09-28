
/**************************************************************/
/************************控制器设备管理表**********************/
/*************************************************************/

drop table if exists device_management;

/*==============================================================*/
/* Table: device_management                                     */
/*==============================================================*/
create table device_management
(
   id                   varchar(100) not null comment '设备ID',
   name                 varchar(100) comment '设备名称',
   device_code          varchar(100) comment '设备编号',
   device_address       varchar(100) comment '设备地址',
   device_gis_x         varchar(100) comment '设备所处经度',
   device_gis_y         varchar(100) comment '设备所处纬度',
   belong_eqipment      varchar(100) comment '所属设备管理',
   device_status        varchar(100) comment '设备状态',
   descrip_infos        varchar(1000) comment '设备描述信息',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   extends1             varchar(100) comment '备用字段1',
   extends2             varchar(100) comment '备用字段2',
   extends3             varchar(100) comment '备用字段3',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists controller_management;

/*==============================================================*/
/* Table: controller_management                                         */
/*==============================================================*/
CREATE TABLE `controller_management` (
  `id` varchar(50) NOT NULL COMMENT '控制器设备ID(UUID:controllerxxxxx)',
  `name` varchar(100) DEFAULT NULL COMMENT '控制器设备名称',
  `controller_code` varchar(100) DEFAULT NULL COMMENT '控制器设备编号',
  `controller_address` varchar(200) DEFAULT NULL COMMENT '控制器设备地址',
  `controller_gis_x` varchar(100) DEFAULT NULL COMMENT '控制器设备所处经度',
  `controller_gis_y` varchar(100) DEFAULT NULL COMMENT '控制器所处纬度',
  `controller_status` varchar(100) DEFAULT NULL COMMENT '网络状态',
  `descrip_infos` varchar(1000) DEFAULT NULL COMMENT '控制器描述信息',
  `create_time` timestamp COMMENT '创建时间',
  `update_time` timestamp COMMENT '更新时间',
  `extends1` varchar(100) DEFAULT NULL COMMENT '控制器IP地址',
  `extends2` varchar(100) DEFAULT NULL COMMENT '控制器端口号',
  `extends3` varchar(100) DEFAULT NULL COMMENT '天线状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists repair_record;

/*==============================================================*/
/* Table: repair_record                                         */
/*==============================================================*/
create table repair_record
(
   id                   int(20) not null auto_increment comment '维修记录ID',
   repair_device_id     varchar(100) comment '维修设备ID',
   repair_device_name   varchar(100) comment '维修设备名称',
   repair_user_name     varchar(100) comment '维修人员姓名',
   repair_user_phone    varchar(100) comment '维修人员联系电话',
   repair_date_star     datetime comment '维修时间起',
   repair_date_end      datetime comment '维修时间止',
   repair_status        varchar(100) comment '维修状态',
   repair_notice        varchar(1000) comment '维修事故通知说明',
   repair_reason        varchar(1000) comment '维修事故原因说明',
   extends1             varchar(100) comment '备用字段1',
   extends2             varchar(100) comment '备用字段2',
   extends3             varchar(100) comment '备用字段3',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists frame_management;

/*==============================================================*/
/* Table: frame_management                                      */
/*==============================================================*/
create table frame_management
(
   id                   varchar(100) not null comment '龙门架ID',
   name                 varchar(100) comment '龙门架名称',
   frame_code           varchar(100) comment '龙门架编号',
   frame_address        varchar(1000) comment '龙门架地址',
   frame_gis_x          varchar(100) comment '龙门架所处经度',
   frame_gis_y          varchar(100) comment '龙门架所处纬度',
   frame_status         varchar(100) comment '设备状态',
   descrip_infos        varchar(1000) comment '龙门架描述信息',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   extends1             varchar(100) comment '备用字段1',
   extends2             varchar(100) comment '备用字段2',
   extends3             varchar(100) comment '备用字段3',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


drop table if exists led_management;

/*==============================================================*/
/* Table: led_management                                         */
/*==============================================================*/
CREATE TABLE `led_management` (
  `id` varchar(100) CHARACTER SET utf8 NOT NULL COMMENT '主键id(UUID:LEDxxxx)',
  `name` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'LED名称',
  `LED_code` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'LED编号',
  `LED_address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'LED地址',
  `LED_gis_x` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'LED所处经度',
  `LED_gis_y` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT 'LED所处纬度',
  `LED_status` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '设备状态（01:未启动，02：正常，03：故障，04：维修中）',
  `descrip_infos` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `extends1` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '预留字段1',
  `extends2` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '预留字段2',
  `extends3` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='LED管理表';

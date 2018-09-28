/*
*初始数据
*/
/*用户初始密码123456*/
insert  into `user`(`id`,`username`,`password`,`telphone`,`birthday`,`identity_card`,`rely_system`,`status`,`create_time`,`update_time`,`ext1`,`ext2`) 
            values (1,'admin','e10adc3949ba59abbe56e057f20f883e','15088888888',sysdate(),'510922000000000000',1,0,NULL,NULL,NULL,NULL);

insert  into `role` values  (1,'root','root',1,'root',1,sysdate(),sysdate(),0),
                            (2,'管理角色','sysMangerRole',1,'admin',1,sysdate(),sysdate(),1),
                            (3,'管理员','admin',1,'admin',1,sysdate(),sysdate(),2);

insert  into `user_role`(`id`,`user_id`,`role_id`) values (1,1,3);

insert into menu VALUES(1,'根机构','root',null,0,NULL,null,1,null,null,SYSDATE(),SYSDATE()),
                       (2,'系统管理','sysManger','/system/management',1,NULL,NULL,2,NULL,NULL,SYSDATE(),SYSDATE()),
                       (3,'用户管理','userManger','/web/user/goListPage',2,NULL,NULL,3,NULL,NULL,SYSDATE(),SYSDATE()),
                       (4,'角色管理','roleManger','/web/role/goListPage',2,NULL,NULL,4,NULL,NULL,SYSDATE(),SYSDATE()),
                       (5,'菜单管理','menuManger','/web/menu/getTreeList',2,NULL,NULL,5,NULL,NULL,SYSDATE(),SYSDATE()),
                       (6,'数据字典','dict','/web/dict/index',2,NULL,NULL,6,NULL,NULL,SYSDATE(),SYSDATE()),
                       (26,'版本管理','sysVersion','/web/sysVersion/goList',2,NULL,NULL,26,NULL,NULL,SYSDATE(),SYSDATE());

insert  into `role_menu`(`id`,`menu_id`,`role_id`) 
                 values (1,1,3),(2,2,3),(3,3,3),(4,4,3),(5,5,3),(6,6,3),(7,7,3),(9,9,3),(10,10,3)
                       ,(11,11,3),(12,12,3),(13,13,3),(14,14,3),(15,15,3),(16,16,3),(17,17,3),(18,18,3),(19,19,3);

/*设备管理*/
insert into menu VALUES (7,'设备管理','deviceManger','/device/management',1,NULL,NULL,7,NULL,NULL,SYSDATE(),SYSDATE()),
                        --  废除(8,'采集设备管理','5.8GdeviceManger','/gyWeb/device/index',7,NULL,NULL,8,NULL,NULL,SYSDATE(),SYSDATE()),
                        (9,'控制器管理','controllerManger','/gyWeb/control/goList',7,NULL,NULL,9,NULL,NULL,SYSDATE(),SYSDATE()),
                        (10,'龙门架管理','frameManger','/gyWeb/frame/index',7,NULL,NULL,10,NULL,NULL,SYSDATE(),SYSDATE()),
                        (11,'LED设备管理','LEDManger','/gyWeb/led/list',7,NULL,NULL,11,NULL,NULL,SYSDATE(),SYSDATE()),
                        (20,'收费站管理','tollStation', '/gyWeb/tollStation/goList', '7', NULL, NULL, '20', NULL, NULL, SYSDATE(),SYSDATE());

/*客户账户管理*/
insert into menu VALUES (12,'客户账户管理','customerCount','/sys/user/account',1,NULL,NULL,12,NULL,NULL,SYSDATE(),SYSDATE()),
                        (13,'客户管理','customerManger','/gyWeb/customer/index',12,NULL,NULL,13,NULL,NULL,SYSDATE(),SYSDATE()),
                        (14,'黑名单管理','blackCustomer','/gyWeb/blacklist/index',12,NULL,NULL,14,NULL,NULL,SYSDATE(),SYSDATE()),
                        (15,'白名单管理','whiteCustomer','/gyWeb/whitelist/index',12,NULL,NULL,15,NULL,NULL,SYSDATE(),SYSDATE());

/*缴费/行驶轨迹管理*/
insert into menu VALUES (16,'缴费/行驶轨迹管理','pay/drvingManger','payment/trajectory/management',1,NULL,NULL,16,NULL,NULL,SYSDATE(),SYSDATE()),
                        (17,'行驶记录','drvingRecord','/gyWeb/drivingrecord/getPageList',16,NULL,NULL,17,NULL,NULL,SYSDATE(),SYSDATE()),
                        (18,'违规处理','breakRecord','/gyWeb/breakRecord/goList',16,NULL,NULL,18,NULL,NULL,SYSDATE(),SYSDATE()),
                        (19,'缴费记录','payRecord','/gyWeb/record/getPageList',16,NULL,NULL,19,NULL,NULL,SYSDATE(),SYSDATE());
/*违规处理*/
insert into menu VALUES (22,'数据统计','count','null',1,NULL,NULL,22,NULL,NULL,SYSDATE(),SYSDATE()),
                        --  废除(23,'采集设备统计','deviceCount','/gyWeb/device/deviceCount',22,NULL,NULL,23,NULL,NULL,SYSDATE(),SYSDATE()),
                        (24,'用户注册统计','registerCustomer','/gyWeb/customer/customerCount',22,NULL,NULL,24,NULL,NULL,SYSDATE(),SYSDATE()),
                        (25,'违规记录统计','breakCount','/gyWeb/count/goBreakCount',22,NULL,NULL,25,NULL,NULL,SYSDATE(),SYSDATE());

			
/*数据字典*/
INSERT INTO `dict` VALUES ('1', '根节点', 'root', '0', '1', '根节点', '1', '2018-08-03 14:49:00', null, null, null, '1');
INSERT INTO `dict` VALUES ('2', '民族', 'nation', '1', '102', '56个民族', '1', '2018-08-03 15:38:07', null, null, null, '1');
INSERT INTO `dict` VALUES ('3', '汉族', 'nation_0', '2', '10202', '01', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('4', '蒙古族', 'nation_1', '2', '10203', '02', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('5', '回族', 'nation_2', '2', '10204', '03', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('6', '藏族', 'nation_3', '2', '10205', '04', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('7', '维吾尔族', 'nation_4', '2', '10206', '05', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('8', '苗族', 'nation_5', '2', '10207', '06', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('9', '彝族', 'nation_6', '2', '10208', '07', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('10', '壮族', 'nation_7', '2', '10209', '08', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('11', '布依族', 'nation_8', '2', '10210', '09', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('12', '朝鲜族', 'nation_9', '2', '10211', '10', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('13', '满族', 'nation_10', '2', '10212', '11', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('14', '侗族', 'nation_11', '2', '10213', '12', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('15', '瑶族', 'nation_12', '2', '10214', '13', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('16', '白族', 'nation_13', '2', '10215', '14', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('17', '土家族', 'nation_14', '2', '10216', '15', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('18', '哈尼族', 'nation_15', '2', '10217', '16', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('19', '哈萨克族', 'nation_16', '2', '10218', '17', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('20', '傣族', 'nation_17', '2', '10219', '18', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('21', '黎族', 'nation_18', '2', '10220', '19', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('22', '傈僳族', 'nation_19', '2', '10221', '20', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('23', '佤族', 'nation_20', '2', '10222', '21', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('24', '畲族', 'nation_21', '2', '10223', '22', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('25', '高山族', 'nation_22', '2', '10224', '23', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('26', '拉祜族', 'nation_23', '2', '10225', '24', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('27', '水族', 'nation_24', '2', '10226', '25', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('28', '东乡族', 'nation_25', '2', '10227', '26', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('29', '纳西族', 'nation_26', '2', '10228', '27', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('30', '景颇族', 'nation_27', '2', '10229', '28', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('31', '柯尔克孜族', 'nation_28', '2', '10230', '29', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('32', '土族', 'nation_29', '2', '10231', '30', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('33', '达斡尔族', 'nation_30', '2', '10232', '31', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('34', '仫佬族', 'nation_31', '2', '10233', '32', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('35', '羌族', 'nation_32', '2', '10234', '33', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('36', '布朗族', 'nation_33', '2', '10235', '34', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('37', '撒拉族', 'nation_34', '2', '10236', '35', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('38', '毛南族', 'nation_35', '2', '10237', '36', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('39', '仡佬族', 'nation_36', '2', '10238', '37', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('40', '锡伯族', 'nation_37', '2', '10239', '38', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('41', '阿昌族', 'nation_38', '2', '10240', '39', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('42', '普米族', 'nation_39', '2', '10241', '40', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('43', '塔吉克族', 'nation_40', '2', '10242', '41', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('44', '怒族', 'nation_41', '2', '10243', '42', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('45', '乌孜别克族', 'nation_42', '2', '10244', '43', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('46', '俄罗斯族', 'nation_43', '2', '10245', '44', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('47', '鄂温克族', 'nation_44', '2', '10246', '45', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('48', '德昴族', 'nation_45', '2', '10247', '46', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('49', '保安族', 'nation_46', '2', '10248', '47', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('50', '裕固族', 'nation_47', '2', '10249', '48', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('51', '京族', 'nation_48', '2', '10250', '49', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('52', '塔塔尔族', 'nation_49', '2', '10251', '50', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('53', '独龙族', 'nation_50', '2', '10252', '51', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('54', '鄂伦春族', 'nation_51', '2', '10253', '52', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('55', '赫哲族', 'nation_52', '2', '10254', '53', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('56', '门巴族', 'nation_53', '2', '10255', '54', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('57', '珞巴族', 'nation_54', '2', '10256', '55', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('58', '基诺族', 'nation_55', '2', '10257', '56', '1', null, null, null, null, '1');

INSERT INTO `dict` VALUES ('59', '性别', 'indexSex', '1', '109', '性别', '1', '2018-08-03 15:38:20', null, null, null, '1');
INSERT INTO `dict` VALUES ('60', '男', 'indexSex_0', '59', '10901', '1', '1', null, null, '2018-08-03 15:27:49', null, '1');
INSERT INTO `dict` VALUES ('61', '女', 'indexSex_1', '59', '10902', '2', '1', null, null, null, null, '1');

INSERT INTO `dict` VALUES ('62', '婚姻', 'indexMaritalStatus', '1', '110', '婚姻', '1', '2018-08-03 15:44:53', null, null, null, '1');
INSERT INTO `dict` VALUES ('63', '未婚', 'indexMaritalStatus_0', '62', '11001', '1', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('64', '已婚', 'indexMaritalStatus_1', '62', '11002', '2', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('65', '初婚', 'indexMaritalStatus_2', '62', '11003', '3', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('66', '再婚', 'indexMaritalStatus_3', '62', '11004', '4', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('67', '复婚', 'indexMaritalStatus_4', '62', '11005', '5', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('68', '离婚', 'indexMaritalStatus_5', '62', '11006', '6', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('69', '丧偶', 'indexMaritalStatus_6', '62', '11007', '7', '1', null, null, null, null, '1');
INSERT INTO `dict` VALUES ('70', '未说明的婚姻状况', 'indexMaritalStatus_7', '62', '11008', '8', '1', null, null, null, null, '1');

INSERT INTO `dict` VALUES ('71', '国籍', 'nationality', '1', '111', '国籍', '1', '2018-08-03 15:50:01', '1', null, null, '1');
INSERT INTO `dict` VALUES ('72', '中国', 'nationality_0', '71', '11101', '1', '1', '2018-08-03 15:51:45', '1', null, null, '1');
INSERT INTO `dict` VALUES ('73', '港、澳、台', 'nationality_1', '71', '11102', '2', '1', '2018-08-03 15:54:28', '1', null, null, '1');

INSERT INTO `dict` VALUES ('74', '证件类型', 'document_type', '1', '112', '证件类型', '1', '2018-08-03 15:55:57', '1', null, null, '1');
INSERT INTO `dict` VALUES ('75', '身份证', 'document_type_0', '74', '11201', '1', '1', '2018-08-03 15:56:16', '1', null, null, '1');
-- INSERT INTO `dict` VALUES ('76', '驾驶证', 'document_type_1', '74', '11202', '2', '1', '2018-08-03 15:56:43', '1', null, null, '1');
-- INSERT INTO `dict` VALUES ('77', '军官证', 'document_type_2', '74', '11203', '3', '1', '2018-08-03 15:57:52', '1', '2018-08-03 16:16:58', '1', '1');

INSERT INTO `dict` VALUES ('78', '准驾车型', 'quasi_driving_car_model', '1', '113', '允许驾驶车型', '1', '2018-08-03 16:01:21', '1', null, null, '1');
INSERT INTO `dict` VALUES ('79', 'A1', 'quasi_driving_car_model_0', '78', '11301', '1', '1', '2018-08-03 16:02:09', '1', '2018-08-03 16:05:17', '1', '1');
INSERT INTO `dict` VALUES ('80', 'A2', 'quasi_driving_car_model_1', '78', '11302', '2', '1', '2018-08-03 16:05:39', '1', null, null, '1');
INSERT INTO `dict` VALUES ('81', 'A3', 'quasi_driving_car_model_2', '78', '11303', '3', '1', '2018-08-03 16:05:56', '1', null, null, '1');
INSERT INTO `dict` VALUES ('82', 'B1', 'quasi_driving_car_model_3', '78', '11304', '4', '1', '2018-08-03 16:06:27', '1', '2018-08-03 16:06:38', '1', '1');
INSERT INTO `dict` VALUES ('83', 'B2', 'quasi_driving_car_model_4', '78', '11305', '5', '1', '2018-08-03 16:06:57', '1', null, null, '1');
INSERT INTO `dict` VALUES ('84', 'C1', 'quasi_driving_car_model_5', '78', '11306', '6', '1', '2018-08-03 16:07:19', '1', null, null, '1');
INSERT INTO `dict` VALUES ('85', 'C2', 'quasi_driving_car_model_6', '78', '11307', '7', '1', '2018-08-03 16:07:42', '1', null, null, '1');
INSERT INTO `dict` VALUES ('86', 'C3', 'quasi_driving_car_model_7', '78', '11308', '8\n', '1', '2018-08-03 16:07:56', '1', null, null, '1');
INSERT INTO `dict` VALUES ('87', 'C4', 'quasi_driving_car_model_8', '78', '11309', '9', '1', '2018-08-03 16:08:18', '1', null, null, '1');
INSERT INTO `dict` VALUES ('88', 'D', 'quasi_driving_car_model_9', '78', '11310', '10', '1', '2018-08-03 16:08:37', '1', null, null, '1');
INSERT INTO `dict` VALUES ('89', 'E', 'quasi_driving_car_model_10', '78', '11311', '11', '1', '2018-08-03 16:09:27', '1', null, null, '1');
INSERT INTO `dict` VALUES ('90', 'F', 'quasi_driving_car_model_11', '78', '11312', '12', '1', '2018-08-03 16:09:42', '1', null, null, '1');
INSERT INTO `dict` VALUES ('91', 'M', 'quasi_driving_car_model_12', '78', '11313', '13', '1', '2018-08-03 16:10:06', '1', null, null, '1');
INSERT INTO `dict` VALUES ('92', 'N', 'quasi_driving_car_model_13', '78', '11314', '14', '1', '2018-08-03 16:10:40', '1', null, null, '1');
INSERT INTO `dict` VALUES ('93', 'P', 'quasi_driving_car_model_14', '78', '11315', '15', '1', '2018-08-03 16:10:53', '1', null, null, '1');

INSERT INTO `dict` VALUES ('94', '客户状态', 'customer_status', '1', '114', '客户状态', '1', '2018-08-03 16:13:41', '1', null, null, '1');
INSERT INTO `dict` VALUES ('95', '一般', 'customer_status_0', '94', '11401', '1', '1', '2018-08-03 16:14:18', '1', null, null, '1');
INSERT INTO `dict` VALUES ('96', '黑名单', 'customer_status_1', '94', '11402', '2', '1', '2018-08-03 16:14:39', '1', null, null, '1');
INSERT INTO `dict` VALUES ('97', '白名单', 'customer_status_2', '94', '11403', '3', '1', '2018-08-03 16:14:58', '1', null, null, '1');

INSERT INTO `dict` VALUES ('98', '设备状态', 'equipment_state', '1', '115', '设备状态', '1', '2018-08-03 16:21:51', '1', null, null, '1');
INSERT INTO `dict` VALUES ('99', '未启用', 'equipment_state_0', '98', '11501', '1', '1', '2018-08-03 16:22:13', '1', null, null, '1');
INSERT INTO `dict` VALUES ('100', '正常', 'equipment_state_1', '98', '11502', '2', '1', '2018-08-03 16:22:49', '1', null, null, '1');
INSERT INTO `dict` VALUES ('101', '故障', 'equipment_state_2', '98', '11503', '3', '1', '2018-08-03 16:23:07', '1', null, null, '1');
INSERT INTO `dict` VALUES ('102', '维修中', 'equipment_state_3', '98', '11504', '4', '1', '2018-08-03 16:23:34', '1', null, null, '1');

INSERT INTO `dict` VALUES ('103', '缴费类型', 'payment_type', '1', '116', '缴费类型', '1', '2018-08-03 16:25:35', '1', null, null, '1');
INSERT INTO `dict` VALUES ('104', '已缴费', 'payment_type_0', '103', '11601', '1', '1', '2018-08-03 16:26:16', '1', null, null, '1');
INSERT INTO `dict` VALUES ('105', '待缴费', 'payment_type_1', '103', '11602', '2', '1', '2018-08-03 16:26:36', '1', null, null, '1');
INSERT INTO `dict` VALUES ('106', '补缴费', 'payment_type_2', '103', '11603', '3', '1', '2018-08-03 16:26:54', '1', null, null, '1');

INSERT INTO `dict` VALUES ('107', '缴费状态', 'payment_state', '1', '117', '缴费状态', '1', '2018-08-03 16:28:18', '1', null, null, '1');
INSERT INTO `dict` VALUES ('108', '完成缴费', 'payment_state_0', '107', '11701', '1', '1', '2018-08-03 16:28:47', '1', null, null, '1');
INSERT INTO `dict` VALUES ('109', '未完成缴费', 'payment_state_1', '107', '11702', '2', '1', '2018-08-03 16:29:13', '1', null, null, '1');

INSERT INTO `dict` VALUES ('110', '违规类型', 'type_of_violation', '1', '118', '违规类型', '1', '2018-08-03 16:31:27', '1', null, null, '1');

INSERT INTO `dict` VALUES ('114', '维修状态', 'repairStatus', '1', null, '维修状态', '1', '2018-08-07 17:47:44', '1', null, null, '1');
INSERT INTO `dict` VALUES ('115', '未开始', 'repairStatus_01', '114', null, '1', '1', '2018-08-07 17:48:49', '1', '2018-08-07 17:49:59', '1', '1');
INSERT INTO `dict` VALUES ('116', '进行中', 'repairStatus_02', '114', null, '2', '1', '2018-08-07 17:49:27', '1', '2018-08-07 17:50:05', '1', '1');
INSERT INTO `dict` VALUES ('117', '维修完成', 'repairStatus_03', '114', null, '3', '1', '2018-08-07 17:49:45', '1', '2018-08-07 17:50:08', '1', '1');

INSERT INTO `dict` VALUES ('118', '违规审核状态', 'breakType', '1', null, '违规审核状态', '1', '2018-08-08 16:09:56', '1', null, null, '1');
INSERT INTO `dict` VALUES ('119', '待审核', 'break_underview_01', '118', null, '1', '1', '2018-08-08 16:11:05', '1', '2018-08-08 16:41:59', '1', '1');
INSERT INTO `dict` VALUES ('120', '审核通过', 'break_underview_02', '118', null, '2', '1', '2018-08-08 16:12:19', '1', null, null, '1');
INSERT INTO `dict` VALUES ('121', '审核未通过', 'break_underview_03', '118', null, '3', '1', '2018-08-08 16:12:45', '1', '2018-08-08 16:38:30', '1', '1');

INSERT INTO `dict` VALUES ('122', '卡口数据', 'type_of_violation_3', '110', null, '卡口采集数据类型', '1', '2018-08-13 14:44:41', '1', '2018-08-13 14:49:12', '1', '1');

INSERT INTO `dict` VALUES ('123', '使用性质', 'useType', '1', null, '使用性质', '1', '2018-08-13 14:44:41', '1', '2018-08-13 14:49:12', '1', '1');
INSERT INTO `dict` VALUES ('124', '自用', 'useType_01', '123', null, '1', '1', '2018-08-13 14:44:41', '1', '2018-08-13 14:49:12', '1', '1');

INSERT INTO `dict` VALUES ('125', '车辆类型', 'carType', '1', null, '车辆类型', '1', '2018-08-13 14:44:41', '1', '2018-08-13 14:49:12', '1', '1');
INSERT INTO `dict` VALUES ('126', '大货车', 'carType_01', '125', null, '1', '1', '2018-08-13 14:44:41', '1', '2018-08-13 14:49:12', '1', '1');
INSERT INTO `dict` VALUES ('127', '小型客车', 'carType_02', '125', null, '2', '1', '2018-08-17 15:50:31', '1', null, null, '1');
INSERT INTO `dict` VALUES ('128', '小轿车', 'carType_03', '125', null, '3', '1', '2018-08-17 15:51:06', '1', null, null, '1');
INSERT INTO `dict` VALUES ('129', '巴士', 'carType_04', '125', null, '4', '1', '2018-08-17 15:51:26', '1', null, null, '1');

INSERT INTO `dict` VALUES ('130', '车牌号前缀', 'plateNumPrefix', '1', null, '车牌号前缀', '1', '2018-08-13 14:44:41', '1', '2018-08-13 14:49:12', '1', '1');
INSERT INTO `dict` VALUES ('131', '贵A', 'plateNumPrefix_01', '130', null, '1', '1', '2018-08-13 14:44:41', '1', '2018-08-13 14:49:12', '1', '1');

INSERT INTO `dict` VALUES ('132', '网络状态', 'contro_net_status', '1', null, '控制器网络状态\n', '1', '2018-08-29 14:24:25', '1', '2018-08-29 14:28:19', '1', '1');
INSERT INTO `dict` VALUES ('133', '正常', 'contro_net_status1', '132', null, '', '1', '2018-08-29 14:24:53', '1', null, null, '1');
INSERT INTO `dict` VALUES ('134', '故障', 'contro_net_status2', '132', null, '', '1', '2018-08-29 14:25:37', '1', null, null, '1');


INSERT INTO `dict` VALUES ('135', '天线状态', 'contro_equip_status', '1', null, '控制器天线状态', '1', '2018-08-29 14:26:22', '1', '2018-08-29 14:28:31', '1', '1');
INSERT INTO `dict` VALUES ('136', '正常', 'contro_equip_status1', '135', null, '', '1', '2018-08-29 14:26:38', '1', null, null, '1');
INSERT INTO `dict` VALUES ('137', '故障', 'contro_equip_status2', '135', null, '', '1', '2018-08-29 14:26:47', '1', null, null, '1');

INSERT INTO `dict` VALUES ('138', '系统配置', 'System_config', '1', null, '', '1', '2018-08-27 09:23:10', '1', null, null, '1');
INSERT INTO `dict` VALUES ('139', 'record_page_type1', 'driving_record_pagetype', '138', null, '行驶记录显示：\nrecord_page_type1:显示及时数据\nrecord_page_type2:显示三天后完整数据', '1', '2018-08-27 09:27:35', '1', '2018-08-27 09:33:27', '1', '1');
INSERT INTO `dict` VALUES ('140', 'break_page_type1', 'break_record_pagetype', '138', null, '违规处理显示\nbreak_page_type1:显示违规处理及时数据\nbreak_page_type2:显示违规处理完整数据\n', '1', '2018-08-27 09:28:39', '1', '2018-08-30 09:08:25', '1', '1');
INSERT INTO `dict` VALUES ('141', 'false', 'isopen_carport_gis', '138', null, '卡口是否开启坐标，坐标点配置在收费站信息表\ntrue：开启\nfalse：关闭', '1', '2018-08-30 09:07:26', '1', '2018-08-30 09:11:43', '1', '1');


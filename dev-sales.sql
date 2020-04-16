/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : dev-sales

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 16/04/2020 10:53:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `uuid` varchar(64) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键ID',
  `account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '登陆账户[手机号]',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '登陆密码',
  `salt` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '盐值',
  `state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '账号状态1:可用2:冻结3:黑名单',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `first_login_time` datetime(0) NULL DEFAULT NULL COMMENT '第一次登陆时间',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最近一次登陆时间',
  `parent_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '账号的上级[谁给的账号]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '登陆账户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('f228805e07e746c39b805acb7e00682b', '13408678419', '6f3ddbb35bef4f9c5cb1bde8865da975', '1ef2f9b6b8984ce5ea3ba2ee0f656e57', '1', '2020-04-15 16:32:32', NULL, NULL, '0');

-- ----------------------------
-- Table structure for account_day_arrange
-- ----------------------------
DROP TABLE IF EXISTS `account_day_arrange`;
CREATE TABLE `account_day_arrange`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `arrange_context` varchar(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '日程备注信息',
  `urgency_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '重要程度[1:重要2:普通]',
  `start_date` date NULL DEFAULT NULL COMMENT '开始时间',
  `end_date` date NULL DEFAULT NULL COMMENT '结束时间',
  `account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人UUID',
  `parent_dept_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '上级所属部门UUID',
  `customer_input` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '手动输入客户信息',
  `customer_join_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '客户关联日程[优先级高]',
  `arrange_color` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '日志标记颜色[红橙黄绿青蓝紫1234567]',
  `delete_is` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否删除[1:删除0未删除]',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最近更新时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '我的日程计划' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for account_info
-- ----------------------------
DROP TABLE IF EXISTS `account_info`;
CREATE TABLE `account_info`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键业务唯一UUID',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '登陆账户UUID',
  `hand_img` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户头像',
  `nike_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '账户昵称',
  `birthday` date NULL DEFAULT NULL COMMENT '员工生日',
  `weixin` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '微信号码',
  `job_code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '员工工号',
  `job_dept_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属部门',
  `job_duty_key` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '工作职务[数据字典职务读取数据]',
  `team_top_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '一级团队名称',
  `job_entry_time` datetime(0) NULL DEFAULT NULL COMMENT '入职时间',
  `job_dimission_time` datetime(0) NULL DEFAULT NULL COMMENT '离职时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人UUID',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_account_uuid` datetime(0) NULL DEFAULT NULL COMMENT '修改人UUID',
  `hq_is` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否是总部的账号[1总部0非总部]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '账户基础信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for city_info
-- ----------------------------
DROP TABLE IF EXISTS `city_info`;
CREATE TABLE `city_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父节点',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '地区管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_follow_record
-- ----------------------------
DROP TABLE IF EXISTS `customer_follow_record`;
CREATE TABLE `customer_follow_record`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '添加记录的人',
  `follow_context` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '跟进历史',
  `follow_type_key` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '标记状态[数据字典key]',
  `follow_type_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '标记状态名称[数据字典描述value]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `sales_tel_account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话记录ID',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '客户跟进记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `sales_tel_account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电销账户UUID',
  `customer_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '客户名称',
  `customer_weixin` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '客户微信',
  `city_level_1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[省]UUID',
  `city_level_1_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[省]名称',
  `city_level_2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[市]UUID',
  `city_level_2_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[市]名称',
  `city_level_3` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[区]UUID',
  `city_level_3_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[区]名称',
  `detaile_address` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '客户详细地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '客户基础信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_order
-- ----------------------------
DROP TABLE IF EXISTS `customer_order`;
CREATE TABLE `customer_order`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `sales_tel_account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电销电话uuid',
  `customer_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '那个用户uuid',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '销售员UUID',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属总团队ID',
  `parent_dept_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属部门UUID',
  `order_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '业务订单号',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '订单时间',
  `order_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '订单状态:[1待发货2已发货]',
  `mpos_sno` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT 'pos机序列码[确定终端信息]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '客户订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fiancial_expend_all_sett
-- ----------------------------
DROP TABLE IF EXISTS `fiancial_expend_all_sett`;
CREATE TABLE `fiancial_expend_all_sett`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `fixed_type_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '结算科目',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队UUID',
  `team_dept_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '部门UUID',
  `sett_all_amt` decimal(18, 2) NULL DEFAULT NULL COMMENT '科目累计所有结算',
  `sett_update` datetime(0) NULL DEFAULT NULL COMMENT '结算时间'
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '所有科目累计结算' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fiancial_expend_day_record
-- ----------------------------
DROP TABLE IF EXISTS `fiancial_expend_day_record`;
CREATE TABLE `fiancial_expend_day_record`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键UUID',
  `fixed_type_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支出固定类型',
  `spend_year` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支出年份',
  `spend_month` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支出月份',
  `spend_time` datetime(0) NULL DEFAULT NULL COMMENT '支出时间',
  `spend_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '支出金额',
  `spend_sno` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支出流水号',
  `sett_use` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否结算[1结算0未结算]',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队UUID',
  `team_dept_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '部门UUID',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属账户UUID',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '日常支出流水' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fiancial_expend_month_sett
-- ----------------------------
DROP TABLE IF EXISTS `fiancial_expend_month_sett`;
CREATE TABLE `fiancial_expend_month_sett`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队UUID',
  `team_dept_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '部门UUID',
  `sett_month` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '结算月份',
  `sett_year` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '结算年份',
  `sett_fixed_type_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '结算科目',
  `sett_amt` decimal(12, 2) NULL DEFAULT NULL COMMENT '结算金额',
  `sett_time` datetime(0) NULL DEFAULT NULL COMMENT '结算时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '月日常累计统计结算' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fiancial_expend_year_sett
-- ----------------------------
DROP TABLE IF EXISTS `fiancial_expend_year_sett`;
CREATE TABLE `fiancial_expend_year_sett`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键',
  `team_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属团队',
  `team_dept_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属部门',
  `sett_fixed_type_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '结算科目',
  `sett_year` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '结算年份',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '计算时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '年日常统计计算' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fiancial_sett_all
-- ----------------------------
DROP TABLE IF EXISTS `fiancial_sett_all`;
CREATE TABLE `fiancial_sett_all`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属团队UUID',
  `team_dept_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属部门UUID',
  `sett_all` decimal(18, 0) NULL DEFAULT NULL COMMENT '当前累计结算所有',
  `sett_year_all` decimal(10, 2) NULL DEFAULT NULL COMMENT '当前今年累计结算',
  `sett_month_all` decimal(10, 2) NULL DEFAULT NULL COMMENT '当前月份累计结算',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '团队所有累计总结算' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for financial_account_salary
-- ----------------------------
DROP TABLE IF EXISTS `financial_account_salary`;
CREATE TABLE `financial_account_salary`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '业务主键ID',
  `financial_temp_join_account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '工资关联模板',
  `account_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '员工当前状态[1:试用期2正式]',
  `team_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前团队UUID',
  `account_dept_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前部门',
  `account_job_position` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前职位[数据字典]',
  `account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前员工',
  `salary_year` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前年份',
  `salary_month` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前月份',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `salary_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '底薪',
  `salary_shipment` decimal(10, 2) NULL DEFAULT NULL COMMENT '出货提成',
  `salary_activate` decimal(10, 2) NULL DEFAULT NULL COMMENT '激活提成',
  `salary_underling_commission` decimal(10, 2) NULL DEFAULT NULL COMMENT '下属工资提成',
  `salary_profit` decimal(10, 2) NULL DEFAULT NULL COMMENT '分润提成',
  `salary_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '薪资状态[1:待发放2:已发放]',
  `check_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '审核状态[1待审核2已审核]',
  `check_res_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '审核结果[1:通过2拒绝]',
  `check_exec` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '审批行为[1:自动2手动]',
  `check_per_account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '审核人',
  `check_sub_account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '审核提交人'
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '员工薪水工资条' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for financial_fixed_expend
-- ----------------------------
DROP TABLE IF EXISTS `financial_fixed_expend`;
CREATE TABLE `financial_fixed_expend`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '归属人UUID',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '总所属团队UUID',
  `team_dept_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '归属部门UUID',
  `spend_time` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支出时间',
  `fixed_type_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支出类型',
  `fixed_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支出费用',
  `fixed_remark` varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支出备注',
  `fixed_pic` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '支付图片',
  `fixed_defalut` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否默认支出[1是0否]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '支出时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '财务的固定开支' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for financial_fixed_type
-- ----------------------------
DROP TABLE IF EXISTS `financial_fixed_type`;
CREATE TABLE `financial_fixed_type`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键类型',
  `type_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '固定支出类型',
  `type_key_code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '固定支出别名',
  `special_level` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '特殊级别[1:特殊0常规]',
  `special_seq` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '特殊排序优先级',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '财务固定支出类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for financial_overall_overview
-- ----------------------------
DROP TABLE IF EXISTS `financial_overall_overview`;
CREATE TABLE `financial_overall_overview`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键',
  `team_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队UUID',
  `sett_year` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '结算年份',
  `sett_month` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '结算月份',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '财务总体概览表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for financial_template
-- ----------------------------
DROP TABLE IF EXISTS `financial_template`;
CREATE TABLE `financial_template`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属团队UUID',
  `salary_temp_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '工资模板名称',
  `trial_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '试用期底薪[元]',
  `trial_shipment` decimal(10, 2) NULL DEFAULT NULL COMMENT '试用期出货提出[元/台]',
  `trial_activate` decimal(10, 2) NULL DEFAULT NULL COMMENT '试用期激活提成[元/台]',
  `trial_underling_commission` decimal(10, 2) NULL DEFAULT NULL COMMENT '试用期下属收入提成[0-50%]',
  `trial_profit` decimal(10, 2) NULL DEFAULT NULL COMMENT '试用期分润提成：0~10‱',
  `formal_salary` decimal(10, 2) NULL DEFAULT NULL COMMENT '正式底薪[元]',
  `formal_shipment` decimal(10, 2) NULL DEFAULT NULL COMMENT '正式出货提出[元/台]',
  `formal_activate` decimal(10, 0) NULL DEFAULT NULL COMMENT '正式激活提成激活提成[元/台]',
  `defalut_use` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否使用[1使用2:弃用]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `check_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '审批状态[1待审核2已审核]',
  `check_exec` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '审核行为[1:系统审核0:手动审核]',
  `check_account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '审核人',
  `check_submit_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '提交审核人',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '团队工资模板\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for financial_tmep_join_account
-- ----------------------------
DROP TABLE IF EXISTS `financial_tmep_join_account`;
CREATE TABLE `financial_tmep_join_account`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键ID',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '账户主键UUID',
  `financial_temp_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '财务工资模板ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间[]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '用户关联工资模板' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_tel_account
-- ----------------------------
DROP TABLE IF EXISTS `sales_tel_account`;
CREATE TABLE `sales_tel_account`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `tel_number` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话号码',
  `tel_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话类型[1:精准类2:普通类3:劣质类]',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '拥有者人数',
  `team_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '最高团队TeamId',
  `tel_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话状态[1:待分配2:待拨打3:待跟进4:已拨打]',
  `batch_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '总部下发号码所属批次编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `tel_state_level` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前号码所属级别[1:团队2部门3个人]',
  `tel_state_level_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前业务关联',
  `exec_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '分配类型[1手动2定时]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '电销电话最终归属用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_tel_pool
-- ----------------------------
DROP TABLE IF EXISTS `sales_tel_pool`;
CREATE TABLE `sales_tel_pool`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `tel_number` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话号码',
  `tel_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话类型[1:精准类2:普通类3:劣质类]',
  `tel_resources` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话数据来源[1:后台导入2:其他]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '号码创建人',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '营销号码电话池' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_tel_task_quarz
-- ----------------------------
DROP TABLE IF EXISTS `sales_tel_task_quarz`;
CREATE TABLE `sales_tel_task_quarz`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键ID',
  `call_start_time` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '设置限制时间',
  `call_end_time` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '设置限制时间',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '分配团队UUID',
  `tel_num` int(11) NULL DEFAULT NULL COMMENT '分配数量',
  `tel_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '营销号码类型',
  `task_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '分配评率[1:天2周3月]',
  `exec_time` datetime(0) NULL DEFAULT NULL COMMENT '运行执行时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `exec_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '执行状态[1:待执行2执行完成]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '定时分配号码业务' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_tel_team_dept_account_pool
-- ----------------------------
DROP TABLE IF EXISTS `sales_tel_team_dept_account_pool`;
CREATE TABLE `sales_tel_team_dept_account_pool`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '拥有电话的人',
  `tel_num` int(11) NULL DEFAULT NULL COMMENT '业务号码分配的数量',
  `tel_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话类型[1:精准类2:普通类3:劣质类]',
  `batch_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '总部统一批次编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '分配时间',
  `grant_account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT ' 下发人',
  `exec_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '分配类型[1手动2定时]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '员工电话拥有记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_tel_team_dept_pool
-- ----------------------------
DROP TABLE IF EXISTS `sales_tel_team_dept_pool`;
CREATE TABLE `sales_tel_team_dept_pool`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `tel_num` int(11) NULL DEFAULT NULL COMMENT '业务号码分配的数量',
  `tel_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '电话类型[1:精准类2:普通类3:劣质类]',
  `dept_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '部门UUID',
  `tel_dept_level` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前号码所属级别[1:一级部门2:超过一级部门分配]',
  `tel_dept_level_parent_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属上级部门UUID',
  `batch_no` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '统一总部分配号码批次编号',
  `receive_account_uuid` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '接受部门人的UUID',
  `grant_account_uuid` varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '下发部门人的UUID',
  `exec_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '分配类型[1手动2定时]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '部门电话池子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sales_tel_team_pool
-- ----------------------------
DROP TABLE IF EXISTS `sales_tel_team_pool`;
CREATE TABLE `sales_tel_team_pool`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务数据主键',
  `batch_order_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '批次业务单号',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队UUID',
  `tel_num` int(11) NULL DEFAULT NULL COMMENT '业务分配的数量',
  `tel_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话类型[1:精准类2:普通类3:劣质类]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '发放时间',
  `receive_account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '接收人UUID',
  `grant_account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '发送人UUID',
  `start_time` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '设置拨打时间start',
  `end_time` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '设置拨打时间end',
  `exec_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '分配类型[1手动2定时]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '团队拥有电话池子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for setting_dic
-- ----------------------------
DROP TABLE IF EXISTS `setting_dic`;
CREATE TABLE `setting_dic`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '主键UUID',
  `dic_code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '字典code业务类型',
  `dic_key` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '字典KEY',
  `dic_value` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '字典Value',
  `dic_seq` int(11) NULL DEFAULT NULL COMMENT '字典权重[升序]',
  `dic_desc` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '字典说明[内部使用]',
  `dic_delete` int(255) NULL DEFAULT NULL COMMENT '是否删除-默认可用[1删除0可用]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '系统数据字典' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for setting_index
-- ----------------------------
DROP TABLE IF EXISTS `setting_index`;
CREATE TABLE `setting_index`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `index_pic` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '首页图片',
  `index_seq` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '首页排序',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '首页启动页面' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for setting_tab
-- ----------------------------
DROP TABLE IF EXISTS `setting_tab`;
CREATE TABLE `setting_tab`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键ID',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户账户UUID',
  `tab_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '看板类型',
  `tab_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '看板名称',
  `tab_seq` int(255) NULL DEFAULT NULL COMMENT '看板排序[升序]',
  `tab_open` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '看板是否打开[1:关闭0:打开]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '首页看板排序' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_app_upgrade
-- ----------------------------
DROP TABLE IF EXISTS `system_app_upgrade`;
CREATE TABLE `system_app_upgrade`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = 'APP版本升级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_feedback
-- ----------------------------
DROP TABLE IF EXISTS `system_feedback`;
CREATE TABLE `system_feedback`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键',
  `feedback_content` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '反馈内容',
  `account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '反馈人',
  `feed_image1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '图片资源I',
  `feed_image2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '图片资源2',
  `feed_image3` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '图片资源3',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '反馈时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '系统意见反馈' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_file
-- ----------------------------
DROP TABLE IF EXISTS `system_file`;
CREATE TABLE `system_file`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `file_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '文件原名称',
  `file_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '文件类型',
  `file_size` double NULL DEFAULT NULL COMMENT '文件大小',
  `file_store` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '存储的目录',
  `file_url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '访问的目录',
  `file_server_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '文件业务类型[自定义]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '文件创建时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '系统文件存储' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_message
-- ----------------------------
DROP TABLE IF EXISTS `system_message`;
CREATE TABLE `system_message`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键ID',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '系统业务公告创建人',
  `notice_title` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '系统公告标题',
  `notice_context` varchar(2000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '系统公告内容[前期控制在2000字内]',
  `notice_time` datetime(0) NULL DEFAULT NULL COMMENT '公告发送时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '系统消息提醒--未完' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键ID',
  `role_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色描述',
  `role_level` int(255) NULL DEFAULT NULL COMMENT '角色级别[值越小权利越大]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `job_is` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否是工作角色[1是0否]',
  `delete_is` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否删除[1:是0:否]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '系统角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_sms_record
-- ----------------------------
DROP TABLE IF EXISTS `system_sms_record`;
CREATE TABLE `system_sms_record`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键',
  `sms_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '短信业务类型[自己定义]',
  `sms_code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '短信内容',
  `sms_send_time` datetime(0) NULL DEFAULT NULL COMMENT '短信发送时间',
  `sms_valid_minutes` int(11) NULL DEFAULT NULL COMMENT '有效时间[分钟数]',
  `end_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '发送类型[1:系统发放2:后台发送3:用户请求]',
  `account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '发送人的UUID',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '短信发送记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for team_dept
-- ----------------------------
DROP TABLE IF EXISTS `team_dept`;
CREATE TABLE `team_dept`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务UUID',
  `dept_leader_account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '部门领导人[可以为空,等高级的人去设置]',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '当前所属团队',
  `dept_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队部门名称',
  `dept_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '部门类型[1:部门2:组织]',
  `parent_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '父级归属UUID[0表示 一级部门]',
  `create_account_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '事件创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '团队部门组织架构' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for team_info
-- ----------------------------
DROP TABLE IF EXISTS `team_info`;
CREATE TABLE `team_info`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `team_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队名称',
  `team_city_level_1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[省]',
  `team_city_level_1_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[省]名称',
  `team_city_level_2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[市]',
  `team_city_level_2_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[市]名称',
  `team_city_level_3` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[区]',
  `team_city_level_3_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '省市区[区]名称',
  `team_leader_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队负责人姓名',
  `team_leader_account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '团队负责人手机号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_account` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人account_uuid',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '总部管理的团队信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for team_product
-- ----------------------------
DROP TABLE IF EXISTS `team_product`;
CREATE TABLE `team_product`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `product_pic` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '产品图片',
  `product_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '产品名称',
  `product_serial_code` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '产品编号[选填]',
  `product_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '产品价格',
  `product_model` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '产品型号',
  `product_note` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '产品备注信息',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属总团队UUID',
  `product_seq` int(255) NULL DEFAULT NULL COMMENT '排序权重[扩展]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '团队产品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for team_target_account
-- ----------------------------
DROP TABLE IF EXISTS `team_target_account`;
CREATE TABLE `team_target_account`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键ID',
  `team_target_record_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '计划业务来源',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属团队',
  `team_dept_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属部门UUID',
  `account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属人UUID',
  `complete_num` int(11) NULL DEFAULT NULL COMMENT '完成数量',
  `target_num` int(11) NULL DEFAULT NULL COMMENT '目标数量',
  `target_date` date NULL DEFAULT NULL COMMENT '目标时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `target_sett` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '是否结算[1:未结算2:待处理3已结算]',
  `complete_date` datetime(0) NULL DEFAULT NULL COMMENT '日目标时间',
  `complete_month` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '本月是否结算[1:未结算2:待处理3已结算]',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '所属目标用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for team_target_record
-- ----------------------------
DROP TABLE IF EXISTS `team_target_record`;
CREATE TABLE `team_target_record`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '业务主键UUID',
  `target_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '目标类型[1:出货量2激活量]',
  `target_date_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '目标类型[1:月目标2日目标]',
  `target_num` int(11) NULL DEFAULT NULL COMMENT '目标数量',
  `team_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属团队目标',
  `receive_account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '接收人的UUID',
  `issue_account_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '下发人UUID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '下发时间',
  `complete_num` int(11) NULL DEFAULT NULL COMMENT '已完成数量',
  `complete_date` date NULL DEFAULT NULL COMMENT '日目标时间',
  `complete_month` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '月目标时间[202003]',
  `complete_sett` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '本月是否结算[1:未结算2:待处理3已结算]'
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '团队目标记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for terminal_state
-- ----------------------------
DROP TABLE IF EXISTS `terminal_state`;
CREATE TABLE `terminal_state`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `customer_order_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '客户订单UUID',
  `mpos_sno` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT 'mpos序列码',
  `terminal_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '终端状态[1未激活2已激活]',
  `terminal_activate_time` datetime(0) NULL DEFAULT NULL COMMENT '终端激活时间',
  `call_data` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '回调返回的数据',
  `call_time` datetime(0) NULL DEFAULT NULL COMMENT '回调时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '终端状态信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehouse_out_records
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_out_records`;
CREATE TABLE `warehouse_out_records`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务主键UUID',
  `customer_order_uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '客户订单号',
  `mpos_sno` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '订单序列号',
  `terminal_image` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '终端图片',
  `terminal

_product` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '终端名称',
  `terminal

_model` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '终端型号',
  `order_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '库房出货单号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '出货时间',
  `team_uuid` varchar(0) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属团队UUID',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '仓库出库记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for warehouse_teaminal_sno
-- ----------------------------
DROP TABLE IF EXISTS `warehouse_teaminal_sno`;
CREATE TABLE `warehouse_teaminal_sno`  (
  `uuid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT '业务数据主键',
  `mpos_sno` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT 'pos终端序列码',
  `mpos_state` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT 'pos状态[1:出货0:库存中]',
  `batch_no` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属划拨批次编号',
  `product_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '产品名称[调支付数据保存]',
  `product_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '产品类型[调支付数据保存]',
  `product_image` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '产品图片[调支付数据保存]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '团队终端MPOS 序列sno码' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

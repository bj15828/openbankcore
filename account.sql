/*
MySQL Data Transfer
Source Host: localhost
Source Database: account
Target Host: localhost
Target Database: account
Date: 2017/12/6 10:04:24
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_account_action_journal
-- ----------------------------
DROP TABLE IF EXISTS `t_account_action_journal`;
CREATE TABLE `t_account_action_journal` (
  `seq_no` bigint(20) NOT NULL,
  `acct_id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  `action` int(2) NOT NULL COMMENT '1- 存入  2 - 支取 3 - 冻结 4 - 解冻',
  `amount` double NOT NULL COMMENT '发生额',
  `before_balance` double NOT NULL COMMENT '余额',
  `after_balance` double NOT NULL,
  `tran_uuid` varchar(32) NOT NULL,
  `tran_seq_no` bigint(20) NOT NULL,
  `url_context` varchar(30) DEFAULT NULL,
  `tran_code` varchar(10) DEFAULT NULL,
  `rid` bigint(20) NOT NULL COMMENT '从t_account_rid更新过来',
  PRIMARY KEY (`seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='对于帐号的操作流水记录\r\n';

-- ----------------------------
-- Table structure for t_account_balance
-- ----------------------------
DROP TABLE IF EXISTS `t_account_balance`;
CREATE TABLE `t_account_balance` (
  `acct_id` varchar(32) NOT NULL,
  `balance` double NOT NULL,
  `frozen_amount` double NOT NULL DEFAULT '0',
  `last_modi_time` datetime NOT NULL COMMENT '认默同账户创建时间',
  PRIMARY KEY (`acct_id`),
  UNIQUE KEY `unique` (`acct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户的余额\r\n';

-- ----------------------------
-- Table structure for t_account_info
-- ----------------------------
DROP TABLE IF EXISTS `t_account_info`;
CREATE TABLE `t_account_info` (
  `acct_id` varchar(32) NOT NULL,
  `stats` int(2) NOT NULL COMMENT '-99 销户  1 - 正常 2 - 未年检 3 - 锁定',
  `create_time` datetime NOT NULL,
  `busi_type` int(2) NOT NULL COMMENT '账户类型，1-个人账户  2 对公账户',
  `product_id` varchar(32) NOT NULL COMMENT '产品ID',
  `master_or_primary` int(1) NOT NULL DEFAULT '1' COMMENT '帐号类型，1 主帐号 2 子帐号',
  `is_calculate_interest` int(1) DEFAULT NULL COMMENT '是否计算利息',
  PRIMARY KEY (`acct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户信息表\r\n登记账户的状态、对应的产品等信息\r\n';

-- ----------------------------
-- Table structure for t_account_interest_accumulate
-- ----------------------------
DROP TABLE IF EXISTS `t_account_interest_accumulate`;
CREATE TABLE `t_account_interest_accumulate` (
  `seq_no` bigint(20) NOT NULL,
  `acct_id` varchar(32) NOT NULL,
  `interest_day` varchar(10) NOT NULL,
  `amount` double NOT NULL,
  `stats` int(2) unsigned NOT NULL COMMENT '1-未处理  9 - 已经处理',
  PRIMARY KEY (`seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帐号计息表\r\n账户余额变动时，更新该表的amount字段';

-- ----------------------------
-- Table structure for t_account_rid
-- ----------------------------
DROP TABLE IF EXISTS `t_account_rid`;
CREATE TABLE `t_account_rid` (
  `acct_id` varchar(255) NOT NULL,
  `rid` bigint(20) NOT NULL,
  PRIMARY KEY (`acct_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用来标识某个帐号的更新顺序，\r\n一旦帐号信息或者帐号的余额数据发生变动时，该序号自增1';

-- ----------------------------
-- Table structure for t_notify_event
-- ----------------------------
DROP TABLE IF EXISTS `t_notify_event`;
CREATE TABLE `t_notify_event` (
  `event_id` bigint(20) NOT NULL,
  `content` varchar(3000) NOT NULL COMMENT '消息内容，JSOn格式',
  `clazz` varchar(50) NOT NULL COMMENT '所属类',
  `stats` int(1) NOT NULL COMMENT '1-成功 0-已发送未收到回复',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_transaction_journal
-- ----------------------------
DROP TABLE IF EXISTS `t_transaction_journal`;
CREATE TABLE `t_transaction_journal` (
  `seq_no` bigint(20) NOT NULL,
  `consmr_id` varchar(20) NOT NULL,
  `consmr_seq_no` varchar(32) NOT NULL,
  `org_consmr_id` varchar(20) DEFAULT NULL,
  `org_consmr_seq_no` varchar(32) DEFAULT NULL,
  `tran_code` varchar(20) NOT NULL COMMENT '交易码',
  `txn_dt` varchar(10) NOT NULL,
  `txn_time` varchar(10) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `tran_type` int(2) NOT NULL COMMENT '交易类型',
  `channel_no` varchar(5) NOT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `uuid` varchar(32) NOT NULL,
  `stats` int(1) NOT NULL DEFAULT '0' COMMENT '1-交易成功  0-已发送MQ未收到回执',
  PRIMARY KEY (`seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易流水表\r\n对于账户的操作的流水记录\r\n';

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_account_action_journal` VALUES ('935811482879401984', '111', '2017-11-29 18:03:39', '1', '1.9', '99999999967.7', '99999999965.8', '12345678901234567890123456789012', '935811482816483328', null, null, '48');
INSERT INTO `t_account_action_journal` VALUES ('935811482887790592', '112', '2017-11-29 18:03:39', '2', '1.9', '1029.3', '1031.2', '12345678901234567890123456789012', '935811482816483328', null, null, '45');
INSERT INTO `t_account_action_journal` VALUES ('937940505608724480', '111', '2017-12-05 15:03:37', '1', '1.9', '99999999965.8', '99999999963.9', '12345678901234567890123456789012', '937940505545805824', null, null, '49');
INSERT INTO `t_account_action_journal` VALUES ('937940505617113088', '112', '2017-12-05 15:03:37', '2', '1.9', '1031.2', '1033.1', '12345678901234567890123456789012', '937940505545805824', null, null, '46');
INSERT INTO `t_account_action_journal` VALUES ('938225860585070592', '111', '2017-12-06 09:57:31', '1', '1.9', '99999999963.9', '99999999962', '12345678901234567890123456789012', '938225860522151936', 'http://localhost:8080/transfer', null, '50');
INSERT INTO `t_account_action_journal` VALUES ('938225860593459200', '112', '2017-12-06 09:57:31', '2', '1.9', '1033.1', '1035', '12345678901234567890123456789012', '938225860522151936', 'http://localhost:8080/transfer', null, '47');
INSERT INTO `t_account_action_journal` VALUES ('938226398294843392', '111', '2017-12-06 09:59:39', '1', '1.9', '99999999962', '99999999960.1', '12345678901234567890123456789012', '938226398273867776', 'http://localhost:8080/transfer', null, '51');
INSERT INTO `t_account_action_journal` VALUES ('938226398303232000', '112', '2017-12-06 09:59:39', '2', '1.9', '1035', '1036.9', '12345678901234567890123456789012', '938226398273867776', 'http://localhost:8080/transfer', null, '48');
INSERT INTO `t_account_balance` VALUES ('111', '99999999960.1', '0', '2017-12-06 09:59:39');
INSERT INTO `t_account_balance` VALUES ('112', '1036.9', '0', '2017-12-06 09:59:39');
INSERT INTO `t_account_rid` VALUES ('111', '52');
INSERT INTO `t_account_rid` VALUES ('112', '49');
INSERT INTO `t_transaction_journal` VALUES ('935806997046104064', '30098', '30098', null, null, '30098345312', '2017-08-19', '12:30:45', '2017-11-29 17:45:49', '1', '12309', '{\"body\":{\"acct_from\":\"111\",\"acct_to\":\"112\",\"busi_type\":\"1\",\"amount\":\"1.90\"},\"header\":{\"svr_cd\":\"30098345312\",\"consmr_id\":\"30098\",\"consmr_seq_no\":\"30098\",\"txn_dt\":\"2017-08-19\",\"txn_time\":\"12:30:45\",\"chnl_tp\":\"12309\",\"uuid\":\"12345678901234567890123456789012\"},\"tranSeqNo\":0}', '12345678901234567890123456789012', '0');
INSERT INTO `t_transaction_journal` VALUES ('935811482816483328', '30098', '30098', null, null, '30098345312', '2017-08-19', '12:30:45', '2017-11-29 18:03:39', '1', '12309', '{\"body\":{\"acct_from\":\"111\",\"acct_to\":\"112\",\"busi_type\":\"1\",\"amount\":\"1.90\"},\"header\":{\"svr_cd\":\"30098345312\",\"consmr_id\":\"30098\",\"consmr_seq_no\":\"30098\",\"txn_dt\":\"2017-08-19\",\"txn_time\":\"12:30:45\",\"chnl_tp\":\"12309\",\"uuid\":\"12345678901234567890123456789012\"},\"tranSeqNo\":0}', '12345678901234567890123456789012', '0');

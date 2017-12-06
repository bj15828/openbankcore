/*
MySQL Data Transfer
Source Host: localhost
Source Database: account_center
Target Host: localhost
Target Database: account_center
Date: 2017/12/6 10:04:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_balance_composition
-- ----------------------------
DROP TABLE IF EXISTS `t_balance_composition`;
CREATE TABLE `t_balance_composition` (
  `bala_comp_id` bigint(20) NOT NULL,
  `name` varchar(15) NOT NULL COMMENT '余额组成名称',
  `value_date` date NOT NULL COMMENT '起息日',
  `interest_rate_id` varchar(32) NOT NULL,
  `is_calc_compound` int(1) NOT NULL COMMENT '是否计算复利',
  PRIMARY KEY (`bala_comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='余额组成主表';

-- ----------------------------
-- Table structure for t_balance_composition_accumulate
-- ----------------------------
DROP TABLE IF EXISTS `t_balance_composition_accumulate`;
CREATE TABLE `t_balance_composition_accumulate` (
  `seq_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `acct_id` varchar(32) NOT NULL,
  `bala_comp_id` bigint(20) NOT NULL COMMENT '余额组成ID',
  `action_date` date NOT NULL COMMENT '发生日期，一般指余额变动日期',
  `balance_deposit` double DEFAULT NULL COMMENT '存入',
  `balance_withdraw` double DEFAULT NULL COMMENT '取支',
  `interest_start_date` date NOT NULL COMMENT '计息开始时间',
  `interest_end_date` date NOT NULL COMMENT '计息结束时间',
  `day_count` int(11) DEFAULT NULL COMMENT '数天',
  `interest_number` int(11) DEFAULT NULL COMMENT '计息积数',
  `event_id` bigint(20) NOT NULL,
  PRIMARY KEY (`seq_no`),
  KEY `get_acct_last_row` (`acct_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_balance_composition_journal
-- ----------------------------
DROP TABLE IF EXISTS `t_balance_composition_journal`;
CREATE TABLE `t_balance_composition_journal` (
  `seq_no` bigint(20) NOT NULL,
  `tran_uuid` varchar(32) NOT NULL,
  `tran_code` varchar(10) NOT NULL,
  `create_time` datetime NOT NULL,
  `bala_comp_id` varchar(32) NOT NULL,
  `amount` double NOT NULL COMMENT '发生额',
  `credit_or_debit` int(1) NOT NULL COMMENT '借贷记，1-借记 2-贷记',
  PRIMARY KEY (`seq_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_balance_trancode
-- ----------------------------
DROP TABLE IF EXISTS `t_balance_trancode`;
CREATE TABLE `t_balance_trancode` (
  `bala_comp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tran_code` varchar(10) NOT NULL,
  PRIMARY KEY (`bala_comp_id`,`tran_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='余额组成对应的交易码 \r\n\r\n根据交易码来判断入哪个余额组成\r\n\r\n比如借记卡存入，入的就是存款余额组成';

-- ----------------------------
-- Table structure for t_product_balance_composition
-- ----------------------------
DROP TABLE IF EXISTS `t_product_balance_composition`;
CREATE TABLE `t_product_balance_composition` (
  `product_id` varchar(32) NOT NULL,
  `bala_comp_id` varchar(32) NOT NULL,
  PRIMARY KEY (`product_id`,`bala_comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='产品对应哪些余额组成';

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_balance_composition_accumulate` VALUES ('2', '1', '1', '2017-10-29', '1', null, '2017-10-29', '2017-10-30', '1', '1', '0');
INSERT INTO `t_balance_composition_accumulate` VALUES ('3', '1', '1', '2017-10-30', '100', null, '2017-10-30', '2017-10-29', null, null, '0');

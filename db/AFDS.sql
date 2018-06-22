/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : afds

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-06-22 20:14:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cpu
-- ----------------------------
DROP TABLE IF EXISTS `cpu`;
CREATE TABLE `cpu` (
  `id` varchar(255) NOT NULL,
  `brands` varchar(255) DEFAULT NULL COMMENT '品牌名',
  `name` varchar(255) DEFAULT NULL COMMENT '系列名',
  `model` varchar(255) DEFAULT NULL COMMENT '产品型号名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `applicable_type` varchar(255) DEFAULT NULL COMMENT '适用类型',
  `cpu_series` varchar(255) DEFAULT NULL COMMENT '系列',
  `cpu_main_frequency` varchar(255) DEFAULT NULL COMMENT 'CPU主频',
  `ghz` varchar(255) DEFAULT NULL COMMENT '最大睿频',
  `slot_type` varchar(255) DEFAULT NULL COMMENT '插槽类型',
  `two_level_caching` varchar(255) DEFAULT NULL COMMENT '二级缓存',
  `core_quantity` varchar(255) DEFAULT NULL COMMENT '核心数量',
  `thread_number` int(11) DEFAULT NULL COMMENT '线程数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for harddisk
-- ----------------------------
DROP TABLE IF EXISTS `harddisk`;
CREATE TABLE `harddisk` (
  `id` varchar(50) NOT NULL,
  `brands` varchar(255) DEFAULT NULL COMMENT '品牌名',
  `name` varchar(255) DEFAULT NULL COMMENT '系列名',
  `model` varchar(255) DEFAULT NULL COMMENT '产品型号名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `type` varchar(255) DEFAULT NULL COMMENT '硬盘类型 固态/普通',
  `storage_capacity` varchar(255) DEFAULT NULL COMMENT '固态存储容量',
  `harddisk_size` varchar(255) DEFAULT NULL COMMENT '固态硬盘尺寸',
  `Interface_type` varchar(255) DEFAULT NULL COMMENT '固态接口类型',
  `cache` varchar(255) DEFAULT NULL COMMENT '固态缓存',
  `rwspeed` varchar(255) DEFAULT NULL COMMENT '固态读写速度',
  `wspeed` varchar(255) DEFAULT NULL COMMENT '固态写入速度',
  `fault_free_time` varchar(255) DEFAULT NULL COMMENT '固态平均无故障时间',
  `search_time` varchar(255) DEFAULT NULL COMMENT '固态平均寻道时间',
  `applicable_type` varchar(255) DEFAULT NULL COMMENT '普通硬盘适用类型',
  `harddisk_size_p` varchar(255) DEFAULT NULL COMMENT '普通硬盘尺寸',
  `harddisk_capacity` varchar(255) DEFAULT NULL COMMENT '普通硬盘容量',
  `single_disk_capacity` varchar(255) DEFAULT NULL COMMENT '普通硬盘单碟容量',
  `cache_p` varchar(255) DEFAULT NULL COMMENT '普通硬盘缓存',
  `speed` varchar(255) DEFAULT NULL COMMENT '普通硬盘转速',
  `interface_type_p` varchar(255) DEFAULT NULL COMMENT '普通硬盘接口类型',
  `interface_rate` varchar(255) DEFAULT NULL COMMENT '普通硬盘接口速率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='硬盘表';

-- ----------------------------
-- Table structure for mainboard
-- ----------------------------
DROP TABLE IF EXISTS `mainboard`;
CREATE TABLE `mainboard` (
  `id` varchar(50) NOT NULL,
  `brands` varchar(255) DEFAULT NULL COMMENT '品牌名',
  `name` varchar(255) DEFAULT NULL COMMENT '系列名',
  `model` varchar(255) DEFAULT NULL COMMENT '产品型号名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `main_chipset` varchar(255) DEFAULT NULL COMMENT '主芯片组',
  `audio_chip` varchar(255) DEFAULT NULL COMMENT '音频芯片',
  `memory_type` varchar(255) DEFAULT NULL COMMENT '内存类型',
  `max_memory_capacity` varchar(255) DEFAULT NULL COMMENT '最大内存容量',
  `motherboard_type` varchar(255) DEFAULT NULL COMMENT '主板版型',
  `shape_size` varchar(255) DEFAULT NULL COMMENT '外形尺寸',
  `power_supply_socket` varchar(255) DEFAULT NULL COMMENT '电源插口',
  `power_supply_mode` varchar(255) DEFAULT NULL COMMENT '供电模式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主板表';

-- ----------------------------
-- Table structure for memorybar
-- ----------------------------
DROP TABLE IF EXISTS `memorybar`;
CREATE TABLE `memorybar` (
  `id` varchar(50) NOT NULL,
  `brands` varchar(255) DEFAULT NULL COMMENT '品牌名',
  `name` varchar(255) DEFAULT NULL COMMENT '系列名',
  `model` varchar(255) DEFAULT NULL COMMENT '产品型号名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `applicable_type` varchar(255) DEFAULT NULL COMMENT '适用类型',
  `memory_capacity` varchar(255) DEFAULT NULL COMMENT '内存容量',
  `memory_type` varchar(255) DEFAULT NULL COMMENT '内存类型',
  `main_frequency_of_memory` varchar(255) DEFAULT NULL COMMENT '内存主频',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内存条表';

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` varchar(50) NOT NULL,
  `brands` varchar(255) DEFAULT NULL COMMENT '品牌名',
  `name` varchar(255) DEFAULT NULL COMMENT '系列名',
  `model` varchar(255) DEFAULT NULL COMMENT '产品型号名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `power_type` varchar(255) DEFAULT NULL COMMENT '电源类型',
  `out_line_type` varchar(255) DEFAULT NULL COMMENT '出线类型',
  `rated_power` varchar(255) DEFAULT NULL COMMENT '额定功率',
  `max_power` varchar(255) DEFAULT NULL COMMENT '最大功率',
  `motherboard_interface` varchar(255) DEFAULT NULL COMMENT '主板接口',
  `hard_disk_interface` varchar(255) DEFAULT NULL COMMENT '硬盘接口',
  `pfc_type` varchar(255) DEFAULT NULL COMMENT 'PFC类型',
  `conversion_efficiency` varchar(255) DEFAULT NULL COMMENT '转换效率',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电源表';

-- ----------------------------
-- Table structure for videocard
-- ----------------------------
DROP TABLE IF EXISTS `videocard`;
CREATE TABLE `videocard` (
  `id` varchar(50) NOT NULL,
  `brands` varchar(255) DEFAULT NULL COMMENT '品牌名',
  `name` varchar(255) DEFAULT NULL COMMENT '系列名',
  `model` varchar(255) DEFAULT NULL COMMENT '产品型号名',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `graphics_card_type` varchar(255) DEFAULT NULL COMMENT '显卡类型',
  `video_card_chip` varchar(255) DEFAULT NULL COMMENT '显卡芯片',
  `core_frequency` varchar(255) DEFAULT NULL COMMENT '核心频率',
  `memory_frequency` varchar(255) DEFAULT NULL COMMENT '显存频率',
  `memory_capacity` varchar(255) DEFAULT NULL COMMENT '显存容量',
  `memory_interface` varchar(255) DEFAULT NULL COMMENT '显存位宽',
  `power_interface` varchar(255) DEFAULT NULL COMMENT '电源接口',
  `power_supply_mode` varchar(255) DEFAULT NULL COMMENT '供电模式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='显卡表';

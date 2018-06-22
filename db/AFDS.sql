/*
SQLyog Trial v11.01 (32 bit)
MySQL - 8.0.11 : Database - afds
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`afds` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `afds`;

/*Table structure for table `cpu` */

DROP TABLE IF EXISTS `cpu`;

CREATE TABLE `cpu` (
  `id` varchar(50) COLLATE utf8mb4_hu_0900_ai_ci NOT NULL DEFAULT 'uuid()',
  `brands` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `name` varchar(40) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `model` varchar(30) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `type` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `generration` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `nm` bigint(20) DEFAULT NULL,
  `namnum` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `corenum` bigint(20) DEFAULT NULL,
  `threadsnum` bigint(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hu_0900_ai_ci;

/*Data for the table `cpu` */

/*Table structure for table `harddisk` */

DROP TABLE IF EXISTS `harddisk`;

CREATE TABLE `harddisk` (
  `id` varchar(50) COLLATE utf8mb4_hu_0900_ai_ci NOT NULL DEFAULT 'uuid()',
  `brands` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `name` varchar(40) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `model` varchar(30) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `type` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `capacity` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `intertype` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `speed` bigint(20) DEFAULT NULL,
  `size` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `core` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hu_0900_ai_ci;

/*Data for the table `harddisk` */

/*Table structure for table `mainboard` */

DROP TABLE IF EXISTS `mainboard`;

CREATE TABLE `mainboard` (
  `id` varchar(50) COLLATE utf8mb4_hu_0900_ai_ci NOT NULL DEFAULT 'uuid()',
  `brands` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `name` varchar(40) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `model` varchar(30) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `ssdnum` bigint(20) DEFAULT NULL,
  `ramnum` bigint(20) DEFAULT NULL,
  `satanum` bigint(20) DEFAULT NULL,
  `size` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `powernum` bigint(20) DEFAULT NULL,
  `powermodel` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `cpumodel` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `cpunum` bigint(20) DEFAULT '1',
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hu_0900_ai_ci;

/*Data for the table `mainboard` */

/*Table structure for table `memorybar` */

DROP TABLE IF EXISTS `memorybar`;

CREATE TABLE `memorybar` (
  `id` varchar(50) COLLATE utf8mb4_hu_0900_ai_ci NOT NULL DEFAULT 'uuid()',
  `brands` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `name` varchar(40) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `model` varchar(30) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `type` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `capacity` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `ddr` bigint(20) DEFAULT NULL,
  `speed` bigint(20) DEFAULT NULL,
  `mainhz` bigint(20) DEFAULT NULL,
  `std` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `partbrands` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `cl` bigint(20) DEFAULT NULL,
  `ramcheck` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hu_0900_ai_ci;

/*Data for the table `memorybar` */

/*Table structure for table `power` */

DROP TABLE IF EXISTS `power`;

CREATE TABLE `power` (
  `id` varchar(50) COLLATE utf8mb4_hu_0900_ai_ci NOT NULL DEFAULT 'uuid()',
  `brands` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `name` varchar(40) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `model` varchar(30) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `type` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `outtype` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `size` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `stdw` bigint(20) DEFAULT NULL,
  `fan` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `maxw` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hu_0900_ai_ci;

/*Data for the table `power` */

/*Table structure for table `videocard` */

DROP TABLE IF EXISTS `videocard`;

CREATE TABLE `videocard` (
  `id` varchar(50) COLLATE utf8mb4_hu_0900_ai_ci NOT NULL DEFAULT 'uuid()',
  `brands` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `name` varchar(40) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `model` varchar(30) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `type` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `core` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `corehz` bigint(20) DEFAULT NULL,
  `memnum` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `memhz` bigint(20) DEFAULT NULL,
  `power` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `powertype` varchar(20) COLLATE utf8mb4_hu_0900_ai_ci DEFAULT NULL,
  `weight` bigint(20) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hu_0900_ai_ci;

/*Data for the table `videocard` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

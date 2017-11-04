/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.17-log : Database - wechat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wechat` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wechat`;

/*Table structure for table `token` */

DROP TABLE IF EXISTS `token`;

CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appid` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `secret` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `upd_time` datetime DEFAULT NULL,
  `wechat_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `token` */

insert  into `token`(`id`,`appid`,`create_time`,`secret`,`token`,`upd_time`,`wechat_name`) values 
(1,'wx26d5f45da3c878fb',NULL,'ac102d07412fc89e015df7e8c5250b14',NULL,NULL,NULL),
(3,'wx9ef09c62adc0fb10',NULL,'015b812976e491c8d68664dd969aa8a7',NULL,NULL,NULL),
(4,'wx923b379cd895a2a6',NULL,'ce524269d81e786ad203a0eb2e8d111f',NULL,NULL,NULL),
(5,'wxa4b4b009a3f33643',NULL,'b2f2ad680cfd26df0b327210234b73af',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

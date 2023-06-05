/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.30 : Database - tokopi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tokopi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `tokopi`;

/*Table structure for table `dtrans` */

DROP TABLE IF EXISTS `dtrans`;

CREATE TABLE `dtrans` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `price` int NOT NULL,
  `qty` int NOT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `subtotal` int NOT NULL,
  `order_id` int DEFAULT NULL,
  `menu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa5c0k7y0lgobo3fct56i7yph7` (`order_id`),
  KEY `FKi8abxfac839rm8xphtleoitqw` (`menu_id`),
  CONSTRAINT `FKa5c0k7y0lgobo3fct56i7yph7` FOREIGN KEY (`order_id`) REFERENCES `htrans` (`id`),
  CONSTRAINT `FKi8abxfac839rm8xphtleoitqw` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `dtrans` */

insert  into `dtrans`(`id`,`created_at`,`updated_at`,`price`,`qty`,`subtotal`,`order_id`,`menu_id`) values
(4,'2023-06-01 00:05:22.917000','2023-06-01 00:05:22.917000',20000,1,20000,1,1),
# (11,'2023-06-01 00:38:39.064000','2023-06-01 00:38:39.064000',20000,1,20000,4,13),
# (12,'2023-06-01 00:42:22.250000','2023-06-01 00:42:22.250000',20000,1,20000,7,14),
(13,'2023-06-01 00:55:16.754000','2023-06-01 00:55:16.754000',20000,1,20000,1,1),
(14,'2023-06-01 00:56:26.625000','2023-06-01 00:56:26.625000',20000,1,20000,1,1),
(15,'2023-06-01 01:03:40.406000','2023-06-01 01:03:40.406000',20000,1,20000,1,1),
(16,'2023-06-01 01:05:29.391000','2023-06-01 01:05:29.391000',20000,1,20000,1,1),
(17,'2023-06-01 01:06:36.146000','2023-06-01 01:06:36.146000',20000,1,20000,1,1),
(18,'2023-06-01 01:07:06.010000','2023-06-01 01:07:06.010000',20000,1,20000,1,1),
(19,'2023-06-01 01:07:31.338000','2023-06-01 01:07:31.338000',20000,1,20000,1,1),
(20,'2023-06-01 01:07:45.477000','2023-06-01 01:07:45.477000',20000,1,20000,3,1);

/*Table structure for table `htrans` */

DROP TABLE IF EXISTS `htrans`;

CREATE TABLE `htrans` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `total_item` int NOT NULL,
  `total_price` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `htrans` */

insert  into `htrans`(`id`,`created_at`,`updated_at`,`status`,`total_item`,`total_price`) values 
(1,'2023-05-31 23:47:04.202000','2023-05-31 23:47:04.202000','Done',1,20000),
(2,'2023-05-31 23:47:21.567000','2023-05-31 23:47:21.567000','Pending',2,50000),
(3,'2023-05-31 23:47:32.246000','2023-05-31 23:47:32.246000','Pending',2,60000),
(4,'2023-06-01 00:38:39.091000','2023-06-01 00:38:39.091000',NULL,0,0),
(5,'2023-06-01 00:42:14.776000','2023-06-01 00:42:14.776000','Pending',2,60000),
(6,'2023-06-01 00:42:16.514000','2023-06-01 00:42:16.514000','Pending',2,60000),
(7,'2023-06-01 00:42:22.253000','2023-06-01 00:42:22.253000',NULL,0,0);

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `category` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `image_url` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `price` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `menu` */

insert  into `menu`(`id`,`created_at`,`updated_at`,`category`,`description`,`image_url`,`name`,`price`) values 
(1,'2023-05-17 05:20:51.699000','2023-05-17 05:20:51.699000','Coffee','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','americano.png','Americano',20000),
(2,'2023-05-31 23:25:22.703000','2023-05-31 23:25:22.703000','Coffee','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','caramel-macchiato.png','Caramel Macchiato',30000),
(3,'2023-05-31 23:33:28.797000','2023-05-31 23:33:28.797000','Coffee','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','cappuccino.png','Cappuccino',25000),
(4,'2023-05-31 23:33:30.633000','2023-05-31 23:33:30.633000','Coffee','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','dolce-latte.png','Dolce Latte',15000),
(5,'2023-05-31 23:33:31.576000','2023-05-31 23:33:31.576000','Non-Coffee','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','classic-chocolate.png','Classic Chocolate',30000),
(6,'2023-05-31 23:33:32.391000','2023-05-31 23:33:32.391000','Non-Coffee','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','strawberry-frappe.png','Strawberry Frappe',40000),
(7,'2023-05-31 23:33:33.171000','2023-05-31 23:33:33.171000','Non-Coffee','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','caramel-frappe.png','Caramel Frappe',40000),
(8,'2023-05-31 23:33:33.901000','2023-05-31 23:33:33.901000','Non-Coffee','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','matcha-frappe.png','Matcha Frappe',35000),
(9,'2023-05-31 23:33:34.665000','2023-05-31 23:33:34.665000','Food','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','walnut-brownie.png','Walnut Brownie',25000),
(10,'2023-05-31 23:33:35.490000','2023-05-31 23:33:35.490000','Food','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','cinnamon-roll.png','Cinnamon Roll',25000),
(11,'2023-05-31 23:34:54.389000','2023-05-31 23:34:54.389000','Food','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','butter-croissant.png','Butter Croissant',25000),
(12,'2023-05-31 23:34:55.374000','2023-05-31 23:34:55.374000','Food','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget rhoncus ultricies, nunc elit ultricies nunc, vitae luctus nisl nunc eu nunc.','chocochip-cookie.png','Chocochip Cookie',25000),
(13,'2023-06-01 00:38:39.122000','2023-06-01 00:38:39.122000',NULL,NULL,NULL,NULL,0),
(14,'2023-06-01 00:42:22.256000','2023-06-01 00:42:22.256000',NULL,NULL,NULL,NULL,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

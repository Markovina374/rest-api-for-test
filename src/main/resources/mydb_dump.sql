CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;

USE `mydb` ;

CREATE TABLE `contract` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `date_of_last_update` date NOT NULL,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


INSERT INTO `contract` VALUES (1,'2020-01-20','2020-02-26','Lukoil'),(2,'2020-01-20','2020-03-26','CVT'),(3,'2020-02-20','2020-04-26','Epam'),(4,'2020-03-21','2020-05-26','GazProm'),(5,'2020-04-22','2020-06-26','NikeSB'),(6,'2020-05-23','2021-06-20','OnitsukaTiger'),(7,'2020-06-23','2021-06-19','Casio'),(8,'2020-01-26','2021-06-01','Nissan'),(9,'2020-01-21','2020-02-04','Vans'),(10,'2020-01-22','2021-06-08','Samsung');

CREATE DATABASE  IF NOT EXISTS `registration-rest-api` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `registration-rest-api`;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone_number` int(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `dob` DATE DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;

INSERT INTO `client` VALUES 
	(1,'David', 'Adams',123456,'david@gmail.com','1234','mail','2019-04-21'),
    (2,'Sohaib', 'Ahmed',12345,'sohaib@gmail.com','1234','mail','2019-04-21');

/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
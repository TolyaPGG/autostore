CREATE DATABASE  IF NOT EXISTS `wsite` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `wsite`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: wsite
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answers` (
  `q_id` int(11) DEFAULT NULL,
  `text` text,
  `author` text,
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` VALUES (10,'делай сам','dudes',60),(10,'ываываыв','dudes',61),(10,'выаываыв','dudes',62);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quests`
--

DROP TABLE IF EXISTS `quests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quests` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` text,
  `title` text,
  `author` text,
  `date` date DEFAULT NULL,
  `text` text,
  PRIMARY KEY (`q_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quests`
--

LOCK TABLES `quests` WRITE;
/*!40000 ALTER TABLE `quests` DISABLE KEYS */;
INSERT INTO `quests` VALUES (10,'Требуется замена заднего редуктора BMW X5','Требуется замена заднего редуктора BMW X5','dudes','2016-11-20','Ищу недорогой сервис для замены заднего редуктора на x5. Кто что может посоветовать?');
/*!40000 ALTER TABLE `quests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_pictures`
--

DROP TABLE IF EXISTS `user_pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_pictures` (
  `user` text,
  `picture` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_pictures`
--

LOCK TABLES `user_pictures` WRITE;
/*!40000 ALTER TABLE `user_pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(50) NOT NULL,
  `password` char(50) NOT NULL,
  `email` char(50) NOT NULL,
  `role` char(50) NOT NULL,
  `firstname` char(50) DEFAULT NULL,
  `lastname` char(50) DEFAULT NULL,
  `locale` char(5) DEFAULT 'en_US',
  `confirmed` bit(1) DEFAULT b'0',
  `active` bit(1) DEFAULT b'0',
  `uuid` char(50) DEFAULT NULL,
  `deletedate` date DEFAULT NULL,
  `vote` float DEFAULT NULL,
  `vote_count` int(11) DEFAULT NULL,
  UNIQUE KEY `username` (`username`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='sellers and buyers';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (24,'dudes','a3c73fbd0b3c6aaa95166f61e6652b04','ztalgatm@gmail.com','DISCUSSER',NULL,NULL,'en_US','','\0','f79d98b2-f113-4706-b2d4-52ca52410a7b','2016-11-24',NULL,NULL),(26,'dudos','7bf9f3cc746b6f8672fb505782657531','ztalgatm@gmail.com','DISCUSSER',NULL,NULL,'en_US','','\0','6a9d5be7-86e1-4cbb-8a2d-f74fa600b93a','2016-11-24',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'wsite'
--

--
-- Dumping routines for database 'wsite'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-20 16:45:03

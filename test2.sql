-- MySQL dump 10.13  Distrib 5.7.26, for macos10.14 (x86_64)
--
-- Host: localhost    Database: test2
-- ------------------------------------------------------
-- Server version	5.7.26

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
-- Current Database: `test2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `test2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test2`;

--
-- Table structure for table `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stu` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `password` char(32) DEFAULT NULL COMMENT '密码是32位的md5值',
  `birthday` date DEFAULT NULL COMMENT '生日'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu`
--

LOCK TABLES `stu` WRITE;
/*!40000 ALTER TABLE `stu` DISABLE KEYS */;
INSERT INTO `stu` VALUES (1,'hc','hc1997','1997-06-26'),(2,'dr','c','1998-02-28'),(3,'yyh','e','1998-05-25'),(4,'hsr',NULL,NULL),(5,'dsy','xihuanJJ2!','1998-02-02'),(6,'zht','zhtdsb','1998-05-23'),(7,'wyz',NULL,NULL),(8,'wl',NULL,NULL);
/*!40000 ALTER TABLE `stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt1`
--

DROP TABLE IF EXISTS `tt1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt1` (
  `id` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt1`
--

LOCK TABLES `tt1` WRITE;
/*!40000 ALTER TABLE `tt1` DISABLE KEYS */;
INSERT INTO `tt1` VALUES (1),(-128),(127),(127),(-128);
/*!40000 ALTER TABLE `tt1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt10`
--

DROP TABLE IF EXISTS `tt10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt10` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) NOT NULL DEFAULT '中国'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt10`
--

LOCK TABLES `tt10` WRITE;
/*!40000 ALTER TABLE `tt10` DISABLE KEYS */;
INSERT INTO `tt10` VALUES (1,'中国');
/*!40000 ALTER TABLE `tt10` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt11`
--

DROP TABLE IF EXISTS `tt11`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt11` (
  `id` int(11) DEFAULT NULL COMMENT '序号',
  `name` varchar(10) DEFAULT NULL COMMENT '人的姓名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt11`
--

LOCK TABLES `tt11` WRITE;
/*!40000 ALTER TABLE `tt11` DISABLE KEYS */;
/*!40000 ALTER TABLE `tt11` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt12`
--

DROP TABLE IF EXISTS `tt12`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt12` (
  `id` int(10) unsigned zerofill DEFAULT NULL,
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt12`
--

LOCK TABLES `tt12` WRITE;
/*!40000 ALTER TABLE `tt12` DISABLE KEYS */;
INSERT INTO `tt12` VALUES (0000000001,80),(0000000002,77),(0000000003,60);
/*!40000 ALTER TABLE `tt12` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt13`
--

DROP TABLE IF EXISTS `tt13`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt13` (
  `id` int(11) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt13`
--

LOCK TABLES `tt13` WRITE;
/*!40000 ALTER TABLE `tt13` DISABLE KEYS */;
INSERT INTO `tt13` VALUES (1,'b');
/*!40000 ALTER TABLE `tt13` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt14`
--

DROP TABLE IF EXISTS `tt14`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt14` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`name`,`age`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt14`
--

LOCK TABLES `tt14` WRITE;
/*!40000 ALTER TABLE `tt14` DISABLE KEYS */;
/*!40000 ALTER TABLE `tt14` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt15`
--

DROP TABLE IF EXISTS `tt15`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt15` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt15`
--

LOCK TABLES `tt15` WRITE;
/*!40000 ALTER TABLE `tt15` DISABLE KEYS */;
INSERT INTO `tt15` VALUES (1,'hc'),(2,'wangfan');
/*!40000 ALTER TABLE `tt15` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt16`
--

DROP TABLE IF EXISTS `tt16`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt16` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` enum('男','女') DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `age` (`age`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt16`
--

LOCK TABLES `tt16` WRITE;
/*!40000 ALTER TABLE `tt16` DISABLE KEYS */;
INSERT INTO `tt16` VALUES (1,'hc','男',80),(3,NULL,'女',18);
/*!40000 ALTER TABLE `tt16` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt2`
--

DROP TABLE IF EXISTS `tt2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt2` (
  `id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt2`
--

LOCK TABLES `tt2` WRITE;
/*!40000 ALTER TABLE `tt2` DISABLE KEYS */;
INSERT INTO `tt2` VALUES (0),(255);
/*!40000 ALTER TABLE `tt2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt3`
--

DROP TABLE IF EXISTS `tt3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt3` (
  `id` int(11) DEFAULT NULL,
  `num` bit(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt3`
--

LOCK TABLES `tt3` WRITE;
/*!40000 ALTER TABLE `tt3` DISABLE KEYS */;
INSERT INTO `tt3` VALUES (10,_binary '\n'),(11,_binary 'A');
/*!40000 ALTER TABLE `tt3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt4`
--

DROP TABLE IF EXISTS `tt4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt4` (
  `id` int(11) DEFAULT NULL,
  `num` float(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt4`
--

LOCK TABLES `tt4` WRITE;
/*!40000 ALTER TABLE `tt4` DISABLE KEYS */;
INSERT INTO `tt4` VALUES (1,99.96),(1,99.46),(1,99.99),(1,99.99),(1,99.99),(1,99.94);
/*!40000 ALTER TABLE `tt4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt6`
--

DROP TABLE IF EXISTS `tt6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt6` (
  `t1` float(10,8) DEFAULT NULL,
  `t2` decimal(10,8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt6`
--

LOCK TABLES `tt6` WRITE;
/*!40000 ALTER TABLE `tt6` DISABLE KEYS */;
INSERT INTO `tt6` VALUES (34.12345505,34.12345678);
/*!40000 ALTER TABLE `tt6` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt7`
--

DROP TABLE IF EXISTS `tt7`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt7` (
  `t1` char(2) DEFAULT NULL,
  `t2` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt7`
--

LOCK TABLES `tt7` WRITE;
/*!40000 ALTER TABLE `tt7` DISABLE KEYS */;
INSERT INTO `tt7` VALUES ('av','av'),('av','av'),('中国','中国'),('中国','中国');
/*!40000 ALTER TABLE `tt7` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt8`
--

DROP TABLE IF EXISTS `tt8`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt8` (
  `t1` date DEFAULT NULL,
  `t2` datetime DEFAULT NULL,
  `t3` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt8`
--

LOCK TABLES `tt8` WRITE;
/*!40000 ALTER TABLE `tt8` DISABLE KEYS */;
INSERT INTO `tt8` VALUES ('2019-05-09','2019-05-08 00:00:00','2019-05-10 11:38:26'),('2019-05-08','2019-05-08 19:39:20','2019-05-10 00:00:00');
/*!40000 ALTER TABLE `tt8` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tt9`
--

DROP TABLE IF EXISTS `tt9`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tt9` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tt9`
--

LOCK TABLES `tt9` WRITE;
/*!40000 ALTER TABLE `tt9` DISABLE KEYS */;
/*!40000 ALTER TABLE `tt9` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `votes`
--

DROP TABLE IF EXISTS `votes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `votes` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `hobby` set('唱','跳','rap','篮球') DEFAULT NULL,
  `sex` enum('男','女') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votes`
--

LOCK TABLES `votes` WRITE;
/*!40000 ALTER TABLE `votes` DISABLE KEYS */;
INSERT INTO `votes` VALUES (1,'hc','唱','男'),(1,'cxk','篮球','女'),(2,'cxk','唱,跳,rap,篮球','女');
/*!40000 ALTER TABLE `votes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `votes1`
--

DROP TABLE IF EXISTS `votes1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `votes1` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `hobby` set('吃','喝','嫖','赌') DEFAULT NULL,
  `gender` enum('男','女') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `votes1`
--

LOCK TABLES `votes1` WRITE;
/*!40000 ALTER TABLE `votes1` DISABLE KEYS */;
INSERT INTO `votes1` VALUES (1,'王凡','吃,喝,嫖,赌','男'),(2,'侯昌','吃,喝','男'),(3,'王亮','吃,喝,嫖,赌','男'),(4,'赵沛轩','吃,嫖','男'),(5,'宋拓','吃,嫖','男');
/*!40000 ALTER TABLE `votes1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-10 21:31:21

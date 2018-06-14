CREATE DATABASE  IF NOT EXISTS `relativehelper` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `relativehelper`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: relativehelper
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `chatmodel`
--

DROP TABLE IF EXISTS `chatmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chatmodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `chatroom` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatmodel`
--

LOCK TABLES `chatmodel` WRITE;
/*!40000 ALTER TABLE `chatmodel` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatmodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatroommodel`
--

DROP TABLE IF EXISTS `chatroommodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chatroommodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatroommodel`
--

LOCK TABLES `chatroommodel` WRITE;
/*!40000 ALTER TABLE `chatroommodel` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatroommodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `files`
--

DROP TABLE IF EXISTS `files`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `files` (
  `FILEID` int(11) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `AUTHOR` varchar(45) DEFAULT NULL,
  `PATH` varchar(8000) DEFAULT NULL,
  `TASK_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`FILEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `files`
--

LOCK TABLES `files` WRITE;
/*!40000 ALTER TABLE `files` DISABLE KEYS */;
INSERT INTO `files` VALUES (1,'Monalisa','1','C:\\Users\\Fabio\\Software-Data\\eclipse\\GitHub\\ch.bfh.bti7081.s2018.blue\\src\\main\\resources\\FILES\\1.pdf',7);
/*!40000 ALTER TABLE `files` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `information`
--

DROP TABLE IF EXISTS `information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `information` (
  `NAME` varchar(100) NOT NULL,
  `TEXT` text,
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `information`
--

LOCK TABLES `information` WRITE;
/*!40000 ALTER TABLE `information` DISABLE KEYS */;
INSERT INTO `information` VALUES ('Alkoholsucht','die chemische Verbindung Ethanol, genannt auch Äthylalkohol, die im allgemeinen Sprachgebrauch als Alkohol bezeichnet wird...'),('Arbeitssucht','Der Begriff Arbeitssucht wird heutzutage seltener verwendet...'),('Coffeinsucht','Coffein oder Koffein (auch Tein, Teein oder Thein, früher auch Caffein) ist ein Alkaloid (Purinalkaloid) aus der Stoffgruppe der Xanthine.'),('Internetsucht','Internetsucht, die auch unter dem Namen Onlinesucht bekannt ist, ist der zwanghafte Drang,...'),('Kaufsucht','In Europa wird Kaufsucht erst seit Anfang der 90er Jahre erforscht. '),('Magersucht','Schlank zu sein, entspricht immer noch dem gängigen Schönheitsideal.');
/*!40000 ALTER TABLE `information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginaccount`
--

DROP TABLE IF EXISTS `loginaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginaccount` (
  `USERNAME` varchar(45) NOT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `FIRSTNAME` varchar(45) DEFAULT NULL,
  `LASTNAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(65) DEFAULT NULL,
  `STREET` varchar(45) DEFAULT NULL,
  `ZIPCODE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginaccount`
--

LOCK TABLES `loginaccount` WRITE;
/*!40000 ALTER TABLE `loginaccount` DISABLE KEYS */;
INSERT INTO `loginaccount` VALUES ('gertl1','Thun','Lars','Gertsch','03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4','Mittlere Strasse 22','3600'),('herrs1','Thun','Simon','Herrmann','F8638B979B2F4F793DDB6DBD197E0EE25A7A6EA32B0AE22F5E3C5D119D839E75','Mittlere Strasse 22','3600');
/*!40000 ALTER TABLE `loginaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicine` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `LOGINACCOUNT_USERNAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'Ascosal','Fieber und/oder Schmerzen bei ','herrs1'),(2,'Tramadol plus Spirig HC','Mässiger bis starker Schmerzen','herrs1'),(3,'Nebivolol Sandoz','Bluthochdruck und chronischer Herzschwäche ','gertl1'),(4,'Terbinafin Axapharm','Nicht lokal behandelbare Mykosen der Haut und Haare','gertl1'),(5,'CellCept','Fieber und/oder Schmerzen bei Erkältungskrankheiten ','gertl1'),(6,'CYMBALTA','Depression, generalisierten Angststörung, Schmerzen','gertl1'),(7,'Duloxalta ','Mittelschwere bis schwere Depressionen ','herrs1'),(8,'Aponal ','Entzugserscheinungen bei Alkohol-, Arzneimittel- oder Drogenabhängigkeit','herrs1'),(9,'Cipramil ','Antidepressivum in der Behandlung von Depressionen','herrs1'),(10,'Trevilor','Antidepressivum','herrs1');
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderstatus`
--

DROP TABLE IF EXISTS `orderstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LOGINACCOUNT_USERNAME` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1066 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderstatus`
--

LOCK TABLES `orderstatus` WRITE;
/*!40000 ALTER TABLE `orderstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',0);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tasks` (
  `TASKID` int(11) NOT NULL,
  `SUBJECT` varchar(100) DEFAULT NULL,
  `DUEDATE` date DEFAULT NULL,
  `DESCRIPTION` varchar(8000) DEFAULT NULL,
  `STATUS` varchar(25) DEFAULT NULL,
  `USERNAME` varchar(45) NOT NULL,
  PRIMARY KEY (`TASKID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'Spazieren gehen','2018-07-13','In der Natur','Not done yet','herrs1'),(2,'Zoo besuchen','2018-08-27','In Zoo gehen','Not done yet','gertl1'),(3,'Viel Trinken','2018-05-21','Viel Wasser Trinken','Done','gertl1'),(4,'Medikament einnehmen','2018-05-09','2 Aspirin einnehmen','Done','gertl1'),(5,'Arzttermin','2018-04-02','Zum Arzt gehen','Done','herrs1'),(6,'Freunde treffen','2018-06-19','Ein paar Freunde nach Hause einladen','Not done yet','herrs1'),(7,'Ein Bild malen','2018-06-10','Ein Bild zur Ablenkung malen','Done','gertl1'),(8,'Arzttermin','2018-06-12','Lunge untersuchen lassen','Not done yet','gertl1');
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermedicine`
--

DROP TABLE IF EXISTS `usermedicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermedicine` (
  `idmedicine` int(11) NOT NULL,
  `LOGINACCOUNT_USERNAME` varchar(45) NOT NULL,
  PRIMARY KEY (`idmedicine`,`LOGINACCOUNT_USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermedicine`
--

LOCK TABLES `usermedicine` WRITE;
/*!40000 ALTER TABLE `usermedicine` DISABLE KEYS */;
INSERT INTO `usermedicine` VALUES (11001,'gertl1'),(11003,'gertl1'),(11004,'gertl1'),(11004,'herrs1'),(11005,'herrs1'),(11006,'herrs1'),(11007,'herrs1'),(11008,'herrs1'),(11010,'gertl1'),(11011,'gertl1');
/*!40000 ALTER TABLE `usermedicine` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-14 18:05:12

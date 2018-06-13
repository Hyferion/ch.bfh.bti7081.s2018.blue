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
-- Table structure for table `information `
--

DROP TABLE IF EXISTS `information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `information` (
  `NAME` varchar(100) NOT NULL,
  `TEXT` text(10000) DEFAULT NULL,
  PRIMARY KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `information`
--

LOCK TABLES `information` WRITE;
/*!40000 ALTER TABLE `orderstatus` DISABLE KEYS */;
INSERT INTO `information` VALUES ('Alkoholsucht','Viele Menschen trinken nach Feierabend gerne ein Bier oder ein Glas Wein, und auch in der Freizeit oder bei Festlichkeiten wird gerne Alkohol getrunken. Dagegen ist im Grunde nichts einzuwenden, doch die Grenzen zur Sucht sind leider schleichend. Regelmäßiger Alkoholgenuss kann schnell in die Abhängigkeit führen, so dass viele den Absprung nicht mehr rechtzeitig schaffen. Sobald man merkt, dass man sich unter Alkoholeinfluss besser fühlt, und das Leben besser ertragen kann, ist dies meistens schon der Anfang vom Ende.'),
('Coffeinsucht','Obwohl Coffein nicht zu den Drogen gehört, kann man eine Sucht entwickeln. Der Körper gewöhnt sich an die übermäßige Zufuhr von Coffein, so dass auf eine Art und Weise auch eine körperliche Abhängigkeit entsteht. Coffein fördert die Konzentration und hält wach, so dass gerade Berufstätige Unmengen von Kaffee trinken, um bei der Arbeit fit zu sein. Vielen ist dabei nicht bewusst, dass auch Coffein abhängig machen kann, denn immerhin zählt es zu den ältesten Aufputschmitteln. Coffein ist überall erhältlich, sei es in Form von Kaffee, Cola, Tee oder Energy-Drinks.'),
('Magersucht','Schlank zu sein, entspricht immer noch dem gängigen Schönheitsideal. In der Werbung und den Medien wird den Menschen suggeriert, dass nur schlanke Menschen attraktiv sind. Models werden immer dünner, bei einigen sieht man sogar die Knochen. Gerade junge Frauen, die unter einem schlechten Selbstbewusstsein leiden, lassen sich in dieser Richtung beeinflussen. Sie orientieren sich an den dünnen Stars und wollen auch so sein, um begehrt und beliebt zu sein. Viele Frauen treibt das in die Magersucht, und sogar berühmte Stars sind davon betroffen. Die Betroffenen haben eine gestörte Wahrnehmung von ihrem Körper.');
/*!40000 ALTER TABLE `orderstatus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-25 10:51:16

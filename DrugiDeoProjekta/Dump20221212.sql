-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: primer
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `id_gen`
--

DROP TABLE IF EXISTS `id_gen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `id_gen` (
  `gen_name` varchar(50) NOT NULL,
  `gen_val` int(11) NOT NULL,
  PRIMARY KEY (`gen_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id_gen`
--

LOCK TABLES `id_gen` WRITE;
/*!40000 ALTER TABLE `id_gen` DISABLE KEYS */;
INSERT INTO `id_gen` VALUES ('klijent_gen',16),('trans_gen',54);
/*!40000 ALTER TABLE `id_gen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klijenti`
--

DROP TABLE IF EXISTS `klijenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klijenti` (
  `id` int(11) NOT NULL,
  `ime` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `stanjeracuna` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klijenti`
--

LOCK TABLES `klijenti` WRITE;
/*!40000 ALTER TABLE `klijenti` DISABLE KEYS */;
INSERT INTO `klijenti` VALUES (1,'Ana','Nikole Pasica 1','18000'),(2,'Nikola','Tetovska 2/1','304400'),(3,'Jana','Ljube Nesica 5','922200'),(4,'Marko','Kotorska 3','16000'),(5,'Zarko','B.Radicevica 4/2','15000'),(6,'Ravi','Textile 6','20300'),(7,'Milan','Prizrenska 10','103400'),(8,'Jelena','Cara Dusana 6','8000'),(9,'Dusan','S.Markovica 50','0'),(14,'Tea','Cara Miska','10800');
/*!40000 ALTER TABLE `klijenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transakcija`
--

DROP TABLE IF EXISTS `transakcija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transakcija` (
  `id` int(11) NOT NULL,
  `idprimaoca` int(11) NOT NULL,
  `idposiljaoca` int(11) NOT NULL,
  `iznos` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `komentar` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idprimaoca_idx` (`idprimaoca`),
  KEY `idposiljaoca_idx` (`idposiljaoca`),
  CONSTRAINT `idposiljaoca` FOREIGN KEY (`idposiljaoca`) REFERENCES `klijenti` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idprimaoca` FOREIGN KEY (`idprimaoca`) REFERENCES `klijenti` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transakcija`
--

LOCK TABLES `transakcija` WRITE;
/*!40000 ALTER TABLE `transakcija` DISABLE KEYS */;
INSERT INTO `transakcija` VALUES (1,2,3,200,0,'Potreban potpis'),(10,8,9,200,1,'Nije potreban potpis'),(12,7,8,200,1,'Potreban potpis'),(15,7,8,200,1,'Potreban potpis'),(16,4,5,400,1,'Potreban potpis'),(19,14,9,1800,1,'Nije potreban potpis'),(25,2,5,500,0,'Nije potreban potpis'),(28,9,6,600,0,'Potreban potpis'),(29,9,6,600,0,'Nije potreban potpis'),(32,9,6,600,0,'Potreban potpis'),(33,9,6,600,0,'Potreban potpis'),(43,9,14,900,0,'Nije potreban potpis'),(44,9,14,900,0,'Nije potreban potpis'),(45,9,14,800,0,'Potreban potpis'),(49,14,9,900,0,'Potreban potpis'),(52,2,3,200,1,'Potreban potpis'),(53,8,9,200,1,'Potreban potpis');
/*!40000 ALTER TABLE `transakcija` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-04  0:55:02

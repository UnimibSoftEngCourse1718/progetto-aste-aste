CREATE DATABASE  IF NOT EXISTS `aste` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `aste`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: aste
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attributo`
--

DROP TABLE IF EXISTS `attributo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attributo` (
  `idAttributo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idAttributo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributo`
--

LOCK TABLES `attributo` WRITE;
/*!40000 ALTER TABLE `attributo` DISABLE KEYS */;
INSERT INTO `attributo` VALUES (6,'Cilindrata'),(7,'Marca'),(8,'Anno'),(9,'Km'),(10,'Marca'),(11,'Ram'),(12,'Processore'),(13,'Scheda Grafica'),(14,'Hard Disk');
/*!40000 ALTER TABLE `attributo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_att`
--

DROP TABLE IF EXISTS `cat_att`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cat_att` (
  `idCat_att` int(11) NOT NULL AUTO_INCREMENT,
  `idAttributo` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idCat_att`),
  KEY `fk_cat_att_attributo1_idx` (`idAttributo`),
  KEY `fk_cat_att_categoria1_idx` (`idCategoria`),
  CONSTRAINT `fk_cat_att_attributo1` FOREIGN KEY (`idAttributo`) REFERENCES `attributo` (`idattributo`),
  CONSTRAINT `fk_cat_att_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idcategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_att`
--

LOCK TABLES `cat_att` WRITE;
/*!40000 ALTER TABLE `cat_att` DISABLE KEYS */;
INSERT INTO `cat_att` VALUES (1,6,9),(2,7,9),(3,8,9),(4,9,9),(5,10,10),(6,11,10),(7,12,10),(8,13,10),(9,14,10);
/*!40000 ALTER TABLE `cat_att` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (9,'Auto'),(10,'Computer');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credito`
--

DROP TABLE IF EXISTS `credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `credito` (
  `idCredito` int(11) NOT NULL AUTO_INCREMENT,
  `azione` tinyint(4) NOT NULL,
  `quantita` float NOT NULL,
  `idUtente` int(11) NOT NULL,
  PRIMARY KEY (`idCredito`),
  KEY `fk_credito_utente_idx` (`idUtente`),
  CONSTRAINT `fk_credito_utente` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`idutente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credito`
--

LOCK TABLES `credito` WRITE;
/*!40000 ALTER TABLE `credito` DISABLE KEYS */;
INSERT INTO `credito` VALUES (1,1,100,1),(2,1,100,1),(3,0,100,1);
/*!40000 ALTER TABLE `credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offerta`
--

DROP TABLE IF EXISTS `offerta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `offerta` (
  `idOfferta` int(11) NOT NULL AUTO_INCREMENT,
  `stato` enum('PAGATO','VENDUTO','ATTIVO') NOT NULL DEFAULT 'ATTIVO',
  `importo` float DEFAULT NULL,
  `idOggetto` int(11) NOT NULL,
  `idUtente` int(11) NOT NULL,
  `data` datetime DEFAULT NULL,
  PRIMARY KEY (`idOfferta`),
  KEY `fk_offerta_oggetto1_idx` (`idOggetto`),
  KEY `fk_offerta_utente1_idx` (`idUtente`),
  CONSTRAINT `fk_offerta_oggetto1` FOREIGN KEY (`idOggetto`) REFERENCES `oggetto` (`idoggetto`),
  CONSTRAINT `fk_offerta_utente1` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`idutente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offerta`
--

LOCK TABLES `offerta` WRITE;
/*!40000 ALTER TABLE `offerta` DISABLE KEYS */;
/*!40000 ALTER TABLE `offerta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ogg_att`
--

DROP TABLE IF EXISTS `ogg_att`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ogg_att` (
  `idOgg_att` int(11) NOT NULL AUTO_INCREMENT,
  `valore` varchar(45) NOT NULL,
  `idAttributo` int(11) NOT NULL,
  `idOggetto` int(11) NOT NULL,
  PRIMARY KEY (`idOgg_att`),
  KEY `fk_ogg_att_attributo1_idx` (`idAttributo`),
  KEY `fk_ogg_att_oggetto1_idx` (`idOggetto`),
  CONSTRAINT `fk_ogg_att_attributo1` FOREIGN KEY (`idAttributo`) REFERENCES `attributo` (`idattributo`),
  CONSTRAINT `fk_ogg_att_oggetto1` FOREIGN KEY (`idOggetto`) REFERENCES `oggetto` (`idoggetto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ogg_att`
--

LOCK TABLES `ogg_att` WRITE;
/*!40000 ALTER TABLE `ogg_att` DISABLE KEYS */;
INSERT INTO `ogg_att` VALUES (1,'1400',6,11),(2,'Opel',7,11),(3,'2005',8,11),(4,'80000',9,11);
/*!40000 ALTER TABLE `ogg_att` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oggetto`
--

DROP TABLE IF EXISTS `oggetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `oggetto` (
  `idOggetto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `idUtente` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `tempoAsta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOggetto`),
  KEY `fk_oggetto_utente1_idx` (`idUtente`),
  KEY `fk_oggetto_categoria1_idx` (`idCategoria`),
  CONSTRAINT `fk_oggetto_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idcategoria`),
  CONSTRAINT `fk_oggetto_utente1` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`idutente`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oggetto`
--

LOCK TABLES `oggetto` WRITE;
/*!40000 ALTER TABLE `oggetto` DISABLE KEYS */;
INSERT INTO `oggetto` VALUES (11,'Opel Corsa',1,9,2);
/*!40000 ALTER TABLE `oggetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente` (
  `idUtente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `credito` float NOT NULL DEFAULT '0',
  `ruolo` enum('reg','manager','admin') NOT NULL,
  PRIMARY KEY (`idUtente`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'admin','admin','admin','admin',100,'reg'),(3,'User','User','user','password',0,'reg');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-15 17:54:15

CREATE DATABASE  IF NOT EXISTS `aste` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `aste`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: aste
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
-- Table structure for table `attributo`
--

DROP TABLE IF EXISTS `attributo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attributo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributo`
--

LOCK TABLES `attributo` WRITE;
/*!40000 ALTER TABLE `attributo` DISABLE KEYS */;
/*!40000 ALTER TABLE `attributo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_att`
--

DROP TABLE IF EXISTS `cat_att`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_att` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attributo_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cat_att_attributo1_idx` (`attributo_id`),
  KEY `fk_cat_att_categoria1_idx` (`categoria_id`),
  CONSTRAINT `fk_cat_att_attributo1` FOREIGN KEY (`attributo_id`) REFERENCES `attributo` (`id`),
  CONSTRAINT `fk_cat_att_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_att`
--

LOCK TABLES `cat_att` WRITE;
/*!40000 ALTER TABLE `cat_att` DISABLE KEYS */;
/*!40000 ALTER TABLE `cat_att` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credito`
--

DROP TABLE IF EXISTS `credito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `azione` tinyint(4) NOT NULL,
  `quantita` float NOT NULL,
  `utente_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_credito_utente_idx` (`utente_id`),
  CONSTRAINT `fk_credito_utente` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credito`
--

LOCK TABLES `credito` WRITE;
/*!40000 ALTER TABLE `credito` DISABLE KEYS */;
/*!40000 ALTER TABLE `credito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offerta`
--

DROP TABLE IF EXISTS `offerta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offerta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stato` enum('pagato','venduto','attivo') NOT NULL DEFAULT 'attivo',
  `importo` float DEFAULT NULL,
  `oggetto_id` int(11) NOT NULL,
  `utente_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_offerta_oggetto1_idx` (`oggetto_id`),
  KEY `fk_offerta_utente1_idx` (`utente_id`),
  CONSTRAINT `fk_offerta_oggetto1` FOREIGN KEY (`oggetto_id`) REFERENCES `oggetto` (`id`),
  CONSTRAINT `fk_offerta_utente1` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`)
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ogg_att` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valore` varchar(45) NOT NULL,
  `attributo_id` int(11) NOT NULL,
  `oggetto_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ogg_att_attributo1_idx` (`attributo_id`),
  KEY `fk_ogg_att_oggetto1_idx` (`oggetto_id`),
  CONSTRAINT `fk_ogg_att_attributo1` FOREIGN KEY (`attributo_id`) REFERENCES `attributo` (`id`),
  CONSTRAINT `fk_ogg_att_oggetto1` FOREIGN KEY (`oggetto_id`) REFERENCES `oggetto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ogg_att`
--

LOCK TABLES `ogg_att` WRITE;
/*!40000 ALTER TABLE `ogg_att` DISABLE KEYS */;
/*!40000 ALTER TABLE `ogg_att` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oggetto`
--

DROP TABLE IF EXISTS `oggetto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oggetto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `utente_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_oggetto_utente1_idx` (`utente_id`),
  KEY `fk_oggetto_categoria1_idx` (`categoria_id`),
  CONSTRAINT `fk_oggetto_categoria1` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fk_oggetto_utente1` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oggetto`
--

LOCK TABLES `oggetto` WRITE;
/*!40000 ALTER TABLE `oggetto` DISABLE KEYS */;
/*!40000 ALTER TABLE `oggetto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `credito` float NOT NULL DEFAULT '0',
  `ruolo` enum('reg','manager','admin') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
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

-- Dump completed on 2018-05-31 13:49:32

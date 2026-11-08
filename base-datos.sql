-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: complejo_cines
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asiento`
--

DROP TABLE IF EXISTS `asiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asiento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sala_ID` int NOT NULL,
  `cine_ID` int NOT NULL,
  `funcion_ID` int NOT NULL,
  `fila` int NOT NULL,
  `numero` int NOT NULL,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`,`sala_ID`,`cine_ID`,`funcion_ID`),
  KEY `fk_asiento_sala` (`sala_ID`,`cine_ID`),
  CONSTRAINT `fk_asiento_sala` FOREIGN KEY (`sala_ID`, `cine_ID`) REFERENCES `sala` (`id`, `cine_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiento`
--

LOCK TABLES `asiento` WRITE;
/*!40000 ALTER TABLE `asiento` DISABLE KEYS */;
INSERT INTO `asiento` VALUES (1,1,1,1,1,1,0),(2,1,1,1,1,2,0),(3,1,1,1,2,2,1),(4,2,1,2,1,1,1),(5,2,1,2,1,2,0),(6,2,1,2,2,2,0),(7,3,1,3,1,1,1),(8,3,1,3,1,3,1),(9,3,1,3,1,2,0),(10,4,2,4,1,1,1),(11,4,2,4,3,3,0),(12,4,2,4,1,2,1),(13,5,2,5,1,4,1),(14,5,2,5,1,3,0),(15,5,2,5,3,2,1),(16,6,3,6,1,1,0),(17,6,3,6,2,1,1),(18,6,3,6,3,1,0),(19,7,3,7,3,1,1),(20,7,3,7,3,2,1),(21,7,3,7,3,3,1),(22,8,4,8,1,1,1),(23,8,4,8,2,1,1),(24,8,4,8,1,2,1),(25,9,4,9,1,1,1),(26,9,4,10,2,1,1),(27,9,4,9,2,2,1);
/*!40000 ALTER TABLE `asiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cine`
--

DROP TABLE IF EXISTS `cine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cine` (
  `id` int NOT NULL AUTO_INCREMENT,
  `calle` varchar(100) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cine`
--

LOCK TABLES `cine` WRITE;
/*!40000 ALTER TABLE `cine` DISABLE KEYS */;
INSERT INTO `cine` VALUES (1,'Bvar. Artigas 1825','Montevideo','Tres Cruces'),(2,'Av. Luis Alberto de Herrera 1290','Montevideo','Montevideo'),(3,'José Ellauri 350','Montevideo','Punta Carretas'),(4,'Av. Italia 5775','Montevideo','Portones');
/*!40000 ALTER TABLE `cine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `documento` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `correo_electronico` varchar(50) NOT NULL,
  `contrasena` varchar(30) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (12345672,'Paula','Nuñez','xxxxx@mail.com','1234'),(48338819,'Pepe','Pepi','123456@mail.com','adada'),(51348948,'Ramiro','Techera','aaaaaaa@mail.com','8942'),(58376015,'Sofía','Larrosa','bbbbbbbb@mail.com','1234'),(58478883,'Jacinta','Lacinta','123abc@mail.com','123');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente_CI` int DEFAULT NULL,
  `importe_total` int DEFAULT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL,
  `metodo_pago` varchar(20) NOT NULL,
  `motivo` text,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_compra_cliente` (`cliente_CI`),
  CONSTRAINT `fk_compra_cliente` FOREIGN KEY (`cliente_CI`) REFERENCES `cliente` (`documento`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,12345672,640,'2024-04-10','10:00','Tarjeta',NULL,1),(2,12345672,720,'2024-01-10','9:00','Tarjeta',NULL,0),(3,48338819,320,'2024-04-11','8:00','Efectivo',NULL,1),(4,51348948,320,'2024-04-06','19:00','Tarjeta',NULL,1),(5,51348948,320,'2024-03-12','18:00','Efectivo',NULL,1),(6,58376015,400,'2024-04-12','10:00','Tarjeta',NULL,0),(7,58376015,380,'2026-04-10','12:00','Efectivo',NULL,1);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `documento` int NOT NULL,
  `cine_ID` int NOT NULL,
  `cargo` enum('acomodador','cajero','administrador') NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `contrasena` varchar(30) NOT NULL,
  PRIMARY KEY (`documento`),
  KEY `fk_empleado_cine` (`cine_ID`),
  CONSTRAINT `fk_empleado_cine` FOREIGN KEY (`cine_ID`) REFERENCES `cine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (11111111,3,'acomodador','Natalia','Cruz','2022-08-15','qwert'),(22222222,2,'cajero','Óscar','Peña','2020-03-10','oscarcito'),(58376015,1,'administrador','Marcos','Díaz','2021-05-01','12345'),(58478883,1,'administrador','Pepe','Peposo','2021-05-01','123');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `id` int NOT NULL AUTO_INCREMENT,
  `precio_pagado` int NOT NULL,
  `asiento_ID` int DEFAULT NULL,
  `sala_ID` int DEFAULT NULL,
  `cine_ID` int DEFAULT NULL,
  `funcion_ID` int DEFAULT NULL,
  `compra_ID` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `asiento_ID` (`asiento_ID`,`sala_ID`,`cine_ID`,`funcion_ID`,`compra_ID`),
  KEY `fk_entrada_compra` (`compra_ID`),
  CONSTRAINT `fk_entrada_asiento` FOREIGN KEY (`asiento_ID`, `sala_ID`, `cine_ID`, `funcion_ID`) REFERENCES `asiento` (`id`, `sala_ID`, `cine_ID`, `funcion_ID`),
  CONSTRAINT `fk_entrada_compra` FOREIGN KEY (`compra_ID`) REFERENCES `compra` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (1,320,1,1,1,1,1),(2,320,2,1,1,1,1),(3,320,5,2,1,2,2),(4,400,6,2,1,2,2),(5,320,9,3,1,3,3),(6,320,11,4,2,4,4),(7,320,14,5,2,5,5),(8,400,16,6,3,6,6),(9,380,18,6,3,6,7);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcion`
--

DROP TABLE IF EXISTS `funcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sala_ID` int DEFAULT NULL,
  `cine_ID` int DEFAULT NULL,
  `pelicula_ID` int DEFAULT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(20) NOT NULL,
  `precio_base` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sala_ID` (`sala_ID`,`pelicula_ID`,`fecha`,`hora`),
  KEY `fk_funcion_sala` (`sala_ID`,`cine_ID`),
  KEY `fk_funcion_pelicula` (`pelicula_ID`),
  CONSTRAINT `fk_funcion_pelicula` FOREIGN KEY (`pelicula_ID`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `fk_funcion_sala` FOREIGN KEY (`sala_ID`, `cine_ID`) REFERENCES `sala` (`id`, `cine_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcion`
--

LOCK TABLES `funcion` WRITE;
/*!40000 ALTER TABLE `funcion` DISABLE KEYS */;
INSERT INTO `funcion` VALUES (1,1,1,1,'2024-04-10','18:00',320),(2,2,1,5,'2027-04-10','21:00',380),(3,3,1,1,'2024-04-10','21:00',320),(4,4,2,2,'2024-04-11','19:30',320),(5,5,2,3,'2024-04-13','19:00',420),(6,6,3,4,'2027-04-12','17:00',400),(7,7,3,2,'2024-04-11','19:30',320),(8,8,4,3,'2024-04-13','19:00',420),(9,9,4,5,'2024-04-11','13:00',420),(10,9,4,3,'2025-04-12','22:00',400);
/*!40000 ALTER TABLE `funcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `pelicula_ID` int NOT NULL,
  `genero` varchar(20) NOT NULL,
  PRIMARY KEY (`pelicula_ID`,`genero`),
  CONSTRAINT `fk_genero_pelicula` FOREIGN KEY (`pelicula_ID`) REFERENCES `pelicula` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Ciencia ficción'),(2,'Comedia'),(3,'Drama'),(4,'Acción'),(5,'Terror');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(30) NOT NULL,
  `anio_estreno` date DEFAULT NULL,
  `duracion` varchar(20) DEFAULT NULL,
  `clasificacion_por_edad` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `titulo` (`titulo`,`anio_estreno`,`duracion`,`clasificacion_por_edad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'Aventura Estelar','2020-01-01','120 minutos','12'),(3,'Cataclismo Universal','2021-10-01','100 minutos','16'),(2,'Risas en la Ciudad','2023-01-01','113 minutos','ATP'),(5,'Sombras del Pasado','2022-01-10','90 minutos','18'),(4,'WW3','2024-01-11','203 minutos','18');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sala` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cine_ID` int NOT NULL,
  `numero` int NOT NULL,
  `largo_asientos` int NOT NULL,
  `ancho_asientos` int NOT NULL,
  `capacidad_maxima` int NOT NULL,
  PRIMARY KEY (`id`,`cine_ID`),
  UNIQUE KEY `cine_ID` (`cine_ID`,`numero`),
  CONSTRAINT `fk_sala_cine` FOREIGN KEY (`cine_ID`) REFERENCES `cine` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (1,1,1,13,10,70),(2,1,2,10,6,36),(3,1,3,9,6,36),(4,2,1,10,10,100),(5,2,2,15,10,150),(6,3,1,10,5,50),(7,3,2,7,5,30),(8,4,1,10,10,100),(9,4,2,10,10,100);
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono` (
  `cliente_CI` int DEFAULT NULL,
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY (`telefono`),
  KEY `fk_telefono_cliente` (`cliente_CI`),
  CONSTRAINT `fk_telefono_cliente` FOREIGN KEY (`cliente_CI`) REFERENCES `cliente` (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
INSERT INTO `telefono` VALUES (12345672,'124314245'),(12345672,'837540735'),(48338819,'623687272'),(48338819,'986796874'),(51348948,'625319634'),(51348948,'89668754'),(58376015,'682214123'),(58376015,'712357311'),(58376015,'798372044'),(58478883,'435465413');
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-08 20:36:15

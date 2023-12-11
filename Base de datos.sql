-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: papeleria
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'JGARCIA','password1'),(2,'MLOPEZ','password2'),(3,'CMARTINEZ','password3'),(4,'LGOMEZ','password4'),(5,'APEREZ','password5'),(6,'ADIAZ','password6'),(7,'PRODRIGUEZ','password7'),(8,'SHERNANDEZ','password8'),(9,'DSANCHEZ','password9'),(10,'LFLORES','password10'),(11,'ERICK','Hola'),(18,'RODRIGO','Hola');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historial` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_producto` int DEFAULT NULL,
  `nombre_producto` varchar(50) DEFAULT NULL,
  `cantidad_stock_actual` int DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` VALUES (3,1,'Cuaderno',30,'2023-12-11 10:46:13'),(4,1,'Cuaderno',20,'2023-12-11 10:46:14'),(5,1,'Cuaderno',10,'2023-12-11 10:48:39'),(6,1,'Cuaderno',17,'2023-12-11 10:49:00'),(7,1,'Cuaderno',10,'2023-12-11 10:49:08'),(8,21,'Comida',15,'2023-12-11 10:49:20'),(9,21,'Comida',16,'2023-12-11 10:49:22'),(10,1,'Cuaderno',9,'2023-12-11 11:15:10'),(11,10,'Calculadora básica',34,'2023-12-11 11:15:39'),(12,1,'Cuaderno',29,'2023-12-11 11:16:00'),(13,1,'Cuaderno',28,'2023-12-11 11:55:52'),(14,1,'Cuaderno',26,'2023-12-11 11:56:11'),(15,1,'Cuaderno',25,'2023-12-11 11:58:35'),(16,1,'Cuaderno',24,'2023-12-11 11:58:39'),(17,1,'Cuaderno',19,'2023-12-11 11:59:00');
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio_unitario` decimal(10,2) NOT NULL,
  `cantidad_stock` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Cuaderno',3.50,19),(2,'Bolígrafo Azul',1.00,55),(3,'Bolígrafo Negro',1.00,55),(4,'Lápiz HB',0.50,75),(5,'Goma de borrar',0.75,40),(6,'Regla 30cm',2.00,45),(7,'Carpeta A4',4.00,41),(8,'Pegamento en barra',1.50,41),(9,'Tijeras',3.25,41),(10,'Calculadora básica',8.00,34),(11,'Agenda 2023',6.50,41),(12,'Papel bond A4 (paquete)',5.00,40),(13,'Subrayadores (set)',4.00,50),(14,'Clips metálicos (caja)',2.75,60),(15,'Post-it (pack)',3.25,55),(16,'Grapas (caja)',1.00,70),(17,'Cinta adhesiva',2.25,65),(18,'Rotuladores de colores (set)',6.00,41),(19,'Carpeta de archivador',4.50,41),(20,'Estuche para lápices',3.75,40),(21,'Comida',8.00,16),(22,'Bebida',20.00,15),(23,'Switch',55.00,15);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id_producto` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio_unidad` decimal(10,2) NOT NULL,
  `cantidad` int NOT NULL,
  `precio_total` decimal(10,2) NOT NULL,
  `stock_anterior` int NOT NULL,
  `stock_nuevo` int NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `venta_ibfk_2` (`id_producto`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (10,'Comida',10.50,20,200.10,50,30,'2023-12-11 11:41:56'),(1,'Cuaderno',3.50,1,3.50,29,28,'2023-12-11 11:55:52'),(1,'Cuaderno',3.50,2,7.00,28,26,'2023-12-11 11:56:11'),(1,'Cuaderno',3.50,1,3.50,26,25,'2023-12-11 11:58:35'),(1,'Cuaderno',3.50,1,3.50,25,24,'2023-12-11 11:58:39'),(1,'Cuaderno',3.50,5,17.50,24,19,'2023-12-11 11:59:00'),(2,'Bolígrafo Azul',1.00,5,5.00,60,55,'2023-12-11 11:59:00');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-11  6:10:18

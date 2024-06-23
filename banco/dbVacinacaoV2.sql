-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbvacinacao
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `agendamentovisita`
--

DROP TABLE IF EXISTS `agendamentovisita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamentovisita` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `dataVisita` datetime NOT NULL,
  `situacao` varchar(20) NOT NULL,
  `id_agenteSaude` int DEFAULT NULL,
  `id_paciente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `agendamentovisita_id_agentesaude_foreign` (`id_agenteSaude`),
  KEY `agendamentovisita_id_paciente_foreign` (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamentovisita`
--

LOCK TABLES `agendamentovisita` WRITE;
/*!40000 ALTER TABLE `agendamentovisita` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamentovisita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agentesaude`
--

DROP TABLE IF EXISTS `agentesaude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agentesaude` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `celular` varchar(11) NOT NULL,
  `senha` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `agentesaude_cpf_unique` (`cpf`),
  UNIQUE KEY `agentesaude_celular_unique` (`celular`),
  UNIQUE KEY `agentesaude_senha_unique` (`senha`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agentesaude`
--

LOCK TABLES `agentesaude` WRITE;
/*!40000 ALTER TABLE `agentesaude` DISABLE KEYS */;
INSERT INTO `agentesaude` VALUES (12,'Teste5000','08974125245','41947722141','$2b$08$k/GgHfQyfg.z7VuxrjID7eOQ.B/SdODz5fKh7GltLqJpTCVdl3Mfa'),(13,'Teste5 de Desenvolvimento','08974124245','48947722141','$2b$08$JPA37tx/TH/7hM7iIizrBuS5ZML1S05VkDLggTVrzPO.O/wR0Zt7q'),(15,'Teste5 de Desenvolvimento','85798754325','14725836915','$2b$08$7UDwMIUZl3jCfxaYsqGwTe7p.T1sNjsu5L3tBD7HJZSZZqma4ah/q'),(16,'Teste5 de Desenvolvimento','85798854325','24725836915','$2b$08$Hhw7scVeARzULDFsTUdl0.MbuW/rDKvqDaEWxvb7fBgIJPoU.Cry.');
/*!40000 ALTER TABLE `agentesaude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cep` varchar(8) NOT NULL,
  `logradouro` varchar(50) NOT NULL,
  `numero` varchar(5) NOT NULL,
  `complemento` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'12345678','Avenida Exemplo','123','Apartamento 45','Centro','São Paulo','SP'),(2,'87580250','Maven','404','ap32','Zona III','Umuarama','PR'),(3,'87502450','rua','4578','casa','java','umuarama','parana'),(4,'87502450','rua','4578','casa','java','umuarama','parana');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knex_migrations`
--

DROP TABLE IF EXISTS `knex_migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `knex_migrations` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `batch` int DEFAULT NULL,
  `migration_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knex_migrations`
--

LOCK TABLES `knex_migrations` WRITE;
/*!40000 ALTER TABLE `knex_migrations` DISABLE KEYS */;
INSERT INTO `knex_migrations` VALUES (1,'20240621223350_create_dbVacinacao.js',1,'2024-06-21 23:25:33');
/*!40000 ALTER TABLE `knex_migrations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knex_migrations_lock`
--

DROP TABLE IF EXISTS `knex_migrations_lock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `knex_migrations_lock` (
  `index` int unsigned NOT NULL AUTO_INCREMENT,
  `is_locked` int DEFAULT NULL,
  PRIMARY KEY (`index`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knex_migrations_lock`
--

LOCK TABLES `knex_migrations_lock` WRITE;
/*!40000 ALTER TABLE `knex_migrations_lock` DISABLE KEYS */;
INSERT INTO `knex_migrations_lock` VALUES (1,0);
/*!40000 ALTER TABLE `knex_migrations_lock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_endereco` int unsigned NOT NULL,
  `nome` varchar(100) NOT NULL,
  `dataNascimento` date NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `cns` varchar(15) NOT NULL,
  `celular` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nomeCuidador` varchar(100) DEFAULT NULL,
  `telefoneCuidador` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `paciente_cpf_unique` (`cpf`),
  UNIQUE KEY `paciente_cns_unique` (`cns`),
  UNIQUE KEY `paciente_celular_unique` (`celular`),
  UNIQUE KEY `paciente_email_unique` (`email`),
  KEY `paciente_id_endereco_foreign` (`id_endereco`),
  CONSTRAINT `paciente_id_endereco_foreign` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (3,1,'Daniel teste','2000-08-10','12345678910','12345678912345','12345678910','exemplo@teste.com','testando','40048922987'),(8,1,'danielTeste','2000-08-10','14837940320','963852741258745','98765432148','exemplo2@teste.com','testando','40048922987'),(15,1,'danielteste','2020-10-24','','963852641258747','98778432148','exemplo57@teste.com','testando','40048922987'),(16,1,'Daniel teste','2023-02-02','08916635926','987548632658725','12345678958','exemplo47@teste.com','testando','40048922987'),(17,1,'danielJAVAAAA','2000-01-10','08916635935','123456789102369','21997221511','java@daniel.com',NULL,NULL),(18,2,'javaDaniel','2000-10-08','12345678917','123859745215965','47997221558','daniel@java.com',NULL,NULL),(20,4,'daniel','2000-10-08','12345698724','147852369852145','46997221511','java@java.com',NULL,NULL);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prontuario`
--

DROP TABLE IF EXISTS `prontuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prontuario` (
  `id_vacina` int unsigned NOT NULL,
  `id_agendamentoVisita` int unsigned NOT NULL,
  PRIMARY KEY (`id_vacina`,`id_agendamentoVisita`),
  KEY `prontuario_id_agendamentovisita_foreign` (`id_agendamentoVisita`),
  CONSTRAINT `prontuario_id_agendamentovisita_foreign` FOREIGN KEY (`id_agendamentoVisita`) REFERENCES `agendamentovisita` (`id`),
  CONSTRAINT `prontuario_id_vacina_foreign` FOREIGN KEY (`id_vacina`) REFERENCES `vacina` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prontuario`
--

LOCK TABLES `prontuario` WRITE;
/*!40000 ALTER TABLE `prontuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `prontuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacina`
--

DROP TABLE IF EXISTS `vacina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacina` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nomeVacina` varchar(50) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `vacina_nomevacina_unique` (`nomeVacina`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` VALUES (1,'Covid-19','TesteCovid-19 China');
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-22 23:16:08

-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: soft1
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `admin_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_psw` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES ('A-1','Zhang Yi','123','john.doe@example.com'),('A-2','Li Er','123',NULL),('A-3','Wang San','456','alice.j@example.com'),('A-4','Liu Si','789','bob.w@example.com');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `student_id` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `doctor_id` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `appointment_id` int NOT NULL AUTO_INCREMENT,
  `appointment_time` time NOT NULL,
  `appointment_date` date NOT NULL,
  PRIMARY KEY (`appointment_id`,`doctor_id`,`student_id`) USING BTREE,
  KEY `doctor_id` (`doctor_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES ('S-123456','D-000001',1,'10:00:00','2025-12-15'),('S-234567','D-000002',2,'11:00:00','2025-12-15'),('S-345678','D-000003',3,'13:00:00','2025-12-15'),('S-456789','D-000004',4,'14:00:00','2025-12-15'),('S-567890','D-000005',5,'09:00:00','2025-12-15'),('S-678901','D-000006',6,'08:00:00','2025-12-15'),('S-123121','D-000002',9,'09:00:00','2025-12-15'),('S-123121','D-000001',10,'08:00:00','2025-12-15'),('S-123121','D-000001',11,'14:30:00','2025-12-15'),('S-123121','D-000002',12,'15:30:00','2025-12-15'),('S-123121','D-000004',13,'17:30:00','2025-12-15'),('S-123121','D-000005',14,'09:00:00','2025-12-15'),('S-123121','D-000002',15,'11:00:00','2025-12-15'),('S-123126','D-000006',16,'17:00:00','2025-12-15'),('S-234567','D-000004',17,'15:00:00','2025-12-15'),('S-123125','D-000001',25,'14:30:00','2025-12-15'),('S-123125','D-000002',26,'15:30:00','2025-12-15');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `appointment_show`
--

DROP TABLE IF EXISTS `appointment_show`;
/*!50001 DROP VIEW IF EXISTS `appointment_show`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `appointment_show` AS SELECT 
 1 AS `student_name`,
 1 AS `doctor_name`,
 1 AS `appointment_time`,
 1 AS `appointment_date`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `cases`
--

DROP TABLE IF EXISTS `cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cases` (
  `case_id` int NOT NULL AUTO_INCREMENT,
  `doctor_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `student_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `case_description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Diagnostic_date` date DEFAULT NULL,
  `Diagnostic_time` time DEFAULT NULL,
  `Diagnostic_num` int DEFAULT NULL,
  `Diagnostic_des` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`case_id`) USING BTREE,
  KEY `student_id` (`student_id`) USING BTREE,
  KEY `doctor_id` (`doctor_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1323378 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cases`
--

LOCK TABLES `cases` WRITE;
/*!40000 ALTER TABLE `cases` DISABLE KEYS */;
INSERT INTO `cases` VALUES (1323345,'D-000001','S-123456','Feeling sad or depressed, confused thinking, difficulty concentrating, detachment from reality (delusions), paranoia, or hallucinations.','2025-12-15',NULL,2,'Recurring auditory hallucinations; noticeable loosening or disruption of thought; incoherent speech.'),(1323346,'D-000002','S-234567','Depression.','2025-12-15',NULL,3,'Depressive symptoms.'),(1323347,'D-000003','S-345678','Low mood, slow thinking, cognitive disturbances, low self-evaluation, guilt, hypochondriac thoughts.','2025-12-15','09:10:11',2,'Impaired social functioning, causing distress or negative consequences; symptoms meet criteria and persist for at least two weeks.'),(1323348,'D-000004','S-456789','Loss of interest, lack of pleasure, decreased energy or fatigue, psychomotor retardation or agitation.','2025-12-15','15:44:17',2,'Symptoms meeting diagnostic standards for at least two weeks; may include some schizophrenic features.'),(1323349,'D-000005','S-567890','Depressive episodes characterized by persistent low mood, disproportionate to circumstances, ranging from sadness to severe despair or even stupor.','2025-12-15',NULL,2,'Excluding organic mental disorders or depression caused by psychoactive substances.'),(1323350,'D-000006','S-678901','High energy, reduced need for rest, increased activity, inability to stay calm, frequent changes in plans, impulsive behavior (e.g., spending, irresponsibility, reckless actions).','2025-12-15','12:55:17',1,'Excludes organic mental disorders or substance-induced disorders; comorbidity possible in schizophrenia.'),(1323354,'D-000002','S-123121','here is come description',NULL,NULL,12,'anxious'),(1323355,NULL,NULL,NULL,'2025-12-15',NULL,1,NULL),(1323356,NULL,NULL,NULL,'2025-12-15',NULL,1,NULL),(1323363,'D-000006','S-123126',NULL,'2025-12-15',NULL,1,NULL),(1323364,'D-000004','S-234567','Depression.','2025-12-15',NULL,3,'Depressive symptoms.'),(1323376,'D-000001','S-123125','a description',NULL,NULL,3,'anxious'),(1323377,'D-000002','S-123125','a description',NULL,NULL,3,'anxious');
/*!40000 ALTER TABLE `cases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_and_teacher`
--

DROP TABLE IF EXISTS `class_and_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_and_teacher` (
  `teacher_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `major_class` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`teacher_id`,`major_class`) USING BTREE,
  KEY `major_class` (`major_class`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_and_teacher`
--

LOCK TABLES `class_and_teacher` WRITE;
/*!40000 ALTER TABLE `class_and_teacher` DISABLE KEYS */;
INSERT INTO `class_and_teacher` VALUES ('T-999998','BIO1702'),('T-999997','CHEM1703'),('T-999999','CS1701'),('T-999996','HIS1704'),('T-999994','MATH1706'),('T-999995','PHY1705');
/*!40000 ALTER TABLE `class_and_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `doctor_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `doctor_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `doctor_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `doctor_sex` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` smallint NOT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `department` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `head_of_department` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `img_url` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`doctor_id`) USING BTREE,
  KEY `head_of_department` (`head_of_department`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES ('D-000001','Dr. Wang','1221','Male',35,'Chief Physician','17888888888','Counseling','D-000001',NULL),('D-000002','Dr. Zhang','1222','Female',42,'General Physician','17777777777','Counseling','D-000001',NULL),('D-000003','Dr. Li','1223','Male',38,'Associate Chief Physician','17666666666','Therapy','D-000001',NULL),('D-000004','Dr. Zhao','1223','Female',29,'Chief Physician','17555555555','Therapy','D-000001',NULL),('D-000005','Dr. Chen','1223','Male',44,'Associate Chief Physician','17444444444','Psychiatry','D-000001',NULL),('D-000006','Dr. Liu','1223','Female',37,'General Physician','17333333333','Psychiatry','D-000001',NULL),('D-136767','Kaidas','123','Male',21,'General Physician','123124','Counseling','D-000001',NULL);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_schedules`
--

DROP TABLE IF EXISTS `doctor_schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_schedules` (
  `schedule_id` int NOT NULL AUTO_INCREMENT,
  `schedule_time` time DEFAULT NULL,
  `doctor_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `booking` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `schedule_date` date DEFAULT NULL,
  PRIMARY KEY (`schedule_id`) USING BTREE,
  KEY `doctor_id` (`doctor_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_schedules`
--

LOCK TABLES `doctor_schedules` WRITE;
/*!40000 ALTER TABLE `doctor_schedules` DISABLE KEYS */;
INSERT INTO `doctor_schedules` VALUES (1,'08:00:00','D-000001','1','2025-12-05'),(2,'09:00:00','D-000001',NULL,'2025-12-06'),(3,'10:00:00','D-000002','1','2025-12-05'),(4,'11:00:00','D-000002','1','2025-12-05'),(5,'13:00:00','D-000003',NULL,'2025-12-05'),(6,'14:00:00','D-000003',NULL,'2025-12-05'),(7,'15:00:00','D-000004','1','2025-12-05'),(8,'16:00:00','D-000004',NULL,'2025-12-05'),(9,'09:30:00','D-000005','1','2025-12-05'),(10,'10:30:00','D-000005',NULL,'2025-12-07'),(11,'11:30:00','D-000006','1','2025-12-05'),(12,'12:30:00','D-000006',NULL,'2025-12-05'),(13,'14:30:00','D-000001','1','2025-12-15'),(14,'15:30:00','D-000002','1','2025-12-15'),(15,'16:30:00','D-000003','1','2025-12-15'),(16,'17:30:00','D-000004','1','2025-12-15'),(17,'09:00:00','D-000005','1','2025-12-16'),(18,'10:00:00','D-000006','1','2025-12-16'),(19,'11:00:00','D-000001',NULL,'2025-12-17'),(20,'12:00:00','D-000002',NULL,'2025-12-20'),(21,'14:00:00','D-000003',NULL,'2025-12-15'),(22,'15:00:00','D-000004','1','2025-12-15'),(23,'16:00:00','D-000005','1','2025-12-15'),(24,'17:00:00','D-000006','1','2025-12-16'),(25,'09:30:00','D-000001',NULL,'2025-12-16'),(26,'10:30:00','D-000002','1','2025-12-16'),(27,'11:30:00','D-000003',NULL,'2025-12-17'),(28,'12:30:00','D-000004',NULL,'2025-12-17'),(29,'14:30:00','D-000005',NULL,'2025-12-19'),(30,'15:30:00','D-000006','1','2025-12-19'),(31,'16:30:00','D-000001',NULL,'2025-12-19'),(32,'17:30:00','D-000002',NULL,'2025-12-19'),(33,'09:00:00','D-000003','1','2025-12-20'),(34,'10:00:00','D-000004',NULL,'2025-12-20'),(35,'11:00:00','D-000005',NULL,'2025-12-20'),(36,'12:00:00','D-000006',NULL,'2025-12-20');
/*!40000 ALTER TABLE `doctor_schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `doctor_student_cases`
--

DROP TABLE IF EXISTS `doctor_student_cases`;
/*!50001 DROP VIEW IF EXISTS `doctor_student_cases`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `doctor_student_cases` AS SELECT 
 1 AS `doctor_id`,
 1 AS `student_id`,
 1 AS `doctor_name`,
 1 AS `case_description`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `report` (
  `repo_id` int NOT NULL AUTO_INCREMENT,
  `student_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `teacher_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `doctor_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `diagnose_message` char(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `report_date` date DEFAULT NULL,
  PRIMARY KEY (`repo_id`) USING BTREE,
  KEY `student_id` (`student_id`) USING BTREE,
  KEY `teacher_id` (`teacher_id`) USING BTREE,
  KEY `doctor_id` (`doctor_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (2,'S-234567','T-999998','D-000001','Everything is normal. Rest is recommended.','2025-01-08'),(3,'S-345678','T-999997','D-000004','11111','2025-01-21'),(4,'S-456789','T-999996','D-000002','Mild anxiety. More rest and stress-relief is recommended.','2025-01-02'),(5,'S-567890','T-999995','D-000004','Bipolar disorder. Hospitalization is recommended.','2025-01-11'),(6,'S-678901','T-999994','D-000006','Severe depression. Hospitalization is recommended.','2025-01-07'),(14,'S-123125','T-999999','D-000001','rest',NULL),(15,'S-123125','T-999999','D-000002','rest',NULL);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `student_sex` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `age` smallint NOT NULL,
  `major_class` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone_number` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idcard_num` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  KEY `majorcla` (`major_class`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('S-111111','Xiao Da','1211','Female',18,'SE2102','13608546593','520121200408111111'),('S-112233','Xiao Chen','1222','Female',18,'MATH1706','11111111111','11111111111111111'),('S-123121','Zhang Yi','pwd001','Male',21,'CS1701','13800010011','110105199703071101'),('S-123122','Li Er','pwd002','Female',22,'CS1701','13911120012','110105199703071102'),('S-123123','Wang San','pwd003','Male',20,'CS1701','13822230013','110105199703071103'),('S-123124','Zhao Si','pwd004','Female',19,'CS1701','13733340014','110105199703071104'),('S-123125','Qian Wu','pwd005','Male',20,'CS1701','13644450015','110105199703071105'),('S-123126','Sun Ba','pwd006','Male',21,'CS1701','13555560016','110105199703071106'),('S-123127','Zhou Qi','pwd007','Male',22,'CS1701','13466670017','110105199703071107'),('S-123128','Wu Ba','pwd008','Female',19,'CS1701','13377780018','110105199703071108'),('S-123129','Zheng Jiu','pwd009','Male',20,'CS1701','13288890019','110105199703071109'),('S-123131','Zhao Shiyi','pwd011','Male',22,'CS1701','13100010021','110105199703071111'),('S-123132','Qian Shier','pwd012','Female',19,'CS1701','13011120022','110105199703071112'),('S-123133','Sun Shisan','pwd013','Male',20,'CS1701','13912230023','110105199703071113'),('S-123134','Li Shisi','pwd014','Female',21,'CS1701','13823340024','110105199703071114'),('S-123135','Zhou Shiwu','pwd015','Male',22,'CS1701','13734450025','110105199703071115'),('S-123136','Wu Shiliu','pwd016','Female',19,'CS1701','13645560026','110105199703071116'),('S-123137','Zheng Shiqi','pwd017','Male',20,'CS1701','13556670027','110105199703071117'),('S-123138','Wang Shiba','pwd018','Female',21,'CS1701','13467780028','110105199703071118'),('S-123139','Zhao Shijiu','pwd019','Male',22,'CS1701','13378890029','110105199703071119'),('S-12319','Lian Xuju','12222','Female',19,'SE2102','13608546593','520121200408111110'),('S-123456','Haha','2222','Male',11,'SE2102','111111111','522401200212253333'),('S-123466','Student Test','2222','Male',11,'SE2102','111111111','522401200212253333'),('S-234567','Li Si','1222','Male',21,'BIO1702','13911122334','110105199703071235'),('S-345678','Wang Wu','1223','Male',22,'CHEM1703','13822233445','110105199703071236'),('S-456789','Xiao Hong','1224','Female',19,'HIS1704','13733344556','110105199703071237'),('S-567890','Xiao Ming','1225','Male',20,'PHY1705','13644455667','110105199703071238');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `student_class_teacher`
--

DROP TABLE IF EXISTS `student_class_teacher`;
/*!50001 DROP VIEW IF EXISTS `student_class_teacher`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `student_class_teacher` AS SELECT 
 1 AS `student_id`,
 1 AS `major_class`,
 1 AS `teacher_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teacher_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `teacher_name` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `passwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('T-999994','GAO','15522118822','1111'),('T-999995','XIE','15522117722','1111'),('T-999996','HU','15522116622','1111'),('T-999997','HE','15522115522','1111'),('T-999998','LIU','15522114422','1111'),('T-999999','HAN','15522113322','1111');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `teacher_plus_class`
--

DROP TABLE IF EXISTS `teacher_plus_class`;
/*!50001 DROP VIEW IF EXISTS `teacher_plus_class`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `teacher_plus_class` AS SELECT 
 1 AS `teacher_id`,
 1 AS `teacher_name`,
 1 AS `phone`,
 1 AS `passwd`,
 1 AS `major_class`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `teacher_student`
--

DROP TABLE IF EXISTS `teacher_student`;
/*!50001 DROP VIEW IF EXISTS `teacher_student`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `teacher_student` AS SELECT 
 1 AS `teacher_id`,
 1 AS `teacher_name`,
 1 AS `phone`,
 1 AS `student_id`,
 1 AS `student_name`,
 1 AS `phone_number`,
 1 AS `student_sex`,
 1 AS `age`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `appointment_show`
--

/*!50001 DROP VIEW IF EXISTS `appointment_show`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `appointment_show` AS select `student`.`student_name` AS `student_name`,`doctor`.`doctor_name` AS `doctor_name`,`appointment`.`appointment_time` AS `appointment_time`,`appointment`.`appointment_date` AS `appointment_date` from ((`appointment` join `student`) join `doctor`) where ((`appointment`.`doctor_id` = `doctor`.`doctor_id`) and (`appointment`.`student_id` = `student`.`student_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `doctor_student_cases`
--

/*!50001 DROP VIEW IF EXISTS `doctor_student_cases`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `doctor_student_cases` AS select `doctor`.`doctor_id` AS `doctor_id`,`cases`.`student_id` AS `student_id`,`doctor`.`doctor_name` AS `doctor_name`,`cases`.`case_description` AS `case_description` from (`doctor` join `cases`) where (`doctor`.`doctor_id` = `cases`.`doctor_id`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `student_class_teacher`
--

/*!50001 DROP VIEW IF EXISTS `student_class_teacher`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `student_class_teacher` AS select `s`.`student_id` AS `student_id`,`s`.`major_class` AS `major_class`,`ct`.`teacher_id` AS `teacher_id` from (`student` `s` join `class_and_teacher` `ct` on((`s`.`major_class` = `ct`.`major_class`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `teacher_plus_class`
--

/*!50001 DROP VIEW IF EXISTS `teacher_plus_class`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `teacher_plus_class` AS select `t`.`teacher_id` AS `teacher_id`,`t`.`teacher_name` AS `teacher_name`,`t`.`phone` AS `phone`,`t`.`passwd` AS `passwd`,`ct`.`major_class` AS `major_class` from (`teacher` `t` join `class_and_teacher` `ct` on((`t`.`teacher_id` = `ct`.`teacher_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `teacher_student`
--

/*!50001 DROP VIEW IF EXISTS `teacher_student`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `teacher_student` AS select `t`.`teacher_id` AS `teacher_id`,`t`.`teacher_name` AS `teacher_name`,`t`.`phone` AS `phone`,`s`.`student_id` AS `student_id`,`s`.`student_name` AS `student_name`,`s`.`phone_number` AS `phone_number`,`s`.`student_sex` AS `student_sex`,`s`.`age` AS `age` from ((`teacher` `t` join `class_and_teacher` `ct` on((`t`.`teacher_id` = `ct`.`teacher_id`))) join `student` `s` on((`ct`.`major_class` = `s`.`major_class`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-06  1:39:22

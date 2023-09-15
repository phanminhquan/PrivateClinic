-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: privateclinic
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `benh_nhan`
--

DROP TABLE IF EXISTS `benh_nhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benh_nhan` (
  `maBN` bigint NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `dienThoai` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `gioiTinh` tinyint(1) NOT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `avatar` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `maTK` bigint DEFAULT NULL,
  PRIMARY KEY (`maBN`),
  KEY `maTK` (`maTK`),
  CONSTRAINT `benh_nhan_ibfk_1` FOREIGN KEY (`maTK`) REFERENCES `tai_khoan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benh_nhan`
--

LOCK TABLES `benh_nhan` WRITE;
/*!40000 ALTER TABLE `benh_nhan` DISABLE KEYS */;
INSERT INTO `benh_nhan` VALUES (35,'Phan minh quân','0123343534','pmquan176@gmail.com','2002-08-16',1,'29 cong hoa tp hcm','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693295964/qwyxwekzuyquoe9s5zdp.png',66),(36,'Nguyen Minh Nhat','0123456789','nhat1@gmail.com','2002-08-19',1,'go vap tpHCM','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693296405/ycdsjtr78ikozgvfzcka.png',66),(37,'nguyen thanh nhan','0122234345','nhan211@gmail.com','2011-06-14',1,'cu chi thanh pho ho chi minh','https://res.cloudinary.com/dexbjwfjg/image/upload/v1694348463/awqkdj194wwku5mdyjdd.png',68),(38,'abvc','0788363322','thanh.dh@ou.edu.vn','2023-09-22',1,'aasa','https://res.cloudinary.com/dexbjwfjg/image/upload/v1694394268/w6fcmkni97dw9em2igow.png',69);
/*!40000 ALTER TABLE `benh_nhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ca_truc`
--

DROP TABLE IF EXISTS `ca_truc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ca_truc` (
  `maCT` int NOT NULL AUTO_INCREMENT,
  `gioTruc` time DEFAULT NULL,
  `gioKetThuc` time DEFAULT NULL,
  PRIMARY KEY (`maCT`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ca_truc`
--

LOCK TABLES `ca_truc` WRITE;
/*!40000 ALTER TABLE `ca_truc` DISABLE KEYS */;
INSERT INTO `ca_truc` VALUES (1,'07:00:00','09:30:00'),(2,'09:30:00','11:00:00'),(3,'11:00:00','13:30:00'),(4,'13:30:00','16:00:00');
/*!40000 ALTER TABLE `ca_truc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ca_truc_trong_tuan`
--

DROP TABLE IF EXISTS `ca_truc_trong_tuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ca_truc_trong_tuan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_ca_truc` int DEFAULT NULL,
  `id_ngay` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_ngay` (`id_ngay`),
  KEY `id_ca_truc` (`id_ca_truc`),
  CONSTRAINT `ca_truc_trong_tuan_ibfk_1` FOREIGN KEY (`id_ngay`) REFERENCES `date_of_week` (`id`),
  CONSTRAINT `ca_truc_trong_tuan_ibfk_2` FOREIGN KEY (`id_ca_truc`) REFERENCES `ca_truc` (`maCT`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ca_truc_trong_tuan`
--

LOCK TABLES `ca_truc_trong_tuan` WRITE;
/*!40000 ALTER TABLE `ca_truc_trong_tuan` DISABLE KEYS */;
INSERT INTO `ca_truc_trong_tuan` VALUES (1,1,1),(6,2,1),(7,3,1),(8,1,2),(9,2,2),(11,4,2),(12,2,3),(13,3,3),(14,2,4),(16,4,4);
/*!40000 ALTER TABLE `ca_truc_trong_tuan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ct_ds_kham`
--

DROP TABLE IF EXISTS `ct_ds_kham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ct_ds_kham` (
  `maCTDS` bigint NOT NULL AUTO_INCREMENT,
  `maBN` bigint NOT NULL,
  `maTG` bigint NOT NULL,
  `trangthai` tinyint DEFAULT NULL,
  `ngaykham` date NOT NULL,
  PRIMARY KEY (`maCTDS`),
  KEY `maBN` (`maBN`),
  KEY `maTG` (`maTG`),
  CONSTRAINT `ct_ds_kham_ibfk_1` FOREIGN KEY (`maBN`) REFERENCES `benh_nhan` (`maBN`),
  CONSTRAINT `ct_ds_kham_ibfk_3` FOREIGN KEY (`maTG`) REFERENCES `thoi_gian` (`maTG`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ct_ds_kham`
--

LOCK TABLES `ct_ds_kham` WRITE;
/*!40000 ALTER TABLE `ct_ds_kham` DISABLE KEYS */;
INSERT INTO `ct_ds_kham` VALUES (10,35,22,2,'2023-08-29'),(11,36,22,3,'2023-09-01'),(12,37,23,2,'2023-09-10'),(13,38,22,2,'2023-09-11');
/*!40000 ALTER TABLE `ct_ds_kham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_of_week`
--

DROP TABLE IF EXISTS `date_of_week`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_of_week` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_of_week` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_of_week`
--

LOCK TABLES `date_of_week` WRITE;
/*!40000 ALTER TABLE `date_of_week` DISABLE KEYS */;
INSERT INTO `date_of_week` VALUES (1,'Thứ hai'),(2,'Thứ ba'),(3,'Thứ tư'),(4,'Thứ năm'),(5,'Thứ sáu'),(6,'Thứ bảy'),(7,'Chủ nhật');
/*!40000 ALTER TABLE `date_of_week` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoa_don`
--

DROP TABLE IF EXISTS `hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoa_don` (
  `maHD` bigint NOT NULL AUTO_INCREMENT,
  `tienThuoc` float NOT NULL,
  `tienKham` float NOT NULL,
  `tongTien` float NOT NULL,
  `created_date` datetime NOT NULL,
  `maPK` bigint NOT NULL,
  PRIMARY KEY (`maHD`),
  UNIQUE KEY `maPK` (`maPK`),
  CONSTRAINT `hoa_don_ibfk_1` FOREIGN KEY (`maPK`) REFERENCES `phieu_kham` (`maPK`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoa_don`
--

LOCK TABLES `hoa_don` WRITE;
/*!40000 ALTER TABLE `hoa_don` DISABLE KEYS */;
INSERT INTO `hoa_don` VALUES (7,210000,100000,310000,'2023-01-01 00:00:00',325),(8,430000,100000,530000,'2023-02-06 00:00:00',326),(9,210000,100000,310000,'2023-03-06 00:00:00',327),(10,30000,100000,130000,'2023-04-06 00:00:00',328),(11,185000,100000,285000,'2023-05-06 00:00:00',329),(12,155000,100000,255000,'2023-06-06 00:00:00',330),(13,155000,100000,255000,'2023-07-06 00:00:00',331),(14,55000,100000,155000,'2023-08-06 00:00:00',332),(15,155000,100000,255000,'2023-09-06 00:00:00',333),(16,310000,100000,410000,'2023-10-06 00:00:00',334),(17,55000,100000,155000,'2023-11-06 00:00:00',335),(18,400000,100000,500000,'2023-12-06 00:00:00',336),(19,400000,100000,500000,'2022-09-06 00:00:00',346),(20,555000,100000,655000,'2023-09-10 00:00:00',347),(21,210000,100000,310000,'2023-09-11 00:00:00',348);
/*!40000 ALTER TABLE `hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `maNV` bigint NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `diaChi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `dienThoai` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhAnh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `IdUser` bigint DEFAULT NULL,
  PRIMARY KEY (`maNV`),
  UNIQUE KEY `email` (`email`),
  KEY `IdUser` (`IdUser`),
  CONSTRAINT `nhan_vien_ibfk_1` FOREIGN KEY (`IdUser`) REFERENCES `user_role` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (5,'quan','admin@gmail.com','2002-07-16','119 trần dần Thành Phố Hồ Chí Minh','0882223552','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693293518/v3tx9c08h5teocyw1ouo.png',NULL),(34,'Phan Minh Quan','quan@gmail.com','2023-08-29','1/7 Bà Điểm Hóc Môn','0788363329','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693293362/remqmbpxkly3xsj1ixfx.png',1),(35,'Nguyen Minh Nhat','Nhat@gmail.com','2023-08-29','23 Nguyễn Thái Sơn Hồ Chí Minh','0123456778','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693293811/deaua7vslj3wpilcypxw.png',1),(36,'Nguyen Thanh Nhan','Nhan@gmail.com','2022-08-05','Củ Chi Thành Phố Hồ Chí Minh','0555364543','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693293889/golusekhctddagxc7fxj.png',1),(37,'Nguyen Thi Hong Nhung','nhung@gmail.com','2000-08-16','26 Từ Liêm Hà Nội','0664545454','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693294122/tbj8v3jdagqzwcakpef8.png',2),(38,'Le Thi Nho','nga@gmail.com','1999-08-03','66 Hoa Hồng Đà Nẵng','0442746747','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693294189/lthro7phvmcoq3vfiv9l.png',2),(39,'Bui Thu Phuong','phuong@gmail.com','2001-08-12','bắc á Thành Phố Quảng Nam','0667467663','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693294334/n5bbtavusdtdjuygqbcq.png',2),(40,'abc','abc@gmail.com','2023-09-03','qdaas','0123333333','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693749466/szai9eqmggaskjxy4kyl.jpg',1);
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien_catruc`
--

DROP TABLE IF EXISTS `nhanvien_catruc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien_catruc` (
  `maNV_CT` int NOT NULL AUTO_INCREMENT,
  `id_CT` int DEFAULT NULL,
  `id_NV` bigint DEFAULT NULL,
  PRIMARY KEY (`maNV_CT`),
  KEY `id_NV` (`id_NV`),
  KEY `id_CT` (`id_CT`),
  CONSTRAINT `nhanvien_catruc_ibfk_2` FOREIGN KEY (`id_NV`) REFERENCES `nhan_vien` (`maNV`),
  CONSTRAINT `nhanvien_catruc_ibfk_3` FOREIGN KEY (`id_CT`) REFERENCES `ca_truc_trong_tuan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien_catruc`
--

LOCK TABLES `nhanvien_catruc` WRITE;
/*!40000 ALTER TABLE `nhanvien_catruc` DISABLE KEYS */;
INSERT INTO `nhanvien_catruc` VALUES (6,1,34),(7,1,35),(8,1,36),(9,1,38),(10,1,39),(11,6,34),(12,6,38),(16,9,38),(18,14,35),(19,16,36);
/*!40000 ALTER TABLE `nhanvien_catruc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_kham`
--

DROP TABLE IF EXISTS `phieu_kham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_kham` (
  `maPK` bigint NOT NULL AUTO_INCREMENT,
  `ngayKham` date DEFAULT NULL,
  `trieuChung` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `chuanDoan` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
  `maBN` bigint DEFAULT NULL,
  `xacnhan` tinyint DEFAULT NULL,
  `maBS` bigint DEFAULT NULL,
  PRIMARY KEY (`maPK`),
  KEY `maBN` (`maBN`),
  KEY `maBS` (`maBS`),
  CONSTRAINT `phieu_kham_ibfk_1` FOREIGN KEY (`maBN`) REFERENCES `benh_nhan` (`maBN`),
  CONSTRAINT `phieu_kham_ibfk_2` FOREIGN KEY (`maBS`) REFERENCES `nhan_vien` (`maNV`)
) ENGINE=InnoDB AUTO_INCREMENT=349 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_kham`
--

LOCK TABLES `phieu_kham` WRITE;
/*!40000 ALTER TABLE `phieu_kham` DISABLE KEYS */;
INSERT INTO `phieu_kham` VALUES (325,'2023-01-01','Nhuc dau, dau lung','viem khop cap tinh',35,1,35),(326,'2023-02-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(327,'2023-03-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(328,'2023-04-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(329,'2023-05-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(330,'2023-06-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(331,'2023-07-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(332,'2023-08-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(333,'2023-09-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(334,'2023-10-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(335,'2023-11-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(336,'2023-12-06','Sot, so mui, huc dau','Sot sieu vi',36,1,34),(346,'2022-09-06','dau dau, moi goi','viem khop cap tinh',36,1,34),(347,'2023-09-10','dau dau, moi goi','viem khop cap tinh',37,1,34),(348,'2023-09-11','ho, sổ mũi','covid',38,1,34);
/*!40000 ALTER TABLE `phieu_kham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieu_thuoc`
--

DROP TABLE IF EXISTS `phieu_thuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieu_thuoc` (
  `maPK_Thuoc` bigint NOT NULL AUTO_INCREMENT,
  `soLuong` int DEFAULT NULL,
  `cachDung` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `maThuoc` bigint NOT NULL,
  `maPK` bigint NOT NULL,
  PRIMARY KEY (`maPK_Thuoc`),
  KEY `maThuoc` (`maThuoc`),
  KEY `maPK` (`maPK`),
  CONSTRAINT `phieu_thuoc_ibfk_1` FOREIGN KEY (`maThuoc`) REFERENCES `thuoc` (`maThuoc`) ON DELETE CASCADE,
  CONSTRAINT `phieu_thuoc_ibfk_2` FOREIGN KEY (`maPK`) REFERENCES `phieu_kham` (`maPK`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieu_thuoc`
--

LOCK TABLES `phieu_thuoc` WRITE;
/*!40000 ALTER TABLE `phieu_thuoc` DISABLE KEYS */;
INSERT INTO `phieu_thuoc` VALUES (40,1,'dung sau khi an',31,325),(41,2,'dung truoc khi di ngu',32,325),(42,1,'ngay uong hai lan sang va toi',33,326),(43,1,'uong truoc khi ngu',34,326),(44,1,'uong sau khi an',31,327),(45,1,'uong sau khi an no',32,327),(46,2,'uong sau khi ngu day',34,328),(47,1,'ngay uong mot lan vao buoi sang',34,329),(48,1,'ngay uong mot lan ',32,329),(49,1,'uong truoc khi an no',32,330),(50,1,'dung truoc khi di ngu',32,331),(51,1,'thuoc tri chan thuong, ngay uong hai lan',31,332),(52,1,'uong truoc khi ngu',32,333),(53,1,'uong truoc khi ngu',32,334),(54,1,'uong truoc khi ngu',32,334),(55,1,'dung truoc khi di ngu',31,335),(56,1,'dung truoc khi di ngu',33,336),(57,1,'dung truoc khi di ngu',33,346),(58,1,'uong truoc khi ngu',32,347),(59,1,'uong truoc khi ngu sau khi an',33,347),(60,1,'uong truoc khi ngu',32,348),(61,1,'uong truoc khi ngu',31,348);
/*!40000 ALTER TABLE `phieu_thuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `avatar` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  `user_role` enum('ADMIN','NURSE','DOCTOR','STAFF') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `maNV` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `maNV` (`maNV`),
  CONSTRAINT `tai_khoan_ibfk_1` FOREIGN KEY (`maNV`) REFERENCES `nhan_vien` (`maNV`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (5,'admin','admin','$2a$12$LK/ATXOJ6OTgmP34/Jfa5OyQtj8MDdpf2KiiPqBukAsejXRmI6uNy','abc',1,'ADMIN',5),(59,'Phan Minh Quan','quan','$2a$10$6j.HjxMtLNILnw3rF0cq9eWMnDkzrRtzk2enOZIqy/ZKfdAdj4/se','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693293945/vhr9znusdmohnbm2bxwk.png',1,'DOCTOR',34),(60,'Nguyen Minh Nhat','nhat','$2a$10$8YpCa9kgdMm0BcJDrzYC0uD1z6X4ITPYYEYKxrZj6Llhpg2VFyuOG','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693293994/a0b6owqsyxr33njol8em.png',1,'DOCTOR',35),(61,'Nguyen Thanh Nhan','nhan','$2a$10$OfTkWFZkgh9BvHHAccQ.yexJrufJLZNxtD8LKxSllgP4YGLP6PPJu','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693294028/iqt8gaa7nemnknefjign.png',1,'DOCTOR',36),(62,'Nguyen thi Hong Nhung','nhung','$2a$10$2y.OZZFDcyl7K1DSpL4UZuOlm54fLFX6olzy90/ZVd2jtp73APuEK','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693294442/zwsjkwar9nch9wybtq9l.png',1,'NURSE',37),(63,'Le thi Nga','nga','$2a$10$c2Fl55QjFNFFNn4lGTS9E.aqkAyCQeLJyddNhCFpQF9s3ZNeucT7C','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693294488/nxeyk8obdvr0rakfsddw.png',1,'NURSE',38),(64,'Bui Thu Phuong','phuong','$2a$10$Y2uhEHEEqIMqpUIwNZHDlOZbxub9Oe6Coj5lW/gKPIpxpaUWFUmTS','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693294527/s3gim5mhexlmpgoklrcx.png',1,'NURSE',39),(65,'quan phan','pmquan176@gmail.com','$2a$10$vWFntQ.HFQBfXgrH/jWXEuBY6P4cQUEaj2DLgIEAH7K54jmVlje52','https://lh3.googleusercontent.com/a/AAcHTtcWHu6BznEIm84hgC4N8f067jdHkYya80EK-jPTwgBBgQ=s96-c',1,'STAFF',NULL),(66,'user','user','$2a$10$puFsWJmpB1YpCoUJP4Bpm.0QQURjM9dbFJ9CqOY2eDtiRJWJdhBie','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693295785/rhhgzne5bjdimphrlbub.png',1,'STAFF',NULL),(68,'nguyen thanh nhan','nhan123','$2a$10$mM5gV1bGdwR5PT8rZsbPyOdVtu0AkZaMK4sFDnQG4nOjhKdVxplxi','https://res.cloudinary.com/dexbjwfjg/image/upload/v1694348335/jfcepbtisfvtd46beptb.png',1,'STAFF',NULL),(69,'abc','thanh','$2a$10$4qUX7vhop75hmAkkdxzYheG/kIQR2UzDN.wG7/m4nO5nmRzE2effC','https://res.cloudinary.com/dexbjwfjg/image/upload/v1694394185/fzgn6mndiwiy3llbtzn1.png',1,'STAFF',NULL);
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thoi_gian`
--

DROP TABLE IF EXISTS `thoi_gian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thoi_gian` (
  `maTG` bigint NOT NULL AUTO_INCREMENT,
  `gio` time NOT NULL,
  PRIMARY KEY (`maTG`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thoi_gian`
--

LOCK TABLES `thoi_gian` WRITE;
/*!40000 ALTER TABLE `thoi_gian` DISABLE KEYS */;
INSERT INTO `thoi_gian` VALUES (22,'08:00:00'),(23,'13:00:00');
/*!40000 ALTER TABLE `thoi_gian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thuoc`
--

DROP TABLE IF EXISTS `thuoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thuoc` (
  `maThuoc` bigint NOT NULL AUTO_INCREMENT,
  `tenThuoc` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `moTa` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `soLuong` int NOT NULL,
  `giaBan` float NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `donVi` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `hinhAnh` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`maThuoc`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thuoc`
--

LOCK TABLES `thuoc` WRITE;
/*!40000 ALTER TABLE `thuoc` DISABLE KEYS */;
INSERT INTO `thuoc` VALUES (31,'Deecogen','Ultracet là thuốc giảm đau chứa Paracetamol và Tramadol',40,55000,1,'18mg','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693294910/c3b3e0udfyqcjxnd7fn1.png'),(32,'Hapacol','Hapacol trị đau nhức',40,155000,1,'120mg','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693295002/mzbvookerti39oqehzth.png'),(33,'Tam Binh Viem Khop','Trị viêm khớp nhức mỏi',30,400000,1,'60 tablets','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693295137/zltd0uds0bxpfmktswcp.png'),(34,'Utracet','Utraceet trị sốt nhẹ, sốt nặngg',100,30000,1,'37mg-paracitamol hcl','https://res.cloudinary.com/dexbjwfjg/image/upload/v1693295240/yjj0vntmeei2mogkapbh.png');
/*!40000 ALTER TABLE `thuoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `Id` bigint NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'Bác sĩ'),(2,'Y tá');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-15 12:51:44

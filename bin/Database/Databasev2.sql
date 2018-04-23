CREATE DATABASE  IF NOT EXISTS `internation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `internation`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: internation
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `video_id` int(11) DEFAULT NULL,
  `sub_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Review_Video_idx` (`video_id`),
  KEY `FK_Review_Sub_idx` (`sub_id`),
  CONSTRAINT `FK_Review_Sub` FOREIGN KEY (`sub_id`) REFERENCES `sub` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Review_Video` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub`
--

DROP TABLE IF EXISTS `sub`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `content_internation` text,
  `time` time DEFAULT NULL,
  `video_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Sub_Video_idx` (`video_id`),
  CONSTRAINT `FK_Sub_Video` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub`
--

LOCK TABLES `sub` WRITE;
/*!40000 ALTER TABLE `sub` DISABLE KEYS */;
INSERT INTO `sub` VALUES (1,'welcome to English class 101 coms English in three minutes ',NULL,'00:07:00',1),(2,'the fastest easiest and most fun way to learn English',NULL,'00:13:00',1),(3,'hi how\'s it going',NULL,'00:18:00',1),(4,'I\'m Alicia nice to meet you ',NULL,'00:20:00',1),(5,'in this series we\'re going to learn some easy ways to ask and answer common questions in English ',NULL,'00:00:23',1),(6,' it\'s really useful and it only takes three minutes in this lesson ',NULL,'00:31:00',1),(7,'you\'re going to learn new more common ways to ask and answer the question how are you in English ',NULL,'00:36:00',1),(8,'you\'ve probably learned how are you and I\'m fine in textbooks before ',NULL,'00:44:00',1),(9,'but in the United States people will usually ask this question and answer it in a different way',NULL,'00:51:00',1),(10,'first let\'s review if someone says ',NULL,'00:58:00',1),(11,'how are you',NULL,'01:02:00',1),(12,'you can say ',NULL,'01:03:00',1),(13,'I\'m fine',NULL,'01:04:00',1),(14,'I\'m fine',NULL,'01:06:00',1),(15,'here are some other ways to answer',NULL,'01:07:00',1),(16,'pretty good  this means about the same thing as I\'m fine',NULL,'01:10:00',1),(17,'pretty good ',NULL,'01:16:00',1),(18,'we also have not bad',NULL,'01:18:00',1),(19,' you can use this if you are feeling just okay or so-so',NULL,'01:22:00',1),(20,'Not bad',NULL,'01:27:00',1),(21,' let\'s look at our question again how are you',NULL,'01:28:00',1),(22,'this is the most well known way of asking how someone is',NULL,'01:31:00',1),(23,'you could use it when you want to be polite ',NULL,'01:36:00',1),(24,'but now let\'s look at some different ways to ask how someone is ',NULL,'01:40:00',1),(25,'these ways are more casual and much more common',NULL,'01:45:00',1),(26,'first hey how\'s it going',NULL,'01:49:00',1),(27,'hey how\'s it going',NULL,'01:52:00',1),(28,'you can answer this in many ways ',NULL,'01:55:00',1),(29,' if you\'re feeling good you can say ',NULL,'01:58:00',1),(30,'Good',NULL,'02:01:00',1),(31,'Good',NULL,'02:02:00',1),(32,'pretty good ',NULL,'02:04:00',1),(33,'pretty good',NULL,'02:05:00',1),(34,'not bad',NULL,'02:06:00',1),(35,'not bad',NULL,'02:07:00',1),(36,'once more ',NULL,'02:10:00',1),(37,'good pretty good not bad',NULL,'02:12:00',1),(38,'here\'s a tip',NULL,'02:15:00',1),(39,'even though these answers mean the same thing as I\'m fine',NULL,'02:17:00',1),(40,'you can\'t answer how\'s it going with I\'m fine ',NULL,'02:22:00',1),(41,'it will sound a bit strange ',NULL,'02:26:00',1),(42,' if you\'re not feeling good you can say',NULL,'02:27:00',1),(43,'not so good',NULL,'02:31:00',1),(44,'not so good',NULL,'02:34:00',1),(45,'good not great',NULL,'02:36:00',1),(46,'good not great',NULL,'02:38:00',1),(47,'or not so well',NULL,'02:40:00',1),(48,'or not so well',NULL,'02:43:00',1),(49,'be careful if you say one of these the other person will usually ask ',NULL,'02:44:00',1),(50,'why what\'s wrong to be polite then you will have  explain',NULL,'02:50:00',1),(51,'another casual but very common version of how are you is what\'s up ',NULL,'02:55:00',1),(52,'what\'s up',NULL,'03:02:00',1),(53,'to  reply use a cheerful voice as you say',NULL,'03:04:00',1),(54,'Not much',NULL,'03:07:00',1),(55,'Not much',NULL,'03:09:00',1),(56,'or nothing much',NULL,'03:10:00',1),(57,'nothing much',NULL,'03:11:00',1),(58,'this means you\'re free and able to chat ',NULL,'03:13:00',1),(59,'since what\'s up is just another way of saying hello you can also reply ',NULL,'03:18:00',1),(60,'hey',NULL,'03:24:00',1),(61,'or Hi',NULL,'03:25:00',1),(62,'now it\'s time for Alicia\'s advice',NULL,'03:26:00',1),(63,'a lot of the time when we ask questions that mean how are you in English ',NULL,'03:30:00',1),(64,'we\'re not actually asking about the other person\'s health ',NULL,'03:34:00',1),(65,'we\'re only asking to be polite',NULL,'03:39:00',1),(66,'you should think of these questions as another way of saying hello',NULL,'03:41:00',1),(67,'a way for the conversation to get started instead of actual literal ',NULL,'03:45:00',1),(68,'in fact when someone asks you what\'s up you don\'t even have to answer',NULL,'03:52:00',1),(69,'just say what\'s up in reply ',NULL,'03:57:00',1),(70,'do you knowthe difference between what do you do and what are you doing ',NULL,'04:01:00',1),(71,'it\'s a little tricky but we\'ll explain it simply in the next English in three minutes lesson',NULL,'04:07:00',1),(72,'see you next time',NULL,'04:13:00',1),(73,'Welcome to EnglishClass101.comâs âEnglish in Three Minutesâ. The fastest, easiest,and most fun way to learn English.',NULL,'00:08:00',2),(74,'Hey everyone, Iâm Alisha!',NULL,'00:17:00',2),(75,'In this series, weâre going to learn some easy ways to ask and answer common questions in English. ',NULL,'00:20:00',2),(76,'Itâs really useful, and it only takes three minutes!',NULL,'00:27:00',2),(77,'In this lesson, youâre going to learn how to ask what someoneâs job is in natural English.',NULL,'00:30:00',2),(78,'Of course, you *can* just say, âWhat is your job?â ',NULL,'00:37:00',2),(79,'This is correct English, but it sounds too direct and awkward. ',NULL,'00:41:00',2),(80,'Native English speakers almost never say this in a social situation.',NULL,'00:46:00',2),(81,'Instead, they use a different question.',NULL,'00:50:00',2),(82,'But before we master that, we need to compare it to a very similar question.',NULL,'00:53:00',2),(83,'âWhat are you doing?â',NULL,'00:58:00',2),(84,'âIâm presenting a video about English!â',NULL,'01:00:00',2),(85,'âWhat do you do?â',NULL,'01:04:00',2),(86,'âIâm an English teacher!â',NULL,'01:06:00',2),(87,'Do you see the difference?',NULL,'01:08:00',2),(88,'These two questions - âWhat are you doing?â and âWhat do you do?â sound similar, but',NULL,'01:10:00',2),(89,'The first one is asking what you are doing right now, this minute',NULL,'01:19:00',2),(90,'You answer it using an -ing verb.',NULL,'01:24:00',2),(91,'âWhat are you doing?â',NULL,'01:26:00',2),(92,'âIâm reading!â',NULL,'01:28:00',2),(93,'âIâm watching TV!â',NULL,'01:29:00',2),(94,'While the second is actually a shortened version of âWhat do you do for a living?â.',NULL,'01:32:00',2),(95,'This is how we ask âWhat is your job?â in natural English.',NULL,'01:38:00',2),(96,'Letâs practice this question.',NULL,'01:42:00',2),(97,'âWhat do you do?â',NULL,'01:44:00',2),(98,'âWhat do you do?â',NULL,'01:45:00',2),(99,'When native speakers of English ask this question, it can come out very fast, and sound more',NULL,'01:48:00',2),(100,'In order to tell it apart from âwhat are you doing?â, just listen for the âingâsound on the end of the question ',NULL,'01:56:00',2),(101,'if itâs not there, then youâre being asked what your job is!',NULL,'02:03:00',2),(102,'So how would you answer this question?',NULL,'02:08:00',2),(103,'Just think of it as if the other person is asking you âWhat is your job?â',NULL,'02:11:00',2),(104,'You could answer with âI amâ, plus your job.',NULL,'02:16:00',2),(105,'âIâm a teacher.â ',NULL,'02:20:00',2),(106,'âIâm a teacher.â ',NULL,'02:21:00',2),(107,'or,âIâm an engineer.â',NULL,'02:23:00',2),(108,'If you want to learn more job names, go to EnglishClass101.com and check out the Core Word Lists. ',NULL,'02:26:00',2),(109,'These cover job vocabulary and more, and include a picture and audio to help you perfect your pronunciation.',NULL,'02:34:00',2),(110,'You can also mention the place that you work at, starting with âI work atâ.',NULL,'02:42:00',2),(111,'I work at a hospital.',NULL,'02:48:00',2),(112,'I work at a hospital.',NULL,'02:49:00',2),(113,'I work at a law firm.',NULL,'02:53:00',2),(114,'I work at a law firm.',NULL,'02:55:00',2),(115,'If you work for a big company that is well-known, you can say âI work forâ, and then the name:',NULL,'02:58:00',2),(116,'âI work for Microsoft.â',NULL,'03:05:00',2),(117,'âI work for Microsoft.â',NULL,'03:07:00',2),(118,'I work for The New York Times.',NULL,'03:10:00',2),(119,'I work for The New York Times.',NULL,'03:12:00',2),(120,'Now itâs time for Alishaâs Advice!',NULL,'03:16:00',2),(121,'When you ask the question âWhat do you do?â and the other person tells you their job,itâs polite to make some kind of positive comment about his or her job ',NULL,'03:19:00',2),(122,'for example,âHow interesting!â or âThat must be excitingâ or even âOh, really!â',NULL,'03:30:00',2),(123,'Remember to sound sincere!',NULL,'03:37:00',2),(124,'Do you know how native English speakers ask each other what their hobbies are? ',NULL,'03:40:00',2),(125,'Hint: we donât use the word âhobbiesâ!',NULL,'03:45:00',2),(126,'Find out next time in the third English in 3 Minutes Lesson! ',NULL,'03:49:00',2),(127,'See you next time!',NULL,'03:53:00',2);
/*!40000 ALTER TABLE `sub` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `videoname` text,
  `content` text,
  `timepause` time DEFAULT NULL,
  `image` text,
  `link` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'Learn English - Greetings in English','Learn English - Greetings in English, how to Answer the Question \"How are you?\"',NULL,'Images/1.png','https://www.youtube.com/watch?https://www.youtube.com/watch?v=dmOKZLeFKCM&list=PL4C632FCF5FCB9C21'),(2,'Learn English - Asking About Occupations, What is your Job?','Learn English - Asking About Occupations, What is your Job?',NULL,'Images/2.png','https://www.youtube.com/watch?v=GnQ2iCIpOmE&list=PL4C632FCF5FCB9C21&index=2'),(3,'Learn English - Asking About Hobbies, What do you do for fun?','Learn English - Asking About Hobbies, What do you do for fun?',NULL,'Images/3.png','https://www.youtube.com/watch?v=nMFrC3UGtek&index=3&list=PL4C632FCF5FCB9C21'),(4,'Learn English - Asking \'Where are you from?\'','Learn English - Asking \'Where are you from?\'',NULL,'Images/4.png','https://www.youtube.com/watch?v=gE9XU5YE9Dk&index=4&list=PL4C632FCF5FCB9C21');
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'internation'
--

--
-- Dumping routines for database 'internation'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-18 20:46:53

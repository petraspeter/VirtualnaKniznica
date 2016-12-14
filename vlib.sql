-- MySQL dump 10.13  Distrib 5.7.16, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: vlib
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `id_autor` int(11) NOT NULL AUTO_INCREMENT,
  `meno_autor` varchar(50) CHARACTER SET utf8 NOT NULL,
  `alias_meno` varchar(50) CHARACTER SET utf8 NOT NULL,
  `priezvisko_autor` varchar(50) CHARACTER SET utf8 NOT NULL,
  `alias_priezvisko` varchar(50) CHARACTER SET utf8 NOT NULL,
  `stredne_autor` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `alias_stredne` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `popis_autor` varchar(2000) CHARACTER SET utf8 DEFAULT 'Žiaden popis nebol pridaný.',
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COLLATE=utf8_slovak_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Edgar','edgar','Poe','poe','Allan','allan','Edgar Allan Poe (* 19. januar 1809, Boston, Massachusetts, USA – † 7. oktober 1849, Baltimore, Maryland, USA) bol americky romanticky basnik, prozaik, literarny teoretik a esejista.\n\nBol autorom spravidla fantastickych a mystickych pribehov a zakladatelom detektivneho a hororoveho zanru.'),(2,'Terry','terry','pratchett','pratchett','',NULL,'Sir Terry Pratchett (celym menom Terence David John Pratchett) (* 28. april 1948 – † 12. marec 2015) bol anglicky autor fantasy literatury.'),(12,'William','william','Shakespeare','shakespeare','',NULL,'William Shakespeare (* april 1564; pokrsteny 26. aprila 1564, Stratford-upon-Avon – † 23. april 1616, Stratford-upon-Avon) bol vyznamny anglicky spisovatel, dramatik a herec.'),(13,'Alexandre','alexandre','Dumas','dumas','',NULL,'Alexandre Dumas starsi, vlastnym menom Thomas Alexandre Davy de La Pailleterie (* 24. jul 1802, Villers-Cotterêts, Aisne – † 5. december 1870, Puys, Seine-Maritime) bol francuzsky prozaik a dramatik obdobia romantizmu. Bol synom generala a vnukom francuzskeho markiza a kreolky z francuzskej kolonie Santo Domingo (dnes Haiti). Preslavil sa najma dobrodruznymi historickymi romanmi. Vela jeho diel viacnasobne dostalo filmovu podobu. Uspesny romanopisec a dramatik bol v kruhoch parizskej bohemy povestny svojou telesnou silou a bujnou povahou. Tieto povahove crty sa odrazili v jeho viacerych oblubenych literarnych postavach (silacke kusky Porthosa a i.).'),(15,'George','george','Orwell','orwell','',NULL,'Eric Arthur Blair (* 25. jun 1903, Motihari, India – † 21. januar 1950, Londyn, Spojene kralovstvo), znamy pod literarnym pseudonymom George Orwell, bol britsky novinar a spisovatel.'),(16,'Andrej','andrej','Sapkowski','sapkowski','','','Andrzej Sapkowski (vyslovnost [andzej sapkovski], * 21. jun 1948, Lodz) je povazovany za jedneho z najlepsich autorov slovanskej fantasy. Je velmi popularny nielen v rodnom Polsku, ale aj v Ceskej republike, Slovensku, Rusku, Nemecku, v Portugalsku, Francuzsku, Svajciarsku a obrovsku popularitu si vydobyl v Spanielsku.\n\nPo studiu na vysokej skole pracoval v oblasti zahranicneho obchodu. Svoju prvu poviedku publikoval v roku 1986 a uz o dva roky neskor sa stal jednym z najoblubenejsich spisovatelov fantasy v Polsku. Okrem knih pise aj poviedky, recenzie, komentare a fejtony, najma do polskych fantasy casopisov Fantastika a Magia a Mec (v orig. Magia i miecz)\n\nJeho najznamejsim dielom su poviedky a osemdielna saga o zaklinacovi Geraltovi z Rivie a princeznej Ciri.'),(29,'Karel','karel','Capek','capek','',NULL,'PhDr. Karel Capek (9. ledna 1890 Malé Svatosovice – 25. prosince 1938 Praha) byl ceský spisovatel, intelektuál, novinár, dramatik, prekladatel a fotograf.'),(34,'Giovanni','giovanni','Boccaccio','boccaccio',NULL,NULL,'Giovanni Boccaccio (* 16. jun 1313, Certaldo, Taliansko – † 21. december 1375, Tamze) bol taliansky spisovatel obdobia renesancie.'),(35,'George','george','Martin','martin',NULL,NULL,'George Raymond Richard Martin (* 20. september 1948, Bayonne, USA), skratene George R. R. Martin je americky scenarista a spisovatel fantasy, sci-fi a hororovej literatury. Je autorom popularnej fantasy romanovej sagy A Song of Ice and Fire (doslovne Piesen ladu a ohna). Je drzitelom viacerych spisovatelskych oceneni, cien Hugo a Nebula, ceny Brama Stokera ci World Fantasy Award.'),(36,'Jules','jules','Verne','verne',NULL,NULL,'Žiaden popis nebol pridaný.'),(37,'Honore','honore','deBalzac','deBalzac',NULL,NULL,'Žiaden popis nebol pridaný.'),(38,'Fjodor','fjodor','Dostojevskij','dostojevskij',NULL,NULL,'Žiaden popis nebol pridaný.'),(39,'Karl','karl','May','may',NULL,NULL,'Žiaden popis nebol pridaný.'),(40,'Malleus','malleus','kladivo','kladivo',NULL,NULL,'Žiaden popis nebol pridaný.'),(41,'Ruth','ruth','Smythersova','smythersova','Deversova','deversova',''),(42,'ruth','ruth','smythersonova','smythersonova','den','den','Napsala Ruth Smythersova,milovana zena reverenda L. D. Smytherse, pastora arkadicke metodisticke cirkve, pri vyrocnim regionalnim shromazdeni.');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kniha`
--

DROP TABLE IF EXISTS `kniha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kniha` (
  `id_kniha` int(11) NOT NULL AUTO_INCREMENT,
  `nazov_kniha` varchar(150) CHARACTER SET utf8 NOT NULL,
  `alias_kniha` varchar(150) CHARACTER SET utf8 NOT NULL,
  `autor_kniha` int(11) NOT NULL,
  `url_kniha` varchar(320) CHARACTER SET utf8 NOT NULL,
  `pridal_kniha` int(11) NOT NULL,
  `format_kniha` varchar(5) CHARACTER SET utf8 NOT NULL,
  `zaner` int(11) NOT NULL,
  `jazyk_1` varchar(5) CHARACTER SET utf8 NOT NULL,
  `jazyk_2` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `oblubenost_kniha` int(11) DEFAULT '0',
  `pocet_stran` int(11) DEFAULT NULL,
  `popis_kniha` varchar(5000) CHARACTER SET utf8 DEFAULT 'Žiaden popis nebol pridaný.',
  PRIMARY KEY (`id_kniha`),
  KEY `pridal_knihu_idx` (`pridal_kniha`),
  KEY `autor_knihy_idx` (`autor_kniha`),
  KEY `zaner_knihy_idx` (`zaner`),
  CONSTRAINT `autor_knihy` FOREIGN KEY (`autor_kniha`) REFERENCES `autor` (`id_autor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pridal_knihu` FOREIGN KEY (`pridal_kniha`) REFERENCES `pouzivatel` (`id_pouzivatel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `zaner_knihy` FOREIGN KEY (`zaner`) REFERENCES `zaner` (`id_zaner`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_slovak_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kniha`
--

LOCK TABLES `kniha` WRITE;
/*!40000 ALTER TABLE `kniha` DISABLE KEYS */;
INSERT INTO `kniha` VALUES (1,'Křev elfů','krev elfu',16,'http://s.ics.upjs.sk/~ppetras/paz1c/Zakl%c3%adna%c4%8d%202%20-%20Krev%20za%20krev.pdf',4,'pdf',10,'CZ',NULL,0,NULL,'Žiaden popis nebol pridaný.'),(5,'Skrotenie certice','skrotenie certice',12,'http://s.ics.upjs.sk/~ppetras/paz1c/zkroceni_zle_zeny.pdf',4,'pdf',17,'CZ','',NULL,117,'Skrotenie dracice, v strarsich prekladoch zname ako Skrotenie zlej zeny (anglicky: The Taming of the Shrew) je komedia anglickeho dramatika Williama Shakespearea, napisana okolo rokov 1593 az 1594.'),(6,'Krakatit','krakatit',29,'http://s.ics.upjs.sk/~ppetras/paz1c/krakatit.pdf',4,'pdf',34,'CZ','',NULL,250,'Krakatit je jedno z diel Karla Capka, v ktorom varuje pred bliziacim sa nebezpecenstvom, ktore videl v neustalom sa vyvijani techniky. Po prvykrat bolo vydane v roku 1924. Zaujimave je, ze Capek pisal o energii, ktora je v kazdej hmote. Vytvoril tak predobraz atomovej bomby vynajdenej o stvrtstorocie neskor.'),(8,'Dekameron','dekameron',34,'http://s.ics.upjs.sk/~ppetras/paz1c/Boccaccio-Dekameron.pdf',4,'pdf',35,'CZ','',NULL,493,'Dekameron je soubor sta novel o lásce rozdelených po deseti na deset dni. Pribehy si vypravi deset mladych lidi, kteií utekli z mesta na venkov, aby se zachranili pred morem, ktery vypukl ve Florencii roku 1348.'),(9,'Hra o trony 1','hra o trony 1',35,'http://s.ics.upjs.sk/~ppetras/paz1c/Pisen%20ledu%20a%20ohne%20-%2001%20-%20Hra%20o%20truny%20-%2001.pdf',4,'pdf',10,'CZ',NULL,10,NULL,'Žiaden popis nebol pridaný.'),(10,'Hra o trony 2','hra o trony 2',35,'http://s.ics.upjs.sk/~ppetras/paz1c/Pisen%20ledu%20a%20ohne%20-%2001%20-%20Hra%20o%20truny%20-%2002.pdf',4,'pdf',10,'CZ',NULL,0,NULL,'Žiaden popis nebol pridaný.'),(11,'Stret kralov 1','stret kralov 1',35,'http://s.ics.upjs.sk/~ppetras/paz1c/Pisen%20ledu%20a%20ohne%20-%2002%20-%20Stret%20kralu%20-%2001.pdf',4,'pdf',10,'CZ',NULL,5,NULL,'Žiaden popis nebol pridaný.'),(12,'stret kralov 2','stret kralov 2',35,'http://s.ics.upjs.sk/~ppetras/paz1c/Pisen%20ledu%20a%20ohne%20-%2002%20-%20Stret%20kralu%20-%2002.pdf',4,'pdf',10,'CZ',NULL,0,NULL,'Žiaden popis nebol pridaný.'),(13,'Posledne zelanie','posledne zelanie',16,'http://s.ics.upjs.sk/~ppetras/paz1c/Sapkowski%20Andrzej%20Zaklinac%20-%20Povidky%20I%20Posledni%20prani.pdf',4,'pdf',10,'CZ',NULL,55,336,'Žiaden popis nebol pridaný.'),(14,'Zaklinac, poviedka','zaklinac, poviedka',40,'http://s.ics.upjs.sk/~ppetras/paz1c/Zakl%c3%adna%c4%8d%201%20-%20Malleus,%20%c5%99e%c4%8den%c3%bd%20Kladivo.pdf',4,'pdf',10,'CZ',NULL,7,NULL,'Žiaden popis nebol pridaný.'),(19,'Bila nemoc','bila nemoc',29,'http://s.ics.upjs.sk/~ppetras/paz1c/bila_nemoc.pdf',4,'pdf',9,'CZ',NULL,0,NULL,'Žiaden popis nebol pridaný.'),(20,'Cesta do stredu zeme','cesta do stredu zeme',36,'http://s.ics.upjs.sk/~ppetras/paz1c/cesta_do_stredu_zeme.pdf',4,'pdf',9,'CZ',NULL,0,NULL,'Žiaden popis nebol pridaný.'),(21,'Havran a ine basne','havran a ine basne',1,'http://s.ics.upjs.sk/~ppetras/paz1c/havran.pdf',4,'pdf',1,'CZ',NULL,73,NULL,'Žiaden popis nebol pridaný.'),(22,'Idio','idiot',38,'http://s.ics.upjs.sk/~ppetras/paz1c/idiot-dostojevsky.pdf',4,'pdf',9,'CZ',NULL,0,NULL,'Žiaden popis nebol pridaný.'),(23,'Vinnetou','vinnetou',39,'http://s.ics.upjs.sk/~ppetras/paz1c/karel_may-vinnetou_I.pdf',4,'pdf',9,'CZ','',NULL,0,'0'),(24,'Vinnetou 2','vinnetou 2',39,'http://s.ics.upjs.sk/~ppetras/paz1c/karel_may-vinnetou_II.pdf',4,'pdf',9,'CZ','',NULL,325,'325'),(25,'sexualna prirucka z roku 1894','sexualna prirucka z roku 1894',41,'http://s.ics.upjs.sk/~ppetras/paz1c/sexualni_prirucka_z_roku_1894.pdf',15,'pdf',36,'sk','',NULL,3,'3'),(27,'sexualna prirucka','sexualna prirucka',42,'http://s.ics.upjs.sk/~ppetras/paz1c/sexualni_prirucka_z_roku_1894.pdf',15,'',36,'CZ','',NULL,3,'3');
/*!40000 ALTER TABLE `kniha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `oblubene`
--

DROP TABLE IF EXISTS `oblubene`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `oblubene` (
  `id_oblubene` int(11) NOT NULL AUTO_INCREMENT,
  `kniha_oblubene` int(11) NOT NULL,
  `pouzivatel_oblubene` int(11) NOT NULL,
  PRIMARY KEY (`id_oblubene`),
  KEY `oblubena_kniha_idx` (`kniha_oblubene`),
  KEY `oblubena_pouzivatel_idx` (`pouzivatel_oblubene`),
  CONSTRAINT `oblubena_kniha` FOREIGN KEY (`kniha_oblubene`) REFERENCES `kniha` (`id_kniha`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oblubena_pouzivatel` FOREIGN KEY (`pouzivatel_oblubene`) REFERENCES `pouzivatel` (`id_pouzivatel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oblubene`
--

LOCK TABLES `oblubene` WRITE;
/*!40000 ALTER TABLE `oblubene` DISABLE KEYS */;
INSERT INTO `oblubene` VALUES (1,1,4);
/*!40000 ALTER TABLE `oblubene` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pouzivatel`
--

DROP TABLE IF EXISTS `pouzivatel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pouzivatel` (
  `id_pouzivatel` int(11) NOT NULL AUTO_INCREMENT,
  `meno_pouzivatel` varchar(100) CHARACTER SET utf8 NOT NULL,
  `email_pouzivatel` varchar(320) CHARACTER SET utf8 DEFAULT NULL,
  `heslo_pouzivatel` varchar(320) CHARACTER SET utf8 NOT NULL,
  `sol_pouzivatel` varchar(30) CHARACTER SET utf8 NOT NULL,
  `je_admin` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_pouzivatel`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_slovak_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pouzivatel`
--

LOCK TABLES `pouzivatel` WRITE;
/*!40000 ALTER TABLE `pouzivatel` DISABLE KEYS */;
INSERT INTO `pouzivatel` VALUES (4,'root','','1F36ED3A3456B94975E5EDEFD52F175D12E4F81A32758AE832412C65CF20137E','hns61leok4gt1jdph5a3is3eib',1),(6,'gyula','gyula@jefrajer.sk','301D47F6369F73A8A8F729509D4CB666507B1987F5FFAE312D9234416A469FB5','esi8so7q9vjjpbv1rfqu028774',0),(7,'gyula2','','73CF2E74DCB31FA2C776591CC289DB24E9AF3A9847858BFC89BA8F0EB6A065DB','cv3puoals82v5e71esv4m2jifn',0),(14,'root2','','2BC68604FCFF850ED162DE9A6DDD4906AF9765538A93038618F81C74483F42BA','and8sml1hfk16r0qhmtuviv2eg',0),(15,'peter','','70E35FF8BF5F95464FCFF5D66F6DDAACBCB4C93E602F49F3C423EB512CFF7FD0','671ljk9vrn5cr1stv0ejn6ij2v',0);
/*!40000 ALTER TABLE `pouzivatel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rozcitane`
--

DROP TABLE IF EXISTS `rozcitane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rozcitane` (
  `id_rozcitane` int(11) NOT NULL AUTO_INCREMENT,
  `kniha_rozcitane` int(11) NOT NULL,
  `pouzivatel_rozcitane` int(11) NOT NULL,
  `strana_rozcitane` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_rozcitane`),
  KEY `rozcitana_kniha_idx` (`kniha_rozcitane`),
  KEY `rozcitana_pouzivatel_idx` (`pouzivatel_rozcitane`),
  CONSTRAINT `rozcitana_kniha` FOREIGN KEY (`kniha_rozcitane`) REFERENCES `kniha` (`id_kniha`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rozcitana_pouzivatel` FOREIGN KEY (`pouzivatel_rozcitane`) REFERENCES `pouzivatel` (`id_pouzivatel`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rozcitane`
--

LOCK TABLES `rozcitane` WRITE;
/*!40000 ALTER TABLE `rozcitane` DISABLE KEYS */;
INSERT INTO `rozcitane` VALUES (1,1,4,15),(2,6,4,0);
/*!40000 ALTER TABLE `rozcitane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaner`
--

DROP TABLE IF EXISTS `zaner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zaner` (
  `id_zaner` int(11) NOT NULL AUTO_INCREMENT,
  `nazov_zaner` varchar(45) CHARACTER SET utf8 NOT NULL,
  `alias_zaner` varchar(45) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_zaner`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_slovak_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaner`
--

LOCK TABLES `zaner` WRITE;
/*!40000 ALTER TABLE `zaner` DISABLE KEYS */;
INSERT INTO `zaner` VALUES (1,'Poézia','poezia'),(2,'Autobiografia','autobiografia'),(3,'Bájka','bajka'),(4,'Rozprávka','rozpravka'),(5,'Biografia','biografia'),(6,'Denník','dennik'),(7,'Diár','diar'),(8,'Esej','esej'),(9,'Román','roman'),(10,'Fantasy','fantasy'),(11,'Scifi','scifi'),(12,'Dráma','drama'),(13,'Satira','satira'),(14,'Triler','triler'),(15,'Sága','saga'),(16,'Poviedka','poviedka'),(17,'Komédia','komedia'),(18,'Tragédia','tragedia'),(19,'Činohra','cinohra'),(20,'Dobrodružný román','dobrodruzny roman'),(21,'Historický román','historicky roman'),(22,'Gotický román','goticky roman'),(23,'Historická detektívka','historicka detektivka'),(24,'Komický román','komicky roman'),(25,'Politický román','politcky roman'),(26,'Fantasy detektívka','fantasy detektivka'),(34,'Utopistický román','utopisticky roman'),(35,'Novela','novela'),(36,'sexualna prirucka','sexualna prirucka');
/*!40000 ALTER TABLE `zaner` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-14  8:30:32

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.5.9-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database gymtool
DROP DATABASE IF EXISTS `gymtool`;
CREATE DATABASE IF NOT EXISTS `gymtool` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gymtool`;

-- Dump della struttura di tabella gymtool.Utente
DROP TABLE IF EXISTS `Utente`;
CREATE TABLE IF NOT EXISTS `Utente` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(32) NOT NULL,
  `Cognome` varchar(32) NOT NULL,
  `Username` varchar(32) DEFAULT NULL,
  `Email` varchar(64) NOT NULL,
  `Password` varchar(32) NOT NULL,
  `DataNascita` date NOT NULL,
  `Altezza` varchar(10) DEFAULT NULL,
  `Peso` varchar(10) DEFAULT NULL,
  `Vita` varchar(10) DEFAULT NULL,
  `Collo` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username` (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella gymtool.Utente: ~0 rows (circa)
/*!40000 ALTER TABLE `Utente` DISABLE KEYS */;
/*!40000 ALTER TABLE `Utente` ENABLE KEYS */;

-- Dump della struttura di tabella gymtool.Scheda
DROP TABLE IF EXISTS `Scheda`;
CREATE TABLE IF NOT EXISTS `Scheda` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idUtente` int(11) DEFAULT NULL,
  `Nome` varchar(45) DEFAULT NULL,
  `Share` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_scheda1` (`idUtente`),
  CONSTRAINT `fk_scheda1` FOREIGN KEY (`idUtente`) REFERENCES `Utente` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella gymtool.Scheda: ~0 rows (circa)
/*!40000 ALTER TABLE `Scheda` DISABLE KEYS */;
/*!40000 ALTER TABLE `Scheda` ENABLE KEYS */;

-- Dump della struttura di tabella gymtool.Categoria
DROP TABLE IF EXISTS `Categoria`;
CREATE TABLE IF NOT EXISTS `Categoria` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Dump dei dati della tabella gymtool.Categoria: ~8 rows (circa)
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
REPLACE INTO `Categoria` (`ID`, `Nome`) VALUES
	(1, 'Petto'),
	(2, 'Spalle'),
	(3, 'Dorso'),
	(4, 'Braccia'),
	(5, 'Gambe'),
	(6, 'Glutei'),
	(7, 'Addominali'),
	(8, 'Cardio');
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;

-- Dump della struttura di tabella gymtool.Esercizio
DROP TABLE IF EXISTS `Esercizio`;
CREATE TABLE IF NOT EXISTS `Esercizio` (
  `ID` int(11) NOT NULL,
  `Nome` varchar(64) NOT NULL,
  `Descrizione` varchar(500) DEFAULT NULL,
  `CatEsercizio` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CatEs` (`CatEsercizio`),
  CONSTRAINT `FK_CatEs` FOREIGN KEY (`CatEsercizio`) REFERENCES `Categoria` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella gymtool.Esercizio: ~13 rows (circa)
/*!40000 ALTER TABLE `Esercizio` DISABLE KEYS */;
REPLACE INTO `Esercizio` (`ID`, `Nome`, `Descrizione`, `CatEsercizio`) VALUES
	(1, 'Bench Press', 'La posizione di partenza vede l\'atleta sdraiato supino su una panca piana con glutei, \r\n								  parte alta della schiena, scapole e nuca sempre a contatto con essa e con i piedi appoggiati saldamente al terreno verticalmente sotto, \r\n								  o dietro le ginocchia, ma mai davanti. \r\n								  Le anche sono abdotte e gli arti inferiori spingono sul pavimento in modo equilibrato per garantire stabilità alla posizione.', 1),
	(2, 'Push Up', NULL, 1),
	(3, 'Military Press', NULL, 2),
	(4, 'Lateral Raise', NULL, 2),
	(5, 'Lat Machine', NULL, 3),
	(6, 'Pull Up', NULL, 3),
	(7, 'Curl con bilanciere', NULL, 4),
	(8, 'Curl con manubri', NULL, 4),
	(9, 'Leg Press', NULL, 5),
	(10, 'Squat', NULL, 5),
	(11, 'Hip thrust', NULL, 6),
	(12, 'Running', NULL, 8),
	(13, 'Sit Up', NULL, 7);
/*!40000 ALTER TABLE `Esercizio` ENABLE KEYS */;


-- Dump della struttura di tabella gymtool.Allenamento
DROP TABLE IF EXISTS `Allenamento`;
CREATE TABLE IF NOT EXISTS `Allenamento` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idEsercizio` int(11) DEFAULT NULL,
  `idScheda` int(11) DEFAULT NULL,
  `Serie` int(11) DEFAULT NULL,
  `Ripetizioni` int(11) DEFAULT NULL,
  `Giorno` int(11) DEFAULT NULL,
  `Riga` int(11) DEFAULT NULL,
  `Tempo` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Allena1` (`idScheda`),
  KEY `fk_Allena2` (`idEsercizio`),
  CONSTRAINT `fk_Allena1` FOREIGN KEY (`idScheda`) REFERENCES `Scheda` (`ID`),
  CONSTRAINT `fk_Allena2` FOREIGN KEY (`idEsercizio`) REFERENCES `Esercizio` (`ID`)
);

-- Dump dei dati della tabella gymtool.Allenamento: ~0 rows (circa)
/*!40000 ALTER TABLE `Allenamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Allenamento` ENABLE KEYS */;




/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

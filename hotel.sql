-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 29 Mars 2019 à 19:15
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `hotel`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartement`
--

CREATE TABLE IF NOT EXISTS `appartement` (
  `NumA` int(11) NOT NULL AUTO_INCREMENT,
  `TypeA` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  PRIMARY KEY (`NumA`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci AUTO_INCREMENT=31 ;

--
-- Contenu de la table `appartement`
--

INSERT INTO `appartement` (`NumA`, `TypeA`) VALUES
(1, 'SINGLE APPART'),
(2, 'SINGLE APPART'),
(3, 'SINGLE APPART'),
(4, 'SINGLE APPART'),
(5, 'SINGLE APPART'),
(6, 'SINGLE APPART'),
(7, 'SINGLE APPART'),
(8, 'SINGLE APPART'),
(9, 'SINGLE APPART'),
(10, 'SINGLE APPART'),
(11, 'SINGLE APPART'),
(12, 'SINGLE APPART'),
(13, 'SINGLE APPART'),
(14, 'SINGLE APPART'),
(15, 'SINGLE APPART'),
(16, 'TWINS APPART'),
(17, 'TWINS APPART'),
(18, 'TWINS APPART'),
(19, 'TWINS APPART'),
(20, 'TWINS APPART'),
(21, 'TWINS APPART'),
(22, 'TWINS APPART'),
(23, 'TWINS APPART'),
(24, 'TWINS APPART'),
(25, 'TWINS APPART'),
(26, 'FAMILLY APPART'),
(27, 'FAMILLY APPART'),
(28, 'FAMILLY APPART'),
(29, 'FAMILLY APPART'),
(30, 'FAMILLY APPART');

-- --------------------------------------------------------

--
-- Structure de la table `banque`
--

CREATE TABLE IF NOT EXISTS `banque` (
  `IdB` int(11) NOT NULL AUTO_INCREMENT,
  `SoldeB` int(4) NOT NULL,
  `NumCompte` varchar(20) COLLATE utf8_general_mysql500_ci NOT NULL,
  `IdCl` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdB`),
  KEY `IdCl` (`IdCl`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci AUTO_INCREMENT=6 ;

--
-- Contenu de la table `banque`
--

INSERT INTO `banque` (`IdB`, `SoldeB`, `NumCompte`, `IdCl`) VALUES
(1, 300000, 'ML001', NULL),
(2, 200000, 'ML002', NULL),
(3, 100000, 'ML003', NULL),
(4, 50000, 'ML004', NULL),
(5, 30000, 'ML005', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `IdCl` int(11) NOT NULL AUTO_INCREMENT,
  `NomCl` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  `PrenomCl` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  `ContactCl` int(15) NOT NULL,
  `Age` int(11) NOT NULL,
  `compte` varchar(11) COLLATE utf8_general_mysql500_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  `IdEm` varchar(50) COLLATE utf8_general_mysql500_ci DEFAULT NULL,
  `IdR` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdCl`),
  KEY `Client_Employe_FK` (`IdEm`),
  KEY `Client_Reservation0_FK` (`IdR`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci AUTO_INCREMENT=32 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`IdCl`, `NomCl`, `PrenomCl`, `ContactCl`, `Age`, `compte`, `Email`, `IdEm`, `IdR`) VALUES
(1, 'traore', 'ouss', 80254167, 29, 'ML001', 'oustraore@gmail.com', NULL, NULL),
(2, 'dembe', 'tembe', 92563147, 63, 'ML003', 'tembe@gmail.com', NULL, NULL),
(3, 'dembe', 'tembe', 92563147, 63, 'ML003', 'tembe@gmail.com', NULL, NULL),
(4, 'dembe', 'tembe', 92563147, 63, 'ML003', 'tembe@gmail.com', NULL, NULL),
(5, 'dergu', 'houli', 89524176, 21, 'ML001', 'houli@gmail.com', NULL, NULL),
(6, 'foufou', 'goulou', 71254063, 27, 'ML002', 'goulou@gmail.com', NULL, NULL),
(7, 'kante', 'aly', 75846971, 20, 'ML6584', 'alik@gmail.com', NULL, NULL),
(8, 'cisse', 'fatou', 98562314, 61, 'ML001', 'fatou@gmail.com', NULL, NULL),
(9, 'goupoil', 'doiple', 59585754, 23, 'ML002', 'doiple@gmail.com', NULL, NULL),
(10, 'qery', 'sera', 70148956, 54, 'ML003', 'sera@gmail.com', NULL, NULL),
(11, 'fofana', 'fanta', 50214639, 26, 'ML001', 'fanta@gmail.com', NULL, NULL),
(12, 'Bary', 'santa', 98564712, 26, 'ML001', 'santa@gmail.com', NULL, NULL),
(13, 'rouyal', 'pouli', 69523147, 29, 'ML001', 'pouli@gmail.com', NULL, NULL),
(14, 'zazeru', 'podase', 82547169, 36, 'ML005', 'podase@gmail.com', NULL, NULL),
(15, 'Base', 'QRAE', 96235874, 81, 'ML002', 'QRAE@gmail.com', NULL, NULL),
(16, 'ruie', 'poui', 52130469, 90, 'ML003', 'poui@gmail.com', NULL, NULL),
(17, 'glihou', 'pordon', 82574691, 32, 'ML001', 'pordon@gmail.com', NULL, NULL),
(18, 'QUAXI', 'Saure', 95682314, 52, 'ML002', 'Saure@gmail.com', NULL, NULL),
(19, 'nommu', 'holli', 52147896, 46, 'ML002', 'holli@gmail.com', NULL, NULL),
(20, 'lifou', 'mossi', 96325841, 25, 'ML006', 'mossi@gmail.com', NULL, NULL),
(21, 'fagop', 'fatou', 79521480, 24, 'ML001', 'fatou@gmail.com', NULL, NULL),
(22, 'tutou', 'poilu', 91247560, 28, 'ML003', 'poilu@gmail.com', NULL, NULL),
(23, 'Sori', 'Sare', 50578962, 26, 'ML002', 'Sare@gmail.com', NULL, NULL),
(24, 'Warri', 'Zase', 92568417, 52, 'ML001', 'Zase@gmail.com', NULL, NULL),
(25, 'Doumbia', 'Moridian', 95247813, 23, 'ML004', 'Moridian@gmail.com', NULL, NULL),
(26, 'Sangare', 'Sang', 72165843, 38, 'ML005', 'Sang@gmail.com', NULL, NULL),
(27, 'zertyuiop', 'poiuytrez', 96325847, 43, 'ML005', 'poiuytrez@gmail.com', NULL, NULL),
(28, 'moihopu', 'sorrou', 50231478, 51, 'ML002', 'sorrou@gmail.com', NULL, NULL),
(29, 'Quazer', 'dermou', 83265974, 26, 'ML003', 'dermou@gmail.com', NULL, NULL),
(30, 'maman', 'doumbia', 96328574, 20, 'ML001', 'doumbiam@gmail.com', NULL, NULL),
(31, 'SASSI', 'SOSSO', 78524163, 46, 'ML001', 'SASSI@gmail.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `IdEm` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  `NomEm` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  `PrenomEm` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  `TypeEm` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  PRIMARY KEY (`IdEm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `IdR` int(11) NOT NULL AUTO_INCREMENT,
  `DebutR` text COLLATE utf8_general_mysql500_ci NOT NULL,
  `FinR` text COLLATE utf8_general_mysql500_ci NOT NULL,
  `ModeR` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  `FraisR` int(15) NOT NULL,
  `NumA` int(11) DEFAULT NULL,
  `NumS` int(11) DEFAULT NULL,
  `SommeRecu` int(15) NOT NULL,
  `SommeRest` int(15) NOT NULL,
  PRIMARY KEY (`IdR`),
  KEY `Reservation_Appartement_FK` (`NumA`),
  KEY `Reservation_Salle0_FK` (`NumS`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci AUTO_INCREMENT=29 ;

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`IdR`, `DebutR`, `FinR`, `ModeR`, `FraisR`, `NumA`, `NumS`, `SommeRecu`, `SommeRest`) VALUES
(1, '2 - mars - 2019', '21 - mars - 2019', 'Reservation simple', 10000, NULL, NULL, 10000, 3800000),
(2, '9 - mars - 2019', '18 - mars - 2019', 'Reservation simple', 10000, NULL, NULL, 10000, 450000),
(3, '9 - mars - 2019', '18 - mars - 2019', 'Reservation simple', 10000, NULL, NULL, 10000, 450000),
(4, '5 - april - 2019', '10 - april - 2019', 'Reservation avec avance', 5000, NULL, NULL, 500000, -200000),
(5, '8 - mars - 2019', '13 - mars - 2019', 'Tout payé', 0, NULL, NULL, 350000, 0),
(6, '15 - mars - 2019', '20 - mars - 2019', 'Tout payé', 0, NULL, NULL, 300000, 0),
(7, '2 - avril - 2019', '4 - avril - 2019', 'Reservation simple', 10000, NULL, NULL, 10000, 140000),
(8, '1 - mars - 2019', '11 - mars - 2019', 'Reservation simple', 10000, NULL, NULL, 10000, 500000),
(9, '3 - avril - 2019', '23 - avril - 2019', 'Reservation simple', 10000, NULL, NULL, 10000, 1400000),
(10, '1-janvier-2019', '9-janvier-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 400000),
(11, '9-mars-2019', '11-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 100000),
(12, '2-juin-2019', '12-juin-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 500000),
(13, '9-décembre-2019', '18-décembre-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 540000),
(14, '6-février-2019', '13-février-2019', 'Reservation avec avance', 5000, NULL, NULL, 80000, 410000),
(15, '8-mars-2019', '19-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 550000),
(16, '7-mars-2019', '27-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 1000000),
(17, '5-avril-2019', '7-avril-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 100000),
(18, '9-mars-2019', '11-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 100000),
(19, '3-mars-2019', '13-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 500000),
(20, '1-mars-2019', '20-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 950000),
(21, '9-mars-2019', '13-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 200000),
(22, '6-mars-2019', '18-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 600000),
(23, '8-janvier-2019', '12-janvier-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 800000),
(24, '2-février-2019', '9-février-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 350000),
(25, '2-mars-2019', '7-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 1000000),
(26, '15-mars-2019', '18-mars-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 150000),
(27, '9-avril-2019', '11-avril-2019', 'Reservation simple', 10000, NULL, NULL, 10000, 400000),
(28, '30-mars-2019', '2-avril-2019', 'Tout payé', 0, NULL, NULL, -1960000, 0);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `NumS` int(6) NOT NULL AUTO_INCREMENT,
  `TypeS` varchar(50) COLLATE utf8_general_mysql500_ci NOT NULL,
  PRIMARY KEY (`NumS`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci AUTO_INCREMENT=6 ;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`NumS`, `TypeS`) VALUES
(1, 'salle de réunion'),
(2, 'salle de réunion'),
(3, 'salle de réunion'),
(4, 'salle de conférence'),
(5, 'salle de cérémonie');

-- --------------------------------------------------------

--
-- Structure de la table `tarif`
--

CREATE TABLE IF NOT EXISTS `tarif` (
  `IdT` int(11) NOT NULL AUTO_INCREMENT,
  `PrixJ` int(15) NOT NULL,
  `Sejour` int(11) NOT NULL,
  `PrixS` int(15) NOT NULL,
  `NumA` int(11) DEFAULT NULL,
  `NumS` int(11) DEFAULT NULL,
  `IdR` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdT`),
  KEY `Tarif_Appartement_FK` (`NumA`),
  KEY `Tarif_Salle0_FK` (`NumS`),
  KEY `Tarif_Reservation1_FK` (`IdR`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci AUTO_INCREMENT=32 ;

--
-- Contenu de la table `tarif`
--

INSERT INTO `tarif` (`IdT`, `PrixJ`, `Sejour`, `PrixS`, `NumA`, `NumS`, `IdR`) VALUES
(1, 200000, 19, 3800000, NULL, NULL, NULL),
(2, 50000, 0, 0, NULL, NULL, NULL),
(3, 50000, 9, 450000, NULL, NULL, NULL),
(4, 50000, 9, 450000, NULL, NULL, NULL),
(5, 60000, 5, 300000, NULL, NULL, NULL),
(6, 70000, 5, 350000, NULL, NULL, NULL),
(7, 60000, 5, 300000, NULL, NULL, NULL),
(8, 70000, 2, 140000, NULL, NULL, NULL),
(9, 50000, 10, 500000, NULL, NULL, NULL),
(10, 70000, 20, 1400000, NULL, NULL, NULL),
(11, 50000, 0, 0, NULL, NULL, NULL),
(12, 50000, 0, 0, NULL, NULL, NULL),
(13, 50000, 8, 400000, NULL, NULL, NULL),
(14, 50000, 2, 100000, NULL, NULL, NULL),
(15, 50000, 10, 500000, NULL, NULL, NULL),
(16, 60000, 9, 540000, NULL, NULL, NULL),
(17, 70000, 7, 490000, NULL, NULL, NULL),
(18, 50000, 11, 550000, NULL, NULL, NULL),
(19, 50000, 20, 1000000, NULL, NULL, NULL),
(20, 50000, 2, 100000, NULL, NULL, NULL),
(21, 50000, 2, 100000, NULL, NULL, NULL),
(22, 50000, 10, 500000, NULL, NULL, NULL),
(23, 50000, 19, 950000, NULL, NULL, NULL),
(24, 50000, 4, 200000, NULL, NULL, NULL),
(25, 50000, 12, 600000, NULL, NULL, NULL),
(26, 200000, 4, 800000, NULL, NULL, NULL),
(27, 50000, 7, 350000, NULL, NULL, NULL),
(28, 200000, 5, 1000000, NULL, NULL, NULL),
(29, 50000, 3, 150000, NULL, NULL, NULL),
(30, 200000, 2, 400000, NULL, NULL, NULL),
(31, 70000, -28, -1960000, NULL, NULL, NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `banque`
--
ALTER TABLE `banque`
  ADD CONSTRAINT `banque_ibfk_1` FOREIGN KEY (`IdCl`) REFERENCES `client` (`IdCl`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `Client_Employe_FK` FOREIGN KEY (`IdEm`) REFERENCES `employe` (`IdEm`),
  ADD CONSTRAINT `Client_Reservation0_FK` FOREIGN KEY (`IdR`) REFERENCES `reservation` (`IdR`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `Reservation_Appartement_FK` FOREIGN KEY (`NumA`) REFERENCES `appartement` (`NumA`),
  ADD CONSTRAINT `Reservation_Salle0_FK` FOREIGN KEY (`NumS`) REFERENCES `salle` (`NumS`);

--
-- Contraintes pour la table `tarif`
--
ALTER TABLE `tarif`
  ADD CONSTRAINT `Tarif_Appartement_FK` FOREIGN KEY (`NumA`) REFERENCES `appartement` (`NumA`),
  ADD CONSTRAINT `Tarif_Reservation1_FK` FOREIGN KEY (`IdR`) REFERENCES `reservation` (`IdR`),
  ADD CONSTRAINT `Tarif_Salle0_FK` FOREIGN KEY (`NumS`) REFERENCES `salle` (`NumS`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

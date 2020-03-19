-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 19, 2020 at 02:25 PM
-- Server version: 5.7.24
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cme_insurance_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `beneficiaries`
--

DROP TABLE IF EXISTS `beneficiaries`;
CREATE TABLE IF NOT EXISTS `beneficiaries` (
  `grp` smallint(6) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Relationship` varchar(255) DEFAULT NULL,
  `Gender` varchar(255) DEFAULT NULL,
  `Birthday` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beneficiaries`
--

INSERT INTO `beneficiaries` (`grp`, `Name`, `Relationship`, `Gender`, `Birthday`) VALUES
(1, 'Rita', 'Spouse', 'Female', '1995-10-04'),
(1, 'Self', 'Self', 'Male', '1995-10-25'),
(1, 'Joseph', 'Son', 'Male', '2025-06-15'),
(2, 'Self', 'Self', 'Male', '1998-10-15'),
(2, 'Rita', 'Daughter', 'Female', '2026-10-11'),
(3, 'John', 'Son', 'Male', '2023-10-10'),
(3, 'Lea', 'Daughter', 'Female', '2024-10-12');

-- --------------------------------------------------------

--
-- Table structure for table `claims`
--

DROP TABLE IF EXISTS `claims`;
CREATE TABLE IF NOT EXISTS `claims` (
  `claim_id` int(11) NOT NULL AUTO_INCREMENT,
  `Policy` varchar(255) DEFAULT NULL,
  `Incurred` date DEFAULT NULL,
  `PolicyNo` varchar(255) DEFAULT NULL,
  `ClaimedAmount` float DEFAULT NULL,
  PRIMARY KEY (`claim_id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `claims`
--

INSERT INTO `claims` (`claim_id`, `Policy`, `Incurred`, `PolicyNo`, `ClaimedAmount`) VALUES
(1, 'Medical', '2021-06-06', '{2020}-{MedicalPolicy}-{1}', 100),
(2, 'Medical', '2021-07-06', '{2020}-{MedicalPolicy}-{1}', 50),
(3, 'Medical', '2021-08-06', '{2020}-{MedicalPolicy}-{2}', 200),
(4, 'Medical', '2021-09-06', '{2020}-{MedicalPolicy}-{1}', 150),
(5, 'Medical', '2021-11-12', '{2020}-{MedicalPolicy}-{1}', 100),
(6, 'Travel', '2019-12-06', '{2020}-{TravelPolicy}-{2}', 200),
(7, 'Travel', '2020-01-02', '{2020}-{TravelPolicy}-{2}', 100),
(8, 'Travel', '2020-01-03', '{2020}-{TravelPolicy}-{10}', 150),
(9, 'Travel', '2019-12-06', '{2020}-{TravelPolicy}-{2}', 200),
(10, 'Travel', '2019-06-06', '{2020}-{TravelPolicy}-{2}', 300),
(11, 'Motor', '2018-06-07', '{2020}-{MotorPolicy}-{3}', 500),
(12, 'Motor', '2019-01-05', '{2020}-{MotorPolicy}-{3}', 800),
(13, 'Motor', '2020-08-09', '{2020}-{MotorPolicy}-{3}', 1000),
(14, 'Motor', '2019-03-04', '{2021}-{MotorPolicy}-{3}', 200),
(15, 'Motor', '2018-04-05', '{2020}-{MotorPolicy}-{3}', 500);

-- --------------------------------------------------------

--
-- Table structure for table `medicalpolicy`
--

DROP TABLE IF EXISTS `medicalpolicy`;
CREATE TABLE IF NOT EXISTS `medicalpolicy` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Effective` date DEFAULT NULL,
  `Expiry` date DEFAULT NULL,
  `PolicyNo` varchar(255) DEFAULT NULL,
  `Beneficiaries_grp` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicalpolicy`
--

INSERT INTO `medicalpolicy` (`Id`, `Effective`, `Expiry`, `PolicyNo`, `Beneficiaries_grp`) VALUES
(1, '2020-10-11', '2021-10-11', '{2020}-{MedicalPolicy}-{1}', 1),
(2, '2018-10-11', '2022-10-11', '{2020}-{MedicalPolicy}-{2}', 2),
(3, '2018-10-11', '2022-10-12', '{2020}-{MedicalPolicy}-{3}', 3);

-- --------------------------------------------------------

--
-- Table structure for table `motorpolicy`
--

DROP TABLE IF EXISTS `motorpolicy`;
CREATE TABLE IF NOT EXISTS `motorpolicy` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Effective` date DEFAULT NULL,
  `Expiry` date DEFAULT NULL,
  `PolicyNo` varchar(255) DEFAULT NULL,
  `VehcileName` varchar(255) DEFAULT NULL,
  `VehiclePrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `motorpolicy`
--

INSERT INTO `motorpolicy` (`Id`, `Effective`, `Expiry`, `PolicyNo`, `VehcileName`, `VehiclePrice`) VALUES
(1, '2018-05-06', '2020-07-08', '{2020}-{MotorPolicy}-{1}', 'BMW', 10000),
(2, '2019-05-06', '2020-05-06', '{2020}-{MotorPolicy}-{2}', 'Mercedes', 18000),
(3, '2017-06-07', '2021-07-08', '{2020}-{MotorPolicy}-{3}', 'Volkswagen', 9000);

-- --------------------------------------------------------

--
-- Table structure for table `travelpolicy`
--

DROP TABLE IF EXISTS `travelpolicy`;
CREATE TABLE IF NOT EXISTS `travelpolicy` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Effective` date DEFAULT NULL,
  `Expiry` date DEFAULT NULL,
  `PolicyNo` varchar(255) DEFAULT NULL,
  `Departure` varchar(255) DEFAULT NULL,
  `Destination` varchar(255) DEFAULT NULL,
  `nbr_of_days` smallint(6) DEFAULT NULL,
  `Family_coverage` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `travelpolicy`
--

INSERT INTO `travelpolicy` (`Id`, `Effective`, `Expiry`, `PolicyNo`, `Departure`, `Destination`, `nbr_of_days`, `Family_coverage`) VALUES
(1, '2019-10-09', '2020-11-09', '{2020}-{TravelPolicy}-{1}', 'Lebanon', 'Dubai', 15, 1),
(2, '2019-10-09', '2022-10-09', '{2020}-{TravelPolicy}-{2}', 'Lebanon', 'Abu Dabi', 31, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

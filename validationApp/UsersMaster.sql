-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 16, 2019 at 01:20 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `userdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `UsersMaster`
--

CREATE TABLE IF NOT EXISTS `UsersMaster` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(35) NOT NULL,
  `mailId` varchar(35) NOT NULL,
  `password` varchar(100) NOT NULL,
  `roles` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `UsersMaster`
--

INSERT INTO `UsersMaster` (`id`, `name`, `mailId`, `password`, `roles`) VALUES
(1, 'Neeraj', 'a@b.com', '1234', NULL),
(3, 'Amit', 'amit@gmai.com', 'abcd', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

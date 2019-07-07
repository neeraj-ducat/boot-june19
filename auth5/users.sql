-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 07, 2019 at 12:35 PM
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
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('a@b.com', '$2a$12$lTGr.zLcVpdtQDu8lYEHvuYfC3EwBaO1k.pEOqMjHBR7oF1JtU.rO', 1),
('mohit@gmail.com', '$2a$12$lTGr.zLcVpdtQDu8lYEHvuYfC3EwBaO1k.pEOqMjHBR7oF1JtU.rO', 1),
('n@k.com', '$2a$12$lTGr.zLcVpdtQDu8lYEHvuYfC3EwBaO1k.pEOqMjHBR7oF1JtU.rO', 1),
('p@q.com', '$2a$12$lTGr.zLcVpdtQDu8lYEHvuYfC3EwBaO1k.pEOqMjHBR7oF1JtU.rO', 1),
('x@y.com', '$2a$12$lTGr.zLcVpdtQDu8lYEHvuYfC3EwBaO1k.pEOqMjHBR7oF1JtU.rO', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

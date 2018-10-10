-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 10, 2018 at 07:41 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `Employee`
--

CREATE TABLE `Employee` (
  `ssn` int(30) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(50) NOT NULL,
  `salary` int(10) NOT NULL,
  `gender` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Employee`
--

INSERT INTO `Employee` (`ssn`, `dob`, `name`, `address`, `salary`, `gender`) VALUES
(1, '12/02/1989', 'John McBealt', '1233 WIT avenue Waterford', 57000, 'Male'),
(2, '12/12/1979', 'Paul McNallye', '1253 WIT drive Waterford', 47000, 'Male'),
(3, '04/02/1989', 'Mary Johnson', '1423 WIT close Waterford', 47000, 'Female'),
(4, '02/02/1969', 'Stephen Peterson', '2123 WIT island Waterford', 37500, 'Male'),
(5, '30/03/1984', 'Billy O Connor', '91273 WIT area Waterford', 100000, 'Male'),
(6, '28/02/1988', 'Alex Jukowska', '8123 WIT island Waterford', 21000, 'Female'),
(7, '17/12/1982', 'Jacob Murray', '1223 WIT offices Waterford', 34000, 'Male'),
(8, '12/02/1989', 'Robert Kielyfvvrvrvt', '123 WIT forest Waterford', 89000, 'Male'),
(9, '22/11/1973', 'Ciaran Roche', '1323 WIT field Waterford', 12000, 'Male'),
(10, '12/05/1989', 'Ross Kirwan', '1237 WIT street Waterford', 10000, 'Male'),
(14, '12/02/1989', 'John McBealtytr', '1233 WIT avenue Waterford', 57000, 'Male'),
(17, '12/05/1989', 'Ross Kirwan', '1237 WIT street Waterford', 10000, 'Male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Employee`
--
ALTER TABLE `Employee`
  ADD PRIMARY KEY (`ssn`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

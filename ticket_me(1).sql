-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2019-10-14 12:02:10
-- 服务器版本： 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ticket_me`
--

-- --------------------------------------------------------

--
-- 表的结构 `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` int(10) NOT NULL,
  `name_ticket` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `urgency` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE `users` (
  `id_users` int(10) NOT NULL,
  `password` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `adress` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id_users`, `password`, `mail`, `first_name`, `last_name`, `adress`, `phone`) VALUES
(1, '123456', 'yyyyyyy@.com', 'YANG', 'lili', 'sdf rue', '45678513');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2019-11-21 10:38:57
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

--
-- 转存表中的数据 `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `name_ticket`, `urgency`, `category`, `description`) VALUES
(1, 'test', 'Problème', 'Haute', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=hjfdsfjfkl;dshagilgh.dfahgkad,editable,selection=29-29,rows=0,columns=0,scrollbarVisibility=both]'),
(2, 'test2', 'Problème', 'Haute', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=????????? cette fois on a que une fenetre quand il se termine,editable,selection=61-61,rows=0,columns=0,scrollbarVisibility=both]'),
(3, 'test3', 'Question', 'Faible', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=C\'EST POUR TESTER SI J\'AI BIEN MODIFIEE,editable,selection=39-39,rows=0,columns=0,scrollbarVisibility=both]'),
(4, 'test4', 'Question', 'Normale', 'EST ce que je peux afficher le contenue cette fois?'),
(5, 'test5', 'Question', 'Normale', 'hsjkkkkkkkkkkkkkkkkkkdddddddddd'),
(6, 'test6', 'Faible', 'Son', 'sdkkjcl/ndglkfd'),
(7, 'test11/20', 'Haute', 'Affichage', 'llllll'),
(8, 'test2', 'Haute', 'Affichage', 'ffff'),
(9, 'testApresHome', 'Haute', 'Affichage', 'On a reuusit de faire ca apres connecter!!!'),
(10, 'reussit', 'Haute', 'Affichage', 'est ce qu\'on a reussit????'),
(11, 'dddddsd', 'Haute', 'Affichage', 'last time............TTTTTT'),
(12, 'TTTT', 'Haute', 'Affichage', 'ddddddd'),
(13, 'dernier', 'Haute', 'Affichage', 'dddddddddddddddd');

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
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `adress` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id_users`, `password`, `mail`, `first_name`, `last_name`, `name`, `adress`, `phone`, `role`) VALUES
(1, '123456', 'yyyyyyy@.com', 'YANG', 'lili', '', 'sdf rue', '45678513', ''),
(2, '123456', 'jjjjjjj@gmail.com', 'Zhang', 'kk', '', 'sdffggg rue', '5428796', 'Technician'),
(3, '666666', 'hhgfdhj@', 'lala', 'Li', 'Lilala', 'fgdfhfgs', '5428796', 'User'),
(4, '654321', 'jjjjjj@', 'Zhang', 'palala', 'ZhangPalala', 'fffffffff rue', '4789533', 'Technician');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

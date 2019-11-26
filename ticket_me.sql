-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2019-11-26 22:02:15
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
-- 表的结构 `faq`
--

CREATE TABLE `faq` (
  `id_faq` int(5) NOT NULL,
  `name_faq` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `question_faq` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `answer_faq` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `frequency` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `issue`
--

CREATE TABLE `issue` (
  `id_issue` int(5) NOT NULL,
  `name_issue` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `type_issue` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `person`
--

CREATE TABLE `person` (
  `id_person` int(11) NOT NULL,
  `password` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `mail` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `adress` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name_role` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `person`
--

INSERT INTO `person` (`id_person`, `password`, `mail`, `first_name`, `last_name`, `name`, `adress`, `phone`, `name_role`) VALUES
(1, '123456', 'yyyyyyy@.com', 'YANG', 'lili', '', 'sdf rue', '45678513', ''),
(2, '123456', 'jjjjjjj@gmail.com', 'Zhang', 'kk', '', 'sdffggg rue', '5428796', 'Technician'),
(3, '666666', 'hhgfdhj@', 'lala', 'Li', 'Lilala', 'fgdfhfgs', '5428796', 'User'),
(4, '654321', 'jjjjjj@', 'Zhang', 'palala', 'ZhangPalala', 'fffffffff rue', '4789533', 'Technician');

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `name_role` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `satisfaction`
--

CREATE TABLE `satisfaction` (
  `id_satisfaction` int(5) NOT NULL,
  `skill_satisfaction` int(10) NOT NULL,
  `id_person` int(11) DEFAULT NULL,
  `name_role` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `ticket`
--

CREATE TABLE `ticket` (
  `id_ticket` int(10) NOT NULL,
  `name_ticket` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `urgency` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `solution` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `completion_code` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_issue` int(11) DEFAULT NULL,
  `id_person` int(11) DEFAULT NULL,
  `id_faq` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `name_ticket`, `urgency`, `category`, `description`, `status`, `solution`, `completion_code`, `id_issue`, `id_person`, `id_faq`) VALUES
(1, 'test', 'Problème', 'Haute', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=hjfdsfjfkl;dshagilgh.dfahgkad,editable,selection=29-29,rows=0,columns=0,scrollbarVisibility=both]', NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'test2', 'Problème', 'Haute', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=????????? cette fois on a que une fenetre quand il se termine,editable,selection=61-61,rows=0,columns=0,scrollbarVisibility=both]', NULL, NULL, NULL, NULL, NULL, NULL),
(3, 'test3', 'Question', 'Faible', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=C\'EST POUR TESTER SI J\'AI BIEN MODIFIEE,editable,selection=39-39,rows=0,columns=0,scrollbarVisibility=both]', NULL, NULL, NULL, NULL, NULL, NULL),
(4, 'test4', 'Question', 'Normale', 'EST ce que je peux afficher le contenue cette fois?', NULL, NULL, NULL, NULL, NULL, NULL),
(5, 'test5', 'Question', 'Normale', 'hsjkkkkkkkkkkkkkkkkkkdddddddddd', NULL, NULL, NULL, NULL, NULL, NULL),
(6, 'test6', 'Faible', 'Son', 'sdkkjcl/ndglkfd', NULL, NULL, NULL, NULL, NULL, NULL),
(7, 'test11/20', 'Haute', 'Affichage', 'llllll', NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'test2', 'Haute', 'Affichage', 'ffff', NULL, NULL, NULL, NULL, NULL, NULL),
(9, 'testApresHome', 'Haute', 'Affichage', 'On a reuusit de faire ca apres connecter!!!', NULL, NULL, NULL, NULL, NULL, NULL),
(10, 'reussit', 'Haute', 'Affichage', 'est ce qu\'on a reussit????', NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'dddddsd', 'Haute', 'Affichage', 'last time............TTTTTT', NULL, NULL, NULL, NULL, NULL, NULL),
(12, 'TTTT', 'Haute', 'Affichage', 'ddddddd', NULL, NULL, NULL, NULL, NULL, NULL),
(13, 'dernier', 'Haute', 'Affichage', 'dddddddddddddddd', NULL, NULL, NULL, NULL, NULL, NULL),
(14, 'tester2', 'Haute', 'Affichage', 'fgmjhjfgjhkhgjhfjhdffgfdgfsd', NULL, NULL, NULL, NULL, NULL, NULL),
(15, 'Teste1123', 'Normale', 'Son', 'lalala', NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faq`
--
ALTER TABLE `faq`
  ADD PRIMARY KEY (`id_faq`);

--
-- Indexes for table `issue`
--
ALTER TABLE `issue`
  ADD PRIMARY KEY (`id_issue`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id_person`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`name_role`);

--
-- Indexes for table `satisfaction`
--
ALTER TABLE `satisfaction`
  ADD PRIMARY KEY (`id_satisfaction`),
  ADD KEY `fk_person` (`id_person`),
  ADD KEY `fk_role` (`name_role`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `fk_issue` (`id_issue`),
  ADD KEY `fk_person` (`id_person`),
  ADD KEY `fk_faq` (`id_faq`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `faq`
--
ALTER TABLE `faq`
  MODIFY `id_faq` int(5) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `issue`
--
ALTER TABLE `issue`
  MODIFY `id_issue` int(5) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `satisfaction`
--
ALTER TABLE `satisfaction`
  MODIFY `id_satisfaction` int(5) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- 限制导出的表
--

--
-- 限制表 `satisfaction`
--
ALTER TABLE `satisfaction`
  ADD CONSTRAINT `satisfaction_ibfk_1` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `satisfaction_ibfk_2` FOREIGN KEY (`name_role`) REFERENCES `role` (`name_role`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- 限制表 `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_issue`) REFERENCES `issue` (`id_issue`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`id_faq`) REFERENCES `faq` (`id_faq`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

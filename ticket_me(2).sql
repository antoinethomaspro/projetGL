-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2019-12-03 23:53:56
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
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `adress` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name_role` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `person`
--

INSERT INTO `person` (`id_person`, `password`, `email`, `name`, `adress`, `phone`, `name_role`) VALUES
(1, '4KhF28uk', 'dbabcock0@skyrock.com', 'dbabcock0', '2129 Dahle Hill', '9053061567', 'Admin'),
(2, 'LDWJKK', 'tshord1@globo.com', 'tshord1', '4738 Redwing Center', '5946504696', 'Admin'),
(3, '0HZYnoSCNod', 'fskeemer2@mit.edu', 'fskeemer2', '8959 Schlimgen Circle', '8822319784', 'Admin'),
(4, 'QS8Cl1VT5', 'scadlock3@wikimedia.org', 'scadlock3', '5 Farwell Trail', '8954878426', 'Technician'),
(5, 'tRfHJdX', 'bmcgovern4@themeforest.net', 'bmcgovern4', '2 Arapahoe Plaza', '1892014748', 'Technician'),
(6, 'rp8mzeTUV', 'atewnion5@pcworld.com', 'atewnion5', '9322 North Place', '6731567576', 'Technician'),
(7, 'h8rZLdr0hS', 'afassam6@cpanel.net', 'afassam6', '911 Sachs Road', '5973100112', 'Technician'),
(8, '0AKsd2a', 'fcrosse7@stumbleupon.com', 'fcrosse7', '7 Hayes Trail', '9623423996', 'Technician'),
(9, 'ZpQErBB', 'vhabberjam8@omniture.com', 'vhabberjam8', '311 Warrior Street', '1773682125', 'Technician'),
(10, 'zFzjLU', 'jlabon9@ustream.tv', 'jlabon9', '51 Autumn Leaf Street', '3481192260', 'Technician'),
(11, 'kqd3KV', 'dfaggea@phoca.cz', 'dfaggea', '6 Debs Alley', '9797910864', 'Technician'),
(12, '2zEmfZO', 'nlayzellb@bigcartel.com', 'nlayzellb', '637 Dwight Hill', '9438228886', 'Technician'),
(13, 'tgOpXTZyEhDM', 'cmunceyc@loc.gov', 'cmunceyc', '5637 Farragut Junction', '9009247170', 'Technician'),
(14, 'Q3EUsY2SHi', 'jswallwelld@mapquest.com', 'jswallwelld', '65 Victoria Street', '4442784230', 'Technician'),
(15, 'TxC4fHfl', 'vhodgee@uol.com.br', 'vhodgee', '2 Pepper Wood Park', '5467804183', 'Technician'),
(16, 'IGh7MQhVr', 'triddellf@deliciousdays.com', 'triddellf', '4 Pierstorff Court', '6332640883', 'Technician'),
(17, 'rRCW11Uq', 'bjerdang@dedecms.com', 'bjerdang', '9487 Thompson Terrace', '3654263500', 'Technician'),
(18, 'EmEsMRK0', 'kshakeladeh@chicagotribune.com', 'kshakeladeh', '9132 Raven Pass', '7463655818', 'Technician'),
(19, 'Ek2ytbSAYB', 'itollfreei@icio.us', 'itollfreei', '72839 Thackeray Drive', '5393218539', 'Technician'),
(20, 'Jkws8HRU9g', 'dbirneyj@blogtalkradio.com', 'dbirneyj', '34 Mesta Center', '3576195792', 'Technician'),
(21, 'Y773RFsvmTB', 'abid_persondissk@aol.com', 'abid_persondissk', '45 Dakota Parkway', '6583534008', 'Technician'),
(22, 'hWrXQQsD', 'imorsleyl@etsy.com', 'imorsleyl', '4290 Dayton Avenue', '9467316579', 'Technician'),
(23, '4FiKSn', 'svaanm@altervista.org', 'svaanm', '85360 Luster Junction', '3375248835', 'Technician'),
(24, '9HSP3Iq7RN', 'nmitchelyn@yellowpages.com', 'nmitchelyn', '3625 Weeping Birch Point', '6679166669', 'User'),
(25, 'crN7HtMmKjr', 'yangzilu049@gmail.com', 'omaceo', '1 Sloan Way', '7622373246', 'User'),
(26, 'KY2mZFWcfK', 'okurthp@mlb.com', 'okurthp', '64 Anhalt Hill', '3847269221', 'User'),
(27, '8OimRVxeNE7', 'jnareq@php.net', 'jnareq', '05987 Green Point', '7901698457', 'User'),
(28, 'Cg2ImKfrhB', 'ystairmondr@networkadvertising.org', 'ystairmondr', '79 Victoria Way', '9909667338', 'User'),
(29, '9bPqNw', 'ksmithsons@webs.com', 'ksmithsons', '98993 Golden Leaf Avenue', '4432368842', 'User'),
(30, 'HfaIuKMjQdzK', 'ahefnert@hexun.com', 'ahefnert', '540 Carioca Junction', '1072541562', 'User'),
(31, 'fSQXyuoo9', 'blid_persongettu@slashdot.org', 'blid_persongettu', '57646 Bonner Hill', '3354306292', 'User'),
(32, 'Ff2TqePNcw6', 'fmorisonv@boston.com', 'fmorisonv', '88923 Westerfield Lane', '3602770218', 'User'),
(33, 'AVPVUY', 'fescoffreyw@wsj.com', 'fescoffreyw', '181 Arrowood Court', '6049326927', 'User'),
(34, 'VV5mXRmk', 'hgrishuninx@soup.io', 'hgrishuninx', '17 Dennis Parkway', '8957696588', 'User'),
(35, 'NfAi5JZfpLf5', 'sdruely@imgur.com', 'sdruely', '09 Rusk Junction', '1847127330', 'User'),
(36, '8givbsR', 'scorcoranz@acquirethisname.com', 'scorcoranz', '530 Meadow Rid_personge Crossing', '9692355743', 'User'),
(37, 'KZ8tKwGBqiXd', 'tmarcinkowski10@bloglovin.com', 'tmarcinkowski10', '20911 Cascade Road', '9278514193', 'User'),
(38, 'FnWkSXYddb', 'dpretsell11@posterous.com', 'dpretsell11', '1621 Westrid Point', '5501106551', 'User'),
(39, 'wtolqTejG', 'ubremeyer12@homestead.com', 'ubremeyer12', '46943 Hoffman Drive', '6273174063', 'User'),
(40, 'ZOIXS4Hc9Q', 'bmckelvey13@de.vu', 'bmckelvey13', '525 Susan Avenue', '3519324540', 'User'),
(41, 'fQiLtJ', 'cbrinkman14@deliciousdays.com', 'cbrinkman14', '789 Tennessee Junction', '3509828351', 'User'),
(42, 'CH3kpyXUF5yi', 'mdurkin15@foxnews.com', 'mdurkin15', '46 American Terrace', '7796798001', 'User'),
(43, 'ZYNe3Sa', 'dsculley16@jalbum.net', 'dsculley16', '4 Burrows Center', '1845735868', 'User'),
(44, 'ufxLD1DiI', 'bornelas17@samsung.com', 'bornelas17', '18 Kensington Crossing', '5832558968', 'User'),
(45, 'bHsGekD6enP', 'hfairrie18@twitpic.com', 'hfairrie18', '02 Melody Pass', '4881775254', 'User'),
(46, '5TKfBHcWE3', 'ahanratty19@virginia.edu', 'ahanratty19', '11 Lunder Center', '3008589274', 'User'),
(47, 'taPtrp', 'lmaillard1a@bandcamp.com', 'lmaillard1a', '197 Gerald Center', '4105743187', 'User'),
(48, '79uRjFx', 'vhinkensen1b@1688.com', 'vhinkensen1b', '239 Cambrid Alley', '7308855448', 'User'),
(49, 'FXOkHAc9', 'ktoyer1c@goo.gl', 'ktoyer1c', '1148 Schurz Lane', '8234314732', 'User'),
(50, 'TaT4Gi2eTvkU', 'ycamden1d@theguardian.com', 'ycamden1d', '275 American Junction', '2104094085', 'User'),
(51, 'eChTIAvERdQ', 'wronnay1e@devhub.com', 'wronnay1e', '82147 Dapin Street', '7294380344', 'User'),
(52, 'ICn1Bt2SLsp', 'atreece1f@cnbc.com', 'atreece1f', '42577 Kingsford Alley', '5175249667', 'User'),
(53, 'DqNgu30uqOxe', 'rstriker1g@ehow.com', 'rstriker1g', '5 Milwaukee Pass', '8911351737', 'User'),
(54, '9eTq6m', 'elemonnier1h@google.co.jp', 'elemonnier1h', '145 Anhalt Park', '8633172887', 'User'),
(55, 'qdsIiK6DYR', 'pnaulty1i@themeforest.net', 'pnaulty1i', '82745 Sugar Junction', '4525269205', 'User'),
(56, '3xYPrlLwzVT', 'aivanyutin1j@bing.com', 'aivanyutin1j', '2 Tennessee Pass', '3156443064', 'User'),
(57, 'Yn8yKEPbMn', 'scollinwood1k@jugem.jp', 'scollinwood1k', '201 Thompson Park', '6353837462', 'User'),
(58, '8sxwKbB', 'btatersale1l@istockphoto.com', 'btatersale1l', '87851 Thierer Place', '8284702938', 'User'),
(59, 'BKp8fY5L', 'rgrebner1m@shareasale.com', 'rgrebner1m', '3 Pleasure Pass', '4756224899', 'User'),
(60, 'LMpptRN4O', 'tredgrove1n@stumbleupon.com', 'tredgrove1n', '8 American Center', '5089315417', 'User'),
(61, 'xJmBHIY', 'mduplantier1o@themeforest.net', 'mduplantier1o', '0 Old Shore Point', '6264337578', 'User'),
(62, 'HzWqTYv', 'gkempston1p@privacy.gov.au', 'gkempston1p', '2111 Jenifer Road', '6422445500', 'User'),
(63, '5NXCSzOc7D', 'mmajor1q@vimeo.com', 'mmajor1q', '327 South Way', '7519241249', 'User'),
(64, 'qThL0MEudntP', 'mmccard1r@nsw.gov.au', 'mmccard1r', '52 Caliangt Trail', '2078858691', 'User'),
(65, 'UCSISbrF0S', 'ucartner1s@guardian.co.uk', 'ucartner1s', '648 Lakewood Gardens Court', '7244730899', 'User'),
(66, 'S6lM3Xxe3ph', 'mnealand1t@skype.com', 'mnealand1t', '08 Union Street', '8043580475', 'User'),
(67, 'yZp3ugvnNyy6', 'mcampey1u@i2i.jp', 'mcampey1u', '4 Monterey Junction', '7426658998', 'User'),
(68, 'wlM1nqxy', 'hbolf1v@wired.com', 'hbolf1v', '5595 Texas Lane', '4497620948', 'User'),
(69, 'DKubPFXu', 'jwhitely1w@newyorker.com', 'jwhitely1w', '6963 Monica Terrace', '5387286303', 'User'),
(70, '8fovFEHBQ', 'caristid_persone1x@newyorker.com', 'caristid_persone1x', '65472 Katie Park', '1913367336', 'User'),
(71, 'ZDRo11h', 'lbains1y@army.mil', 'lbains1y', '03 Nevada Street', '9471447142', 'User'),
(72, '3PfphNw', 'fklimes1z@godaddy.com', 'fklimes1z', '4256 Spohn Crossing', '2755169282', 'User'),
(73, 'ZqtpHcBCz', 'fwolton20@hugedomains.com', 'fwolton20', '19428 Sherman Trail', '1324628891', 'User'),
(74, 'ZpOtyqenGOT', 'yfollet21@devhub.com', 'yfollet21', '0 Village Trail', '9344571632', 'User'),
(75, 'yhDlQ7eP', 'ebeceril22@hhs.gov', 'ebeceril22', '27 Farwell Place', '6955755619', 'User'),
(76, 'DkO4lz92', 'esavile23@salon.com', 'esavile23', '60 Sherid Point', '5715694628', 'User'),
(77, 'Bknh9zLs6hV', 'apratton24@hubpages.com', 'apratton24', '9 Harper Road', '8905700144', 'User'),
(78, 'DuWIi7q5D', 'fmaslen25@cloudflare.com', 'fmaslen25', '1812 Sunnysid_persone Lane', '6896743559', 'User'),
(79, 'fIXSI24BX5c', 'khaselden26@ucoz.com', 'khaselden26', '372 Chinook Park', '7049981327', 'User'),
(80, 'e6wETMZjQ', 'ltucker27@army.mil', 'ltucker27', '5773 Blaine Parkway', '3229581799', 'User'),
(81, 'xca41hNH', 'kdecort28@wikimedia.org', 'kdecort28', '764 Becker Trail', '1234382350', 'User'),
(82, 'gXhSGcN0d', 'glegrand29@goodreads.com', 'glegrand29', '1 Bellgrove Lane', '8896392805', 'User'),
(83, 'FovWfjbHAyo', 'cvooght2a@cnet.com', 'cvooght2a', '960 Service Point', '6083208050', 'User'),
(84, 'N21rVUq', 'jsheaber2b@1und1.de', 'jsheaber2b', '68 Derek Street', '2876390087', 'User'),
(85, 'PEcpYq', 'ghoodspeth2c@ft.com', 'ghoodspeth2c', '8 Tennyson Street', '3063292448', 'User'),
(86, 'dCvWMaCCBspi', 'mwebberley2d@amazon.co.jp', 'mwebberley2d', '45919 Harbort Alley', '6903234265', 'User'),
(87, 'eWXWoMCesYH9', 'eblakemore2e@tiny.cc', 'eblakemore2e', '9 Bowman Trail', '5892816351', 'User'),
(88, 'Rt00nGDzn', 'nrubertis2f@behance.net', 'nrubertis2f', '211 Grayhawk Pass', '9576086268', 'User'),
(89, 'mZLuHiwd', 'hbuckland2g@lulu.com', 'hbuckland2g', '183 Warner Junction', '3578391960', 'User'),
(90, 'U1yhvTO', 'abasilotta2h@chicagotribune.com', 'abasilotta2h', '503 Autumn Leaf Drive', '5362388137', 'User'),
(91, 'hUwIciBjco3i', 'mpeacock2i@xrea.com', 'mpeacock2i', '78 Declaration Point', '2206294863', 'User'),
(92, 'V3abxrPy2F0P', 'gkiessel2j@imgur.com', 'gkiessel2j', '37 Waywood Junction', '7162562537', 'User'),
(93, '0JkZKFgV1UQ', 'bwoollons2k@linkedin.com', 'bwoollons2k', '8877 Hanson Circle', '4837433958', 'User'),
(94, '1z0ZEH', 'mdonet2l@flickr.com', 'mdonet2l', '3103 Garrison Place', '3065500049', 'User'),
(95, 'SBkdZGZR', 'smcentegart2m@nasa.gov', 'smcentegart2m', '22347 Warner Center', '3629879849', 'User'),
(96, '4RvVOQg5bf', 'cdeverille2n@usatoday.com', 'cdeverille2n', '8 Towne Plaza', '9868950517', 'User'),
(97, 'lOmDhVjO', 'sstanworth2o@webeden.co.uk', 'sstanworth2o', '696 Ramsey Terrace', '8841533980', 'User'),
(98, 'MX7nZM9JPl8Y', 'mwoolford2p@reference.com', 'mwoolford2p', '4551 Bultman Way', '9707594908', 'User'),
(99, 'V2riLBTLxT8j', 'dmurison2q@indiegogo.com', 'dmurison2q', '6664 Trailsway Court', '6974375244', 'User'),
(100, 'TbQ9THb', 'rgocke2r@nydailynews.com', 'rgocke2r', '6040 Rid Oak Place', '2637647475', 'User'),
(101, '123456', 'gsfh@', 'lili', '1 rue', '063254228', 'User'),
(102, '666666', 'jkfdshgh@', 'newUserLala', '1 rue', '1233589', 'User');

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
  `name_ticket` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `urgency` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `solution` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `completion_code` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_issue` int(11) DEFAULT NULL,
  `id_faq` int(11) DEFAULT NULL,
  `isCreatedBy` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `isSolvedBy` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `ticket`
--

INSERT INTO `ticket` (`id_ticket`, `name_ticket`, `urgency`, `category`, `description`, `status`, `solution`, `completion_code`, `id_issue`, `id_faq`, `isCreatedBy`, `isSolvedBy`) VALUES
(1, 'test', 'Problème', 'Haute', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=hjfdsfjfkl;dshagilgh.dfahgkad,editable,selection=29-29,rows=0,columns=0,scrollbarVisibility=both]', NULL, 'reussit', 'wwwww', NULL, NULL, '', ''),
(2, 'test2', 'Problème', 'Haute', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=????????? cette fois on a que une fenetre quand il se termine,editable,selection=61-61,rows=0,columns=0,scrollbarVisibility=both]', NULL, 's', 's', NULL, NULL, '', ''),
(3, 'test3', 'Question', 'Faible', 'java.awt.TextArea[text0,154,56,441x96,invalid,text=C\'EST POUR TESTER SI J\'AI BIEN MODIFIEE,editable,selection=39-39,rows=0,columns=0,scrollbarVisibility=both]', NULL, 'sl ', ' comCode', NULL, NULL, '', ''),
(4, 'test4', 'Question', 'Normale', 'EST ce que je peux afficher le contenue cette fois?', 0, ' sl ', ' comCode', NULL, NULL, '', ''),
(5, 'test5', 'Question', 'Normale', 'hsjkkkkkkkkkkkkkkkkkkdddddddddd', 0, '+ sl + ', '+ comCode+', NULL, NULL, '', ''),
(6, 'test6', 'Faible', 'Son', 'sdkkjcl/ndglkfd', NULL, NULL, NULL, NULL, NULL, '', ''),
(7, 'test11/20', 'Haute', 'Affichage', 'llllll', NULL, NULL, NULL, NULL, NULL, '', ''),
(8, 'test2', 'Haute', 'Affichage', 'ffff', NULL, NULL, NULL, NULL, NULL, '', ''),
(9, 'testApresHome', 'Haute', 'Affichage', 'On a reuusit de faire ca apres connecter!!!', NULL, NULL, NULL, NULL, NULL, '', ''),
(10, 'reussit', 'Haute', 'Affichage', 'est ce qu\'on a reussit????', NULL, NULL, NULL, NULL, NULL, '', ''),
(11, 'dddddsd', 'Haute', 'Affichage', 'last time............TTTTTT', NULL, NULL, NULL, NULL, NULL, '', ''),
(12, 'TTTT', 'Haute', 'Affichage', 'ddddddd', NULL, NULL, NULL, NULL, NULL, '', ''),
(13, 'dernier', 'Haute', 'Affichage', 'dddddddddddddddd', NULL, NULL, NULL, NULL, NULL, '', ''),
(14, 'tester2', 'Haute', 'Affichage', 'fgmjhjfgjhkhgjhfjhdffgfdgfsd', NULL, NULL, NULL, NULL, NULL, '', ''),
(15, 'Teste1123', 'Normale', 'Son', 'lalala', NULL, NULL, NULL, NULL, NULL, '', ''),
(16, 'probleme de boolean', 'Haute', 'Affichage', 'on peur inserer le boolean mtn?', 0, 'training', 'yeeeees', NULL, NULL, '', ''),
(17, 'il y a des difference?', 'Haute', 'Affichage', 'yes?', 1, NULL, NULL, NULL, NULL, '', ''),
(18, 'test1201', 'Haute', 'Affichage', 'yes', 1, NULL, NULL, NULL, NULL, '', ''),
(19, 'titre', ' priorite ', ' categorie', 'description', 1, NULL, NULL, NULL, NULL, 'lili', ''),
(20, 'Test pourMarlyn Magwood', 'Haute', 'Affichage', 'est ce qu\'on peur indiquer ce ticket est cree par qui?', 1, NULL, NULL, NULL, NULL, 'Marlyn Magwood', ''),
(21, 'TicketPourOma', 'Haute', 'Affichage', 'C\'est son ticket1', 0, 'email???', 'training', NULL, NULL, 'omaceo', 'scadlock3'),
(22, 'TicektPourOma', 'Haute', 'Affichage', 'C\'est son ticket2', 1, 'email', 'training', NULL, NULL, 'omaceo', ''),
(23, 'ticketPourOmaceo', 'Haute', 'Affichage', 'C\'est son ticket3', 1, 'email', 'training', NULL, NULL, 'omaceo', ''),
(24, 'ticketPourOma', 'Haute', 'Affichage', 'C\'est son ticket4', 1, 'email?', 'training', NULL, NULL, 'omaceo', '');

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
-- 使用表AUTO_INCREMENT `person`
--
ALTER TABLE `person`
  MODIFY `id_person` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;
--
-- 使用表AUTO_INCREMENT `satisfaction`
--
ALTER TABLE `satisfaction`
  MODIFY `id_satisfaction` int(5) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id_ticket` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- 限制导出的表
--

--
-- 限制表 `satisfaction`
--
ALTER TABLE `satisfaction`
  ADD CONSTRAINT `satisfaction_ibfk_2` FOREIGN KEY (`name_role`) REFERENCES `role` (`name_role`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- 限制表 `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`id_issue`) REFERENCES `issue` (`id_issue`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`id_faq`) REFERENCES `faq` (`id_faq`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

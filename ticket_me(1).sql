
--
-- Database: `ticket_me`
--

-- --------------------------------------------------------



CREATE TABLE `faq` (
  `id_faq` int(5) NOT NULL,
  `name_faq` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `question_faq` varchar(225) COLLATE utf8_unicode_ci NOT NULL,
  `answer_faq` varchar(225) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `faq` (`id_faq`, `name_faq`, `question_faq`, `answer_faq`) VALUES
(1, 'Sound', 'When I click play it the application plays the video but there is no sound', 'Check if your PC is not on mute mode'),
(2, 'Display', 'I canâ€™t rotate my screen', 'You can rotate the screen to portrait or upside-down landscape, by hitting CTRL + ALT + Left Arrow, Right Arrow or Down arrow'),
(3, 'Contact', 'I have a different question. How do I contact you if I need help?', 'Check your inbox email and spam emails if needed'),
(4, 'creating tickets', 'how many tickets can i make?', 'you can create as much tickets as you want'),
(5, 'password', 'I have forgotten my ticket\'s password, what do i do?', 'click on "i have forgotten my password" on the ticket window and change it vi your email or phone number'),
(6, 'username', 'i have forgotten my username, how do i find my ticket?', 'you have it in your email, check your email'),
(7, 'solved my problem', 'i have solved my problem, can i delete my ticket?', 'yes, connect yourself with your username and password and click on delete my ticket button.'),
(8, 'edit profile ', 'i have changed my email address how do i edit my profile?', 'replace your email address with the new one'),
(9, 'phone number ', 'can i put only my phone number and not email?', 'we need your email to send you the solution of your ticket'),
(10, 'duration', 'how long will my ticket get to be solved?', 'it depends on what urgency you have chosen. high urgency tickets are solved in between one week.\r\n\r\n'),
(11, 'language', 'i don\'t understand English can i change the language of this software?', 'Sorry, we are working on it. '),
(12, 'ticket list', 'my ticket list is empty, i can\'t find my ticket.', 'check your email, your ticket may be solved already.'),
(13, 'state', 'how do i know the state of my ticket?', 'check your ticket list if your ticket is not there anymore, it may be solved');



CREATE TABLE `person` (
  `id_person` int(11) NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `adress` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `name_role` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



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
(102, '666666', 'jkfdshgh@', 'newUserLala', '1 rue', '1233589', 'User'),
(103, '123456', 'fgfdhgf@', 'lala', '1 rue', '12536423', 'User');



CREATE TABLE `role` (
  `id_role` int(11) NOT NULL,
  `name_role` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `role` (`id_role`, `name_role`) VALUES
(1, 'Admin'),
(2, 'Technician'),
(3, 'User');



CREATE TABLE `satisfaction` (
  `id_satisfaction` int(5) NOT NULL,
  `skill_satisfaction` int(10) DEFAULT NULL,
  `id_person` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `satisfaction` (`id_satisfaction`, `skill_satisfaction`, `id_person`) VALUES
(1, 3, 4),
(2, 4, 4),
(3, NULL, 4),
(4, NULL, 5),
(5, 2, 6),
(6, 4, 6),
(7, 5, 6),
(8, 4, 7),
(9, 3, 8),
(10, 3, 9),
(11, 1, 11),
(12, NULL, 10),
(13, 3, 12),
(14, 2, 12),
(15, NULL, 13),
(16, NULL, 14),
(17, NULL, 15),
(18, NULL, 16),
(19, NULL, 17),
(20, NULL, 18),
(21, 4, 19),
(22, 2, 19),
(23, 4, 19),
(24, 3, 19),
(25, 4, 20),
(26, 5, 20),
(27, 4, 20),
(28, 4, 20),
(29, 5, 21),
(30, 4, 22),
(31, 3, 22),
(32, NULL, 22),
(33, 4, 22),
(34, 5, 23),
(35, 4, 23),
(36, NULL, 23),
(37, NULL, 5);



CREATE TABLE `superticket` (
  `id_superTicket` int(5) NOT NULL,
  `category` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `solution` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `superticket` (`id_superTicket`, `category`, `description`, `solution`) VALUES
(1, 'pc', 'computer screen in blue', 'Try to reboot your computer'),
(2, 'wireless network', 'print anything with computer', 'Have you checked if itâ€™s on? And connected to the wifi?'),
(3, 'password', 'password probleme', 'you are going to receive a message on your phone to check if the person changing the password is you and then change your password'),
(4, 'software', 'canâ€™t run my code in java application because it doesnâ€™t accept the java environment ', 'your java path and java environment have to match to be able to work'),
(5, 'freebox', 'can\'t connect with internet but\r\nhave already fix the box', '1)check your mode of box\r\n2)If your network connection light is red, please unplug your Box 4G + and place it somewhere else in your home.\r\n3ï¼‰If the phenomenon persists, please contact their support services by phone.'),
(6, 'youtube', 'The video problems', 'browsers that we recommend using to upload videos:\r\n\r\n    Google Chrome\r\n    Firefox 4 or higher\r\n    Internet Explorer or Microsoft Edge with Silverlight turned on'),
(7, 'whatsapp', 'problems about sending or receiving messages and problems about sending or receiving messages', 'If you\'re sure your phone is connected to the Internet, there are a few reasons why WhatsApp messages aren\'t going through:\n\nYour phone '),
(8, 'gmail', ' how can  change gmail settings,I canâ€™t find it', 'On your computer, go to Gmail.\r\nIn the top right, click Settings'),
(9, 'microsoft', 'What if dont\'t have enough disk space for the update?', 'Try deleting files you donâ€™t need, uninstalling apps you donâ€™t use, or moving '),
(10, 'internet', 'can\'t Connect to the Home WiFi Network', 'Follow these steps to determine whether the issue is with your login credentials, the device or your network. The links will provide additional tips.');



CREATE TABLE `ticket` (
  `id_ticket` int(10) NOT NULL,
  `name_ticket` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `urgency` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `category` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `screenshot` blob NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `solution` text COLLATE utf8_unicode_ci,
  `completion_code` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_superTicket` int(11) DEFAULT NULL,
  `isCreatedBy` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `isSolvedBy` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `ticket` (`id_ticket`, `name_ticket`, `urgency`, `category`, `description`, `screenshot`, `status`, `solution`, `completion_code`, `id_superTicket`, `isCreatedBy`, `isSolvedBy`) VALUES
(1, 'blue screen', 'High', 'pc', 'my computer screen in blue', '', 0, 'Try to reboot your computer', 'training', 1, 'rgocke2r', 'svaanm'),
(2, 'Log-in', 'Low', 'pc', 'I have written my username and password but i still canâ€™t log in', '', 0, 'try turning off your caps lock before writing your password', 'training', NULL, 'apratton24', 'svaanm'),
(3, 'deleted files', 'High', 'pc', 'I accidently deleted some of my files and I need them for my project how can i recover them', '', 0, 'check your recycle been first and if your lost files are not there do not use that drive as long as you have not retrieved your files or your files will be replaced by new data', 'training', NULL, 'fmaslen25', 'svaanm'),
(4, 'slowliness', 'low', 'pc', 'my computer is too slow, what can i do so it works faster?', '', 0, 'try to clean your computer fan periodically, your computer may be just overheated', 'training', NULL, 'esavile23', 'imorsleyl'),
(5, 'printer is not working', 'Medium', 'wireless network', 'i canâ€™t print anything with my computer because its not working', '', 0, 'Have you checked if itâ€™s on? And connected to the wifi?', 'training', 2, 'apratton24', 'imorsleyl'),
(6, 'noise', 'Medium', 'pc', 'my computer is making grinding noise', '', 1, NULL, NULL, NULL, 'apratton24', NULL),
(7, 'slow internet', 'Low', 'wireless network', 'i canâ€™t load my projects because the internet is so slow', '', 0, 'check out your computer if there are viruses or spywares and always install an antivirus software', 'training', 2, 'fmaslen25', 'imorsleyl'),
(8, 'canâ€™t connect to the network', 'Low', 'wireless network', 'the wireless network keeps kicking me off', '', 0, 'your router may be overloaded, try to connect to another router', 'training', NULL, 'khaselden26', 'imorsleyl'),
(9, 'USB device not recognized', 'Low', 'pc', 'my computer doesnâ€™t recognize my usb driver', '', 0, 'try to use another port if it still doesnâ€™t work try putting it on someone elseâ€™s computer to check if its not broken', 'training', NULL, 'fmaslen25', 'abid_persondissk'),
(10, 'password reset', 'Low', 'password', 'i want to reset my password because I have forgotten my current password', '', 0, 'you are going to receive a message on your phone to check if the person changing the password is you and then change your password', 'training', 3, 'ltucker27', 'dbirneyj'),
(11, ' uploading errors', 'Low', 'youtube', 'I can\'t open the video and it shows me an error with \'A network error has occurred\' ', '', 0, '\n\nMake sure that you\'ve updated your browser to the latest version. Older browsers can often cause problems. Below are some of the browsers that we recommend using to upload videos:\n\n    Google Chrome\n    Firefox 4 or higher\n    Internet Explorer or Microsoft Edge with Silverlight turned on\n', 'solved with a workaround', 6, 'nmitchelyn', 'scadlock3'),
(12, 'Duplicate uploads', 'Medium', 'youtube', 'I can\'t upload the same video twice? The second upload is a duplicate', '', 0, 'If you\'d like to upload the same video again, try editing the video before uploading it. For example, change the video length by adding extra frames or compress the video. Changing the file name alone won\'t prevent the duplicate upload error message.', 'solved with a workaround', 6, 'omaceo', 'scadlock3'),
(13, 'Video stuck during upload', 'Low', 'youtube', 'My video stuck during upload', '', 0, '\r\n    File type and size: Your video\'s file type and video format determine its size. To make your uploads faster, encode your videos in one of these recommended formats.\r\n    Slow Internet connection: Search \'Internet speed test\' on google.co.uk to check your Internet connection. Slow or unstable Internet connection is one of the main causes of slow uploads.\r\n    Heavy upload traffic: You might be uploading during a busy time. At some peak hours, your Internet Service Provider registers spikes of upload traffic and might take longer to upload your video to YouTube. Find out more about video performance on YouTube.\r\n    Resolution: Higher resolution videos take longer to upload. For instance, a 4K video will take longer to upload than a 1080p video.\r\n', 'training', NULL, 'okurthp', 'scadlock3'),
(14, 'printer', 'Low', 'printer', 'the printer is down', '', 1, NULL, NULL, NULL, 'fmaslen25', NULL),
(15, 'adobt reader updated problem', 'Low', 'pc', 'I donâ€™t have the adnibistration rights for updating adobe reader what should i do', '', 0, 'The move to cloud-based service desk software helps cut down on these calls, because the updates are installed automatically. You can also release formal announcements and notifications of upcoming changes to software and/or applications through the portal.', 'training', NULL, 'khaselden26', 'dbirneyj'),
(16, 'video conferencing error', 'Low', 'pc', 'there is an error while video conferencing', '', 1, NULL, NULL, NULL, 'ltucker27', NULL),
(17, 'voicemail password reset', 'Low', 'pc', 'mey voicemail password needs to be reste', '', 1, NULL, NULL, NULL, 'ltucker27', NULL),
(18, 'slow network', 'Medium', 'wireless network', 'the network is slow', '', 0, 'Some problems are due to physical location relative to network nodes or building materials affecting signal. Network upgrades often make things temporarily slower in exchange for faster access upon upgrade completion. Plan and execute these changes with minimal service disruption through an appropriate IT change management process', 'training', 2, 'ltucker27', 'dbirneyj'),
(19, 'document acces', 'Low', 'pc', 'i canâ€™t acces to my documents', '', 0, 'change hardware or applications, employees need to know how to access their documents in the new hardware/software environment.', 'training', NULL, 'ltucker27', 'dbirneyj'),
(20, 'third-party software problems', 'High', 'pc', 'i canâ€™t use third party applications I have so many problems, please help me as fast as you can because I need to finish my project as soon as possible and i need that third party application', '', 0, 'To prevent these problems, many organizations deny administrative rights to employees wanting to install their own third-party software. In addition, we recommend tracking every detail about every device through a comprehensive IT asset management strategy', 'training', NULL, 'ltucker27', 'itollfreei'),
(21, 'frozen computer', 'Low', 'pc', 'my computer just froze what can I do ', '', 1, NULL, NULL, NULL, 'kdecort28', NULL),
(22, 'network connection', 'Medium', 'pc', 'BYOD problems', '', 0, 'bring your own device', 'abandonned by use', NULL, 'ltucker27', 'itollfreei'),
(23, 'deleting application', 'Low', 'pc', 'my pc keeps deleting every application I install on it', '', 1, NULL, NULL, NULL, 'glegrand29', NULL),
(24, 'my apache is not working', 'High', 'software', 'i canâ€™t connect myself to my database because my apache is not working after I installed new version of windows', '', 1, NULL, NULL, NULL, 'glegrand29', NULL),
(25, 'java environment not working', 'Low', 'software', 'i canâ€™t run my code in java application because it doesnâ€™t accept the java environment', '', 0, 'your java path and java environment have to match to be able to work', 'training', 4, 'kdecort28', 'itollfreei'),
(26, 'keayboard not working', 'Low', 'pc', 'My keyboard isnâ€™t inputing anything on my computer even though it works on other computers', '', 0, 'try to clean up your keyboard port', 'training', NULL, 'cvooght2a', 'itollfreei'),
(27, 'clean up c driver', 'Medium', 'pc', 'how can I clean up my C drive without losing any document or application?', '', 1, NULL, NULL, NULL, 'cvooght2a', NULL),
(28, 'Video stuck during upload', 'low', 'youtube', 'My video always stuck during upload ,and I  donâ€™t know how to do', '', 1, NULL, NULL, NULL, 'jnareq', ''),
(29, 'Troubleshoot video takedowns', 'Medium', 'youtube', 'Iâ€™am a youtuber and my video is taken down but I donâ€™t know why', '', 0, 'Your video was removed from YouTube because a copyright owner sent us a complete legal request to take it down. You also received a copyright strike. Learn how copyright strikes can affect your account.', 'solved with a workaround', NULL, 'blid_persongettu', 'atewnion5'),
(30, 'Saving chat history', 'Low', 'whatsapp', 'I canâ€™t find button to save my history of chat', '', 1, NULL, NULL, NULL, 'nmitchelyn', ''),
(31, 'notifications', 'Medium', 'whatsapp', 'Why don\'t I get notifications?', '', 0, 'When a message is sent to you via WhatsApp, but you do not have the app open to receive it, your iPhone will automatically display a push notification to alert you of the message. iOS apps can provide three types of notifications:\n\nSounds: An audible alert plays.\nAlerts/Banners: An alert or banner appears on the screen.\nBadges: An image or number appears on the application icon.', 'solved with a workaround', 7, 'ksmithsons', 'jlabon'),
(32, 'messages problems', 'Low', 'whatsapp', 'I have some problems about sending or receiving messages', '', 0, 'If you\'re sure your phone is connected to the Internet, there are a few reasons why WhatsApp messages aren\'t going through:\n\nYour phone needs to be restarted or turned off and on.\nThe contact you\'re messaging has blocked your number. Find out more in this article.\nYou haven\'t completed the initial verification process. Learn about verification on: Android | iPhone | Windows Phone.\nThe number of the contact you\'re trying to message on WhatsApp hasn\'t been saved correctly on your phone. Learn the correct format of each phone number here.', 'training', 7, 'ahefnert', 'jlabon'),
(33, 'Troubleshoot blurry photos', 'Medium', 'whatsapp', 'My photos  appear blurry', '', 1, NULL, NULL, NULL, 'blid_personngettu', NULL),
(34, 'Change Gmail settings', 'Low', 'gmail', 'I mant to knows how can I change my gmail settings,I canâ€™t find it', '', 0, 'On your computer, go to Gmail.\nIn the top right, click Settings Settingsand then Settings.\nAt the top, choose a settings page, such as General, Labels, or Inbox.\nMake your changes.\nAfter you\'re done with each page, click Save Changes at the bottom.', 'training', 8, 'fescoffreyw', 'atewnion5'),
(35, 'Google Account', 'Medium', 'gmail', 'I can\'t sign in to your Google Account,and I think someone else is using your account.', '', 0, 'For help getting back in to your account:\r\n\r\nFollow the steps to recover your account.\r\nYou\'ll be asked some questions to confirm it\'s your account. Answer as best you can.\r\nIf you\'re having trouble, try the tips to complete account recovery steps.\r\nReset your password when prompted. Choose a strong password that you haven\'t already used with this account. Learn how to create a strong password.', 'training', 8, 'sdruely', 'afassam6'),
(36, 'Gmail addresses', 'Medium', 'gmail', 'My dots don\'t matter in Gmail addresses', '', 1, NULL, NULL, NULL, 'ahefnert', NULL),
(37, 'Google products', 'Medium', 'gmail', 'How can I use Google products, like Gmail or Calendar, in the same window on MY computer.', '', 1, NULL, NULL, NULL, 'ystairmonde', NULL),
(38, 'Use Gmail for business', 'High', 'gmail', 'Can I use gmail for business and how?', '', 0, 'Swap @gmail.com with your own domain to create professional email addresses for everyone on your team, like yourname@example.com. With a custom email at your domain, you can help build customer trust and create group mailing lists, such as sales@yourcompany.', 'solved with a workaround', NULL, 'jnareq\r\n', 'fcrosse7'),
(39, 'Space Drive', 'High', 'microsoft', '\nWhat if I don\'t have enough disk space for the update?', '', 0, 'Try deleting files you donâ€™t need, uninstalling apps you donâ€™t use, or moving files to another drive like an external USB drive or OneDrive. For more tips on freeing up disk space, see Free up drive space in Windows 10.', 'solved with a workaround', 9, 'ahefnert', 'atewnion5'),
(40, 'Xbox', 'Medium', 'microsoft', 'Once I join the Xbox Game Pass Ultimate plan,where can I find My membre benifits?', '', 0, 'Once you join the Xbox Game Pass Ultimate plan, you can continue to access all your Xbox Live Gold benefits in the Xbox Live Gold lounge on your Xbox One Home and your Xbox Game Pass benefits on the dedicated Xbox Game Pass tab on your Xbox One.', 'solved with a workaround', NULL, 'sdruely', 'nlayzellb'),
(41, 'Windows virtual', 'Medium', 'microsoft', 'When is windows virtual desktop an approprite solution?', '', 1, NULL, NULL, NULL, 'hgrishuninx', NULL),
(42, 'Skype Number', 'Low', 'microsoft', 'How can I do I block unwanted calls to my Skype Number', '', 1, NULL, NULL, NULL, 'scorcoranz', NULL),
(43, 'Windows Update', 'Medium', 'microsoft', '\r\n\r\nI want to stop downloading from or uploading to other PCs on the local network but I donâ€™t know how to do that ,can you help me?\r\n\r\n', '', 1, NULL, NULL, NULL, 'tmarcinkowski19', NULL),
(44, 'Page', 'Low', 'facebook', 'How can I invite people to like my Page or share another Page with my friends.', '', 0, 'To share a Page with friends:\r\nClick Share below the Page\'s cover photo.\r\nClick the dropdown menu at the top to select where you want to share the Page (example: your timeline, a Page you manage).\r\nWrite an optional update or message.\r\nClick Post or Send.', 'training', 9, 'dpretsell11', 'nlayzellb'),
(45, 'add captions', 'Medium', 'facebook', 'How do I add captions to my Page\'s video on Facebook?', '', 0, 'To add captions to your Page\'s video:\r\nClick Photo/Video at the top of your Page\'s timeline.\r\nClick Upload Photos/Video and select a video from your computer.\r\nOnce your video has uploaded, click Subtitles & Captions(CC) in the column on the right.\r\nNext to Video Language, select the main language spoken in the video.\r\nOnce your video has finished uploading, select whether you\'d like to auto-generate captions, write them yourself or upload a SubRip (.srt) file.\r\nClick Publish.', 'training', 9, 'bmckelvey13', 'dfaggea'),
(46, 'Hacked page', 'High', 'facebook', '\r\nI think my Facebook Page was hacked or taken over by someone else.\r\nAnd I can\'t access your Page', '', 1, NULL, NULL, NULL, 'cbrinkman14', NULL),
(47, 'problems of results page', 'urgency', 'facebook', 'I\'ve noticed that your Page isn\'t appearing in search results on Facebook,what can I do?', '', 1, NULL, NULL, NULL, 'bmckelvey13', NULL),
(48, 'Connect to network', 'Medium', 'internet', 'I can\'t Connect to the Home WiFi Network,and I dontâ€™t know how o do ,would you please help me?', '', 0, 'Follow these steps to determine whether the issue is with your login credentials, the device or your network. The links will provide additional tips.\n:Login Credentials,Device Issues,Networdk issues', '', 10, 'dpretsell11', 'vhabberjam8'),
(49, 'Connect Gaming device', 'Medium', 'internet', 'Could you please help me connect your wireless devices such as gaming consoles or systems, smart TVs, and wireless printers to your in-home WiFi network?', '', 1, NULL, NULL, NULL, 'fcrosse7', NULL),
(50, 'Port Triggering', 'Medium', 'internet', 'What is Port Triggering on the Xfinity Gateway?How can I set Up Port Triggering?', '', 1, NULL, NULL, NULL, 'afassam6', NULL),
(51, 'quality of video', 'Medium', 'whatsapp', 'My video in chat is always in low quality and I how to do', '', 0, 'If you\'re sure your phone is connected to the Internet, there are a few reasons why WhatsApp messages aren\'t going through:', 'training', 7, 'omaceo', 'scadlock3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faq`
--
ALTER TABLE `faq`
  ADD PRIMARY KEY (`id_faq`);

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
  ADD KEY `fk_person` (`id_person`);

--
-- Indexes for table `superticket`
--
ALTER TABLE `superticket`
  ADD PRIMARY KEY (`id_superTicket`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id_ticket`);



ALTER TABLE `faq`
  MODIFY `id_faq` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

ALTER TABLE `person`
  MODIFY `id_person` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;

ALTER TABLE `satisfaction`
  MODIFY `id_satisfaction` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

ALTER TABLE `superticket`
  MODIFY `id_superTicket` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

ALTER TABLE `ticket`
  MODIFY `id_ticket` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

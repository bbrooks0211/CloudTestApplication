-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 17, 2019 at 11:58 PM
-- Server version: 5.6.34-log
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cloudtestapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `forumposts`
--

CREATE TABLE IF NOT EXISTS `forumposts` (
  `id` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `content` varchar(1250) NOT NULL,
  `category` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `forumposts`
--

INSERT INTO `forumposts` (`id`, `userID`, `content`, `category`) VALUES
(1, 1, 'Wow, this forum sucks', 'default'),
(2, 2, 'yeah I agree, this forum really does suck', 'default'),
(3, 1, 'thanks for agreeing with me m8 &#129315;&#129315;', 'default'),
(4, 3, 'Hey guys, what do you think of this forum?', 'default'),
(5, 2, '@Billy it sucks', 'default'),
(6, 4, 'This is another forum post', 'default');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(512) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'meme', 'meme'),
(2, 'trashman', 'meme'),
(3, 'Billy', 'meme'),
(4, 'bbrooks', 'meme');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `forumposts`
--
ALTER TABLE `forumposts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `forumposts`
--
ALTER TABLE `forumposts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

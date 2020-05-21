-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2020 at 10:49 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `db_booklist`
--

CREATE TABLE `db_booklist` (
  `bookId` varchar(50) NOT NULL,
  `title` varchar(300) NOT NULL,
  `author` varchar(300) NOT NULL,
  `category` varchar(50) NOT NULL,
  `returnBook` int(50) NOT NULL,
  `issueBook` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_booklist`
--

INSERT INTO `db_booklist` (`bookId`, `title`, `author`, `category`, `returnBook`, `issueBook`) VALUES
('AA003', 'Milk Tea', 'SMDC', 'History', 4, 6),
('AA004', 'OOP', 'Maam Orchea', 'Computer', 4, 6),
('AA006', 'Q', 'Q', 'English', 2, 0),
('AA007', 'W', 'W', 'Filipino', 100, 0),
('AA008', 'R', 'R', 'Arts', 15, 0),
('AA009', 'TT', 'TT', 'Mathematics', 17, 0),
('AA010', 'I', 'I', 'English', 18, 2),
('AA011', 'J', 'J', 'Mathematics', 12, 1),
('AA012', 'CDCD', 'CDCD', 'Science', 4, 1),
('AA013', 'TER', 'TER', 'Filipino', 6, 0),
('AA016', 'me', 'em', 'Mathematics', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `db_code`
--

CREATE TABLE `db_code` (
  `code` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_code`
--

INSERT INTO `db_code` (`code`) VALUES
('BUU3B'),
('CWMFQ'),
('UJG16'),
('YMZKO');

-- --------------------------------------------------------

--
-- Table structure for table `db_history`
--

CREATE TABLE `db_history` (
  `historyId` varchar(50) NOT NULL,
  `studentId` varchar(50) NOT NULL,
  `name` varchar(300) NOT NULL,
  `yearSection` varchar(50) NOT NULL,
  `bookId` varchar(50) NOT NULL,
  `title` varchar(300) NOT NULL,
  `author` varchar(300) NOT NULL,
  `category` varchar(50) NOT NULL,
  `action` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `duedate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_history`
--

INSERT INTO `db_history` (`historyId`, `studentId`, `name`, `yearSection`, `bookId`, `title`, `author`, `category`, `action`, `date`, `duedate`) VALUES
('TRANS001', 'w', 'w', 'w', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '10 01 2010', '10 06 2010'),
('TRANS002', 'q', 'q', 'q', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '10 01 2010', '10 06 2010'),
('TRANS003', '18-01-0135', 'Joshua M. Manalo', 'BMHR 2-1', 'AA003', 'Tukmol', 'Joshua Manalo', 'Filipino', 'Issue Book', '11 25 2019', '11 30 2019'),
('TRANS004', '18-01-0135', 'Joshua M. Manalo', 'BMHR 2-1', 'AA003', 'Tukmol', 'Joshua Manalo', 'Filipino', 'Return Book', '11 25 2019', '11 25 2019'),
('TRANS005', '18-01-0057', 'Mica Mediado', 'BSIT 2-2', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS006', 'w', 'w', 'w', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '10 01 2010', '11 26 2019'),
('TRANS007', 'q', 'q', 'q', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '10 01 2010', '11 26 2019'),
('TRANS008', '18-01-0096', 'Meme Vice', 'BSCS 2-1', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS009', '18-01-0096', 'Meme Vice', 'BSCS 2-1', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '11 26 2019', '11 26 2019'),
('TRANS010', '18-01-0057', 'Mica Mediado', 'BSIT 2-2', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '11 26 2019', '11 26 2019'),
('TRANS011', '18-01-0096', 'Mica Mediado', 'BSIT 3-4', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS012', '18-01-0096', 'Mica Mediado', 'BSIT 3-4', 'aa002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '11 26 2019', '11 26 2019'),
('TRANS013', '19-09-9999', 'j', 'qq', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS014', '18-09-0099', 'jhgqhfqh', 'ge', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS015', '18-09-0099', 'jhgqhfqh', 'ge', 'aa002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '11 26 2019', '11 26 2019'),
('TRANS016', '11-11-1111', 'meme vice', 'vmdi 2-2', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS017', '11-11-1111', 'meme vice', 'vmdi 2-2', 'aa002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '11 26 2019', '11 26 2019'),
('TRANS018', '11-11-1111', 'q', 'q', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS019', '11-11-1111', 'wq', 'wq', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS020', '11-11-1111', 'wq', 'wq', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '11 26 2019', '11 26 2019'),
('TRANS021', '11-11-1111', 'q', 'q', 'aa001', 'Aiyuuu', 'mad company', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS022', '11-11-1111', 'w', 'w', 'aa003', 'Tukmol', 'Joshua Manalo', 'Filipino', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS023', '22-22-2222', 'q', 'q', 'aa002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
('TRANS024', '22-22-2222', 'q', 'q', 'aa002', 'Reading Comprehensive', 'James', 'English', 'Return Book', '11 26 2019', '11 26 2019'),
('TRANS025', '11-11-1111', 'hilot jason', 'BSIT 2-1', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '11 27 2019', '12 02 2019'),
('TRANS026', '18-01-0143', 'Nan', 'BSIT 2-1', 'AA005', 'Mama mu', 'Ako lang', 'English', 'Issue Book', '11 29 2019', '12 04 2019'),
('TRANS027', '18-01-0143', 'Nan', 'BSIT 2-1', 'AA005', 'Mama mu', 'Ako lang', 'English', 'Return Book', '11 29 2019', '11 29 2019'),
('TRANS028', '21', '21', '21', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '11 29 2019', '12 04 2019'),
('TRANS029', '23', '32', '32', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 29 2019', '12 04 2019'),
('TRANS030', '43', '43', '43', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '11 29 2019', '12 04 2019'),
('TRANS031', '54', '45', '54', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '11 29 2019', '12 04 2019'),
('TRANS032', 'q', 'q', 'q', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '11 06 2010', '11 11 2010'),
('TRANS033', 'q', 'q', 'q', 'aa003', 'Tukmol', 'Joshua Manalo', 'Filipino', 'Return Book', '11 26 2019', '11 06 2010'),
('TRANS034', '', '', '', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '', ''),
('TRANS035', '', '', '', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '', ''),
('TRANS036', '', '', '', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '', ''),
('TRANS037', '', '', '', 'AA005', 'Mama mu', 'Ako lang', 'English', 'Issue Book', '', ''),
('TRANS038', '', '', '', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '', ''),
('TRANS039', '', '', '', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '', ''),
('TRANS040', '', '', '', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '', ''),
('TRANS041', '', '', '', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '', ''),
('TRANS042', '', '', '', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '', ''),
('TRANS043', '18-01-0001', 'Ian Destura', 'BSIT 2-1', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '10 02 2010', '10 07 2010'),
('TRANS044', '18-01-0001', 'Ian Destura', 'BSIT 2-1', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '10 02 2010', '10 07 2010'),
('TRANS045', 'a', 'a', 'a', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '10 02 2010', '10 07 2010'),
('TRANS046', 'a', 'a', 'a', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '10 02 2010', '10 07 2010'),
('TRANS047', 'a', 'a', 'a', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Return Book', '11 27 2019', '10 02 2010'),
('TRANS048', 'a', 'a', 'a', 'AA003', 'Tukmol', 'Joshua Manalo', 'Filipino', 'Return Book', '11 26 2019', '10 01 2010'),
('TRANS049', '123123', 'ian destura', 'bsit 2-1', 'AA016', 'me', 'em', 'Mathematics', 'Issue Book', '10/01/2010', '10/06/2010'),
('TRANS050', '123123', 'ian destura', 'bsit 2-1', 'AA016', 'me', 'em', 'Mathematics', 'Return Book', '10/01/2010', '10/01/2010'),
('TRANS051', '123123', 'ian', 'ian', 'AA008', 'R', 'R', 'Arts', 'Issue Book', '10/01/2010', '10/06/2010'),
('TRANS052', '123123', 'ian', 'ian', 'AA009', 'TT', 'TT', 'Mathematics', 'Issue Book', '10/01/2010', '10/06/2010'),
('TRANS053', '123123', 'ian', 'ian', 'AA010', 'I', 'I', 'English', 'Issue Book', '10/01/2010', '10/06/2010'),
('TRANS054', '123123', 'ian', 'ian', 'AA008', 'R', 'R', 'Arts', 'Return Book', '10/01/2010', '10/01/2010'),
('TRANS055', '123123', 'ian', 'ian', 'aa009', 'TT', 'TT', 'Mathematics', 'Return Book', '10/01/2010', '10/01/2010'),
('TRANS056', '123123', 'ian', 'ian', 'AA016', 'me', 'em', 'Mathematics', 'Issue Book', '10/01/2010', '10/06/2010'),
('TRANS057', '123123', 'ian', 'ian', 'AA016', 'me', 'em', 'Mathematics', 'Return Book', '10/01/2010', '10/01/2010'),
('TRANS058', '123123', 'ian', 'bsit 2-1', 'AA010', 'I', 'I', 'English', 'Issue Book', '10/01/2010', '10/06/2010'),
('TRANS059', '123123', 'ian', 'bsit 2-1', 'AA011', 'J', 'J', 'Mathematics', 'Issue Book', '10/01/2010', '10/06/2010'),
('TRANS060', '123123', 'ian', 'bsit 2-1', 'AA012', 'CDCD', 'CDCD', 'Science', 'Issue Book', '10/01/2010', '10/06/2010'),
('TRANS061', '123123', '1231123', '123213', 'AA016', 'me', 'em', 'Mathematics', 'Issue Book', '10 01 2010', '10 06 2010'),
('TRANS062', '123123', '1231123', '123213', 'AA016', 'me', 'em', 'Mathematics', 'Return Book', '10 01 2010', '10 01 2010'),
('TRANS063', '123123', '123', '312', 'AA016', 'me', 'em', 'Mathematics', 'Issue Book', '10 01 2010', '10 06 2010'),
('TRANS064', '123123', '123', '312', 'AA016', 'me', 'em', 'Mathematics', 'Return Book', '10 01 2010', '10 01 2010'),
('TRANS065', '23', '23', '23', 'AA016', 'me', 'em', 'Mathematics', 'Issue Book', '10 01 2010', '10 06 2010'),
('TRANS066', '23', '23', '23', 'AA016', 'me', 'em', 'Mathematics', 'Return Book', '10 01 2010', '10 01 2010'),
('TRANS067', '123123', '123', '123', 'AA016', 'me', 'em', 'Mathematics', 'Issue Book', '10/01/2010', '10/06/2010');

-- --------------------------------------------------------

--
-- Table structure for table `db_libraryusers`
--

CREATE TABLE `db_libraryusers` (
  `id` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `name` varchar(300) NOT NULL,
  `studentNo` varchar(50) NOT NULL,
  `section` varchar(50) NOT NULL,
  `course` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_libraryusers`
--

INSERT INTO `db_libraryusers` (`id`, `date`, `time`, `name`, `studentNo`, `section`, `course`) VALUES
(14, '10/03/2010', '12:33', 'w', 'w', 'w', 'BSIT'),
(15, '10/03/2010', '12:37', 'q', 'q', 'q', 'BSIT'),
(16, '10/03/2010', '12:38', 'e', 'e', 'e', 'BSHM'),
(17, '10/03/2010', '12:39', 'z', 'z', 'z', 'BSBM'),
(18, '10/03/2010', '01:29', 'i', 'i', 'i', 'BSC'),
(19, '10/16/2010', '01:30', 'w', 'w', 'w', 'BSIT'),
(20, '10/16/2010', '01:36', 'w', 'q', 'q', 'BSCS'),
(21, '10/16/2010', '01:42', 'q', 'q', 'q', 'BSIT'),
(22, '10/30/2010', '01:46', 'q', 'q', 'q', 'BSCS'),
(23, '10/30/2010', '08:33', 'q', 'q', 'q', 'BSCS'),
(24, '10/31/2010', '08:35', 'w', 'w', 'w', 'BSBM'),
(25, '10/31/2010', '08:39', 'q', 'q', 'qq', 'BSCS'),
(26, '10/31/2010', '08:50', 'Q', 'Q', 'Q', 'BSCS'),
(27, '10/31/2010', '08:54', 'W', 'W', 'W', 'BSIT'),
(28, '10/31/2010', '03:43', 'w', 'w', 'w', 'BSIT'),
(29, '11/01/2010', '03:46', 'q', 'q', 'q', 'BSIT'),
(30, '11/02/2010', '03:54', 'e', 'e', 'e', 'BSIT'),
(31, '11/02/2010', '03:55', 'q', 'q', 'q', 'BSHM'),
(32, '11/02/2010', '03:57', 'S', 'S', 'S', 'BSIT'),
(33, '11/03/2010', '04:15', 'e', 'e', 'e', 'BSIT'),
(34, '11/03/2010', '08:52', 'w', 'w', 'w', 'BSIT'),
(35, '11/03/2010', '09:15', 'qqqqq', 'q', 'q', 'BSCS'),
(36, '11/03/2010', '09:36', 'q', 'q', 'q', 'BSCS'),
(37, '11/04/2010', '10:13', 'q', 'q', 'q', 'BSIT'),
(38, '11/04/2010', '10:15', 'q', 'q', 'q', 'BSHM'),
(39, '11/04/2010', '10:17', 'e', 'e', 'e', 'BSHM'),
(40, '11/05/2010', '11:45', 'q', 'q', 'q', 'BSCS'),
(41, '11/06/2010', '11:57', 's', 's', 's', 'BSIT'),
(42, '10/01/2010', '12:47', 'w', 'w', 'w', 'BSIT'),
(43, '01/07/2020', '09:55', 'q', 'q', 'q', 'BSIT');

-- --------------------------------------------------------

--
-- Table structure for table `db_signup`
--

CREATE TABLE `db_signup` (
  `id` varchar(50) NOT NULL,
  `last` varchar(50) NOT NULL,
  `first` varchar(50) NOT NULL,
  `middle` varchar(50) NOT NULL,
  `age` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `address` varchar(350) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `position` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_signup`
--

INSERT INTO `db_signup` (`id`, `last`, `first`, `middle`, `age`, `gender`, `address`, `contact`, `email`, `position`, `username`, `password`, `type`) VALUES
('CVSU003', 'q', 'q', 'q', '12', 'q', 'q', '09263665735', 'w', 'w', '123123', '123123', 'Librarian'),
('CVSU004', 'w', 'w', 'w', '12', 'ww', 'w', '09263665735', 'w', 'w', '111222', '123123', 'Librarian'),
('CVSU005', 'w', 'w', 'w', '12', 'ww', 'w', '09263665735', 'jdestura48@gmail.com', 'Teacher', 'ianpogi', '123123', 'Admin'),
('CVSU006', 'e', 'e', 'e', '12', 'eee', 'e', '09263665735', 'e', 'e', 'mica123', '123123', 'Librarian'),
('CVSU007', 'w', 'w', 'w', '15', 'w', 'w', '09263665735', 'w', 'w', 'mics123', '123123', 'Admin'),
('CVSU008', 'mmmm', 'm', 'm', '12', 'm', 'mm', '09263665735', 'm', 'm', 'meme123', '123123', 'Librarian');

-- --------------------------------------------------------

--
-- Table structure for table `db_transaction`
--

CREATE TABLE `db_transaction` (
  `transId` int(50) NOT NULL,
  `studentId` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL,
  `yearSection` varchar(50) NOT NULL,
  `bookId` varchar(100) NOT NULL,
  `title` varchar(200) NOT NULL,
  `author` varchar(200) NOT NULL,
  `category` varchar(50) NOT NULL,
  `action` varchar(100) NOT NULL,
  `date` varchar(50) NOT NULL,
  `duedate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_transaction`
--

INSERT INTO `db_transaction` (`transId`, `studentId`, `name`, `yearSection`, `bookId`, `title`, `author`, `category`, `action`, `date`, `duedate`) VALUES
(93, '11-11-1111', 'q', 'q', 'aa001', 'Aiyuuu', 'mad company', 'English', 'Issue Book', '11 26 2019', '12 01 2019'),
(94, '11-11-1111', 'w', 'w', 'aa003', 'Tukmol', 'Joshua Manalo', 'Filipino', 'Issue Book', '11 26 2019', '12 01 2019'),
(96, '11-11-1111', 'hilot jason', 'BSIT 2-1', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '11 27 2019', '12 02 2019'),
(98, '21', '21', '21', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '11 29 2019', '12 04 2019'),
(99, '23', '32', '32', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '11 29 2019', '12 04 2019'),
(100, '43', '43', '43', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '11 29 2019', '12 04 2019'),
(101, '54', '45', '54', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '11 29 2019', '12 04 2019'),
(102, '', '', '', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '', ''),
(103, '', '', '', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '', ''),
(104, '', '', '', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '', ''),
(105, '', '', '', 'AA005', 'Mama mu', 'Ako lang', 'English', 'Issue Book', '', ''),
(106, '', '', '', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '', ''),
(107, '', '', '', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '', ''),
(108, '', '', '', 'AA002', 'Reading Comprehensive', 'James', 'English', 'Issue Book', '', ''),
(109, '', '', '', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '', ''),
(110, '', '', '', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '', ''),
(111, '18-01-0001', 'Ian Destura', 'BSIT 2-1', 'AA003', 'Milk Tea', 'SMDC', 'History', 'Issue Book', '10 02 2010', '10 07 2010'),
(112, '18-01-0001', 'Ian Destura', 'BSIT 2-1', 'AA004', 'OOP', 'Maam Orchea', 'Computer', 'Issue Book', '10 02 2010', '10 07 2010'),
(117, '123123', 'ian', 'ian', 'AA010', 'I', 'I', 'English', 'Issue Book', '10/01/2010', '10/06/2010'),
(119, '123123', 'ian', 'bsit 2-1', 'AA010', 'I', 'I', 'English', 'Issue Book', '10/01/2010', '10/06/2010'),
(120, '123123', 'ian', 'bsit 2-1', 'AA011', 'J', 'J', 'Mathematics', 'Issue Book', '10/01/2010', '10/06/2010'),
(121, '123123', 'ian', 'bsit 2-1', 'AA012', 'CDCD', 'CDCD', 'Science', 'Issue Book', '10/01/2010', '10/06/2010'),
(125, '123123', '123', '123', 'AA016', 'me', 'em', 'Mathematics', 'Issue Book', '10/01/2010', '10/06/2010');

-- --------------------------------------------------------

--
-- Table structure for table `db_worklog`
--

CREATE TABLE `db_worklog` (
  `id` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `name` varchar(300) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `db_worklog`
--

INSERT INTO `db_worklog` (`id`, `date`, `type`, `name`, `status`) VALUES
(15, '10/01/2010 - 08:10', 'Admin', 'w w w', 'Delete Books'),
(16, '10/01/2010 - 08:33', 'Admin', 'w w w', 'Log Out'),
(17, '10/01/2010 - 08:54', 'Admin', 'w w w', 'Log In'),
(18, '10/01/2010 - 08:55', 'Admin', 'w w w', 'Issue Book'),
(19, '10/01/2010 - 08:55', 'Admin', 'w w w', 'Return Book'),
(20, '10/01/2010 - 08:56', 'Admin', 'w w w', 'Issue Book'),
(21, '10/01/2010 - 08:57', 'Admin', 'w w w', 'Access Authentication Code'),
(22, '10/01/2010 - 08:58', 'Admin', 'w w w', 'Create Admin Account'),
(23, '10/01/2010 - 08:59', 'Admin', 'w w w', 'Delete User'),
(24, '10/01/2010 - 08:59', 'Admin', 'w w w', 'Log Out'),
(25, '10/01/2010 - 09:00', 'Admin', 'w w w', 'Log In'),
(26, '10/01/2010 - 09:00', 'Admin', 'w w w', 'Log Out'),
(27, '10/01/2010 - 09:08', 'Admin', 'w w w', 'Log In'),
(28, '10/01/2010 - 09:09', 'Admin', 'w w w', 'Log Out'),
(29, '10/01/2010 - 09:12', 'Admin', 'w w w', 'Log In'),
(30, '10/01/2010 - 09:12', 'Admin', 'w w w', 'Issue Book');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `db_booklist`
--
ALTER TABLE `db_booklist`
  ADD PRIMARY KEY (`bookId`);

--
-- Indexes for table `db_code`
--
ALTER TABLE `db_code`
  ADD PRIMARY KEY (`code`);

--
-- Indexes for table `db_history`
--
ALTER TABLE `db_history`
  ADD PRIMARY KEY (`historyId`);

--
-- Indexes for table `db_libraryusers`
--
ALTER TABLE `db_libraryusers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `db_signup`
--
ALTER TABLE `db_signup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `db_transaction`
--
ALTER TABLE `db_transaction`
  ADD PRIMARY KEY (`transId`);

--
-- Indexes for table `db_worklog`
--
ALTER TABLE `db_worklog`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `db_libraryusers`
--
ALTER TABLE `db_libraryusers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `db_transaction`
--
ALTER TABLE `db_transaction`
  MODIFY `transId` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=126;

--
-- AUTO_INCREMENT for table `db_worklog`
--
ALTER TABLE `db_worklog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

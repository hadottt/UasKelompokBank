-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 19, 2020 at 09:23 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--
CREATE DATABASE IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bank`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('hadi', 123),
('di', 4848),
('ha', 52545),
('hadinata', 22222222);

-- --------------------------------------------------------

--
-- Table structure for table `nasabah`
--

DROP TABLE IF EXISTS `nasabah`;
CREATE TABLE `nasabah` (
  `no_rek` int(20) NOT NULL,
  `nik` int(20) DEFAULT NULL,
  `nama` varchar(25) DEFAULT NULL,
  `alamat` tinytext DEFAULT NULL,
  `jenis` varchar(25) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nasabah`
--

INSERT INTO `nasabah` (`no_rek`, `nik`, `nama`, `alamat`, `jenis`, `status`) VALUES
(123, 82541151, 'hadi', 'adada', '3', 'Aktif'),
(4848, 84848, 'di', '484', '1', 'Aktif'),
(52545, 825190000, 'ha', 'ada', '2', 'Aktif'),
(22222222, 825190063, 'hadinata', 'sadada', '3', 'Aktif');

-- --------------------------------------------------------

--
-- Table structure for table `saldo`
--

DROP TABLE IF EXISTS `saldo`;
CREATE TABLE `saldo` (
  `no_rek` int(10) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `jml_saldo` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `saldo`
--

INSERT INTO `saldo` (`no_rek`, `nama`, `jml_saldo`) VALUES
(123, 'hadi', 50000),
(4848, 'di', 0),
(52545, 'ha', 0),
(22222222, 'hadinata', 30000);

-- --------------------------------------------------------

--
-- Table structure for table `tagihan`
--

DROP TABLE IF EXISTS `tagihan`;
CREATE TABLE `tagihan` (
  `id_pel` int(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jml_tag` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tagihan`
--

INSERT INTO `tagihan` (`id_pel`, `nama`, `jml_tag`) VALUES
(22222222, 'hadi', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
CREATE TABLE `transaksi` (
  `tanggal` varchar(255) NOT NULL,
  `no_rek` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_rek_tujuan` varchar(20) NOT NULL,
  `D/K` char(1) NOT NULL,
  `keterangan` char(255) NOT NULL,
  `nominal` int(10) NOT NULL,
  `saldo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`tanggal`, `no_rek`, `nama`, `no_rek_tujuan`, `D/K`, `keterangan`, `nominal`, `saldo`) VALUES
('19-12-2020', '22222222', 'hadinata', ' - ', 'K', 'tarik', 10000, 60000),
('19-12-2020 08:18:01', '22222222', 'hadinata', ' - ', 'D', 'setor', 10000, 50000),
('19-12-2020 08:27:01', '22222222', 'hadinata', '123', 'K', 'Transfer', 10000, 60000),
('19-12-2020 08:29:34', '22222222', 'hadinata', '123', 'K', 'Transfer', 5000, 50000),
('19-12-2020 08:34:57', '22222222', 'hadinata', '123', 'K', 'Transfer', 5000, 45000),
('19-12-2020 08:58:54', '22222222', 'hadi', 'kosong', 'K', 'bayar listrik', 10000, 40000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `password` (`password`);

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`no_rek`);

--
-- Indexes for table `saldo`
--
ALTER TABLE `saldo`
  ADD PRIMARY KEY (`no_rek`);

--
-- Indexes for table `tagihan`
--
ALTER TABLE `tagihan`
  ADD PRIMARY KEY (`id_pel`),
  ADD UNIQUE KEY `nama` (`nama`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`tanggal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

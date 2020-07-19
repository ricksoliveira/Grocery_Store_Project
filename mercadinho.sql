-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jul 19, 2020 at 04:39 PM
-- Server version: 5.7.28
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mercadinho`
--

-- --------------------------------------------------------

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `ID_Produto` int(11) NOT NULL AUTO_INCREMENT,
  `Criacao` varchar(20) NOT NULL,
  `Alteracao` varchar(20) DEFAULT NULL,
  `Descricao` varchar(45) NOT NULL,
  `Quantidade` int(11) NOT NULL,
  `Preco` double NOT NULL,
  `Status` varchar(12) NOT NULL,
  PRIMARY KEY (`ID_Produto`),
  KEY `Alteracao` (`Alteracao`),
  KEY `Criacao` (`Criacao`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `Login_Usuario` varchar(20) NOT NULL,
  `Senha` varchar(12) NOT NULL,
  `Admin` int(11) NOT NULL,
  PRIMARY KEY (`Login_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`Login_Usuario`, `Senha`, `Admin`) VALUES
('root', '123', 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`Alteracao`) REFERENCES `usuario` (`Login_Usuario`),
  ADD CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`Criacao`) REFERENCES `usuario` (`Login_Usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

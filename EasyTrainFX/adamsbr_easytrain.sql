-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: mysql-adamsbr.alwaysdata.net
-- Generation Time: Mar 07, 2025 at 02:02 PM
-- Server version: 10.11.11-MariaDB
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `adamsbr_easytrain`
--

-- --------------------------------------------------------

--
-- Table structure for table `Arret`
--

CREATE TABLE `Arret` (
  `id` int(3) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `type_d_arret` enum('terminus','intermediaire') NOT NULL DEFAULT 'intermediaire'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Dumping data for table `Arret`
--

INSERT INTO `Arret` (`id`, `nom`, `type_d_arret`) VALUES
(1, 'Gare de Meulan', 'terminus'),
(2, 'Cergy prefecture', 'intermediaire'),
(3, 'Gare de Saint Lazare', 'terminus');

-- --------------------------------------------------------

--
-- Table structure for table `Trajet`
--

CREATE TABLE `Trajet` (
  `code` varchar(50) NOT NULL,
  `tempsDepart` datetime NOT NULL,
  `tempsArrivee` datetime NOT NULL,
  `arretDepart_id` int(3) DEFAULT NULL,
  `arretArrivee_id` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Dumping data for table `Trajet`
--

INSERT INTO `Trajet` (`code`, `tempsDepart`, `tempsArrivee`, `arretDepart_id`, `arretArrivee_id`) VALUES
('T123', '2024-10-04 08:00:00', '2024-10-04 09:00:00', 1, 2),
('T124', '2024-10-04 14:00:00', '2024-10-04 15:00:00', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `id` int(3) NOT NULL,
  `login` varchar(30) NOT NULL,
  `mdp` varchar(256) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `dateEmbauche` datetime NOT NULL,
  `role` enum('ADMIN','EMPLOYE') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Dumping data for table `Utilisateur`
--

INSERT INTO `Utilisateur` (`id`, `login`, `mdp`, `nom`, `prenom`, `dateEmbauche`, `role`) VALUES
(1, 'Adam', 'mdp123', 'Sabor', 'Adam', '2023-05-10 09:00:00', 'ADMIN'),
(2, 'Wissam', 'mdp456', 'Sabor', 'Wissam', '2023-08-13 09:00:00', 'EMPLOYE');

--
-- Triggers `Utilisateur`
--
-- Triggers `pour insert dans Utilisateur`
DELIMITER $$
CREATE TRIGGER `verif_nom_utilisateur_insert` BEFORE INSERT ON `Utilisateur` FOR EACH ROW BEGIN
    IF LOWER(NEW.nom) = 'test' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Erreur : le nom ne peut pas être "test" .';
    END IF;
END
$$
DELIMITER ;

-- Triggers `pour updat   dans Utilisateur`
DELIMITER $$
CREATE TRIGGER `verif_nom_utilisateur_update` BEFORE UPDATE ON `Utilisateur` FOR EACH ROW BEGIN
    IF LOWER(NEW.nom) = 'test' THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Erreur : le nom ne peut pas être "test" .';
    END IF;
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Arret`
--
ALTER TABLE `Arret`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Trajet`
--
ALTER TABLE `Trajet`
  ADD PRIMARY KEY (`code`),
  ADD KEY `arretDepart_id` (`arretDepart_id`),
  ADD KEY `arretArrivee_id` (`arretArrivee_id`);

--
-- Indexes for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Arret`
--
ALTER TABLE `Arret`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Trajet`
--
ALTER TABLE `Trajet`
  ADD CONSTRAINT `trajet_ibfk_1` FOREIGN KEY (`arretDepart_id`) REFERENCES `Arret` (`id`),
  ADD CONSTRAINT `trajet_ibfk_2` FOREIGN KEY (`arretArrivee_id`) REFERENCES `Arret` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

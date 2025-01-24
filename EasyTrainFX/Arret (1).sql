-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : ven. 24 jan. 2025 à 13:29
-- Version du serveur : 5.7.39
-- Version de PHP : 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `EasyTrain`
--

-- --------------------------------------------------------

--
-- Structure de la table `Arret`
--

CREATE TABLE `Arret` (
  `id` int(3) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `type_d_arret` enum('terminus','intermediaire') NOT NULL DEFAULT 'intermediaire'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Arret`
--

INSERT INTO `Arret` (`id`, `nom`, `type_d_arret`) VALUES
(1, 'Gare de Meulan', 'terminus'),
(2, 'Cergy prefecture', 'intermediaire'),
(3, 'Gare de Saint Lazare', 'terminus');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Arret`
--
ALTER TABLE `Arret`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Arret`
--
ALTER TABLE `Arret`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : dim. 29 sep. 2024 à 14:00
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
  `id` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `ville` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Arret`
--

INSERT INTO `Arret` (`id`, `nom`, `ville`) VALUES
(1, 'Gare de Meulan', 'Meulan'),
(2, 'Cergy prefecture', 'Cergy'),
(3, 'Gare de Saint Lazare', 'Paris');

-- --------------------------------------------------------

--
-- Structure de la table `Trajet`
--

CREATE TABLE `Trajet` (
  `id` int(11) NOT NULL,
  `heureDepart` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Trajet`
--

INSERT INTO `Trajet` (`id`, `heureDepart`) VALUES
(1, '08:00:00'),
(2, '14:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `Trajet_Arret`
--

CREATE TABLE `Trajet_Arret` (
  `trajet_id` int(11) NOT NULL,
  `arret_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Trajet_Arret`
--

INSERT INTO `Trajet_Arret` (`trajet_id`, `arret_id`) VALUES
(1, 1),
(1, 2),
(2, 2),
(2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `motDePasse` varchar(100) DEFAULT NULL,
  `dateDeNaissance` date DEFAULT NULL,
  `role` enum('ADMIN','PASSAGER') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`id`, `nom`, `prenom`, `email`, `motDePasse`, `dateDeNaissance`, `role`) VALUES
(3, 'Adam', 'Sabor', 'saboradam5@gmail.com', 'mdp123', '2003-05-05', 'ADMIN'),
(4, 'Wissam', 'Sabor', 'wissamsabor@gmail.com', 'mdp456', '2006-08-13', 'PASSAGER');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Arret`
--
ALTER TABLE `Arret`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Trajet`
--
ALTER TABLE `Trajet`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `Trajet_Arret`
--
ALTER TABLE `Trajet_Arret`
  ADD PRIMARY KEY (`trajet_id`,`arret_id`),
  ADD KEY `arret_id` (`arret_id`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Arret`
--
ALTER TABLE `Arret`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `Trajet`
--
ALTER TABLE `Trajet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Trajet_Arret`
--
ALTER TABLE `Trajet_Arret`
  ADD CONSTRAINT `trajet_arret_ibfk_1` FOREIGN KEY (`trajet_id`) REFERENCES `Trajet` (`id`),
  ADD CONSTRAINT `trajet_arret_ibfk_2` FOREIGN KEY (`arret_id`) REFERENCES `Arret` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

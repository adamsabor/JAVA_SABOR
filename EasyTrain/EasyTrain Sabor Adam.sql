-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : ven. 04 oct. 2024 à 16:52
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
  `nom` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Arret`
--

INSERT INTO `Arret` (`id`, `nom`) VALUES
(1, 'Gare de Meulan'),
(2, 'Cergy prefecture'),
(3, 'Gare de Saint Lazare');

-- --------------------------------------------------------

--
-- Structure de la table `Trajet`
--

CREATE TABLE `Trajet` (
  `code` varchar(50) NOT NULL,
  `tempsDepart` datetime NOT NULL,
  `tempsArrivee` datetime NOT NULL,
  `arretDepart_id` int(3) DEFAULT NULL,
  `arretArrivee_id` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Trajet`
--

INSERT INTO `Trajet` (`code`, `tempsDepart`, `tempsArrivee`, `arretDepart_id`, `arretArrivee_id`) VALUES
('T123', '2024-10-04 08:00:00', '2024-10-04 09:00:00', 1, 2),
('T124', '2024-10-04 14:00:00', '2024-10-04 15:00:00', 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE `Utilisateur` (
  `id` int(3) NOT NULL,
  `login` varchar(30) NOT NULL,
  `mdp` varchar(256) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `dateEmbauche` datetime NOT NULL,
  `role` enum('ADMIN','EMPLOYE') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`id`, `login`, `mdp`, `nom`, `prenom`, `dateEmbauche`, `role`) VALUES
(1, 'Adam', 'mdp123', 'Sabor', 'Adam', '2023-05-10 09:00:00', 'ADMIN'),
(2, 'Wissam', 'mdp456', 'Sabor', 'Wissam', '2023-08-13 09:00:00', 'EMPLOYE');

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
  ADD PRIMARY KEY (`code`),
  ADD KEY `arretDepart_id` (`arretDepart_id`),
  ADD KEY `arretArrivee_id` (`arretArrivee_id`);

--
-- Index pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Arret`
--
ALTER TABLE `Arret`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `Utilisateur`
--
ALTER TABLE `Utilisateur`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Trajet`
--
ALTER TABLE `Trajet`
  ADD CONSTRAINT `trajet_ibfk_1` FOREIGN KEY (`arretDepart_id`) REFERENCES `Arret` (`id`),
  ADD CONSTRAINT `trajet_ibfk_2` FOREIGN KEY (`arretArrivee_id`) REFERENCES `Arret` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

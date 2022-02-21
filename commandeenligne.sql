-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 01 jan. 2022 à 00:00
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `commandeenligne`
--

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `active` bit(1) NOT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `delivery_address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`id`, `active`, `contact`, `delivery_address`, `name`) VALUES
(1, b'0', '96640137', 'Ezaahra,cité El Amal', 'firas'),
(2, b'0', '95352972', 'Ezzahra, cité El Amal', 'Ayoub'),
(3, b'0', '55525415', 'Ariana,cité Essaha', 'Ahmed'),
(4, b'1', '93250500', 'Manouba, Cité khaznadar', 'Khaled'),
(5, b'0', '95667258', 'Ariana,raouad cité Al amal', 'Med ali'),
(6, b'1', '7715030', 'Ariana, cité El ghazela', 'Rafik');

-- --------------------------------------------------------

--
-- Structure de la table `customer_orders`
--

CREATE TABLE `customer_orders` (
  `customer_id` int(11) NOT NULL,
  `orders_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `delivery`
--

CREATE TABLE `delivery` (
  `id` int(11) NOT NULL,
  `delivery_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `shopping_date` date DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `delivery`
--

INSERT INTO `delivery` (`id`, `delivery_date`, `name`, `shopping_date`, `order_id`) VALUES
(1, '2021-12-15', 'Amine', '2021-12-14', 13),
(2, '2021-12-08', 'Amine', '2021-12-05', 18),
(3, '2021-12-17', 'Anis', '2021-12-14', 17),
(4, '2021-12-13', 'Anis', '2021-12-11', 15),
(5, '2021-12-29', 'Amine', '2021-12-28', 12),
(6, '2021-12-24', 'Amine', '2021-12-23', 14),
(7, '2021-12-20', 'Anis', '2021-12-16', 16),
(8, '2021-12-03', 'Anis', '2021-12-01', 16),
(9, '2021-12-08', 'Fedi', '2021-12-08', 15);

-- --------------------------------------------------------

--
-- Structure de la table `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `weight` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `item`
--

INSERT INTO `item` (`id`, `description`, `price`, `weight`) VALUES
(1, 'fromage', 15, 250),
(2, 'jambon', 10, 300),
(3, 'Scalope dinde', 15, 400),
(4, 'Poulet', 20, 450),
(5, 'Scalope poulet', 25, 500),
(6, 'Steak de dinde', 15, 350);

-- --------------------------------------------------------

--
-- Structure de la table `order_customer`
--

CREATE TABLE `order_customer` (
  `id` int(11) NOT NULL,
  `create_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `order_customer`
--

INSERT INTO `order_customer` (`id`, `create_date`, `status`, `customer_id`) VALUES
(1, '2021-12-27', 'DELIVERED', 1),
(12, '2021-12-05', 'CREATE', 1),
(13, '2021-11-01', 'DELIVERED', 2),
(14, '2021-11-02', 'PAID', 2),
(15, '2021-10-30', 'PAID', 1),
(16, '2021-10-31', 'PAID', 2),
(17, '2021-11-10', 'PAID', 3),
(18, '2021-11-17', 'DELIVERED', 3),
(19, '2021-12-05', 'PAID', 4),
(20, '2021-12-31', 'PAID', 4),
(21, '2021-12-24', 'PAID', 5),
(22, '2021-12-26', 'PAID', 6);

-- --------------------------------------------------------

--
-- Structure de la table `order_detail`
--

CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `tax` float NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `order_detail`
--

INSERT INTO `order_detail` (`id`, `qty`, `tax`, `item_id`, `order_id`) VALUES
(1, 2, 15, 3, 1),
(2, 10, 10, 4, 14),
(3, 10, 5, 5, 18),
(4, 10, 15, 3, 16),
(5, 11, 15, 3, 13),
(6, 15, 6.5, 6, 12),
(7, 25, 5, 1, 15),
(8, 30, 15, 3, 17),
(9, 30, 5, 5, 19),
(10, 40, 6.5, 6, 20),
(11, 13, 6.5, 6, 21),
(12, 17, 6.5, 6, 22);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `customer_orders`
--
ALTER TABLE `customer_orders`
  ADD UNIQUE KEY `UK_4m0sjmnfkb97mpn89e5xnw3v3` (`orders_id`),
  ADD KEY `FK7ntkighomv9fa5287rev8a3wy` (`customer_id`);

--
-- Index pour la table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlnjwoojp1bp15965y13ogqorf` (`order_id`);

--
-- Index pour la table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `order_customer`
--
ALTER TABLE `order_customer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt9ws53lpvx6c4h3gp3k03duq3` (`customer_id`);

--
-- Index pour la table `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4dtqbi7ilse9x730y087wagm2` (`item_id`),
  ADD KEY `FKbs1c4y9spdxpx1dhssyvqmitn` (`order_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `item`
--
ALTER TABLE `item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `order_customer`
--
ALTER TABLE `order_customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `customer_orders`
--
ALTER TABLE `customer_orders`
  ADD CONSTRAINT `FK7ntkighomv9fa5287rev8a3wy` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKr6h6vlt79oqrx3mie5beuq5gp` FOREIGN KEY (`orders_id`) REFERENCES `order_customer` (`id`);

--
-- Contraintes pour la table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `FKlnjwoojp1bp15965y13ogqorf` FOREIGN KEY (`order_id`) REFERENCES `order_customer` (`id`);

--
-- Contraintes pour la table `order_customer`
--
ALTER TABLE `order_customer`
  ADD CONSTRAINT `FKt9ws53lpvx6c4h3gp3k03duq3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Contraintes pour la table `order_detail`
--
ALTER TABLE `order_detail`
  ADD CONSTRAINT `FK4dtqbi7ilse9x730y087wagm2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `FKbs1c4y9spdxpx1dhssyvqmitn` FOREIGN KEY (`order_id`) REFERENCES `order_customer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

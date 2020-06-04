CREATE SCHEMA IF NOT EXISTS nomads_bdd DEFAULT CHARACTER SET utf8mb4;
USE nomads_bdd;

--
-- Table structure for table `ville`
--

DROP TABLE IF EXISTS `ville`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ville` (
  `id_ville` bigint(20) NOT NULL AUTO_INCREMENT,
  `code_postal` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ville`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adresse` (
  `id_adresse` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle_adresse` varchar(255) DEFAULT NULL,
  `id_ville` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_adresse`),
  KEY `FKj4b3a8rme34kwf9x76apbhrvt` (`id_ville`),
  CONSTRAINT `FKj4b3a8rme34kwf9x76apbhrvt` FOREIGN KEY (`id_ville`) REFERENCES `ville` (`id_ville`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `status_masseur`
--

DROP TABLE IF EXISTS `status_masseur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status_masseur` (
  `id_status` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `credentials`
--

DROP TABLE IF EXISTS `credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credentials` (
  `id_credential` bigint(20) NOT NULL AUTO_INCREMENT,
  `hashed_password` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_credential`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `id_discriminator_utilisateur` varchar(31) NOT NULL,
  `id_utilisateur` bigint(20) NOT NULL AUTO_INCREMENT,
  `numero_siret` varchar(255) DEFAULT NULL,
  `raison_sociale` varchar(255) DEFAULT NULL,
  `actif` bit(1) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `nom_masseur` varchar(255) DEFAULT NULL,
  `porte_monnaie` bigint(20) DEFAULT NULL,
  `prenom_masseur` varchar(255) DEFAULT NULL,
  `id_adresse` bigint(20) DEFAULT NULL,
  `id_credential` bigint(20) DEFAULT NULL,
  `id_status` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_utilisateur`),
  KEY `FKnyi5gbai4jrvhqq5qeyabkqkb` (`id_adresse`),
  KEY `FKngp6c9qql542serwc04ev6eqy` (`id_credential`),
  KEY `FKjc763w7nffcjpsg9nhc5cuc92` (`id_status`),
  CONSTRAINT `FKjc763w7nffcjpsg9nhc5cuc92` FOREIGN KEY (`id_status`) REFERENCES `status_masseur` (`id_status`),
  CONSTRAINT `FKngp6c9qql542serwc04ev6eqy` FOREIGN KEY (`id_credential`) REFERENCES `credentials` (`id_credential`),
  CONSTRAINT `FKnyi5gbai4jrvhqq5qeyabkqkb` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`id_adresse`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `commande`
--

DROP TABLE IF EXISTS `commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commande` (
  `id_commande` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime(6) DEFAULT NULL,
  `id_masseur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `FK5mxwotsrt7cjexsxhxhi30p0o` (`id_masseur`),
  CONSTRAINT `FK5mxwotsrt7cjexsxhxhi30p0o` FOREIGN KEY (`id_masseur`) REFERENCES `utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `titre`
--

DROP TABLE IF EXISTS `titre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `titre` (
  `id_titre` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_titre`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id_contact` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `contact_nom` varchar(255) DEFAULT NULL,
  `numero_telephone` varchar(255) DEFAULT NULL,
  `fonction_niveau` varchar(255) DEFAULT NULL,
  `contact_prenom` varchar(255) DEFAULT NULL,
  `id_titre` bigint(20) DEFAULT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_contact`),
  KEY `FKo5116txuq7f9uh9jkxqrax2er` (`id_titre`),
  KEY `FKcxudgkq3qip5ocxbckdox59dm` (`id_utilisateur`),
  CONSTRAINT `FKcxudgkq3qip5ocxbckdox59dm` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`),
  CONSTRAINT `FKo5116txuq7f9uh9jkxqrax2er` FOREIGN KEY (`id_titre`) REFERENCES `titre` (`id_titre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `disponibilite`
--

DROP TABLE IF EXISTS `disponibilite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `disponibilite` (
  `id_disponibilite` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime(6) DEFAULT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_disponibilite`),
  KEY `FKq02iax1jwbbd157pamf9a0nwe` (`id_utilisateur`),
  CONSTRAINT `FKq02iax1jwbbd157pamf9a0nwe` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id_type` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `status_lieu`
--

DROP TABLE IF EXISTS `status_lieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `status_lieu` (
  `id_status` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produit` (
  `id_discriminator_produit` varchar(31) NOT NULL,
  `id_produit` bigint(20) NOT NULL AUTO_INCREMENT,
  `prix_credit` bigint(20) DEFAULT NULL,
  `prix_euro` double DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `couleur` varchar(255) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `modele` varchar(255) DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `taille` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `nombre_credit` bigint(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `heure_debut` time DEFAULT NULL,
  `heure_debut_imperative` bit(1) DEFAULT NULL,
  `heure_fin` time DEFAULT NULL,
  `tournee_imperative` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lieu` (
  `id_lieu` bigint(20) NOT NULL AUTO_INCREMENT,
  `actif` bit(1) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `id_adresse` bigint(20) DEFAULT NULL,
  `id_commanditaire` bigint(20) DEFAULT NULL,
  `id_status` bigint(20) DEFAULT NULL,
  `id_type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_lieu`),
  KEY `FKmde9ni48w4fb5qo2qr7lh25cp` (`id_adresse`),
  KEY `FK50eakjxs4rbokxnflaxrixfbc` (`id_commanditaire`),
  KEY `FKkkosyf9xye7obvqagen2earby` (`id_status`),
  KEY `FK5wl4ba9yi5iuufqwklb97enye` (`id_type`),
  CONSTRAINT `FK50eakjxs4rbokxnflaxrixfbc` FOREIGN KEY (`id_commanditaire`) REFERENCES `utilisateur` (`id_utilisateur`),
  CONSTRAINT `FK5wl4ba9yi5iuufqwklb97enye` FOREIGN KEY (`id_type`) REFERENCES `type` (`id_type`),
  CONSTRAINT `FKkkosyf9xye7obvqagen2earby` FOREIGN KEY (`id_status`) REFERENCES `status_lieu` (`id_status`),
  CONSTRAINT `FKmde9ni48w4fb5qo2qr7lh25cp` FOREIGN KEY (`id_adresse`) REFERENCES `adresse` (`id_adresse`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lieu_tournee`
--

DROP TABLE IF EXISTS `lieu_tournee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lieu_tournee` (
  `id_lieu_tournee` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_lieu` bigint(20) DEFAULT NULL,
  `id_tournee` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_lieu_tournee`),
  KEY `FKrfpuqrernxwb8qs8lemp48nyl` (`id_lieu`),
  KEY `FK2ufhlf5ccvw6wh0itveeww7et` (`id_tournee`),
  CONSTRAINT `FK2ufhlf5ccvw6wh0itveeww7et` FOREIGN KEY (`id_tournee`) REFERENCES `produit` (`id_produit`),
  CONSTRAINT `FKrfpuqrernxwb8qs8lemp48nyl` FOREIGN KEY (`id_lieu`) REFERENCES `lieu` (`id_lieu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lieu_compte_rendu`
--

DROP TABLE IF EXISTS `lieu_compte_rendu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lieu_compte_rendu` (
  `id_lieu_compte_rendu` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentaire` varchar(255) DEFAULT NULL,
  `id_lieu_compte_rendus` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_lieu_compte_rendu`),
  KEY `FKqf3t521snwltn6r381bmq6w98` (`id_lieu_compte_rendus`),
  CONSTRAINT `FKqf3t521snwltn6r381bmq6w98` FOREIGN KEY (`id_lieu_compte_rendus`) REFERENCES `lieu_tournee` (`id_lieu_tournee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ligne_commande`
--

DROP TABLE IF EXISTS `ligne_commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ligne_commande` (
  `id_ligne_commande` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_produit` int(11) DEFAULT NULL,
  `id_commande` bigint(20) DEFAULT NULL,
  `id_produit` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_ligne_commande`),
  KEY `FKf3ttmql7i67fw0oyon0im086n` (`id_commande`),
  KEY `FKdm6vi9v9tfwh696qd8yqf8iqs` (`id_produit`),
  CONSTRAINT `FKdm6vi9v9tfwh696qd8yqf8iqs` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`),
  CONSTRAINT `FKf3ttmql7i67fw0oyon0im086n` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `masseur_compte_rendu`
--

DROP TABLE IF EXISTS `masseur_compte_rendu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `masseur_compte_rendu` (
  `id_masseur_compte_rendu` bigint(20) NOT NULL AUTO_INCREMENT,
  `commentaire` varchar(255) DEFAULT NULL,
  `nombre_massage` int(11) DEFAULT NULL,
  `revenu` double DEFAULT NULL,
  PRIMARY KEY (`id_masseur_compte_rendu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `masseur_tournee`
--

DROP TABLE IF EXISTS `masseur_tournee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `masseur_tournee` (
  `id_masseur_tournee` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_masseur` bigint(20) DEFAULT NULL,
  `id_masseur_compte_rendu` bigint(20) DEFAULT NULL,
  `id_tournee` bigint(20) DEFAULT NULL,
  `id_masseur_tournees` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_masseur_tournee`),
  KEY `FKjn1kc803rxj8eit6m30g4tmw3` (`id_masseur`),
  KEY `FKirumcksd0un6hf92jbl4t9ief` (`id_masseur_compte_rendu`),
  KEY `FKlono37tvew266txyu3hs1wet3` (`id_tournee`),
  KEY `FK5i2apl1ho2wpyisnbebdaosab` (`id_masseur_tournees`),
  CONSTRAINT `FK5i2apl1ho2wpyisnbebdaosab` FOREIGN KEY (`id_masseur_tournees`) REFERENCES `utilisateur` (`id_utilisateur`),
  CONSTRAINT `FKirumcksd0un6hf92jbl4t9ief` FOREIGN KEY (`id_masseur_compte_rendu`) REFERENCES `masseur_compte_rendu` (`id_masseur_compte_rendu`),
  CONSTRAINT `FKjn1kc803rxj8eit6m30g4tmw3` FOREIGN KEY (`id_masseur`) REFERENCES `utilisateur` (`id_utilisateur`),
  CONSTRAINT `FKlono37tvew266txyu3hs1wet3` FOREIGN KEY (`id_tournee`) REFERENCES `produit` (`id_produit`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


SET FOREIGN_KEY_CHECKS = 0;

/* PACK_CREDIT */
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_euro`, `libelle`, `nombre_credit`) VALUES ('PACK_CREDIT', '16.50', 'Pack 05 Mads', '5');
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_euro`, `libelle`, `nombre_credit`) VALUES ('PACK_CREDIT', '32.90', 'Pack 10 Mads', '10');
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_euro`, `libelle`, `nombre_credit`) VALUES ('PACK_CREDIT', '44.90', 'Pack 15 Mads', '15');

/* TOURNEE */
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '2', '2020-01-01', '14:00', FALSE, '18:00', FALSE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '3', '2020-01-02', '18:00', FALSE, '22:00', TRUE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '4', '2020-01-02', '20:00', TRUE, '00:00', FALSE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '5', '2020-01-02', '22:00', TRUE, '02:00', TRUE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '2', '2019-12-25', '14:00', FALSE, '18:00', FALSE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '3', '2019-12-25', '18:00', FALSE, '22:00', TRUE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '4', '2019-12-26', '20:00', TRUE, '00:00', FALSE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '5', '2019-12-26', '22:00', TRUE, '02:00', TRUE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '2', '2019-12-26', '14:00', FALSE, '18:00', FALSE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '3', '2019-12-27', '18:00', FALSE, '22:00', TRUE);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_credit`, `date`, `heure_debut`, `heure_debut_imperative`, `heure_fin`, `tournee_imperative`) VALUES ('TOURNEE', '4', '2019-12-27', '20:00', TRUE, '00:00', FALSE);

/* MATERIEL */
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_euro`, `categorie`, `couleur`, `marque`, `modele`, `taille`, `quantite`) VALUES ('MATERIEL', '49.00', 'T- Shirt', 'Bordeau', 'Nomads', 'Femme', 'S', 14);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_euro`, `categorie`, `couleur`, `marque`, `modele`, `taille`, `quantite`) VALUES ('MATERIEL', '49.00', 'T- Shirt', 'Bordeau', 'Nomads', 'Homme', 'M', 23);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_euro`, `categorie`, `couleur`, `marque`, `quantite`) VALUES ('MATERIEL', '39.90', 'Terminal Paiement', 'Blanc', 'Sumup', 7);
INSERT INTO `nomads_bdd`.`produit` (`id_discriminator_produit`, `prix_euro`, `categorie`, `couleur`, `marque`, `quantite`) VALUES ('MATERIEL', '74.90', 'Chaise Ergonomique', 'Noir', 'Naipo ', 11);

/* Ville */
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75001', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75002', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75003', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75004', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75005', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75006', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75007', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75008', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75009', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75010', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75011', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75012', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75013', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75014', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75015', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75016', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75017', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75018', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75019', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ('75020', 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91640', 'Janvry');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91800', 'Brunoy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91790', 'Boissy-sous-Saint-Yon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91940', 'Villebon-sur-Yvette');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91930', 'Monnerville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91720', 'Gironville-sur-Essonne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91780', 'Saint-Hilaire');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91090', 'Évry');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91630', 'Leudeville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91720', 'Valpuiseaux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Dourdan');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91660', 'Estouches');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91210', 'Draveil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Marolles-en-Beauce');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91540', 'Mennecy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91350', 'Grigny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91710', 'Vert-le-Petit');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91490', 'Oncy-sur-École');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91690', 'Guillerval');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91320', 'Wissous');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91820', 'Vayres-sur-Essonne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Abbéville-la-Rivière');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91630', 'Avrainville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91000', 'Ris-Orangis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91440', 'Bures-sur-Yvette');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91120', 'Palaiseau');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91290', 'Arpajon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91590', 'Guigneville-sur-Essonne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91360', 'Épinay-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Blandy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91800', 'Boussy-Saint-Antoine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91100', 'Villabé');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91620', 'La Ville-du-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91470', 'Angervilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91540', 'Écharcon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91540', 'Ormoy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91590', 'Cerny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91370', 'Verrières-le-Buisson');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91590', 'Boissy-le-Cutté');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91560', 'Crosne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91490', 'Moigny-sur-École');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91310', 'Longpont-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91590', 'Mondeville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91240', 'Saint-Michel-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91160', 'Ballainvilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91140', 'Villejust');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Saint-Escobille');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91280', 'Saint-Pierre-du-Perray');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91780', 'Mérobert');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91610', 'Ballancourt-sur-Essonne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91720', 'Maisse');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91730', 'Chamarande');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91490', 'Milly-la-Forêt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91650', 'Breux-Jouy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91220', 'Le Plessis-Pâté');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91580', 'Auvers-Saint-Georges');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91830', 'Auvernaux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91250', 'Morsang-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91270', 'Vigneux-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91750', 'Champcueil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91080', 'Courcouronnes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91720', 'Boigneville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91580', 'Étréchy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Authon-la-Plaine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91690', 'Boissy-la-Rivière');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91250', 'Saintry-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91310', 'Montlhéry');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91700', 'Fleury-Mérogis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91910', 'Saint-Sulpice-de-Favières');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91480', 'Varennes-Jarcy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91890', 'Vid_villeelles');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91480', 'Quincy-sous-Sénart');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91590', 'Orveau');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Granges-le-Roi');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91940', 'Gometz-le-Châtel');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91820', 'Boutigny-sur-Essonne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91660', 'Méréville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Boutervilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91730', 'Mauchamps');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91430', 'Igny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91170', 'Viry-Châtillon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91880', 'Bouville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Étampes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91400', 'Gometz-la-Ville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91690', 'Arrancourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91570', 'Bièvres');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91590', 'D''Huison-Longueville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Chatignonville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91490', 'Dannemois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91750', 'Chevannes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91470', 'Forges-les-Bains');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91670', 'Angerville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91100', 'Corbeil-Essonnes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91530', 'Le Val-Saint-Germain');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Puiselet-le-Marais');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Bois-Herpin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91400', 'Orsay');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91250', 'Tigery');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91540', 'Fontenay-le-Vicomte');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91300', 'Massy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91590', 'La Ferté-Alais');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91330', 'Yerres');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91550', 'Paray-Vieille-Poste');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91180', 'Saint-Germain-lès-Arpajon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91530', 'Saint-Maurice-Montcouronne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91190', 'Gif-sur-Yvette');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91740', 'Pussay');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91420', 'Morangis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91700', 'Villiers-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'La Forêt-Sainte-Croix');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91630', 'Guibeville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91380', 'Chilly-Mazarin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Champmotteux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91850', 'Bouray-sur-Juine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91840', 'Soisy-sur-École');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91580', 'Souzy-la-Briche');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91290', 'La Norville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91860', 'Épinay-sous-Sénart');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Brières-les-Scellés');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91750', 'Nainville-les-Roches');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91940', 'Ulis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91200', 'Athis-Mons');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91310', 'Leuville-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91450', 'Soisy-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91640', 'Fontenay-lès-Briis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91690', 'Saint-Cyr-la-Rivière');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91090', 'Lisses');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91590', 'Baulne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91640', 'Briis-sous-Forges');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91620', 'Nozay');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Ormoy-la-Rivière');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91160', 'Champlan');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Roinvilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Richarville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91680', 'Courson-Monteloup');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91740', 'Congerville-Thionville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91460', 'Marcoussis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91470', 'Boullay-les-Troux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'La Forêt-le-Roi');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91640', 'Vaugrigneuse');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91510', 'Janville-sur-Juine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91450', 'Étiolles');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91310', 'Linas');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91690', 'Saclas');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91580', 'Chauffour-lès-Étréchy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91940', 'Saint-Jean-de-Beauregard');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91390', 'Morsang-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91260', 'Juvisy-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91780', 'Chalo-Saint-Mars');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91430', 'Vauhallan');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91740', 'Chalou-Moulineux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91810', 'Vert-le-Grand');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91230', 'Montgeron');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91160', 'Saulx-les-Chartreux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91470', 'Pecqueuse');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Corbreuse');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91220', 'Brétigny-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91870', 'Boissy-le-Sec');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91360', 'Villemoisson-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91530', 'Saint-Chéron');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91070', 'Bondoufle');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91830', 'Le Coudray-Montceaux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Roinville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Brouy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91770', 'Saint-Vrain');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91530', 'Sermaise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91190', 'Saint-Aubin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91580', 'Villeneuve-sur-Auvers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91400', 'Saclay');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91520', 'Égly');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Morigny-Champigny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91720', 'Prunay-sur-Essonne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91250', 'Saint-Germain-lès-Corbeil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91720', 'Buno-Bonnevaux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91730', 'Torfou');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91690', 'Fontaine-la-Rivière');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91760', 'Itteville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91650', 'Breuillet');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91190', 'Villiers-le-Bâcle');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91630', 'Cheptainville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91510', 'Lardy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91630', 'Marolles-en-Hurepoix');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91580', 'Villeconin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91700', 'Sainte-Geneviève-des-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91680', 'Bruyères-le-Châtel');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91600', 'Savigny-sur-Orge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Saint-Cyr-sous-Dourdan');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91290', 'Ollainville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91150', 'Mespuits');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91410', 'Plessis-Saint-Benoist');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91720', 'Courdimanche-sur-Essonne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91490', 'Courances');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91470', 'Limours');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91470', 'Molières');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91160', 'Longjumeau');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '91650', 'Saint-Yon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92200', 'Neuilly-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92320', 'Châtillon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92270', 'Bois-Colombes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92800', 'Puteaux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92140', 'Clamart');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92430', 'Marnes-la-Coquette');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92130', 'Issy-les-Moulineaux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92420', 'Vaucresson');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92500', 'Rueil-Malmaison');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92160', 'Antony');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92350', 'Le Plessis-Robinson');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92300', 'Levallois-Perret');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92100', 'Boulogne-Billancourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92600', 'Asnières-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92700', 'Colombes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92260', 'Fontenay-aux-Roses');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92380', 'Garches');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92390', 'Villeneuve-la-Garenne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92400', 'Courbevoie');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92120', 'Montrouge');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92290', 'Châtenay-Malabry');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92110', 'Clichy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92170', 'Vanves');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92410', 'Ville-d''Avray');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92150', 'Suresnes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92310', 'Sèvres');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92330', 'Sceaux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92370', 'Chaville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92250', 'La Garenne-Colombes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92230', 'Gennevilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92000', 'Nanterre');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92210', 'Saint-Cloud');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92240', 'Malakoff');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92220', 'Bagneux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92340', 'Bourg-la-Reine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93350', 'Le Bourget');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93170', 'Bagnolet');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93120', 'La Courneuve');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93320', 'Pavillons-sous-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93270', 'Sevran');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93250', 'Villemomble');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93100', 'Montreuil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93190', 'Livry-Gargan');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93600', 'Aulnay-sous-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93440', 'Dugny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93470', 'Coubron');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93430', 'Villetaneuse');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93340', 'Le Raincy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93260', 'Lilas');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93390', 'Clichy-sous-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93160', 'Noisy-le-Grand');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93230', 'Romainville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93300', 'Aubervilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93130', 'Noisy-le-Sec');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93420', 'Villepinte');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93000', 'Bobigny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93380', 'Pierrefitte-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93290', 'Tremblay-en-France');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93410', 'Vaujours');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93370', 'Montfermeil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93450', 'L''Île-Saint-Denis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93310', 'Le Pré-Saint-Gervais');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93240', 'Stains');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93500', 'Pantin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93360', 'Neuilly-Plaisance');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93110', 'Rosny-sous-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93400', 'Saint-Ouen');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93460', 'Gournay-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93140', 'Bondy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93800', 'Épinay-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93330', 'Neuilly-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93700', 'Drancy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93150', 'Le Blanc-Mesnil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93220', 'Gagny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94120', 'Fontenay-sous-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94440', 'Santeny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94240', 'L''Haÿ-les-Roses');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94450', 'Limeil-Brévannes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94140', 'Alfortville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94420', 'Le Plessis-Trévise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94600', 'Choisy-le-Roi');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94160', 'Saint-Mandé');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94260', 'Fresnes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94350', 'Villiers-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94270', 'Le Kremlin-Bicêtre');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94470', 'Boissy-Saint-Léger');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94510', 'La Queue-en-Brie');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94490', 'Ormesson-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94110', 'Arcueil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94440', 'Marolles-en-Brie');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94440', 'Villecresnes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94170', 'Le Perreux-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94460', 'Valenton');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94130', 'Nogent-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94230', 'Cachan');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94150', 'Rungis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94320', 'Thiais');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94880', 'Sucy-en-Brie');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94520', 'Mandres-les-Roses');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94300', 'Vincennes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94220', 'Charenton-le-Pont');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94410', 'Saint-Maurice');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94360', 'Bry-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94380', 'Bonneuil-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94340', 'Joinville-le-Pont');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94480', 'Ablon-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94880', 'Noiseau');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94250', 'Gentilly');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94800', 'Villejuif');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94400', 'Vitry-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94550', 'Chevilly-Larue');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94430', 'Chennevières-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94520', 'Périgny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94500', 'Champigny-sur-Marne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94200', 'Ivry-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94700', 'Maisons-Alfort');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94310', 'Orly');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94290', 'Villeneuve-le-Roi');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94190', 'Villeneuve-Saint-Georges');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94000', 'Créteil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95560', 'Baillet-en-France');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95520', 'Osny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Hodent');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95770', 'Montreuil-sur-Epte');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95380', 'Chennevières-lès-Louvres');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95680', 'Montlignon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95190', 'Fontenay-en-Parisis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95460', 'Ézanville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95000', 'Neuville-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Sagy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Théméricourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95430', 'Butry-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Le Plessis-Luzarches');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95280', 'Jouy-le-Moutier');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95850', 'Mareil-en-France');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95640', 'Bréançon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95710', 'Chaussy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95810', 'Vallangoujard');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Magny-en-Vexin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Bellefontaine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95640', 'Haravilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95470', 'Survilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95640', 'Le Heaulme');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95650', 'Courcelles-sur-Viosne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95640', 'Brignancourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Seraincourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95470', 'Vémars');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95330', 'Domont');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95500', 'Bonneuil-en-France');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95160', 'Montmorency');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95820', 'Bruyères-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95380', 'Épiais-lès-Louvres');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95650', 'Montgeroult');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95580', 'Margency');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95300', 'Pontoise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95810', 'Menouville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Cléry-en-Vexin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Commeny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95810', 'Épiais-Rhus');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95490', 'Vauréal');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95710', 'Bray-et-Lû');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95670', 'Marly-la-Ville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Le Perchay');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95650', 'Génicourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95510', 'Amenucourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Condécourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95410', 'Groslay');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95180', 'Menucourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95470', 'Saint-Witz');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95350', 'Piscop');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Nucourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95810', 'Arronville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95220', 'Herblay');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Asnières-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95590', 'Presles');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Lassy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95580', 'Andilly');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95780', 'Haute-Isle');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Chaumontel');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95570', 'Villaines-sous-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95120', 'Ermont');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95760', 'Auvers-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95350', 'Saint-Brice-sous-Forêt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Arthies');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95810', 'Grisy-les-Plâtres');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95380', 'Puiseux-en-France');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95190', 'Goussainville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95640', 'Moussy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95480', 'Pierrelaye');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95130', 'Franconville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95380', 'Louvres');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Gouzangrez');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95750', 'Le Bellay-en-Vexin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95500', 'Gonesse');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'La Chapelle-en-Vexin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95690', 'Hédouville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95510', 'Villers-en-Arthies');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Saint-Martin-du-Tertre');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Seugy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95700', 'Roissy-en-France');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95650', 'Boissy-l''Aillerie');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95530', 'La Frette-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Wy-dit-Joli-Village');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95170', 'Deuil-la-Barre');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95870', 'Bezons');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95800', 'Courdimanche');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95340', 'Ronquerolles');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95210', 'Saint-Gratien');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95340', 'Bernes-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95690', 'Nesles-la-Vallée');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95750', 'Chars');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Viarmes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95640', 'Neuilly-en-Vexin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95150', 'Taverny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95550', 'Bessancourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Vigny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Ableiges');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95260', 'Beaumont-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95810', 'Theuville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95770', 'Saint-Clair-sur-Epte');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95510', 'Vienne-en-Arthies');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95240', 'Cormeilles-en-Parisis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95690', 'Labbeville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95300', 'Livilliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Charmont');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95570', 'Bouffémont');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95810', 'Berville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95110', 'Sannois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95380', 'Villeron');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95440', 'Écouen');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95510', 'Saint-Cyr-en-Arthies');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95390', 'Saint-Prix');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95300', 'Ennery');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95320', 'Saint-Leu-la-Forêt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95570', 'Attainville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Belloy-en-France');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95690', 'Frouville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Us');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95660', 'Champagne-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95000', 'Boisemont');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95560', 'Chauvry');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95710', 'Ambleville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95840', 'Béthemont-la-Forêt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95500', 'Le Thillay');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95310', 'Saint-Ouen-l''Aumône');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95560', 'Maffliers');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Noisy-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95590', 'Nerville-la-Forêt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95340', 'Persan');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95290', 'L''Isle-Adam');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95140', 'Garges-lès-Gonesse');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95360', 'Montmagny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95370', 'Montigny-lès-Cormeilles');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95830', 'Cormeilles-en-Vexin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95510', 'Chérence');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Omerville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Luzarches');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95510', 'Aincourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Avernes');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95300', 'Hérouville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95830', 'Frémécourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Frémainville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Saint-Gervais');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95770', 'Buhy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95600', 'Eaubonne');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95760', 'Valmondois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95560', 'Montsoult');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95620', 'Parmain');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95780', 'La Roche-Guyon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95100', 'Argenteuil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95130', 'Le Plessis-Bouchard');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95400', 'Villiers-le-Bel');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95610', 'Éragny');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95500', 'Vaudherland');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Gadancourt');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95200', 'Sarcelles');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Longuesse');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95590', 'Nointel');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95720', 'Le Plessis-Gassot');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95540', 'Méry-sur-Oise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95630', 'Mériel');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95230', 'Soisy-sous-Montmorency');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Banthelu');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95450', 'Guiry-en-Vexin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95640', 'Santeuil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95740', 'Frépillon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95720', 'Bouqueval');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95270', 'Épinay-Champlâtreux');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95720', 'Villiers-le-Sec');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95250', 'Beauchamp');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95720', 'Le Mesnil-Aubry');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95190', 'Châtenay-en-France');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95880', 'Enghien-les-Bains');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Genainville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95640', 'Marines');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95260', 'Mours');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95400', 'Arnouville');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95850', 'Jagny-sous-Bois');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95650', 'Puiseux-Pontoise');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95570', 'Moisselles');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95780', 'Vétheuil');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95840', 'Villiers-Adam');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95420', 'Maudétour-en-Vexin');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95470', 'Fosses');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92190', 'Meudon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '92360', 'Meudon');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93200', 'Saint-Denis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '93210', 'Saint-Denis');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94100', 'Saint-Maur-des-Fossés');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '94210', 'Saint-Maur-des-Fossés');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95000', 'Cergy');
INSERT INTO `ville` (`code_postal`, `libelle`) VALUES ( '95800', 'Cergy');

INSERT INTO `credentials` VALUES (1,'24ef5a2597e76b2840293848fe68f0a4cd71d6478fa0e839b789d1223583d9cb','bar','4AvSAq');
INSERT INTO `credentials` VALUES (2,'658e98b6e60cd10e7bb4b1062e06953dc289ac609e43945769c868606b37644c','masseur','36rvWQ');
INSERT INTO `credentials` VALUES (3,'fd5949ceb40ed9abcf35ea122556e0985ed5515c2732e4b88be878910351082b','admin','HUUy4X');

/* ADRESSE */
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '34 rue du marché', 1);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '23 rue de paris', 2);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '15 avenue montaigne', 3);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '75 boulevard du général de gaulle', 4);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '78 rue de la pompe', 5);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '34 rue de la république', 6);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '23 rue stalingrad', 7);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '15 avenue de madrid', 8);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '75 boulevard du général leclerc', 9);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '78 rue de la promenade', 10);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '22 avenue foch', 24);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '25 boulevard hausmann', 28);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '35 rue de vienne', 33);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '98 boulevard de la résistance', 44);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '77 rue de la gare', 55);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '39 rue de la république', 66);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '20 rue saint martin', 77);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '16 avenue saint lazare', 88);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '74 boulevard du trone', 99);
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ( '68 rue des cloviers', 101);

/* STATUS MASSEUR */
INSERT INTO `nomads_bdd`.`status_masseur` (`libelle`) VALUES ('Débutant');
INSERT INTO `nomads_bdd`.`status_masseur` (`libelle`) VALUES ('Formateur');
INSERT INTO `nomads_bdd`.`status_masseur` (`libelle`) VALUES ('Standard');

/* STATUS STATUT_LIEU */
INSERT INTO `nomads_bdd`.`status_lieu` (`libelle`) VALUES ('En attente');
INSERT INTO `nomads_bdd`.`status_lieu` (`libelle`) VALUES ('Valide');

/* TITRE */
INSERT INTO `nomads_bdd`.`titre` (`libelle`) VALUES ('Monsieur');
INSERT INTO `nomads_bdd`.`titre` (`libelle`) VALUES ('Madame');

/* MASSEUR */
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `actif`, `date_naissance`, `nom_masseur`, `prenom_masseur`, `id_adresse`, `id_status`, `id_credential`, `porte_monnaie`) VALUES ('MASSEUR', '123 123 123 12345', 'best_mass', 1, '1980-08-10', 'Martin', 'Amélie', '1', '2', '2', 10);
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `actif`, `date_naissance`, `nom_masseur`, `prenom_masseur`, `id_adresse`, `id_status`) VALUES ('MASSEUR', '123 123 123 12345', 'mass_detente', 1, '1990-12-24', 'Bernard', 'Arthur', '2', '1');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `actif`, `date_naissance`, `nom_masseur`, `prenom_masseur`, `id_adresse`, `id_status`) VALUES ('MASSEUR', '123 123 123 12345', 'detente_assuree', 0, '1970-11-12', 'Thomas', 'Brice', '3', '3');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `actif`, `date_naissance`, `nom_masseur`, `prenom_masseur`, `id_adresse`, `id_status`) VALUES ('MASSEUR', '123 123 123 12345', 'massage_for_all', 1, '1987-09-20', 'Petit', 'Camille', '4', '2');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `actif`, `date_naissance`, `nom_masseur`, `prenom_masseur`, `id_adresse`, `id_status`) VALUES ('MASSEUR', '123 123 123 12345', 'massage pour vous', 1, '1970-09-24', 'Robert', 'Emmanuel', '5', '1');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `actif`, `date_naissance`, `nom_masseur`, `prenom_masseur`, `id_adresse`, `id_status`) VALUES ('MASSEUR', '123 123 123 12345', 'repos_et_detente', 0, '1995-11-12', 'Richard', 'Gaspard', '6', '3');

/* Type */
INSERT INTO `nomads_bdd`.`type` (`type`) VALUES ('Bar');
INSERT INTO `nomads_bdd`.`type` (`type`) VALUES ('Restaurant');
INSERT INTO `nomads_bdd`.`type` (`type`) VALUES ('Entreprise');

/* Commanditaire */
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `id_adresse`, `id_credential`) VALUES ('COMMANDITAIRE', '123 123 123 12345', 'LE BEAULIEU', '4', '1');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `id_adresse`) VALUES ('COMMANDITAIRE', '123 123 123 12345', 'SANTA LUCIA', '5');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `id_adresse`) VALUES ('COMMANDITAIRE', '123 123 123 12345', 'SARL BAHT', '2');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `id_adresse`) VALUES ('COMMANDITAIRE', '123 123 123 12345', 'SARL BRASSERIE LE FABIEN', '7');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `id_adresse`) VALUES ('COMMANDITAIRE', '123 123 123 12345', 'L AUBERGE AVEYRONNAISE', '8');
INSERT INTO `nomads_bdd`.`utilisateur` (`id_discriminator_utilisateur`, `numero_siret`, `raison_sociale`, `id_adresse`) VALUES ('COMMANDITAIRE', '123 123 123 12345', 'CAFE & BAR PEREIRE SA', '9');

/* Lieu */
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('La Légende', '1', 7, true, 2, '10');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('La Fine Mousse', '1', 7, true, 2, '11');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('Le Supercoin', '1', 8, false, 1, '12');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('Le Red House', '1', 7, true, 2, '13');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('Dernier Bar avant la Fin du Monde', '1', 9, false, 1, '14');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('Académie de la bière', '1', 9, true, 2, '15');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('Le Calbar', '1', 7, true, 2, '16');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('Le Bistrot du Forum', '1', 10, false, 1, '17');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('Nul Bar Ailleurs', '1', 11, true, 2, '18');
INSERT INTO `nomads_bdd`.`lieu` (`nom`, `id_type`, `id_commanditaire`, `actif`, `id_status`, `id_adresse`) VALUES ('My Little Pub', '1', 12, false, 1, '19');


/* MasseurTournee */
INSERT INTO `nomads_bdd`.`masseur_tournee` (`id_masseur`, `id_tournee`) VALUES ('1', '4');
INSERT INTO `nomads_bdd`.`masseur_tournee` (`id_masseur`, `id_tournee`) VALUES ('2', '4');
INSERT INTO `nomads_bdd`.`masseur_tournee` (`id_masseur`, `id_tournee`) VALUES ('1', '5');
INSERT INTO `nomads_bdd`.`masseur_tournee` (`id_masseur`, `id_tournee`) VALUES ('3', '5');
INSERT INTO `nomads_bdd`.`masseur_tournee` (`id_masseur`, `id_tournee`) VALUES ('2', '6');
INSERT INTO `nomads_bdd`.`masseur_tournee` (`id_masseur`, `id_tournee`) VALUES ('1', '7');

/* LieuTournee */
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('1', '4');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('2', '5');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('1', '6');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('4', '7');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('6', '8');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('7', '9');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('9', '10');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('2', '11');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('9', '12');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('4', '13');
INSERT INTO `nomads_bdd`.`lieu_tournee` (`id_lieu`, `id_tournee`) VALUES ('7', '14');


INSERT INTO `adresse` VALUES (24,'admin adresse',202);

INSERT INTO `contact` VALUES (1,'admin email',NULL,'admin telephone',NULL,NULL,1,NULL);
INSERT INTO `contact` VALUES (2,'email masseur',NULL,'telephone masseur',NULL,NULL,2,NULL);
INSERT INTO `contact` VALUES (3,'bar email',NULL,'bar telephone',NULL,NULL,1,NULL);

INSERT INTO `disponibilite` VALUES (1,'2019-01-12 00:12:00.000000',NULL);

/* Premier Aministrateur du site */
INSERT INTO `utilisateur` VALUES ('ADMINISTATEUR',15,'admin numero de siret','admin raison social',NULL,NULL,NULL,NULL,NULL,15,3,NULL);

SET FOREIGN_KEY_CHECKS = 1;

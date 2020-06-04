SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO `annuaire_masseur`.`titre` (`libelle`) VALUES ('Mme');
INSERT INTO `annuaire_masseur`.`titre` (`libelle`) VALUES ('M');

INSERT INTO `annuaire_masseur`.`specialite` (`libelle`) VALUES ('spé1');
INSERT INTO `annuaire_masseur`.`specialite` (`libelle`) VALUES ('spé2');
INSERT INTO `annuaire_masseur`.`specialite` (`libelle`) VALUES ('spé3');



INSERT INTO `annuaire_masseur`.`masseur` (`actif`, `email`, `nom`, `numero_siret`, `prenom`, `raison_sociale`, `telephone`, `id_titre`) VALUES (false,'1@mail.com','nom1','000000000000001','prenom1','raisonSociale1','06000001', 1);
INSERT INTO `annuaire_masseur`.`masseur` (`actif`, `email`, `nom`, `numero_siret`, `prenom`, `raison_sociale`, `telephone`, `id_titre`) VALUES (true, '2@mail.com', 'nom2','000000000000002','prenom2', 'raisonSociale2', '06000002', 2);
INSERT INTO `annuaire_masseur`.`masseur` (`actif`, `email`, `nom`, `numero_siret`, `prenom`, `raison_sociale`, `telephone`, `id_titre`) VALUES (true, '3@mail.com', 'nom3', '000000000000003', 'prenom3', 'raisonSociale3', '06000003', 1);


INSERT INTO `annuaire_masseur`.`masseur_specialite` (`id_masseur`, `id_specialite`) VALUES (1,1);
INSERT INTO `annuaire_masseur`.`masseur_specialite` (`id_masseur`, `id_specialite`) VALUES (2,1);
INSERT INTO `annuaire_masseur`.`masseur_specialite` (`id_masseur`, `id_specialite`) VALUES (2,2);
INSERT INTO `annuaire_masseur`.`masseur_specialite` (`id_masseur`, `id_specialite`) VALUES (3,1);
INSERT INTO `annuaire_masseur`.`masseur_specialite` (`id_masseur`, `id_specialite`) VALUES (3,2);
INSERT INTO `annuaire_masseur`.`masseur_specialite` (`id_masseur`, `id_specialite`) VALUES (3,3);

SET FOREIGN_KEY_CHECKS = 1;
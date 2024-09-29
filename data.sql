-- CREATE DATABASE exam_management_db;
use exam_management_db;
-- --------------------------------Departement-----------------------------
insert into departement(nomDepartement) values("Mathématiques & informatiques");
insert into departement(nomDepartement) values("Civil");
-- select * from departement;
-- --------------------------------Filiere-----------------------------

insert into filiere(nomFiliere) values("Cycle Préparatoire Intégré");
insert into filiere(nomFiliere) values("Génie Informatique");
insert into filiere(nomFiliere) values("Génie Civil");
insert into filiere(nomFiliere) values("Génie de l'Eau et de l'Environnement");
insert into filiere(nomFiliere) values("Génie Energétique et Energie Renouvelable");
insert into filiere(nomFiliere) values("Ingénierie des Données");
insert into filiere(nomFiliere) values("Génie Mécanique");
insert into filiere(nomFiliere) values("Transformation Digitale & Intelligence Artificielle");
-- -- select * from filiere;

-- --------------------------------Niveau-----------------------------

INSERT INTO niveau (titre) VALUES ("Première Année Cycle Préparatoire");
INSERT INTO niveau (titre) VALUES ("Deuxième Année Cycle Préparatoire");
INSERT INTO niveau (titre) VALUES ("Génie Civil 1");
INSERT INTO niveau (titre) VALUES ("Génie Civil 2");
INSERT INTO niveau (titre) VALUES ("Génie Civil 3 Option HYD");
INSERT INTO niveau (titre) VALUES ("Génie Civil 3 Option BPC");
INSERT INTO niveau (titre) VALUES ("Génie de l'eau et de l'Environnement 1");
INSERT INTO niveau (titre) VALUES ("Génie de l'eau et de l'Environnement 2");
INSERT INTO niveau (titre) VALUES ("Génie de l'eau et de l'Environnement 3");
INSERT INTO niveau (titre) VALUES ("Génie Energétique et Energies renouvelables 1");
INSERT INTO niveau (titre) VALUES ("Génie Energétique et Energies renouvelables 2");
INSERT INTO niveau (titre) VALUES ("Génie Energétique et Energies renouvelables 3");
INSERT INTO niveau (titre) VALUES ("Génie Informatique 1");
INSERT INTO niveau (titre) VALUES ("Génie Informatique 2");
INSERT INTO niveau (titre) VALUES ("Génie Informatique 3 Option GL");
INSERT INTO niveau (titre) VALUES ("Génie Informatique 3 Option BI");
INSERT INTO niveau (titre) VALUES ("Génie Informatique 3 Option Médias et Interactions");
INSERT INTO niveau (titre) VALUES ("Génie Mécanique 1");
INSERT INTO niveau (titre) VALUES ("Génie Mécanique 2");
INSERT INTO niveau (titre) VALUES ("Génie Mécanique 3");
INSERT INTO niveau (titre) VALUES ("Ingénierie des données 1");
INSERT INTO niveau (titre) VALUES ("Ingénierie des données 2");
INSERT INTO niveau (titre) VALUES ("Ingénierie des données 3");
INSERT INTO niveau (titre) VALUES ("Transformation Digitale & Intelligence Artificielle 1");
INSERT INTO niveau (titre) VALUES ("Transformation Digitale & Intelligence Artificielle 2");
INSERT INTO niveau (titre) VALUES ("Transformation Digitale & Intelligence Artificielle 3");
-- select * from niveau;


-- --------------------------------Salle-----------------------------
INSERT INTO salle (capacité, nomSalle) VALUES (50, "1NB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "2NB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "3NB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "4NB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "5NB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "6NB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "1AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "2AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "3AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "4AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "5AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "6AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "7AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "8AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "9AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "10AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "11AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "12AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "13AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "14AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "15AB");
INSERT INTO salle (capacité, nomSalle) VALUES (50, "16AB");
INSERT INTO salle (capacité, nomSalle) VALUES (150, "Amphi A");
INSERT INTO salle (capacité, nomSalle) VALUES (100, "Amphi B");
-- select * from salle;


-- --------------------------------semestre-----------------------------

insert into semestre(intitule) values("automne");
insert into semestre(intitule) values("printemps");
-- select * from semestre;

-- --------------------------------session-----------------------------
insert into session(intitule) values("normale");
insert into session(intitule) values("rattrapage");
-- select * from session;


-- --------------------------------typeElement-----------------------------

insert into typeelement(titre) values ("élément");
insert into typeelement(titre) values ("module");
-- select * from typeelement;


-- --------------------------------typeexamen-----------------------------
insert into typeexamen(intitule) values("devoir surveillé 1");
insert into typeexamen(intitule) values("devoir surveillé 2");
insert into typeexamen(intitule) values("devoir surveillé 3");
insert into typeexamen(intitule) values("devoir TP");
insert into typeexamen(intitule) values("examen final");
-- select * from typeexamen;


-- --------------------------------Role et Compte-----------------------------

INSERT INTO `personnel` (`nom`, `prenom`) VALUES
('afkir', 'mohamed');
------------------------------------------------------------

INSERT INTO `role` (`idRole`, `nomRole`) VALUES
(1, 'ROLE_USER');

-- --------------------------------------------------------

INSERT INTO `useraccount` (`accountNonExpired`, `accountNonLocked`, `credentialsNonExpired`, `enabled`, `idCompte`, `idRole`, `idUtilisateur`, `login`, `password`) VALUES
(b'1', b'1', b'1', b'1', 1, 1, 1, 'user', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe');


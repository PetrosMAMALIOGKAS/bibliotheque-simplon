SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS bibliotheque_simplon;
CREATE SCHEMA bibliotheque_simplon;
USE bibliotheque_simplon;

CREATE TABLE editeur (
  editeur_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  adresse VARCHAR(45),
  
  PRIMARY KEY  (editeur_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO editeur VALUES (NULL, "Calimard", "32 rue Quintinie 75016");
INSERT INTO editeur VALUES (NULL, "Elephant", "45 rue Anglaitaire 75018");
INSERT INTO editeur VALUES (NULL, "Folioko", "123 rue Yvart 75013");
INSERT INTO editeur VALUES (NULL, "Folioko", "123 rue Yvart 75013");

CREATE TABLE rayon (
  rayon_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  designtion VARCHAR(45) NOT NULL,
  
  PRIMARY KEY  (rayon_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO rayon VALUES (NULL, "Romans A");
INSERT INTO rayon VALUES (NULL, "Romans B");
INSERT INTO rayon VALUES (NULL, "Mathematiques A");
INSERT INTO rayon VALUES (NULL, "Biologie A");
INSERT INTO rayon VALUES (NULL, "Bandes dessignes A");
INSERT INTO rayon VALUES (NULL, "Bandes dessignes B");
INSERT INTO rayon VALUES (NULL, "Bandes dessignes C");
INSERT INTO rayon VALUES (NULL, "Bandes dessignes D");

CREATE TABLE auteur (
  auteur_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  adresse VARCHAR(45),
  telephone VARCHAR(45),
  PRIMARY KEY  (auteur_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO auteur VALUES (NULL, "Striner", "Max", "26 rue Plumet 75001", "0675123456");
INSERT INTO auteur VALUES (NULL, "Camus", "Albert", "29 rue Bargue 75021", "0675198756");
INSERT INTO auteur VALUES (NULL, "Becket", "Samuel", "76 rue Dutot 75011", "067554326");
INSERT INTO auteur VALUES (NULL, "Frindrich", "Nitche", "36 rue Quitinie 75005", "0670983456");
INSERT INTO auteur VALUES (NULL, "Vian", "Boris", "36 rue Quitinie 75005", "0670983456");
INSERT INTO auteur VALUES (NULL, "Zola", "Emil", "36 rue Quitinie 75005", "0670983456");

CREATE TABLE genre (
  genre_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  description VARCHAR(145),
  
  PRIMARY KEY  (genre_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO genre VALUES (NULL, "policier", "doc");
INSERT INTO genre VALUES (NULL, "science politiques", "doc");
INSERT INTO genre VALUES (NULL, "bandes designees", "doc");
INSERT INTO genre VALUES (NULL, "philosophie", "doc");
INSERT INTO genre VALUES (NULL, "science-fiction", "doc");
INSERT INTO genre VALUES (NULL, "mathematiques", "doc");
INSERT INTO genre VALUES (NULL, "biologie", "doc");

CREATE TABLE livre (
  livre_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  titre VARCHAR(45) NOT NULL,
  auteur INT UNSIGNED  NOT NULL,
  genre INT UNSIGNED  NOT NULL,
 
  PRIMARY KEY  (livre_id),
  CONSTRAINT `fk_livre_auteur_auteur` FOREIGN KEY (auteur) REFERENCES auteur (auteur_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_livre_genre_genre` FOREIGN KEY (genre) REFERENCES genre (genre_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO livre VALUES (NULL, "Bonjour tout le monde", 1, 1);
INSERT INTO livre VALUES (NULL, "Hello world", 2, 1);
INSERT INTO livre VALUES (NULL, "La division", 3, 2);
INSERT INTO livre VALUES (NULL, "Le Petit prince", 3, 4);
INSERT INTO livre VALUES (NULL, "L'etranger", 4, 3);

CREATE TABLE mot_cle (
  mot_cle_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  livre INT UNSIGNED NOT NULL,
  mot VARCHAR(45) NOT NULL,
 
  PRIMARY KEY  (mot_cle_id, livre),
  CONSTRAINT `fk_motCle_livre_livre` FOREIGN KEY (livre) REFERENCES livre (livre_id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO mot_cle VALUES (NULL, 1, "Bonjour");
INSERT INTO mot_cle VALUES (NULL, 1, "monde");
INSERT INTO mot_cle VALUES (NULL, 2, "Bonjour");
INSERT INTO mot_cle VALUES (NULL, 2, "monde");
INSERT INTO mot_cle VALUES (NULL, 4, "petit");
INSERT INTO mot_cle VALUES (NULL, 4, "prince");


CREATE TABLE exemplaire (
  exemplaire_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  livre_id INT UNSIGNED NOT NULL UNIQUE,
  editeur INT UNSIGNED  NOT NULL,
  rayon INT UNSIGNED NOT NULL,
  date_aquisition DATE NOT NULL,
  
  PRIMARY KEY  (exemplaire_id, livre_id),
   CONSTRAINT `fk_exemplaire_editeur_editeur` FOREIGN KEY (editeur) REFERENCES editeur (editeur_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_exemplaire_livre_livreId` FOREIGN KEY (livre_id) REFERENCES livre (livre_id) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_exemplaire_rayon_rayon` FOREIGN KEY (rayon) REFERENCES rayon (rayon_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO exemplaire VALUES (NULL, 1,1, 1, '2020-01-13');
INSERT INTO exemplaire VALUES (NULL, 2,2, 3, '2020-03-17');
INSERT INTO exemplaire VALUES (NULL, 3,3, 1, '2010-03-17');

CREATE TABLE categorie_professionnelle (
  categorie_professionnelle_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  description VARCHAR(145),
  
  PRIMARY KEY  (categorie_professionnelle_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO categorie_professionnelle VALUES (NULL, "informaticien", "doc");
INSERT INTO categorie_professionnelle VALUES (NULL, "etudiant", "doc");
INSERT INTO categorie_professionnelle VALUES (NULL, "demander d'emploi", "doc");
INSERT INTO categorie_professionnelle VALUES (NULL, "admin", "doc");

CREATE TABLE utilisateur (
  utilisateur_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  
  PRIMARY KEY  (utilisateur_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO utilisateur VALUES (NULL, 'auteur_idauteur_idauteur_idlio33@gmail.com', 'paok');
INSERT INTO utilisateur VALUES (NULL, 'sko33@gmail.com','paok');
INSERT INTO utilisateur VALUES (NULL, 'sup33@gmail.com', 'paok');
INSERT INTO utilisateur VALUES (NULL, 'kat33@gmail.com', 'paok');
INSERT INTO utilisateur VALUES (NULL, 'kri33@gmail.com', 'paok');


CREATE TABLE adherent (
  adherent_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  adresse VARCHAR(45) NOT NULL,
  telephone VARCHAR(45) NOT NULL,
  date_naissance DATE NOT NULL,
  date_adhession DATE NOT NULL,
  categorie_professionnelle INT UNSIGNED NOT NULL,
  utilisateur INT UNSIGNED,
  
  PRIMARY KEY  (adherent_id),
  CONSTRAINT `fk_adherent_categorieProfessionnelle_categorieProfessionnelle` FOREIGN KEY (categorie_professionnelle) 
             REFERENCES categorie_professionnelle (categorie_professionnelle_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_adherent_utilisateur_utilisateur` FOREIGN KEY (utilisateur) 
             REFERENCES utilisateur (utilisateur_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO adherent VALUES (NULL, 'Mamaliogkzs', 'Petros', '23 rue La Fayetet 75021', '0123123456', '1983-03-12', '2020-09-14', 3, 1);
INSERT INTO adherent VALUES (NULL, 'Skodras', 'Paulos', '23 rue La bourget 75020',  '0123567456', '1973-09-22', '2020-08-17', 1, 2);
INSERT INTO adherent VALUES (NULL, 'Super', 'hero', '23 rue la paradis 75099', '0321567456', '1973-09-22', '2020-08-17', 1, 3);

CREATE TABLE employe (
  employe_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  adresse VARCHAR(45) NOT NULL,
  telephone VARCHAR(45) NOT NULL,
  date_naissance DATE NOT NULL,
  date_recrutement DATE NOT NULL,
  categorie_professionnelle INT UNSIGNED NOT NULL,
  utilisateur INT UNSIGNED,
  
  PRIMARY KEY  (employe_id),
  CONSTRAINT `fk_employe_categorieProfessionnelle_categorieProfessionnelle` FOREIGN KEY (categorie_professionnelle) 
             REFERENCES categorie_professionnelle (categorie_professionnelle_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_employe_utilisateur_utilisateur` FOREIGN KEY (utilisateur) 
             REFERENCES utilisateur (utilisateur_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO employe VALUES (NULL, 'Katsikis', 'Nikos', '23 rue La Fayetet 75021',  '0123123456', '1983-03-12', '2020-09-14', 4, 4);
INSERT INTO employe VALUES (NULL, 'Kriaris', 'Paulos', '23 rue La bourget 75020', '0123567456', '1973-09-22', '2020-08-17', 4, 5);




CREATE TABLE demander (
  demande_id  INT UNSIGNED NOT NULL AUTO_INCREMENT,
  adherent INT UNSIGNED NOT NULL,
  livre INT UNSIGNED NOT NULL,
  date_demade DATE NOT NULL,

  PRIMARY KEY  (demande_id),
  CONSTRAINT `fk_demander_adherent_adherentId` FOREIGN KEY (adherent) REFERENCES adherent (adherent_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_demander_livre_livreId` FOREIGN KEY (livre) REFERENCES livre (livre_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE preter (
  preter_id  INT UNSIGNED NOT NULL AUTO_INCREMENT,
  adherent INT UNSIGNED NOT NULL,
  livre INT UNSIGNED NOT NULL,
  renouvelle SMALLINT UNSIGNED DEFAULT 0,
  date_prete DATE NOT NULL,
  date_retour DATE NOT NULL,
  
  PRIMARY KEY  (preter_id),
  CONSTRAINT `fk_preter_adherent_adherentId` FOREIGN KEY (adherent) REFERENCES adherent (adherent_id) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_preter_livre_livreId` FOREIGN KEY (livre) REFERENCES livre (livre_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


select * from livre;


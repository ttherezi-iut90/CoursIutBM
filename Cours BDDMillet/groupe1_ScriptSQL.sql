
DROP TABLE if exists Possede;
DROP TABLE if exists Termine;
DROP TABLE if exists Est_compose_de;
DROP TABLE if exists Accepte;
DROP TABLE if exists Recupere;
DROP TABLE if exists Centre_recyclage;
DROP TABLE if exists Lieu_de_collecte;
DROP TABLE if exists Ville;
DROP TABLE if exists Materiaux;
DROP TABLE if exists Tournee;
DROP TABLE if exists Vehicule;




CREATE TABLE Vehicule(
   id_vehicule INT auto_increment,
   nom_vehicule VARCHAR(15),
   PRIMARY KEY(id_vehicule)
                     );

CREATE TABLE Tournee(
    id_tournee INT auto_increment,
    libelle_tournee VARCHAR(50),
    date_tournee DATE,
    id_vehicule INT NOT NULL,
    PRIMARY KEY(id_tournee),
    FOREIGN KEY(id_vehicule) REFERENCES Vehicule(id_vehicule)
);

CREATE TABLE Materiaux(
    id_Materiaux INT auto_increment,
    nom_Materiaux VARCHAR(50),
    prix_au_kg DECIMAL(6,2),
    PRIMARY KEY(id_Materiaux)
);

CREATE TABLE Ville
(
    id_ville    INT auto_increment,
    code_postal VARCHAR(5),
    nom_ville   VARCHAR(50),
    PRIMARY KEY (id_ville)
);

CREATE TABLE Lieu_de_collecte
(
    id_lieu_de_collecte  INT auto_increment,
    nom_lieu_de_collecte VARCHAR(25),
    ville_id             INT NOT NULL,
    PRIMARY KEY (id_lieu_de_collecte),
    CONSTRAINT fk_LieudeCollecte_Ville FOREIGN KEY (ville_id) REFERENCES Ville (id_ville)
);

CREATE TABLE Centre_recyclage(
    id_centre_recyclage INT auto_increment,
    nom_centre_recyclage VARCHAR(25),
    ville_id INT NOT NULL,
    PRIMARY KEY(id_centre_recyclage),
    FOREIGN KEY(ville_id) REFERENCES Ville(id_ville)
);


CREATE TABLE Recupere(
    id_Tournee INT,
    id_Materiaux INT,
    quantité DECIMAL(8,2),
    PRIMARY KEY(id_Tournee, id_Materiaux),
    FOREIGN KEY(id_Tournee) REFERENCES Tournee(id_Tournee),
    FOREIGN KEY(id_Materiaux) REFERENCES Materiaux(id_Materiaux)
);

CREATE TABLE Accepte(
    id_centre_recyclage INT,
    id_Materiaux INT,
    PRIMARY KEY(id_centre_recyclage, id_Materiaux),
    FOREIGN KEY(id_centre_recyclage) REFERENCES Centre_recyclage(id_centre_recyclage),
    FOREIGN KEY(id_Materiaux) REFERENCES Materiaux(id_Materiaux)
);

CREATE TABLE Est_compose_de(
    id_Tournee INT,
    id_lieu_de_collecte INT,
    ordre_collecte INT,
    PRIMARY KEY(id_Tournee, id_lieu_de_collecte),
    FOREIGN KEY(id_Tournee) REFERENCES Tournee(id_Tournee),
    FOREIGN KEY(id_lieu_de_collecte) REFERENCES Lieu_de_collecte(id_lieu_de_collecte)
);

CREATE TABLE Termine(
    id_Tournee INT,
    id_centre_recyclage INT,
    ordre_dépôt VARCHAR(50),
    PRIMARY KEY(id_Tournee, id_centre_recyclage),
    FOREIGN KEY(id_Tournee) REFERENCES Tournee(id_Tournee),
    FOREIGN KEY(id_centre_recyclage) REFERENCES Centre_recyclage(id_centre_recyclage)
);

CREATE TABLE Possede(
    id_lieu_de_collecte INT,
    id_Materiaux INT,
    PRIMARY KEY(id_lieu_de_collecte, id_Materiaux),
    FOREIGN KEY(id_lieu_de_collecte) REFERENCES Lieu_de_collecte(id_lieu_de_collecte),
    FOREIGN KEY(id_Materiaux) REFERENCES Materiaux(id_Materiaux)
);

INSERT INTO Vehicule (id_vehicule,nom_vehicule) VALUES
        (NULL,'CAMION1'),
        (NULL,'CAMION2'),
        (NULL,'CAMION3');

Select * from Vehicule;

INSERT INTO Tournee (id_tournee, libelle_tournee, date_tournee, id_vehicule) VALUES
    (NULL,'Tournee1','2004-01-01',1),
    (NULL,'Tournee2','2004-06-06',2),
    (NULL,'Tournee3','2003-02-06',3);

Select * from Tournee;

INSERT INTO Materiaux(id_Materiaux,nom_Materiaux,prix_au_kg)VALUES
    (NULL,'Fer',148.34),
    (NULL,'Plastique',78.24),
    (NULL,'Carton',48.97);

Select * from Materiaux;


INSERT INTO Ville( id_ville, code_postal, nom_ville) VALUES
    (NULL,22270,'MEGRIT'),
    (NULL,90000,'BELFORT'),
    (NULL,25200,'MONTBELIARD');

Select * from Ville;

INSERT INTO Lieu_de_collecte(id_lieu_de_collecte, nom_lieu_de_collecte, ville_id) values
    (NULL,'Belfort',2),
    (NULL,'Megrit',1),
    (NULL,'Montbeliard',3);

Select * from Lieu_de_collecte;


INSERT INTO Centre_recyclage(id_centre_recyclage, nom_centre_recyclage, ville_id) VALUES
    (NULL,'Centre de Belfort',2),
    (NULL,'Centre de Megrit',1),
    (NULL,'Centre de Montbeliard',3);

Select * from Centre_recyclage;


INSERT INTO Recupere(id_Tournee, id_Materiaux, quantité) VALUES
    (1,1,3000.54),
    (2,2,700.38),
    (3,3,1670.29);

Select * from Recupere;

INSERT INTO Est_compose_de(id_Tournee, id_lieu_de_collecte, ordre_collecte) VALUES
    (1,1,1), --  Pour la tournée N°1, Le camion va dans le Lieu de collecte N°1 en premier-- 
    (1,2,2), --  Pour la tournée N°1, Le camion va dans le Lieu de collecte N°2 en deuxième
    (2,3,1), --  Pour la tournée N°2, Le camion va dans le Lieu de collecte N°3 en premier
    (2,2,2), --  Pour la tournée N°2, Le camion va dans le Lieu de collecte N°2 en deuxième
    (2,1,3) ;--  Pour la tournée N°2, Le camion va dans le Lieu de collecte N°1 en troisième

Select * from Est_compose_de;

INSERT INTO Termine(id_Tournee, id_centre_recyclage, ordre_dépôt) VALUES
    (1,2,1), -- Pour la tournée N°1, Le camion va dans le centre de recyclage N°2 en premier
    (1,1,2), -- Pour la tournée N°1, Le camion va dans le centre de recyclage N°1 en deuxième
    (2,1,1), -- Pour la tournée N°2, Le camion va dans le centre de recyclage N°1 en premier
    (2,3,2), -- Pour la tournée N°2, Le camion va dans le centre de recyclage N°3 en deuxième
    (2,2,3); -- Pour la tournée N°2, Le camion va dans le centre de recyclage N°2 en troisième

select * from Termine;

INSERT INTO Possede(id_lieu_de_collecte, id_Materiaux) VALUES
    (1,1), -- le lieu de collecte n°1 peux accepter le materiau n°1
    (1,2), -- le lieu de collecte n°1 peux accepter le materiau n°2
    (1,3), -- le lieu de collecte n°1 peux accepter le materiau n°3
    (2,2), -- le lieu de collecte n°2 peux accepter le materiau n°2
    (2,1); -- le lieu de collecte n°2 peux accepter le materiau n°1

Select * from Possede;

SELECT T.libelle_tournee, sum(prix_au_kg*R.quantite) as revenuTournee
FROM Materiaux
INNER JOIN Recupere R on Materiaux.id_Materiaux = R.id_Materiaux
INNER JOIN Tournee T on R.id_Tournee = T.id_tournee
GROUP BY R.id_tournee;

SELECT nom_ville, count(nom_lieu_de_collecte) as Nbre_de_lieu_a_collecter
FROM Lieu_de_collecte
INNER JOIN Ville V on Lieu_de_collecte.ville_id = V.id_ville
GROUP BY ville_id;


SELECT V.nom_ville, avg(prix_au_kg*R.quantite) as moyenne_de_revenu_par_ville
FROM Materiaux
INNER JOIN Recupere R on Materiaux.id_Materiaux = R.id_Materiaux
INNER JOIN Tournee T on R.id_Tournee = T.id_tournee
INNER JOIN Lieu_de_collecte Ldc on R.id_lieu_de_collecte = Ldc.id_lieu_de_collecte
INNER JOIN Ville V on Ldc.ville_id = V.id_ville
GROUP BY Ldc.ville_id;


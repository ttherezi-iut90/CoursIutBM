
--Créer une table etudiant avec comme champs :

CREATE Table etudiant(
    id_etu INT AUTO_INCREMENT,
    nom VARCHAR(20),
    adresse TEXT,
    code_postal VARCHAR(5),
    telephone VARCHAR(10),
    date_naissance DATE,
    PRIMARY KEY (id_etu)
);

--Insérer 4 ou 5 enregistrements

INSERT INTO etudiant VALUES(
    NULL,'dupond','rue du chateau','01000','0156987545','2001-5-10'
);

INSERT INTO etudiant VALUES(
    NULL,'durant','rue du pont','22500','0635478120','1995-1-22'
);

INSERT INTO etudiant VALUES(
    NULL,'DUVAL','rue du CHATEAU','90000','0635489126','1990-12-31'
);

--Voir le resultat

SELECT * FROM etudiant;
DESCRIBE etudiant;

--Renommer une table :

RENAME TABLE etudiant TO etudiants;
SHOW TABLES;

--Ajouter un champ en fin liste dans la table :

ALTER table etudiants add groupe VARCHAR(20);
DESCRIBE etudiants;
SELECT * from etudiants;

--Ajouter un champ à une position précise dans la table :
ALTER table etudiants add prenom VARCHAR(20) after nom;
DESCRIBE etudiants;
SELECT * from etudiants;

--Modifier un champ dans la table :

ALTER table etudiants change prenom  prenoms VARCHAR(50) ;
DESCRIBE etudiants;
SELECT * from etudiants;






-- supprimer la table : 
drop table if exists etudiants;
drop table if exists etudiant;
drop table if exists etudiant;
drop table if exists groupe;




CREATE table groupe(

    idGroupe int AUTO_INCREMENT,
    nom varchar(20),

    Primary Key (idGroupe)

);

CREATE table etudiant(
        idEtudiant int AUTO_INCREMENT,
        nom varchar(20),
        idgroupe int,


        PRIMARY KEY (idEtudiant),
        constraint etudiant_groupe_fk foreign key (idGroupe)references groupe(idGroupe)
    );

INSERT INTO groupe VALUES(1,'S2A1');    -- il id 1
INSERT INTO groupe VALUES(2,'S2A2');    -- id 2
INSERT INTO groupe VALUES(3,'S2bisA1'); -- id 3

INSERT INTO etudiant VALUES(1,'paul',1);
INSERT INTO etudiant VALUES(2,'pierre',2);
INSERT INTO etudiant VALUES(3,'toto',3);

select * from etudiant;
select * from groupe;



DROP TABLE IF EXISTS  etudiant_periode,Etudiant, Groupe, Semestre, Periode;

CREATE TABLE Groupe (
                        id_groupe INT AUTO_INCREMENT,
                        libelle VARCHAR(255),
                        PRIMARY KEY (id_groupe)
);

CREATE TABLE Semestre (
                          id_semestre INT AUTO_INCREMENT,
                          libelle VARCHAR(255),
                          PRIMARY KEY (id_semestre)
);

CREATE TABLE Periode (
                         id_periode INT AUTO_INCREMENT,
                         date_debut  DATE,
                         date_fin DATE,
                         PRIMARY KEY (id_periode)

);


CREATE TABLE Etudiant (
        idEtudiant INT AUTO_INCREMENT
    , nom VARCHAR(20)
    , adresse VARCHAR(40)
    , ville VARCHAR(20)
    , code_postal VARCHAR(5)
    , telephone VARCHAR(10)
    , date_naissance DATE
    , sexe VARCHAR(1)
    , boursier VARCHAR(1)
    , groupe_id INT
    , PRIMARY KEY(idEtudiant)
    ,foreign key (groupe_id) references Groupe(id_groupe)


);

CREATE TABLE etudiant_periode (
                                  etudiant_id INT,
                                  periode_id INT,
                                  semestre_id INT,
                                  PRIMARY KEY (etudiant_id,periode_id,semestre_id),
                                  foreign key (etudiant_id) references Etudiant(idEtudiant),
                                  foreign key (periode_id) references  Periode(id_periode),
                                  foreign key (semestre_id)references Semestre(id_semestre)
                              );







INSERT INTO Semestre VALUES (NULL,'S1'),(NULL,'S2'),(NULL,'S3'),(NULL,'S4'),(NULL,'S5'),(NULL,'S6');

INSERT INTO Groupe VALUES (NULL,'A1'),(NULL,'A2'),(NULL,'B1'),(NULL,'B2'),(NULL,'C1'),(NULL,'C2'),(NULL,'D1');


INSERT INTO Periode VALUES (NULL,'2022-09-01','2023-01-15'),(NULL,'2023-1-15','2023-7-1'),
                           (NULL,'2023-09-01','2024-01-15'),(NULL,'2024-1-15','2024-7-1'),
                           (NULL,'2024-09-01','2025-01-15'),(NULL,'2025-1-15','2025-7-1');


-- 2022
INSERT INTO Etudiant (idEtudiant, nom, adresse, ville, code_postal, telephone, date_naissance, sexe, boursier, groupe_id) VALUES
        (NULL, 'BERNARD', '1 rue sous bois', 'Belfort', '90000', '0384545401', '2003-01-01', 'F', 'N', 1),
        (NULL, 'CHAVEAUX', '5 rue du chasseur', 'Strasbourg', '68000', '0384545419', '2003-01-01', 'H', 'N', 2),
        (NULL, 'PRETTOT', '8 rue vilapogo', 'Belfort', '90000', '0384545420', '2003-07-12', 'H', 'O', 2),
        (NULL, 'RIOT', '67 rue pasteur', 'Montbeliard', '25200', '0384545407', '2003-06-06', 'H', 'N', 2),
        (NULL, 'BOISSENIN', '1 rue sous bois', 'Belfort', '90000', '0384545408', '2003-08-09', 'H', 'O', 2),
        (NULL, 'PEQUIGNOT', '2 rue de la liberation', 'Valdoie', '90300', '0384545402', '2002-06-06', 'H', 'O', 1),
        (NULL, 'ZILLIOX', '7 rue du verger', 'Bavilliers', '90120', '0384545403', '2002-01-01', 'H', 'N', 1),
        (NULL, 'MONNIER', '3 rue du boulanger', 'TAILLECOURT', '25400', '0384545404', '2002-02-06', 'H', 'O', 1),
        (NULL, 'BRISCHOUX', '5 rue du chasseur', 'Belfort', '90000', '0384545405', '2002-05-25', 'H', 'N', 2),
        (NULL, 'DUVAL', '8 rue vilapogo', 'Bavilliers', '90120', '0384545406', '2002-03-11', 'H', 'O', 2),
        (NULL, 'FAIVRE', '7 rue des vergers  de rioz', 'Valdoie', '90300', '0384545410', '2002-01-05', 'H', 'O', 3),
        (NULL, 'DELANOE', '7 rue du verger', 'Valdoie', '90300', '0384545417', '2002-01-01', 'H', 'N', 1),
        (NULL, 'BONVALOT', '3 rue du boulanger', 'Belfort', '90000', '0384545418', '2002-01-01', 'H', 'O', 1),
        (NULL, 'COULON', '67 rue pasteur', 'Valdoie', '90300', '0384545421', '2002-01-01', 'H', 'N', 2),
        (NULL, 'KENDE', '2 rue de la liberation', 'Bavilliers', '90120', '0384545423', '2002-05-31', 'H', 'N', 3),
        (NULL, 'KLEIN', '7 rue du verger', 'Montbeliard', '25200', '0384545424', '2002-01-01', 'H', 'N', 3),
        (NULL, 'VALZER', '3 rue du boulanger', 'Valdoie', '90300', '0384545425', '2002-01-06', 'H', 'O', 3),
        (NULL, 'PY', '5 rue du chasseur', NULL, '90000', '0384545426', '2002-01-10', 'F', 'N', 3),
        (NULL, 'VERNET', '8 rue vilapogo', NULL, '90120', '0384545427', '2002-02-02', 'H', 'O', 4),
        (NULL, 'BAILLIT', '67 rue pasteur', NULL, '25200', '0384545428', '2002-01-01', 'H', 'N', 4),
        (NULL, 'LUZET', '2 rue de la liberation', 'Belfort', '90000', '0384545416', '2001-01-01', 'H', 'O', 1),
        (NULL, 'VALOT', '1 rue sous bois', '', '90000', '0384545422', '2001-12-12', 'H', 'O', 2),
        (NULL, 'DUPONT', '8 rue vilapogo', '', '90300', '0384545429', '2001-06-06', 'H', 'O', 4),
        (NULL, 'FAIVRE', '3 rue des vergers', 'Cernay', '68000', '0384545411', '2001-01-01', 'F', 'N', 3),
        (NULL, 'DUCHENNE', '5 rue du chasseur', 'Belfort', '90000', '0384545412', '2001-01-01', 'F', 'O', 3),
        (NULL, 'BOULANGER', '8 rue vilapogo', 'Belfort', '90000', '0384545413', '2001-01-01', 'F', 'N', 1),
        (NULL, 'FONTAINE-LEGIOT', '2 rue des vergers', 'Mulhouse', '68000', '0384545409', '2000-01-01', 'H', 'N', 3),
        (NULL, 'MOREAU', '67 rue pasteur', 'Belfort', '90000', '0384545414', '2000-06-01', 'H', 'O', 1),
        (NULL, 'RIGOULOT', '1 rue sous bois', 'Valdoie', '90300', '0384545415', '2000-12-12', 'H', 'N', 1);

INSERT INTO etudiant_periode VALUES (1,11,1),(19,1,2),(20,1,2),(7,1,1),(8,1,1),(2,1,1),(3,1,1),(4,1,1),(5,1,1),(6,1,1)
                                  ,(6,1,1),(10,1,1),(17,1,2),(18,1,2),(21,1,2),(23,1,2),(24,1,2),(25,1,2),(26,1,2),(27,1,3),(28,1,3),(16,1,2),(22,1,2),(29,1,3)
                                  ,(11,1,1),(12,1,1),(13,1,2),(9,1,1),(14,1,2),(15,1,2);


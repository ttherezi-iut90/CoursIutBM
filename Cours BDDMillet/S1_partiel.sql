drop table if exists Employe;
drop table if exists Departement;

CREATE TABLE Departement (
  id_Departement INT AUTO_INCREMENT
  , Nom_Departement VARCHAR(100)
  , PRIMARY KEY(id_Departement)
);

CREATE TABLE Employe (
  id_Employe INT AUTO_INCREMENT
  , Nom_Employe VARCHAR(20)
  , Tel_pro_Employe VARCHAR(13)
  , Salaire_Employe numeric(7,2)
  , Num_Bureau numeric(2)
  , Date_embauche DATE
  , Departement_Id INT
  , PRIMARY KEY(id_Employe)
  , CONSTRAINT fk_employe_dep FOREIGN KEY (Departement_Id) REFERENCES Departement(id_Departement)
);

INSERT INTO Departement VALUES (NULL, 'Production');
INSERT INTO Departement VALUES (NULL, 'Marketing');
INSERT INTO Departement VALUES (NULL, 'Méthode');
INSERT INTO Departement VALUES (NULL, 'Recherche et développement');

INSERT INTO Employe VALUES (NULL, 'Durand', '0384545401', 2000.00, 1, '2010-10-01', 1);
INSERT INTO Employe VALUES (NULL, 'Dupond', '0384545402', 1500.00, 2, '2012-09-30', 1);
INSERT INTO Employe VALUES (NULL, 'Renaud', '03   84545403', 2000.00, 2, '2009-09-21', 2);
INSERT INTO Employe VALUES (NULL, 'Pierre', '0384545404', 2500.50, 3, '2000-10-02', 2);
INSERT INTO Employe VALUES (NULL, 'Danigo', '0384545405', 1400.50, 3, '2018-10-02', 3);

describe Employe;
SELECT * from Employe;

SELECT Nom_Employe, Tel_pro_Employe
from Employe
where (Num_Bureau=1 OR Num_Bureau=2) AND Salaire_Employe>1800;

SELECT Nom_Employe
from Employe
where ((Nom_Employe like 'D%') or (Nom_Employe like 'P%')) AND (Num_Bureau=1 OR Num_Bureau=3);




update Employe
set Tel_pro_Employe = '0601010101'
where Nom_Employe='Pierre';

alter table Employe
add Prenom_Employe text(20)
after Nom_Employe;

SELECT * from Employe;

SELECT DISTINCT Num_Bureau
FROM Employe
Where Date_embauche>='2011-01-01'
ORDER BY Num_Bureau desc;

SELECT Num_Bureau, count(*) as NB_employe, round(avg(Salaire_Employe),2) as AVG_salaire
From Employe
where (Nom_Employe like 'D%' or Nom_Employe like 'R%')
GROUP BY Num_Bureau
ORDER BY Num_Bureau desc;

SELECT Num_Bureau, count(*) as NB_employe, round(avg(Salaire_Employe),2) as AVG_salaire
From Employe
where (Nom_Employe like 'D%' or Nom_Employe like 'R%')
GROUP BY Num_Bureau
HAVING AVG_salaire>=1500
ORDER BY Num_Bureau desc;


describe Employe;
describe Departement;

SELECT * FROM Departement;
SELECT * FROM Employe;


SELECT Nom_Departement, count(E.Nom_Employe) as NB_employe, round(avg(Salaire_Employe),2) as Moy_salaire
FROM Departement
LEFT JOIN Employe E on Departement.id_Departement = E.Departement_Id
GROUP BY Nom_Departement
ORDER BY Nom_Departement desc;






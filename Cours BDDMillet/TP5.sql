
drop table if exists Etudiant;



CREATE table Etudiant(
                        idEtudiant int AUTO_INCREMENT,
                        nom varchar(20),
                        adresse varchar(40),
                        ville varchar(40),
                        code_postal int,
                        telephone varchar(13),
                        date_naissance date,
                        sexe varchar(1),
                        boursier varchar(1),
                        groupe_id int,
                        semestre_id int,
                        note_ue1 numeric(4,2),
                        note_ue2 numeric(4,2),


                        PRIMARY KEY (idEtudiant)
);

INSERT INTO Etudiant (idEtudiant, nom, adresse, ville, code_postal, telephone, date_naissance, sexe, boursier, groupe_id, semestre_id, note_ue1, note_ue2) VALUES
                                                                                                                                                               (1, 'BERNARD', '1 rue sous bois', 'Belfort', '90000', '0384545401', '2004-01-01', 'F', 'N', 1, 1, '11.50', '10.50'),
                                                                                                                                                               (19, 'CHAVEAUX', '5 rue du chasseur', 'Strasbourg', '68000', '0384545419', '2004-01-01', 'H', 'N', 2, 2, '10.50', '9.50'),
                                                                                                                                                               (20, 'PRETTOT', '8 rue vilapogo', 'Belfort', '90000', '0384545420', '2004-07-12', 'H', 'O', 2, 2, '12.50', '8.50'),
                                                                                                                                                               (7, 'RIOT', '67 rue pasteur', 'Montbeliard', '25200', '0384545407', '2004-06-06', 'H', 'N', 2, 1, '13.50', '12.50'),
                                                                                                                                                               (8, 'BOISSENIN', '1 rue sous bois', 'Belfort', '90000', '0384545408', '2004-08-09', 'H', 'O', 2, 1, '15.5', '16.50'),
                                                                                                                                                               (2, 'PEQUIGNOT', '2 rue de la liberation', 'Valdoie', '90300', '0384545402', '2003-06-06', 'H', 'O', 1, 1, '17.50', '9.50'),
                                                                                                                                                               (3, 'ZILLIOX', '7 rue du verger', 'Bavilliers', '90120', '0384545403', '2003-01-01', 'H', 'N', 1, 1, '11.50','9.25'),
                                                                                                                                                               (4, 'MONNIER', '3 rue du boulanger', 'TAILLECOURT', '25400', '0384545404', '2003-02-06', 'H', 'O', 1, 1, '9.50', '15.5'),
                                                                                                                                                               (5, 'BRISCHOUX', '5 rue du chasseur', 'Belfort', '90000', '0384545405', '2003-05-25', 'H', 'N', 2, 1, '10', '9.50'),
                                                                                                                                                               (6, 'DUVAL', '8 rue vilapogo', 'Bavilliers', '90120', '0384545406', '2003-03-11', 'H', 'O', 2, 1, '13.50', '8.50'),
                                                                                                                                                               (10, 'FAIVRE', '7 rue des vergers  de rioz', 'Valdoie', '90300', '0384545410', '2003-01-05', 'H', 'O', 3, 1, '8.50', '12.50'),
                                                                                                                                                               (17, 'DELANOE', '7 rue du verger', 'Valdoie', '90300', '0384545417', '2003-01-01', 'H', 'N', 1, 2, '12.50', '14.50'),
                                                                                                                                                               (18, 'BONVALOT', '3 rue du boulanger', 'Belfort', '90000', '0384545418', '2003-01-01', 'H', 'O', 1, 2, '10', '11.50'),
                                                                                                                                                               (21, 'COULON', '67 rue pasteur', 'Valdoie', '90300', '0384545421', '2003-01-01', 'H', 'N', 2, 2, '17', '6.5'),
                                                                                                                                                               (23, 'KENDE', '2 rue de la liberation', 'Bavilliers', '90120', '0384545423', '2003-05-31', 'H', 'N', 3, 2, '15', '7.5'),
                                                                                                                                                               (24, 'KLEIN', '7 rue du verger', 'Montbeliard', '25200', '0384545424', '2003-01-01', 'H', 'N', 3, 2, '13', '15'),
                                                                                                                                                               (25, 'VALZER', '3 rue du boulanger', 'Valdoie', '90300', '0384545425', '2003-01-06', 'H', 'O', 3, 2, '11', '10'),
                                                                                                                                                               (26, 'PY', '5 rue du chasseur', NULL, '90000', '0384545426', '2003-01-10', 'F', 'N', 3, 2, '12.20', '7.90'),
                                                                                                                                                               (27, 'VERNET', '8 rue vilapogo', NULL, '90120', '0384545427', '2003-02-02', 'H', 'O', 4, 3, '10.30', '11.85'),
                                                                                                                                                               (28, 'BAILLIT', '67 rue pasteur', NULL, '25200', '0384545428', '2003-01-01', 'H', 'N', 4, 3, '7.90', '15.90'),
                                                                                                                                                               (16, 'LUZET', '2 rue de la liberation', 'Belfort', '90000', '0384545416', '2002-01-01', 'H', 'O', 1, 2, '10.25', '9.25'),
                                                                                                                                                               (22, 'VALOT', '1 rue sous bois', '', '90000', '0384545422', '2002-12-12', 'H', 'O', 2, 2, '10', '9.20'),
                                                                                                                                                               (29, 'DUPONT', '8 rue vilapogo', '', '90300', '0384545429', '2002-06-06', 'H', 'O', 4, 3, '13.20', '15.50'),
                                                                                                                                                               (11, 'FAIVRE', '3 rue des vergers', 'Cernay', '68000', '0384545411', '2002-01-01', 'F', 'N', 3, 1, '5.6', '12.05'),
                                                                                                                                                               (12, 'DUCHENNE', '5 rue du chasseur', 'Belfort', '90000', '0384545412', '2002-01-01', 'F', 'O', 3, 1, '10.4', '11.3'),
                                                                                                                                                               (13, 'BOULANGER', '8 rue vilapogo', 'Belfort', '90000', '0384545413', '2002-01-01', 'F', 'N', 1, 2, '13', '9.20'),
                                                                                                                                                               (9, 'FONTAINE-LEGIOT', '2 rue des vergers', 'Mulhouse', '68000', '0384545409', '2001-01-01', 'H', 'N', 3, 1, '11.25', '12'),
                                                                                                                                                               (14, 'MOREAU', '67 rue pasteur', 'Belfort', '90000', '0384545414', '2001-06-01', 'H', 'O', 1, 2, '9', '12.50'),
                                                                                                                                                               (15, 'RIGOULOT', '1 rue sous bois', 'Valdoie', '90300', '0384545415', '2001-12-12', 'H', 'N', 1, 2, '15', '10.50');



select * from Etudiant;







select Etudiant.nom,Etudiant.adresse,Etudiant.semestre_id,Etudiant.ville
    from Etudiant
        where Etudiant.groupe_id = 1 AND Etudiant.ville = 'Belfort' ;

/* Requête 1 (expression logique) */
select nom,groupe_id,boursier
    from Etudiant
        where groupe_id = 1 AND boursier = 'O' AND semestre_id=1;


select semestre_id,groupe_id,nom
from Etudiant
order by semestre_id asc,groupe_id,nom desc;




/* Requête 2 (expression logique et tri sur plusieurs champs ) :  */

select nom,ville
from Etudiant
where groupe_id = 2
order by ville desc ,nom asc ;



/*Requête 2-2 :
*/
select nom,groupe_id,ville,semestre_id
from Etudiant
where groupe_id=1 and semestre_id=1 or semestre_id=2 and ville='belfort'
order by semestre_id asc,groupe_id asc,ville asc, nom desc;

/*Requête 2-3 :
*/
select nom,groupe_id,semestre_id,code_postal
from Etudiant
where ((groupe_id<> 2 and semestre_id<>2 and code_postal between 90000 and 90999)
    or (semestre_id<>2 and code_postal between  90000 and 90999))
    And  ville !='belfort' and ville != '' and ville IS NOT NULL

order by semestre_id, groupe_id,ville,nom;

/*Requête 2-4 :
*/

select nom,groupe_id,semestre_id,code_postal
from Etudiant
where ((groupe_id<> 2 and semestre_id<>2 and code_postal between 90000 and 90999)
    or (semestre_id<>2 and code_postal between  90000 and 90999))
  And  ville !='belfort' and ville != '' and ville IS NOT NULL

order by semestre_id, groupe_id,ville,nom;

/*Requête 2-5 :
*/


select nom,groupe_id,ville,semestre_id,boursier
from Etudiant
where ((boursier= 'O' or ville= 'Belfort')and semestre_id=2)
order by groupe_id,nom;



/*  Requête 3 (utilisation de DISTINCT)
  */

  select distinct code_postal, ville
from Etudiant;

select distinct ville
from Etudiant
where (code_postal between 90000 and  99999) and ville is not null and ville <>'' ;

/* Requête 4 ( IN : un champ appartient à une liste de valeurs )
*/


select nom, ville
from Etudiant
where ville in ('mulhouse','cernay','strasbourg');


/*Requête 5 (utilisation de NULL)
*/

select nom, ville
from Etudiant
where ville is null or ville = '' and  sexe = 'h';

/*Requête 6 (utilisation de LIKE )
*/

select nom, ville
from Etudiant
where (nom like 'B%' or nom LIKE 'D%')
and ville like '%o%'
order by nom;

select nom,ville,adresse
from Etudiant
where adresse like '%verger%' and (ville like '%er%' or ville like '%al%' )
order by nom;

/*Requête 7 (utilisation de LIMIT )
*/

select nom
from Etudiant
order by nom
limit 5,10;

select nom, groupe_id
from Etudiant





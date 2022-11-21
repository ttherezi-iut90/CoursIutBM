drop table if exists produit;


CREATE table produit(
    id_produit int AUTO_INCREMENT,
    nom varchar(20),
    categorie varchar(20),
    code INT(5),
    prix NUMERIC(5,2),
    date_achat DATE,
    PRIMARY KEY (id_produit)
    );

INSERT into produit VALUES (NULL, 'Pommes','fruits', 01002, 4.5, '2021-10-1');
INSERT into produit VALUES (NULL, 'Poires','fruits', 01008, 4, '2021-09-30');
INSERT into produit VALUES (NULL,	'potiron','légumes',	02018,3,'2021-09-21');
INSERT into produit VALUES (NULL,	'haricots',	'légumes',02089,18,'2021-10-2');
INSERT into produit VALUES (NULL,	'Cerises',	'fruits',	01068,	15,	'2021-09-30');
INSERT into produit VALUES (NULL,	'Patates',	'légumes',	02068,	3,	'2021-09-30');

select nom from produit where prix<10  ;

drop table if exists produit;

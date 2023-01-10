drop table if exists LIGNE;
drop table if exists COMMANDE;
drop table if exists ARTICLE;
drop table if exists CLIENT;



create table if not exists CLIENT(
    idClient int auto_increment primary key ,
    nom varchar(25),
    ville varchar(25)



);

create table if not exists ARTICLE(
    idArticle int auto_increment primary key ,
    designation varchar(50),
    prix numeric(5,2)
);

create table if not exists COMMANDE(
    idCommande int auto_increment primary key ,
    dateCommande date,
    idClient int,
    foreign key (idClient) references CLIENT(idclient)

);

create table if not exists LIGNE(
    idCommande int ,
    idArticle int,
    quantite int,
    foreign key (idCommande) references COMMANDE(idCommande),
    foreign key (idArticle) references ARTICLE(idArticle)

);


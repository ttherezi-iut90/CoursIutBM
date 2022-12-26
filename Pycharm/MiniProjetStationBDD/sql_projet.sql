-- mysql --user=ttherezi  --password=8060 --host=localhost --database=BDD_ProjetStation < sql_projet.sql

Create DATABASE if not EXISTS BDD_ProjetStation;


DROP TABLE IF EXISTS hotel;
DROP TABLE IF EXISTS station;


create TABLE if not exists station(
    id_station INT AUTO_INCREMENT,
    nom_station VARCHAR(255),
    altitude INT,
    PRIMARY KEY (id_station)

);

create TABLE if not exists hotel(
    id_hotel INT AUTO_INCREMENT,
    nom_hotel VARCHAR(25),
    nombre_chambre INT,
    categorie INT,
    prix_base_chambre DECIMAL(5,2),
    date_creation DATE,
    photo VARCHAR(50),
    station_id INT,
    PRIMARY KEY (id_hotel),
    FOREIGN KEY (station_id) REFERENCES station(id_station)
);

describe station;
describe hotel;

INSERT INTO station(id_station, nom_station, altitude)
VALUES  (NULL, 'OZAN', 206),
        (NULL, 'CORMORANCHE-SUR-SAONE', 211),
        (NULL, 'PLAGNE', 922),
        (NULL, 'TOSSIAT', 501),
        (NULL, 'POUILLAT', 770);

INSERT INTO hotel (id_hotel, nom_hotel, nombre_chambre, categorie, prix_base_chambre, date_creation, photo, station_id)
VALUES  (NULL, 'Le Saint joseph', 16, 2, 51.5,'2017-02-03', 'le-saint-joseph.jpg',1),
        (NULL, 'La Castana', 83, 3, 62,'2017-04-28',  'la-castana.jpg', 2),
        (NULL, 'Grand Baraille', 46, 3, 78.5,'2017-04-05',  'grand-baraille.jpg', 3),
        (NULL, 'Pershing Hall', 26, 4, 83,'2017-04-29', 'pershing-hall.jpg',4),
        (NULL, 'Villa Gallici', 470, 1, 92.5,'2017-04-30',  'villa-gallici.jpg', 5),
        (NULL, 'Mandarin oriental party', 14, 4, 102,'2017-04-29','mandarin-oriental-party.jpg', 1),
        (NULL, 'Roch hotel et spa', 71, 4, 54, '2017-04-30',  'roch-hotel-et-spa.jpg', 2),
        (NULL, 'Villa Lara', 570, 1, 63,'2017-04-23','villa-lara.jpg', 3),
        (NULL, 'La Réserve', 6, 5, 114,'2017-04-24',  'la-reserve.jpg', 4),
        (NULL, 'Résidence de France', 65, 5, 122, '2017-04-29',  'residence-de-france.jpg', 1),
        (NULL, 'Antibes les beau près', 36, 4, 78, '2017-04-21', 'antibes-les-beau-près.jpg', 2),
        (NULL, 'Le Savoie', 585, 1,  128,'2017-04-18',  'le-savoie.jpg',3),
        (NULL, 'Hotel Juana', 68, 3, 145,'2017-04-16',  'hotel-juana.jpg', 4),
        (NULL,  'Le Sereno',  455,  3, 200, '2017-04-14',  'le-sereno.jpg', 5);

select * from station;



select nom_station, avg(2*prix_base_chambre), count(id_hotel) from station
left join hotel h on station.id_station = h.station_id
group by  nom_station

select
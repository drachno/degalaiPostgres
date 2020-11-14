DROP TABLE IF EXISTS Automobiliai;
CREATE TABLE Automobiliai
(
id integer NOT NULL,
name varchar(20) NOT NULL,
sanaudosVasara DOUBLE PRECISION NOT NULL,
sanaudosZiema DOUBLE PRECISION NOT NULL,
Degalutipas varchar(10) NOT NULL,
sunaudojoDegalu DOUBLE PRECISION DEFAULT NULL,
PRIMARY KEY (id)
);
alter table Automobiliai alter column id set not null;
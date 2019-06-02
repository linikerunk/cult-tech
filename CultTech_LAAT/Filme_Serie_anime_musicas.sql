create database Laat;
use Laat;
CREATE TABLE Filmes(
id int(4) auto_increment,
nome varchar(30) NOT NULL,
notas int(2),
personagens varchar(50),
descricao varchar(150),
genero_do_filme varchar(15),
PRIMARY KEY (id)
);
ALTER TABLE Filmes CHANGE notas avaliacao int(2) not null;
alter table Filmes change notas nota int(2) not null;
show tables; 	
SHOW COLUMNS FROM Filmes;

CREATE TABLE Series(
id int(4) auto_increment,
nome varchar(30) not null,
avaliacao int(2),
personagens varchar(50),
genero_da_serie varchar(15),
primary key (id)
);

DROP TABLE SERIE;

CREATE TABLE Livros(
id int(4) auto_increment,
nome varchar(30) not null,
autor varchar(35) not null,
numero_de_paginas int(4),
categoria varchar(30),
editora varchar(25),
edicao int (4),
volume int(4),
avaliacao int(2),	
primary key(id)
);

CREATE TABLE Animes(
id int(4) auto_increment,
nome varchar(15),
autor varchar(15),
personagens_favoritos varchar (30),
genero varchar(15),
estudio varchar(20),
temporada int(4),
episodio int(4),
PRIMARY KEY(id)
);

CREATE TABLE Musicas(
id int(4) auto_increment,
nome varchar(20),
cantor varchar(20),
banda varchar(15),
tempo_de_musicas int(10),
ano date,
genero varchar(15),
quantidade_de_faixa int (4),
PRIMARY KEY (id)
);

SHOW tables FROM Laat;
show columns FROM Animes;

ALTER TABLE Serie add temporada int(4) not null;
alter table Serie add episodio int (4) not null;
drop table fornecedores;
show databases;
use laat

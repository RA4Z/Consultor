CREATE TABLE usuario(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null,
    senha varchar(60) not null,
    telefone varchar(45) not null,
    primary key (id)
);

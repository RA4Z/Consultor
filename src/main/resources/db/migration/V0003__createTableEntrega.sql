CREATE TABLE entregas(
    id bigint not null auto_increment,
    pessoa_id bigint not null,

    card_secao varchar(60),
    card_nome varchar(255),
    card_status varchar(30),
    card_datainicio varchar(50),
    card_dataestimada varchar(50),
    card_horas int not null,

    PRIMARY KEY (id)
);

ALTER TABLE entregas ADD CONSTRAINT fk_entregas_pessoa
FOREIGN KEY (pessoa_id) REFERENCES pessoa (id);
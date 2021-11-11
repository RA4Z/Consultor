CREATE TABLE cards
(
    id                BIGINT NOT NULL auto_increment,
    usuario_id        BIGINT NOT NULL,
    card_secao        VARCHAR(60),
    card_nome         VARCHAR(255),
    card_status       VARCHAR(30),
    card_datainicio   DATE,
    card_dataestimada DATE,
    card_tempolimite  INT NOT NULL,
    card_horas        double NOT NULL,
    horas_enviado     INT,
    horas_aprovado    INT,
    PRIMARY KEY (id)
);
    INSERT INTO cards VALUES (1,1,"Seção XBY","Projeção de Sistemas","Parado","1111-11-11","1000-10-12",200,0,0,0);
    INSERT INTO cards VALUES (2,1,"Seção ABC","Projeção de Sistemas","Em Andamento","1111-11-11","1000-10-12",150,0,0,0);
    INSERT INTO cards VALUES (3,1,"Seção TRA","Automação de Motores","Completo","1111-11-11","1000-10-12",100,0,0,0);
    INSERT INTO cards VALUES (4,1,"Seção RAZ","Desenvolvimento de Software","Não Iniciado","1111-11-11","1000-10-12",300,0,0,0);
ALTER TABLE cards
    ADD CONSTRAINT fk_cards_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);

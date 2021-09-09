CREATE TABLE cards
(
    id                BIGINT NOT NULL auto_increment,
    usuario_id        BIGINT NOT NULL,
    card_secao        VARCHAR(60),
    card_nome         VARCHAR(255),
    card_status       VARCHAR(30),
    card_datainicio   VARCHAR(50),
    card_dataestimada VARCHAR(50),
    card_horas        INT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE cards
    ADD CONSTRAINT fk_cards_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (
                                                                                 id);
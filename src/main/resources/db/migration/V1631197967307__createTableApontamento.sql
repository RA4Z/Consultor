CREATE TABLE apontamento
(
    id            BIGINT NOT NULL auto_increment,
    cards_id      BIGINT NOT NULL,
    hora_inicial  INT NOT NULL,
    hora_final    INT NOT NULL,
    horas         INT NOT NULL,
    data_registro DATE NOT NULL,
    descricao     TEXT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE apontamento
    ADD CONSTRAINT fk_apontamento_cards FOREIGN KEY (cards_id) REFERENCES cards (id);
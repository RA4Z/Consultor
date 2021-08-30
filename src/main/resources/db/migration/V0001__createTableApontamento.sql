CREATE TABLE apontamento(
    id bigint not null auto_increment,
    cards_id bigint not null,
    horas int not null,
    data_registro text not null,
    primary key (id)
);

ALTER TABLE apontamento ADD CONSTRAINT fk_apontamento_cards
FOREIGN KEY (cards_id) REFERENCES cards (id);
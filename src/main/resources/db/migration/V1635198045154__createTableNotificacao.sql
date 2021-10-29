create table notificacao (
    id bigint not null auto_increment,
    id_card BIGINT NOT NULL,
    usuario_id bigint not null,
    nome     VARCHAR(100) NOT NULL,
    descricao VARCHAR(100),
    primary key (id)
);

    ALTER TABLE notificacao
    ADD CONSTRAINT fk_notificacao_cards FOREIGN KEY (id_card) REFERENCES cards (id);

    ALTER TABLE notificacao
    ADD CONSTRAINT fk_notificacao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);

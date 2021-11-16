create table notificacao (
    id bigint not null auto_increment,
    usuario_id bigint not null,
    nome     VARCHAR(100) NOT NULL,
    descricao VARCHAR(100),
    primary key (id)
);

    ALTER TABLE notificacao
    ADD CONSTRAINT fk_notificacao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id);

    INSERT INTO notificacao VALUES(1,1,"Alerta","O sistema foi Inicializado com Sucesso.");

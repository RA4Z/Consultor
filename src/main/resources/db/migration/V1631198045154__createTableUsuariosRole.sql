CREATE TABLE role_usuarios
(
    usuarios_id    BIGINT NOT NULL,
    role_nome_role VARCHAR(45) NOT NULL
);

ALTER TABLE role_usuarios
    ADD CONSTRAINT fk_usuarios FOREIGN KEY (usuarios_id) REFERENCES usuario (id);

ALTER TABLE role_usuarios
    ADD CONSTRAINT fk_role FOREIGN KEY (role_nome_role) REFERENCES role (nome_role
        );

INSERT INTO role_usuarios
VALUES     (1,
            "role_consultor");
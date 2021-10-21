CREATE TABLE usuario
(
    id       BIGINT NOT NULL auto_increment,
    id_fornecedor BIGINT NOT NULL,
    nome     VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL,
    senha    VARCHAR(60) NOT NULL,
    telefone VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO usuario VALUES (1,1,"Consultor","consultor@gmail.com","$2a$10$wXtvqXV4qqnArUkRWiaYd.flZcZTcRecCxMlRdg4YC9Y7YtTVJcQq","(47) 4002-8922");

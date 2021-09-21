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
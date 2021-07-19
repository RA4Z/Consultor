CREATE TABLE ocorrencia(
    id bigint not null auto_increment,
    entrega_id bigint not null,
    horas int not null,
    data_registro text not null,
    primary key (id)
);

ALTER TABLE ocorrencia ADD CONSTRAINT fk_ocorrencia_entrega
FOREIGN KEY (entrega_id) REFERENCES entrega (id);
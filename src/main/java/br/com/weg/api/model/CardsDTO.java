package br.com.weg.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CardsDTO {

    Long id;
    String secao;
    String nome;
    String dataInicio;
    String dataEstimada;
    int horas;
    String status;

}

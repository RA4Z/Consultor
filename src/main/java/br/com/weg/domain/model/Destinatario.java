package br.com.weg.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Embeddable
public class Destinatario {

    @Column(name = "card_secao")
    String secao;

    @Column(name = "card_nome")
    String nome;

    @Column(name = "card_datainicio")
    String dataInicio;

    @Column(name = "card_dataestimada")
    String dataEstimada;

    @Column(name = "card_horas")
    int horas;
}

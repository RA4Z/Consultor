package br.com.weg.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Apontamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cards cards;

    private String horaInicial;

    private String horaFinal;

    private double horas;

    private String dataRegistro;

    private String descricao;

}

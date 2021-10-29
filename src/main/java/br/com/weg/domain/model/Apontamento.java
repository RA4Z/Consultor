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

    private int horaInicial;

    private int horaFinal;

    private int horas;

    private String dataRegistro;

    private String descricao;

}

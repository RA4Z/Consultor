package br.com.weg.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApontamentoDTO {

    private Long id;
    private String horaInicial;
    private String horaFinal;
    private double horas;
    private String dataRegistro;
    private String descricao;

}

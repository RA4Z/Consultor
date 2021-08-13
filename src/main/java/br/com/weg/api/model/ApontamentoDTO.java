package br.com.weg.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApontamentoDTO {

    private Long id;
    private int horas;
    private String dataRegistro;

}

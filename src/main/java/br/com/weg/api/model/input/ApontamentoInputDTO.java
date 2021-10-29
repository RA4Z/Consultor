package br.com.weg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ApontamentoInputDTO {

    @NotBlank
    private String dataRegistro;
    @NotNull
    private int horaInicial;
    @NotNull
    private int horaFinal;
    @NotNull
    private int horas;
    @NotBlank
    private String descricao;
}

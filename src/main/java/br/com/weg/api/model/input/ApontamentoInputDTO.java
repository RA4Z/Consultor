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
    @NotBlank
    private String horaInicial;
    @NotBlank
    private String horaFinal;
    @NotNull
    private double horas;
    @NotBlank
    private String descricao;
}

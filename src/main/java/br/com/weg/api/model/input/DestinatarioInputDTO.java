package br.com.weg.api.model.input;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DestinatarioInputDTO {

    @NotBlank
    String nome;
    @NotBlank
    String logradouro;
    @NotBlank
    String numero;
    @NotBlank
    String complemento;
    @NotBlank
    String bairro;

}

package br.com.weg.api.model.input;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PessoaInputDTO {

    @NotNull
    String nome;

    @NotNull UsuarioInputDTO usuario;

    @NotNull
    String telefone;

}

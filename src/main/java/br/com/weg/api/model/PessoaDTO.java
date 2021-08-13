package br.com.weg.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class PessoaDTO {

    String nome;
    UsuarioDTO usuario;
    String telefone;
}

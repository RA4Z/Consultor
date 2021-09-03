package br.com.weg.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;

}

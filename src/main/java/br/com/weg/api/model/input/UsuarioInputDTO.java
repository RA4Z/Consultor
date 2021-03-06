package br.com.weg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioInputDTO {

    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

}

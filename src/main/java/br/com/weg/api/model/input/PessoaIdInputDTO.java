package br.com.weg.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PessoaIdInputDTO {

    @NotNull
    private long id;
}

package br.com.senai.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class EntregaDTO {

    Long id;
    PessoaDTO pessoa;
    DestinatarioDTO destinatario;
    String status;

}

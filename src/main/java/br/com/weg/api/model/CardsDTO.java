package br.com.weg.api.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CardsDTO {

    Long id;
    PessoaDTO pessoa;
    DestinatarioDTO destinatario;
    String status;

}

package br.com.weg.api.model.input;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CardsInputDTO {

    String nome;
    int horasEnviado;


}

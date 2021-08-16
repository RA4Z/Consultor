package br.com.weg.api.model;

import br.com.weg.domain.model.Info;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CardsDTO {

    Long id;
    Info info;
    String status;

}

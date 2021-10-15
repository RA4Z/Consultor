package br.com.weg.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacaoInputDTO {

    private Long idCard;
    private String nome;
    private String descricao;
}

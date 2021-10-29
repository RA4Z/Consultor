package br.com.weg.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificacaoDTO {

    private Long id;
    private Long usuarioId;
    private String nome;
    private String descricao;

}

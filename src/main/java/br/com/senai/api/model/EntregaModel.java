package br.com.senai.api.model;

import br.com.senai.api.model.input.PessoaModel;
import br.com.senai.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EntregaModel {

    private Long id;
    private PessoaModel pessoa;
    private DestinatarioModel destinatario;
    private BigDecimal taxa;
    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;
    private StatusEntrega status;

}

package br.com.weg.api.assembler;

import br.com.weg.api.model.NotificacaoDTO;
import br.com.weg.domain.model.Notificacao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class NotificacaoAssembler {

    private ModelMapper modelMapper;

    public NotificacaoDTO toModel(Notificacao notificacao){
        return modelMapper.map(notificacao, NotificacaoDTO.class);
    }

    public List<NotificacaoDTO> toCollectionModel(List<Notificacao> notificacoes){
        return notificacoes.stream()
                .map((this::toModel))
                .collect(Collectors.toList());
    }
}

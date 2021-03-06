package br.com.weg.domain.service;

import br.com.weg.api.assembler.NotificacaoAssembler;
import br.com.weg.api.model.NotificacaoDTO;
import br.com.weg.domain.repository.NotificacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service

public class NotificacaoService {

    private NotificacaoRepository notificacaoRepository;
    private NotificacaoAssembler notificacaoAssembler;

    public List<NotificacaoDTO> listar() {
        return notificacaoAssembler.toCollectionModel(notificacaoRepository.findAll());
    }

    public List<NotificacaoDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return notificacaoAssembler.toCollectionModel(notificacaoRepository.findByUsuarioId(usuarioId));
    }
    @Transactional
    public void excluir(Long notificacaoId){

        if(!notificacaoRepository.existsById(notificacaoId)){
            ResponseEntity.notFound().build();
            return;
        }

        notificacaoRepository.deleteById(notificacaoId);
        ResponseEntity.ok(notificacaoId);
    }

    @Transactional
    public void excluirTudo(Long usuarioId){

        notificacaoRepository.deleteByIdUsuario(usuarioId);
        ResponseEntity.ok(usuarioId);
    }

}

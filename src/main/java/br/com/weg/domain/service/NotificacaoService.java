package br.com.weg.domain.service;

import br.com.weg.api.assembler.NotificacaoAssembler;
import br.com.weg.api.model.CardsDTO;
import br.com.weg.api.model.NotificacaoDTO;
import br.com.weg.domain.model.Apontamento;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.model.Notificacao;
import br.com.weg.domain.model.Usuario;
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
    private UsuarioService usuarioService;

    public List<NotificacaoDTO> listar() {
        return notificacaoAssembler.toCollectionModel(notificacaoRepository.findAll());
    }

    public List<NotificacaoDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return notificacaoAssembler.toCollectionModel(notificacaoRepository.findByUsuarioId(usuarioId));
    }
    @Transactional
    public ResponseEntity<Object> excluir(Long notificacaoId){

        if(!notificacaoRepository.existsById(notificacaoId)){
            return ResponseEntity.notFound().build();
        }

        notificacaoRepository.deleteById(notificacaoId);
        return ResponseEntity.ok(notificacaoId);
    }

    @Transactional
    public ResponseEntity<Object> excluirTudo(Long usuarioId){

        notificacaoRepository.deleteByIdUsuario(usuarioId);
        return ResponseEntity.ok(usuarioId);
    }

}

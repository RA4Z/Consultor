package br.com.weg.api.controller;

import br.com.weg.api.model.NotificacaoDTO;
import br.com.weg.api.model.UsuarioDTO;
import br.com.weg.domain.model.Usuario;
import br.com.weg.domain.service.NotificacaoService;
import br.com.weg.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    private NotificacaoService notificacaoService;
    private UsuarioService usuarioService;

    @GetMapping
    public List<NotificacaoDTO> listar() {
        return notificacaoService.listar();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<NotificacaoDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return notificacaoService.listarPorUsuario(usuarioId);
    }
    @DeleteMapping("/{notificacaoId}")
    public ResponseEntity<NotificacaoDTO> remover(@Valid @PathVariable Long notificacaoId) {

        notificacaoService.excluir(notificacaoId);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/tudo/{email}")
    public ResponseEntity<NotificacaoDTO> removerTudo(@Valid @PathVariable String email) {
        List<UsuarioDTO> usuario = usuarioService.listarEmail(email);
        Usuario user = new Usuario();
        user.setId(usuario.get(0).getId());
        notificacaoService.excluirTudo(user.getId());

        return ResponseEntity.noContent().build();
    }

}

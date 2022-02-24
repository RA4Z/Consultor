package br.com.weg.api.controller;

import br.com.weg.api.model.CardsDTO;
import br.com.weg.api.model.NotificacaoDTO;
import br.com.weg.api.model.UsuarioDTO;
import br.com.weg.domain.model.Usuario;
import br.com.weg.domain.service.NotificacaoService;
import br.com.weg.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;
    private CardsController cardsController;
    private NotificacaoController notificacaoController;

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{email}")
    public List<UsuarioDTO> listarEmail(@PathVariable String email) {
        return usuarioService.listarEmail(email);
    }

    @GetMapping("/cards/{email}")
    public List<CardsDTO> usarEmail(@PathVariable String email) {
        List<UsuarioDTO> usuario = usuarioService.listarEmail(email);
        Usuario user = new Usuario();
        user.setId(usuario.get(0).getId());

        return cardsController.listarPorUsuario(user.getId());
    }
    @GetMapping("/cards/{email}/{filtro}")
    public List<CardsDTO> usarEmailFiltrado(@PathVariable String email, @PathVariable String filtro) {
        List<UsuarioDTO> usuario = usuarioService.listarEmail(email);
        Usuario user = new Usuario();
        user.setId(usuario.get(0).getId());
        List<CardsDTO> cardsDTOS = cardsController.listarPorUsuario(user.getId());
        return cardsDTOS.stream().filter(cards2 -> cards2.getStatus().equalsIgnoreCase(filtro))
                .collect(Collectors.toList());
    }

    @GetMapping("/notificacao/{email}")
    public List<NotificacaoDTO> usarEmailNotifica(@PathVariable String email) {
        List<UsuarioDTO> usuario = usuarioService.listarEmail(email);
        Usuario user = new Usuario();
        user.setId(usuario.get(0).getId());

        return notificacaoController.listarPorUsuario(user.getId());
    }
    @GetMapping("/texto/{email}/{nome}")
    public List<CardsDTO> filtroNome(@PathVariable String email,@PathVariable String nome) {
        List<UsuarioDTO> usuario = usuarioService.listarEmail(email);
        Usuario user = new Usuario();
        user.setId(usuario.get(0).getId());
        List<CardsDTO> cardsDTOS = cardsController.listarPorUsuario(user.getId());
        return cardsDTOS.stream().filter(cards2 -> cards2.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

}

package br.com.weg.api.controller;

import br.com.weg.api.model.CardsDTO;
import br.com.weg.api.model.UsuarioDTO;
import br.com.weg.domain.model.Usuario;
import br.com.weg.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    UsuarioService usuarioService;
    CardsController cardsController;

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
}

package br.com.weg.api.controller;

import br.com.weg.api.model.CardsDTO;
import br.com.weg.api.model.UsuarioDTO;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.model.Usuario;
import br.com.weg.domain.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/cards/{email}/{filtro}")
    public List<CardsDTO> usarEmailFiltrado(@PathVariable String email, @PathVariable String filtro) {
        List<UsuarioDTO> usuario = usuarioService.listarEmail(email);
        Usuario user = new Usuario();
        user.setId(usuario.get(0).getId());
        List<CardsDTO> cardsDTOS = cardsController.listarPorUsuario(user.getId());
        return cardsDTOS.stream().filter(cards2 -> cards2.getStatus().equalsIgnoreCase(filtro))
                .collect(Collectors.toList());
    }
}

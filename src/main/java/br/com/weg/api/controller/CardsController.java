package br.com.weg.api.controller;

import br.com.weg.api.model.CardsDTO;
import br.com.weg.domain.service.CardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cards")
public class CardsController {

    private CardsService cardsService;

    @GetMapping
    public List<CardsDTO> listar() {
        return cardsService.listar();
    }

    @GetMapping("/filtro/{status}")
    public List<CardsDTO> filtroStatus(@PathVariable String status) {
        return cardsService.filtroStatus(status);
    }

    @GetMapping("/filtro/pesquisa/{nome}")
    public List<CardsDTO> filtroNome(@PathVariable String nome) {
        return cardsService.filtroNome(nome);
    }

    @GetMapping("/{cardsId}")
    public ResponseEntity<CardsDTO> buscar(@PathVariable Long cardsId) {
        return cardsService.buscar(cardsId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<CardsDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return cardsService.listarPorUsuario(usuarioId);
    }

}

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

    @GetMapping("/{cardsId}")
    public ResponseEntity<CardsDTO> buscar(@PathVariable Long cardsId) {
        return cardsService.buscar(cardsId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<CardsDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return cardsService.listarPorUsuario(usuarioId);
    }

}

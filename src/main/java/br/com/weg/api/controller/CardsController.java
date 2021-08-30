package br.com.weg.api.controller;

import br.com.weg.api.model.CardsDTO;
import br.com.weg.domain.service.SolicitacaoCardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cards")
public class CardsController {

    private SolicitacaoCardsService solicitacaoCardsService;

    @GetMapping
    public List<CardsDTO> listar() {
        return solicitacaoCardsService.listar();
    }

    @GetMapping("/filtro/{status}")
    public List<CardsDTO> filtroStatus(@PathVariable String status) {
        return solicitacaoCardsService.filtroStatus(status);
    }

    @GetMapping("/filtro/pesquisa/{nome}")
    public List<CardsDTO> filtroNome(@PathVariable String nome) {
        return solicitacaoCardsService.filtroNome(nome);
    }

    @GetMapping("/{cardsId}")
    public ResponseEntity<CardsDTO> buscar(@PathVariable Long cardsId) {
        return solicitacaoCardsService.buscar(cardsId);
    }
}

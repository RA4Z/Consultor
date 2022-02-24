package br.com.weg.api.controller;

import br.com.weg.api.assembler.CardsAssembler;
import br.com.weg.api.model.CardsDTO;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.service.CardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cards")
public class CardsController {

    private CardsService cardsService;
    private CardsAssembler cardsAssembler;

    @GetMapping("/{cardsId}")
    public ResponseEntity<CardsDTO> buscar(@PathVariable Long cardsId) {
        return cardsService.buscar(cardsId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<CardsDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return cardsService.listarPorUsuario(usuarioId);
    }

    @PutMapping("/enviar/{cardsId}")
    @ResponseStatus(HttpStatus.CREATED)
    public CardsDTO editarStatus(@PathVariable Long cardsId){
        ResponseEntity<Cards> cardsResponseEntity = cardsService.enviarHoras(cardsId);

        return cardsAssembler.toModel(cardsResponseEntity.getBody());
    }

}

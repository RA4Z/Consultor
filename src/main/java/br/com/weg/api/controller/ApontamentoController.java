package br.com.weg.api.controller;

import br.com.weg.api.assembler.ApontamentosAssembler;
import br.com.weg.api.model.input.ApontamentoInputDTO;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.model.Apontamento;
import br.com.weg.api.model.ApontamentoDTO;
import br.com.weg.domain.service.CardsService;
import br.com.weg.domain.service.OcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cards/{cardsId}/apontamento")
public class ApontamentoController {

    private CardsService cardsService;
    private OcorrenciaService ocorrenciaService;
    private ApontamentosAssembler apontamentosAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApontamentoDTO registrar(@PathVariable Long cardsId, @Valid @RequestBody ApontamentoInputDTO apontamentoInputDTO){
        Apontamento apontamentoRegistrada = ocorrenciaService.registrar(cardsId, apontamentoInputDTO.getHoras(),
                apontamentoInputDTO.getDataRegistro());
        return apontamentosAssembler.toModel(apontamentoRegistrada);
    }

    @GetMapping
    public List<ApontamentoDTO> listar(@PathVariable Long cardsId){
        Cards cards = cardsService.buscaCard(cardsId);

        return apontamentosAssembler.toCollectionModel(cards.getApontamentos());
    }
}
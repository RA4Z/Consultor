package br.com.weg.api.controller;

import br.com.weg.api.assembler.ApontamentosAssembler;
import br.com.weg.api.model.input.ApontamentoInputDTO;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.model.Apontamento;
import br.com.weg.api.model.ApontamentoDTO;
import br.com.weg.domain.repository.ApontamentoRepository;
import br.com.weg.domain.service.ApontamentoService;
import br.com.weg.domain.service.CardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cards/{cardsId}/apontamento")
public class ApontamentoController {

    private CardsService cardsService;
    private ApontamentoService apontamentoService;
    private ApontamentosAssembler apontamentosAssembler;
    private ApontamentoRepository apontamentoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApontamentoDTO registrar(@PathVariable Long cardsId, @Valid @RequestBody ApontamentoInputDTO apontamentoInputDTO){
        Apontamento apontamentoRegistrada = apontamentoService.registrar(cardsId, apontamentoInputDTO.getHoras(),
                apontamentoInputDTO.getDataRegistro(), apontamentoInputDTO.getDescricao(), apontamentoInputDTO.getHoraInicial(),
                apontamentoInputDTO.getHoraFinal());
        return apontamentosAssembler.toModel(apontamentoRegistrada);
    }

    @GetMapping
    public List<ApontamentoDTO> listar(@PathVariable Long cardsId){
        Cards cards = cardsService.buscaCard(cardsId);

        return apontamentosAssembler.toCollectionModel(cards.getApontamentos());
    }

    @PutMapping("/{apontamentoId}/editar")
    @ResponseStatus(HttpStatus.CREATED)
    public ApontamentoDTO editar(@Valid @RequestBody ApontamentoInputDTO apontamentoInputDTO, @PathVariable Long apontamentoId){
        Apontamento novoApontamento = apontamentosAssembler.toEntity(apontamentoInputDTO);
        ResponseEntity<Apontamento> apontamentoResponseEntity = apontamentoService.editar(apontamentoId, novoApontamento);

        return apontamentosAssembler.toModel(apontamentoResponseEntity.getBody());
    }


    @DeleteMapping("/{apontamentoId}")
    public ResponseEntity<ApontamentoDTO> deletarApontamento(@PathVariable Long apontamentoId){
        if(!apontamentoRepository.existsById(apontamentoId)){
            return ResponseEntity.notFound().build();
        }

        apontamentoService.excluir(apontamentoId);

        return ResponseEntity.noContent().build();
    }
}

package br.com.weg.domain.service;

import br.com.weg.api.assembler.CardsAssembler;
import br.com.weg.api.model.CardsDTO;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.model.Pessoa;
import br.com.weg.domain.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SolicitacaoCardsService {

    private PessoaService pessoaService;
    private CardsRepository cardsRepository;
    private CardsAssembler cardsAssembler;

    public Cards solicitar(Cards cards) {
        Pessoa pessoa = pessoaService.buscar(cards.getPessoa().getId());
        cards.setPessoa(pessoa);

        return cardsRepository.save(cards);
    }
    public List<CardsDTO> listar() {
        return cardsAssembler.toCollectionModel(cardsRepository.findAll());
    }

    public List<CardsDTO> filtroStatus(String status) {
        return cardsAssembler.toCollectionModel(cardsRepository.findByStatus(status));
    }

    public ResponseEntity<CardsDTO> buscar(Long entregaId) {
        return cardsRepository.findById(entregaId)
                .map(entrega -> {
                    return ResponseEntity.ok(cardsAssembler.toModel(entrega));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
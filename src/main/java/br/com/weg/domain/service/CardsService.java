package br.com.weg.domain.service;

import br.com.weg.api.assembler.CardsAssembler;
import br.com.weg.api.model.CardsDTO;
import br.com.weg.domain.exception.EntidadeNaoEncontradaException;
import br.com.weg.domain.model.Apontamento;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.repository.ApontamentoRepository;
import br.com.weg.domain.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Service
public class CardsService {

    private CardsRepository cardsRepository;
    private CardsAssembler cardsAssembler;
    private ApontamentoRepository apontamentoRepository;
 
    public ResponseEntity<CardsDTO> buscar(Long entregaId) {
        return cardsRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(cardsAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<CardsDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return cardsAssembler.toCollectionModel(cardsRepository.findByUsuarioId(usuarioId));
    }
    public Cards buscaCard(Long cardId){
        return cardsRepository.findById(cardId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Card não encontrado."));
    }
    public void apagarHoras(Long apontamentoId) {
        Apontamento apontamento = apontamentoRepository.getById(apontamentoId);
        Cards card = cardsRepository.getById(apontamento.getCards().getId());
        card.setHoras(card.getHoras() - apontamento.getHoras());
        card = cardsRepository.save(card);
        ResponseEntity.ok(card);
    }

    public void editarHoras(Long apontamentoId, double horasApontamento) {
        Apontamento apontamento = apontamentoRepository.getById(apontamentoId);
        Cards card = cardsRepository.getById(apontamento.getCards().getId());
        card.setHoras(card.getHoras() - apontamento.getHoras());
        card.setHoras(card.getHoras() + horasApontamento);
        card = cardsRepository.save(card);
        ResponseEntity.ok(card);
    }

    public ResponseEntity<Cards> enviarHoras(@Valid @PathVariable Long cardsId) {
        if(!cardsRepository.existsById(cardsId)){
            return ResponseEntity.notFound().build();
        }
        Cards card = cardsRepository.getById(cardsId);
        card.setHorasEnviado(1);
        card = cardsRepository.save(card);
        return ResponseEntity.ok(card);
    }
}
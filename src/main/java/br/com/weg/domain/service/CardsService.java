package br.com.weg.domain.service;

import br.com.weg.api.assembler.CardsAssembler;
import br.com.weg.api.model.CardsDTO;
import br.com.weg.domain.exception.EntidadeNaoEncontradaException;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@AllArgsConstructor
@Service
public class CardsService {

    private CardsRepository cardsRepository;
    private CardsAssembler cardsAssembler;

 
    public List<CardsDTO> listar() {
        return cardsAssembler.toCollectionModel(cardsRepository.findAll());
    }

    public List<CardsDTO> filtroStatus(String status) {
        return cardsAssembler.toCollectionModel(cardsRepository.findByStatus(status));
    }

    public List<CardsDTO> filtroNome(String nome) {
        return cardsAssembler.toCollectionModel(cardsRepository.findByNome(nome));
    }

    public ResponseEntity<CardsDTO> buscar(Long entregaId) {
        return cardsRepository.findById(entregaId)
                .map(entrega -> {
                    return ResponseEntity.ok(cardsAssembler.toModel(entrega));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public List<CardsDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return cardsAssembler.toCollectionModel(cardsRepository.findByUsuarioId(usuarioId));
    }
    public Cards buscaCard(Long entregaId){
        return cardsRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Card não encontrado."));
    }
}
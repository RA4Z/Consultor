package br.com.weg.domain.service;

import br.com.weg.domain.exception.EntidadeNaoEncontradaException;
import br.com.weg.domain.model.Cards;
import br.com.weg.domain.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CardsService {

    private CardsRepository cardsRepository;

    public Cards buscaCard(Long entregaId){
        return cardsRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Card não encontrado."));
    }
}

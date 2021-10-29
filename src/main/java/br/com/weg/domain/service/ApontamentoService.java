package br.com.weg.domain.service;

import br.com.weg.domain.model.Cards;
import br.com.weg.domain.model.Apontamento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ApontamentoService {

    private CardsService cardsService;

    @Transactional
    public Apontamento registrar(Long cardId, int horas, String dataRegistro, String descricao, int horaInicial, int horaFinal){
        Cards cards = cardsService.buscaCard(cardId);

        return cards.adicionarApontamento(horas, dataRegistro, descricao, horaInicial, horaFinal);
    }
}

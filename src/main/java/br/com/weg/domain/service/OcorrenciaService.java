package br.com.weg.domain.service;

import br.com.weg.domain.model.Cards;
import br.com.weg.domain.model.Apontamento;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OcorrenciaService {

    private CardsService cardsService;

    @Transactional
    public Apontamento registrar(Long entregaId, int horas, String dataRegistro){
        Cards cards = cardsService.buscaCard(entregaId);

        return cards.adicionarOcorrencia(horas, dataRegistro);
    }
}

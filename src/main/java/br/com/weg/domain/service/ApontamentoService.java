package br.com.weg.domain.service;

import br.com.weg.domain.model.Cards;
import br.com.weg.domain.model.Apontamento;
import br.com.weg.domain.repository.ApontamentoRepository;
import br.com.weg.domain.repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
@AllArgsConstructor
public class ApontamentoService {

    private CardsService cardsService;
    private ApontamentoRepository apontamentoRepository;
    private CardsRepository cardsRepository;

    @Transactional
    public Apontamento registrar(Long cardId, double horas, String dataRegistro, String descricao, String horaInicial, String horaFinal){
        Cards cards = cardsService.buscaCard(cardId);

        return cards.adicionarApontamento(horas, dataRegistro, descricao, horaInicial, horaFinal);
    }

    public ResponseEntity<Apontamento> editar(@Valid @PathVariable Long apontamentoId, @RequestBody Apontamento apontamento) {

        if(!apontamentoRepository.existsById(apontamentoId)){
            return ResponseEntity.notFound().build();
        }
        apontamento.setId(apontamentoId);
        apontamento.setCards(cardsRepository.getProjeto(apontamentoId).get(0));
        apontamento = apontamentoRepository.save(apontamento);

        return ResponseEntity.ok(apontamento);
    }


    @Transactional
    public void excluir(Long apontamentoId){
        apontamentoRepository.deleteById(apontamentoId);
    }

}

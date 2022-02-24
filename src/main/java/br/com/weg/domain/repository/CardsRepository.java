package br.com.weg.domain.repository;

import br.com.weg.domain.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

    List<Cards> findByUsuarioId(Long usuarioId);

    @Query(value ="select * FROM cards where cards.id = (select cards_id from apontamento where apontamento.id = ?1)", nativeQuery = true)
    List<Cards> getProjeto(Long idApontamento);
}

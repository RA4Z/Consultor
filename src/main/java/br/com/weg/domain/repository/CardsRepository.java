package br.com.weg.domain.repository;

import br.com.weg.domain.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {

    List<Cards> findByStatus(String status);

}

package br.com.weg.domain.repository;

import br.com.weg.domain.model.Apontamento;
import br.com.weg.domain.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ApontamentoRepository extends JpaRepository<Apontamento, Long> {

}

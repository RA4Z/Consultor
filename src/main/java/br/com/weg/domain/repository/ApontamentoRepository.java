package br.com.weg.domain.repository;

import br.com.weg.domain.model.Apontamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApontamentoRepository extends JpaRepository<Apontamento, Long> {

}

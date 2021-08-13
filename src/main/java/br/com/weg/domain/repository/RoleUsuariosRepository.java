package br.com.weg.domain.repository;

import br.com.weg.domain.model.RoleUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleUsuariosRepository extends JpaRepository<RoleUsuarios, Long> {
}

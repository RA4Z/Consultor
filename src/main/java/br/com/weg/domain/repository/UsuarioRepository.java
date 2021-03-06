package br.com.weg.domain.repository;

import br.com.weg.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    Usuario findByEmail(String email);

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    List<Usuario> encontrarEmail(String email);
}

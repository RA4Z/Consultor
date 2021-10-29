package br.com.weg.domain.repository;

import br.com.weg.domain.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    List<Notificacao> findByNome(String nome);

    List<Notificacao> findByUsuarioId(Long usuarioId);

    @Transactional
    @Modifying
    @Query("delete from Notificacao n where n.usuario.id = ?1")
    void deleteByIdUsuario(Long usuarioId);

}

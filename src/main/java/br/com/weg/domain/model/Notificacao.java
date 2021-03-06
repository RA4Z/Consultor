package br.com.weg.domain.model;

import br.com.weg.domain.service.ValidationGroups;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

@Getter
@Setter
@Entity
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Valid
    @ConvertGroup(to = ValidationGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;
}

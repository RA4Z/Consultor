package br.com.senai.domain.model;

import br.com.senai.domain.service.ValidationGroups;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Valid
    @NotNull
    @Embedded
    private Destinatario destinatario;

    @Column(name = "card_status")
    private String status;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias = new ArrayList<>();

    public Ocorrencia adicionarOcorrencia(int horas, String dataRegistro){
        Ocorrencia ocorrencia = new Ocorrencia();

        ocorrencia.setHoras(horas);
        ocorrencia.setDataRegistro(dataRegistro);
        ocorrencia.setEntrega(this);

        destinatario.setHoras(destinatario.getHoras()+horas);

        this.getOcorrencias().add(ocorrencia);

        return ocorrencia;
    }
}

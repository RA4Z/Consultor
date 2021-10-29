package br.com.weg.domain.model;

import br.com.weg.domain.service.ValidationGroups;
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
@Table(name = "cards")
public class Cards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "card_secao")
    String secao;

    @Column(name = "card_nome")
    String nome;

    @Column(name = "card_datainicio")
    String dataInicio;

    @Column(name = "card_dataestimada")
    String dataEstimada;

    @Column(name = "card_horas")
    int horas;

    @Column(name = "card_status")
    private String status;

    @Column(name = "horas_enviado")
    private int horasEnviado;

    @Column(name = "horas_aprovado")
    private int horasAprovado;

    @OneToMany(mappedBy = "cards", cascade = CascadeType.ALL)
    private List<Apontamento> apontamentos = new ArrayList<>();

    public Apontamento adicionarApontamento(int horas, String dataRegistro, String descricao, int horaInicial, int horaFinal){
        Apontamento apontamento = new Apontamento();

        apontamento.setHoraInicial(horaInicial);
        apontamento.setHoraFinal(horaFinal);
        apontamento.setHoras(horas);
        apontamento.setDataRegistro(dataRegistro);
        apontamento.setDescricao(descricao);
        apontamento.setCards(this);

        this.setHoras(this.getHoras()+horas);

        this.getApontamentos().add(apontamento);

        return apontamento;
    }
}

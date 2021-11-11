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
import java.text.DecimalFormat;

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
    private String secao;

    @Column(name = "card_nome")
    private String nome;

    @Column(name = "card_datainicio")
    private String dataInicio;

    @Column(name = "card_dataestimada")
    private String dataEstimada;

    @Column(name = "card_tempolimite")
    private int tempoLimite;

    @Column(name = "card_horas")
    private double horas;

    @Column(name = "card_status")
    private String status;

    @Column(name = "horas_enviado")
    private int horasEnviado;

    @Column(name = "horas_aprovado")
    private int horasAprovado;

    @OneToMany(mappedBy = "cards", cascade = CascadeType.ALL)
    private List<Apontamento> apontamentos = new ArrayList<>();

    public Apontamento adicionarApontamento(double horas, String dataRegistro, String descricao, String horaInicial, String horaFinal){
        if(this.getHoras()+horas < this.tempoLimite+1 && horas < 11) {

            DecimalFormat df = new DecimalFormat("##.##");
            Apontamento apontamento = new Apontamento();
            String ayuda = df.format(horas);
            ayuda = ayuda.replaceAll(",", ".");
            double hora = Double.parseDouble(ayuda);

            apontamento.setHoraInicial(horaInicial);
            apontamento.setHoraFinal(horaFinal);
            apontamento.setHoras(hora);
            apontamento.setDataRegistro(dataRegistro);
            apontamento.setDescricao(descricao);
            apontamento.setCards(this);

            this.setHoras(this.getHoras() + horas);

            this.getApontamentos().add(apontamento);

            return apontamento;
        }
        else{
            return null;
        }
    }
}

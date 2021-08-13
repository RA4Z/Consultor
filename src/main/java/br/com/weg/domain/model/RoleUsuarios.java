package br.com.weg.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class RoleUsuarios{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String nomeRole;

}

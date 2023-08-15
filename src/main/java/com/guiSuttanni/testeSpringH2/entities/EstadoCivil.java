package com.guiSuttanni.testeSpringH2.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estado_civil")
public class EstadoCivil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstadoCivil;
    private String nomeEstadoCivil;

    public Long getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(Long idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public String getNomeEstadoCivil() {
        return nomeEstadoCivil;
    }

    public void setNomeEstadoCivil(String nomeEstadoCivil) {
        this.nomeEstadoCivil = nomeEstadoCivil;
    }
}

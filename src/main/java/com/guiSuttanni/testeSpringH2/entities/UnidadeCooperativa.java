package com.guiSuttanni.testeSpringH2.entities;

import javax.persistence.*;
@Entity
@Table(name = "unidades_cooperativa")
public class UnidadeCooperativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidade;
    private String codigoInterno;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_municipio")
    private Municipio municipio;

    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}

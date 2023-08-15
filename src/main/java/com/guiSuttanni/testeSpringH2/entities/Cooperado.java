package com.guiSuttanni.testeSpringH2.entities;

import javax.persistence.*;

@Entity
@Table(name = "cooperados")
public class Cooperado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCooperado;
    private String conceito;

    @ManyToOne
    @JoinColumn(name = "id_pessoa_fisica")
    private PessoaFisica idPessoaFisica;

    @ManyToOne
    @JoinColumn(name = "id_pessoa_juridica")
    private PessoaJuridica idPessoaJuridica;

    public Long getIdCooperado() {
        return idCooperado;
    }

    public void setIdCooperado(Long idCooperado) {
        this.idCooperado = idCooperado;
    }

    public String getConceito() {
        return conceito;
    }

    public void setConceito(String conceito) {
        this.conceito = conceito;
    }

    public PessoaFisica getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(PessoaFisica idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

    public PessoaJuridica getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(PessoaJuridica idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }
}

package com.guiSuttanni.testeSpringH2.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoaJuridica;
    private String nome;
    private Date dataFundacaoEmpresa;

    public Long getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(Long idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataFundacaoEmpresa() {
        return dataFundacaoEmpresa;
    }

    public void setDataFundacaoEmpresa(Date dataFundacaoEmpresa) {
        this.dataFundacaoEmpresa = dataFundacaoEmpresa;
    }
}

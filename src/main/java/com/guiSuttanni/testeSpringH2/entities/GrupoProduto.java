package com.guiSuttanni.testeSpringH2.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grupo_produto")
public class GrupoProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupoProduto;
    private String nome;

    public Long getIdGrupoProduto() {
        return idGrupoProduto;
    }

    public void setIdGrupoProduto(Long idGrupoProduto) {
        this.idGrupoProduto = idGrupoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

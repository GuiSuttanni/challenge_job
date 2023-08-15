package com.guiSuttanni.testeSpringH2.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String codigoInterno;
    private String nomeComercial;
    private String formulaPrincipioAtivo;
    private String unidadeMedidaPadrao;

    @ManyToOne
    @JoinColumn(name = "id_grupo_produto")
    private GrupoProduto grupoProduto;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNomeComercial() {
        return nomeComercial;
    }

    public void setNomeComercial(String nomeComercial) {
        this.nomeComercial = nomeComercial;
    }

    public String getFormulaPrincipioAtivo() {
        return formulaPrincipioAtivo;
    }

    public void setFormulaPrincipioAtivo(String formulaPrincipioAtivo) {
        this.formulaPrincipioAtivo = formulaPrincipioAtivo;
    }

    public String getUnidadeMedidaPadrao() {
        return unidadeMedidaPadrao;
    }

    public void setUnidadeMedidaPadrao(String unidadeMedidaPadrao) {
        this.unidadeMedidaPadrao = unidadeMedidaPadrao;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }
}

package com.guiSuttanni.testeSpringH2.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "dados_tributacoes")
public class DadosTributacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTributacao;
    private String finalidadeProduto;
    private String ufOrigem;
    private String ufDestino;
    private BigDecimal aliquotaIcms;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Long getIdTributacao() {
        return idTributacao;
    }

    public void setIdTributacao(Long idTributacao) {
        this.idTributacao = idTributacao;
    }

    public String getFinalidadeProduto() {
        return finalidadeProduto;
    }

    public void setFinalidadeProduto(String finalidadeProduto) {
        this.finalidadeProduto = finalidadeProduto;
    }

    public String getUfOrigem() {
        return ufOrigem;
    }

    public void setUfOrigem(String ufOrigem) {
        this.ufOrigem = ufOrigem;
    }

    public String getUfDestino() {
        return ufDestino;
    }

    public void setUfDestino(String ufDestino) {
        this.ufDestino = ufDestino;
    }

    public BigDecimal getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(BigDecimal aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}

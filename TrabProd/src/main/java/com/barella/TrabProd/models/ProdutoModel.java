package com.barella.TrabProd.models;

import com.barella.TrabProd.Enums.ProdutoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ProdutoModel {
    private long id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    @Enumerated(EnumType.STRING)
    private ProdutoEnum status;

    public ProdutoModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

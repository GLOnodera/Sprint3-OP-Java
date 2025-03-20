package com.saudebucal.model;

import jakarta.persistence.*;

@Entity
public class ItemMarketplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private int pontosNecessarios;

    // Construtores
    public ItemMarketplace() {}

    public ItemMarketplace(String nome, String descricao, int pontosNecessarios) {
        this.nome = nome;
        this.descricao = descricao;
        this.pontosNecessarios = pontosNecessarios;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPontosNecessarios() {
        return pontosNecessarios;
    }

    public void setPontosNecessarios(int pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }
}
package com.saudebucal.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class HabitoBucal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private LocalDate data;
    private int pontosGerados;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Construtores
    public HabitoBucal() {}

    public HabitoBucal(String descricao, LocalDate data, int pontosGerados, User user) {
        this.descricao = descricao;
        this.data = data;
        this.pontosGerados = pontosGerados;
        this.user = user;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPontosGerados() {
        return pontosGerados;
    }

    public void setPontosGerados(int pontosGerados) {
        this.pontosGerados = pontosGerados;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
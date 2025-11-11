package com.literaria.backend.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Batalha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "batalha", cascade = CascadeType.ALL)
    private List<Pergunta> perguntas;
    @OneToMany(mappedBy= "batalha", cascade = CascadeType.ALL)
    private List<Npcs> npcs;
    @ManyToOne
    @JoinColumn(name = "mundo_id")
    private Mundo mundo;
    @ManyToMany
    @JoinTable(
        name = "batalha_jogador",
        joinColumns = @JoinColumn(name = "batalha_id"),
        inverseJoinColumns = @JoinColumn(name = "jogador_id")
    )
    private Set<Jogador> jogadores = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public List<Npcs> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<Npcs> npcs) {
        this.npcs = npcs;
    }

    public Mundo getMundo() {
        return mundo;
    }

    public void setMundo(Mundo mundo) {
        this.mundo = mundo;
    }

    public java.util.Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(java.util.Set<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}

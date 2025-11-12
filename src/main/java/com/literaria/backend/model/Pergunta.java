package com.literaria.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;
    private int resposta;
    private String alternativa1;
    private String alternativa2;
    private String alternativa3;
    private String alternativa4;
    @ManyToOne
    @JoinColumn(name = "batalha_id")
    @JsonIgnore
    private Batalha batalha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public String getAlternativa1() {
        return alternativa1;
    }

    public void setAlternativa1(String alternativa1) {
        this.alternativa1 = alternativa1;
    }

    public String getAlternativa2() {
        return alternativa2;
    }

    public void setAlternativa2(String alternativa2) {
        this.alternativa2 = alternativa2;
    }

    public String getAlternativa3() {
        return alternativa3;
    }

    public void setAlternativa3(String alternativa3) {
        this.alternativa3 = alternativa3;
    }

    public String getAlternativa4() {
        return alternativa4;
    }

    public void setAlternativa4(String alternativa4) {
        this.alternativa4 = alternativa4;
    }

    public Batalha getBatalha() {
        return batalha;
    }

    public void setBatalha(Batalha batalha) {
        this.batalha = batalha;
    }
}

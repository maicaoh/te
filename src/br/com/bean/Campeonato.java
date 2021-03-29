package br.com.bean;

public class Campeonato {

    private int idCampeonato;
    private String nome;
    private int qtdEquipe;

    public Campeonato(int idCampeonato, String nome, int qtdEquipe) {
        this.idCampeonato = idCampeonato;
        this.nome = nome;
        this.qtdEquipe = qtdEquipe;

    }

    public Campeonato() {
    }

    public int getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(int idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEquipe() {
        return qtdEquipe;
    }

    public void setQtdEquipe(int qtdEquipe) {
        this.qtdEquipe = qtdEquipe;
    }

}

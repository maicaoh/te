
package br.com.bean;


public class Campeonato {
    private int idCampeonato;
    private String nome;
    private int qtdEquipe;
    private double premiacao;
    private int turno;
    

    public Campeonato(int idCampeonato, String nome, int qtdEquipe, double premiacao, int turno) {
        this.idCampeonato = idCampeonato;
        this.nome = nome;
        this.qtdEquipe = qtdEquipe;
        this.premiacao = premiacao;
        this.turno = turno;
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

    public double getPremiacao() {
        return premiacao;
    }

    public void setPremiacao(double premiacao) {
        this.premiacao = premiacao;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bean;

public class Equipe {
    private int id;
    private String nome;
    private int numeroDeJogadores;
    private String Tecnico;
    private String Patrocinador;

    public Equipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeJogadores() {
        return numeroDeJogadores;
    }

    public void setNumeroDeJogadores(int numeroDeJogadores) {
        this.numeroDeJogadores = numeroDeJogadores;
    }

    public String getTecnico() {
        return Tecnico;
    }

    public void setTecnico(String Tecnico) {
        this.Tecnico = Tecnico;
    }

    public String getPatrocinador() {
        return Patrocinador;
    }

    public void setPatrocinador(String Patrocinador) {
        this.Patrocinador = Patrocinador;
    }
    
    
    
}

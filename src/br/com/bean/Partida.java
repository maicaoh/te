package br.com.bean;

public class Partida {

    private int idPartida;
    private int gol_casa;
    private int gol_fora;
    private int id_campeonato;
    private int idTimeCasa;
    private int idTimeFora;

    public Partida() {
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getGol_casa() {
        return gol_casa;
    }

    public void setGol_casa(int gol_casa) {
        this.gol_casa = gol_casa;
    }

    public int getGol_fora() {
        return gol_fora;
    }

    public void setGol_fora(int gol_fora) {
        this.gol_fora = gol_fora;
    }

    public int getId_campeonato() {
        return id_campeonato;
    }

    public void setId_campeonato(int id_campeonato) {
        this.id_campeonato = id_campeonato;
    }

    public int getIdTimeCasa() {
        return idTimeCasa;
    }

    public void setIdTimeCasa(int idTimeCasa) {
        this.idTimeCasa = idTimeCasa;
    }

    public int getIdTimeFora() {
        return idTimeFora;
    }

    public void setIdTimeFora(int idTimeFora) {
        this.idTimeFora = idTimeFora;
    }

}

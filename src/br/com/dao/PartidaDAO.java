/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;


import br.com.bean.Partida;
import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Random;
import javax.swing.JOptionPane;

public class PartidaDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;
    Partida partida = new Partida();

    public void cadastrarPartida(Partida partida) {
        Random aleatorio = new Random();
        String sql_consulta_geral = "insert into jogo values(null,?,?,?,?,?)";

        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1, aleatorio.nextInt(6));
            pst.setInt(2, aleatorio.nextInt(6));

            pst.setInt(3, partida.getId_campeonato());
            pst.setInt(4, partida.getIdTimeCasa());
            pst.setInt(5, partida.getIdTimeFora());
            pst.execute();
            Conexao.getConexao().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public int VerificarCampeonato(String nome) {
        String sql_consulta_geral = "select count(*) as qtd from campeonato inner join jogo on campeonato.id_campeonato = jogo.campeonato_id_campeonato where nome_campeonato = ?";

        int retorno = 0;
        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                retorno = (rs.getInt("qtd"));
            }
            Conexao.getConexao().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return retorno;
    }

    public String Partidas(int idCampeonato) {
        String sql_consulta_geral = "call partidas(?)";
        String contatenaPartidas = "";
        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1, idCampeonato);
            rs = pst.executeQuery();

            while (rs.next()) {
                contatenaPartidas += rs.getString("equipecasa");
                contatenaPartidas += (" ");
                contatenaPartidas += String.valueOf(rs.getInt("gol_casa"));
                contatenaPartidas += (" x ");
                contatenaPartidas += String.valueOf(rs.getInt("gol_fora"));
                contatenaPartidas += (" ");
                contatenaPartidas += rs.getString("equipefora");
                contatenaPartidas += ("\n");
            }
            Conexao.getConexao().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return contatenaPartidas;
    }

}

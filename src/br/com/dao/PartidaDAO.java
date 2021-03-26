/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.bean.Equipe;
import br.com.bean.Partida;
import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class PartidaDAO {
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        Partida partida = new Partida();

    public void cadastrarPartida(Partida partida){
        Random aleatorio = new Random();
        String sql_consulta_geral = "insert into jogo values(null,?,?,?,?,?)";
        
        
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1,aleatorio.nextInt(6)+1);    
            pst.setInt(2,aleatorio.nextInt(6)+1); 
            pst.setInt(3,partida.getId_campeonato());
            pst.setInt(4,partida.getIdTimeCasa());
            pst.setInt(5,partida.getIdTimeFora());
            pst.execute();
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        } 
        
    }
    
    public ArrayList<Integer> Partida(int idCampeonato) {
        
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int a;
        
        String sql_consulta_geral = "select * from jogo where campeonato_id_campeonato = ? ";
        Equipe equipe = new Equipe();
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1, idCampeonato);
            rs = pst.executeQuery();
            while(rs.next()){
                
                if(rs.getInt("gol_casa") > rs.getInt("gol_fora")){
                    a = lista.get(rs.getInt("Equipe_id_casa"));
                    lista.add(rs.getInt("Equipe_id_casa"), a + 3);
                }else if(rs.getInt("gol_casa") < rs.getInt("gol_fora")) {
                    a = lista.get(rs.getInt("Equipe_id_fora"));
                    lista.add(rs.getInt("Equipe_id_fora"), a + 3);
                }else{
                    a = lista.get(rs.getInt("Equipe_id_casa"));
                    lista.add(rs.getInt("Equipe_id_casa"), a + 1);
                    a = lista.get(rs.getInt("Equipe_id_fora"));
                    lista.add(rs.getInt("Equipe_id_fora"), a + 1);
                }                
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
    
    

}

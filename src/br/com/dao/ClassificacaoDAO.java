/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.bean.Campeonato;
import br.com.bean.Equipe;
import br.com.bean.GradeDeTime;
import br.com.bean.Partida;
import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class ClassificacaoDAO {
    
    
     PreparedStatement pst = null;
        ResultSet rs = null;
        Partida partida = new Partida();
    
    
    
    
    
    public GradeDeTime pontuacao(int idCampeonato, int idTime){
        String sql_consulta_geral = "call pontuacao(?,?)";
        Equipe equipe = new Equipe();
        GradeDeTime classificacao = new GradeDeTime();
        Campeonato campeonato = new Campeonato();
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1, campeonato.getIdCampeonato());
            pst.setInt(1, equipe.getId());
            rs = pst.executeQuery();
            while(rs.next()){
               classificacao.setPontos(rs.getInt("Total"));
               classificacao.setEquipe(rs.getString("Equipe"));
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
        return classificacao;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.bean.Campeonato;
import br.com.bean.Equipe;
import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class EquipeDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public ArrayList<String> nomeEquipe(){
        
        
        String sql_consulta_nome = "select nome_equipe from Equipe";
        ArrayList<String> nomes = new ArrayList<String>();
        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_nome);
            
            rs = pst.executeQuery();
           
            while(rs.next()){
                //camp.setIdCampeonato(rs.getInt("id_campeonato"));
               
                nomes.add(rs.getString("nome_equipe"));
               // camp.setPremiacao(rs.getDouble("premiacao"));
                //camp.setQtdEquipe(rs.getInt("casa_volta"));
               // camp.setTurno(rs.getInt("qtd_equipes_max"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return nomes;
    }

    public Equipe consultarPorNome(String nome) {
        String sql_consulta_geral = "select * from equipe where nome_equipe = ?";
        Equipe equipe = new Equipe();
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                equipe.setId(rs.getInt("id_equipe"));
                equipe.setNome(rs.getString("nome_equipe"));
                equipe.setNumeroDeJogadores(rs.getInt("numero_de_jogadores"));
                equipe.setPatrocinador(rs.getString("Tecnico"));
                equipe.setTecnico(rs.getString("Patrocinador_master"));
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
        return equipe;
    }
    
    public String consultarPorId(int nome) {
        String sql_consulta_geral = "select nome_equipe from equipe where id_equipe = ?";
        Equipe equipe = new Equipe();
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                return rs.getString("nome_equipe");                
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
        return "";
    }

    public void CadastrarEquipe(Equipe equipe) {
        String sql_consulta_geral = "insert into equipe values(null,?,?,?,?)";
      

        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setString(1, equipe.getNome());
            pst.setInt(2, equipe.getNumeroDeJogadores());
            pst.setString(3, equipe.getTecnico());
            pst.setString(4, equipe.getPatrocinador());
            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

    public void atualizarEquipe(Equipe equipe) {
        String sql_consulta_geral = "update equipe set nome_equipe = ?,numero_de_jogadores=?,tecnico=?,patrocinador_master=? where equipe.id_equipe = ?";
        Equipe equip = new Equipe();
        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setString(1, equipe.getNome());
            pst.setInt(2, equipe.getNumeroDeJogadores());
            pst.setString(3, equipe.getTecnico());
            pst.setString(4, equipe.getPatrocinador());
            System.out.println(equipe.getId());
            pst.setInt(5, equipe.getId());
            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluirEquipe(int id_equipe) {
        String sql_consulta_geral = "delete from equipe where equipe.id_equipe = ?";
        Equipe equipe = new Equipe();
        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1, id_equipe);
            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}

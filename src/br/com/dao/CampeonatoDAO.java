
package br.com.dao;

import br.com.bean.Campeonato;
import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CampeonatoDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;
  
   
    // buscar dados do Campeonato por nome
    public ArrayList<String> nomeCampeonato(){
        
        
        String sql_consulta_nome = "select nome_campeonato from Campeonato";
        ArrayList<String> nomes = new ArrayList<String>();
        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_nome);
            
            rs = pst.executeQuery();
           
            while(rs.next()){
                //camp.setIdCampeonato(rs.getInt("id_campeonato"));
               
                nomes.add(rs.getString("nome_campeonato"));
               // camp.setPremiacao(rs.getDouble("premiacao"));
                //camp.setQtdEquipe(rs.getInt("casa_volta"));
               // camp.setTurno(rs.getInt("qtd_equipes_max"));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return nomes;
    }
    
    public Campeonato consultarPorNome(String nome){
        String sql_consulta_geral = "select * from Campeonato where nome_campeonato = ?";
        Campeonato camp = new Campeonato();
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while(rs.next()){
                camp.setIdCampeonato(rs.getInt("id_campeonato"));
                camp.setNome(rs.getString("nome_campeonato"));
                camp.setPremiacao(rs.getDouble("premiacao"));
                camp.setQtdEquipe(rs.getInt("qtd_equipes_max"));
                camp.setTurno(rs.getInt("casa_volta"));
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
        return camp;
    } 
    
    public boolean CadastrarCampeonato(Campeonato campeonato){
        String sql_consulta_geral = "insert into campeonato values(null,?,?,?,?)";
        
        boolean result = false;
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setString(1, campeonato.getNome());
            pst.setInt(2,campeonato.getQtdEquipe());
            pst.setDouble(3,campeonato.getPremiacao());
            pst.setInt(4,campeonato.getTurno());
            result = pst.execute();
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        } 
        return result;
    }
   public boolean atualizarCampeonato(Campeonato campeonato){
        String sql_consulta_geral = "update campeonato set nome_campeonato = ?,qtd_equipes_max=?,premiacao=?,casa_volta=? where campeonato.id_campeonato = ?";
        Campeonato camp = new Campeonato();
        boolean result = false;
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setString(1, campeonato.getNome());
            pst.setInt(2,campeonato.getQtdEquipe());
            pst.setDouble(3,campeonato.getPremiacao());
            pst.setInt(4,campeonato.getTurno());
            pst.setInt(5,campeonato.getIdCampeonato());
            result = pst.execute();
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        } 
        return result;
   }
   
   public void excluirCampeonato(int id_campeonato){
        String sql_consulta_geral = "delete from campeonato where campeonato.id_campeonato = ?";
        Campeonato camp = new Campeonato();
        try{
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1,id_campeonato);
            pst.execute();
            
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        } 
       
   }
   
   
   
}

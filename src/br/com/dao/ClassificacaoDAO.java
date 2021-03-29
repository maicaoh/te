/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;


import br.com.bean.GradeDeTime;
import br.com.bean.Partida;
import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Michael
 */
public class ClassificacaoDAO {

    PreparedStatement pst = null;
    ResultSet rs = null;
    Partida partida = new Partida();

    public ArrayList<GradeDeTime> gerarClassificacao(int idCampeonato) {
        String sql_consulta_geral = "call classificacao(?)";

        ArrayList<GradeDeTime> gradeTime = new ArrayList<GradeDeTime>();
        try {
            pst = Conexao.getConexao().prepareStatement(sql_consulta_geral);
            pst.setInt(1, idCampeonato);
            rs = pst.executeQuery();

            while (rs.next()) {
                GradeDeTime grade = new GradeDeTime();
                grade.setEquipe(rs.getString("nome_equipe"));
                grade.setPontos(rs.getInt("pontos"));
                grade.setVitoria(rs.getInt("vitoria"));
                grade.setEmpate(rs.getInt("empate"));
                grade.setDerrota(rs.getInt("derrota"));
                gradeTime.add(grade);

            }
            Conexao.getConexao().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return gradeTime;
    }

}

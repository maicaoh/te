/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.bean.GradeDeTime;
import br.com.dao.ClassificacaoDAO;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class ClassificacaoController {

    public ArrayList<GradeDeTime> gerarClassificacaoController(int idCampeonato) {
        ClassificacaoDAO classificacaoDAO = new ClassificacaoDAO();
        return classificacaoDAO.gerarClassificacao(idCampeonato);

    }

}

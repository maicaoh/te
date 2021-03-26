/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.bean.GradeDeTime;
import br.com.dao.PartidaDAO;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class ClassificacaoController {
    ClassificacaoController classControl = new ClassificacaoController();
    public ArrayList<Integer> calssificacaoControl(int idCampeonato){
        
        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        
        
        PartidaDAO partidadao = new PartidaDAO();
        ArrayList<Integer> partidaInteger= partidadao.Partida(idCampeonato);
        
        lista.add(1, 0);
        lista.add(2, 0);
        lista.add(3, 0);
        for(int i = 0; i < partidaInteger.size(); i ++){
            if(partidaInteger.get(lista.get(1)) < partidaInteger.get(i))
                lista.add(1, i);
        }
        for(int i = 0; i < partidaInteger.size()-1; i ++){
            if(partidaInteger.get(lista.get(2)) < partidaInteger.get(i) && partidaInteger.get(i) != partidaInteger.get(lista.get(1)))
                lista.add(1, i);
        }
        for(int i = 0; i < partidaInteger.size()-1; i ++){
            if(partidaInteger.get(lista.get(3)) < partidaInteger.get(i) && partidaInteger.get(i) != partidaInteger.get(lista.get(1)) && partidaInteger.get(i) != partidaInteger.get(lista.get(2)))
                lista.add(1, i);
        }
        
        return lista;
    } 
}

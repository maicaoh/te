/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.bean.Campeonato;
import br.com.bean.Equipe;
import br.com.dao.CampeonatoDAO;
import br.com.dao.EquipeDAO;
import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class EquipeController {
    EquipeDAO equipeDao = new EquipeDAO();
    Equipe equipe = new Equipe();
    
    public void cadastrar(String nome,int qtdJogadores,String tecnico,String patrocinador){   
        equipe.setNome(nome);
        equipe.setNumeroDeJogadores(qtdJogadores);
        equipe.setPatrocinador(patrocinador);
        equipe.setTecnico(tecnico);  
        equipeDao.CadastrarEquipe(equipe);
    }
    public ArrayList<String> consultaNomeEquipe(){
        ArrayList<String> nomeEquipe = new ArrayList<String>();
        nomeEquipe = equipeDao.nomeEquipe();
        return nomeEquipe;
    }
    
    public Equipe consultaequipeControl(String nome){
        return equipeDao.consultarPorNome(nome);
    }
    
    public void atualizareqController(Equipe equipe){
        equipeDao.atualizarEquipe(equipe);
    }
    
    public void excluirCampeonatoControl(int id_equipe){
        equipeDao.excluirEquipe(id_equipe);
    }
}

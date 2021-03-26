
package br.com.controller;

import br.com.bean.Campeonato;
import br.com.dao.CampeonatoDAO;
import java.util.ArrayList;

public class CampeonatoController {
    CampeonatoDAO campeonatodao = new CampeonatoDAO();
    Campeonato campeonato = new Campeonato();
    
    public boolean cadastrar(String nome,double premiacao,int numeroDeEquipes,int turno){
        boolean result;
        campeonato.setNome(nome);
        campeonato.setPremiacao(premiacao);
        campeonato.setQtdEquipe(numeroDeEquipes);
        campeonato.setTurno(turno);
        result = campeonatodao.CadastrarCampeonato(campeonato);
        return result;
    }
    
    public ArrayList<String> consultaNomeCampeonato(){
        ArrayList<String> nomesCamp = new ArrayList<String>();
        nomesCamp = campeonatodao.nomeCampeonato();
        System.out.println(nomesCamp);
        return nomesCamp;
    }
    
    public Campeonato consultaCampControl(String nome){
        return campeonatodao.consultarPorNome(nome);
    }
    
    public boolean atualizarCampController(Campeonato campeonato){
        return campeonatodao.atualizarCampeonato(campeonato);
    }
    
    public void excluirCampeonatoControl(int id_campeonato){
        campeonatodao.excluirCampeonato(id_campeonato);
    }
    
}


package br.com.controller;

import br.com.bean.Partida;
import br.com.dao.PartidaDAO;
import br.com.bean.GradeDeTime;

public class JogoController {
    PartidaDAO partidadao = new PartidaDAO();
    Partida partida = new Partida();
    public void cadastroPartidaController(int id_campeonato,int idEquipeCasa,int idEquipeFora){
       
        partida.setId_campeonato(id_campeonato);
        partida.setIdTimeCasa(idEquipeCasa);
        partida.setIdTimeFora(idEquipeFora);
        partidadao.cadastrarPartida(partida);
    }
   
  
    
    
}


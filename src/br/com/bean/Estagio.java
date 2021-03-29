package br.com.bean;

import connection.Conexao;
import br.com.telas.home;

public class Estagio {

    public static void main(String[] args) {
        Conexao a = new Conexao();
        a.getConexao();

        home c = new home();
        c.setVisible(true);
    }

}

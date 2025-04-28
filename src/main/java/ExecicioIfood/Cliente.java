package ExecicioIfood;

import java.util.Observable;
import java.util.Observer;


public class Cliente implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}

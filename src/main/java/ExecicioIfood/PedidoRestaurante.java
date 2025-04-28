package ExecicioIfood;

import java.util.Observable;

public class PedidoRestaurante extends Observable implements IPedido{

    private String itemPedido;
    private PedidoEstado estado;

    public PedidoRestaurante(String itemPedido){
        this.itemPedido = itemPedido;
        this.estado = PedidoEstadoPagamentoValidade.getInstance();
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public void estadoPedido() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String pagamentoValidado() {
        return "";
    }

    @Override
    public String preparando() {
        return "";
    }

    @Override
    public String entregando() {
        return "";
    }

    @Override
    public String entregue() {
        return "";
    }

    @Override
    public String cancelado() {
        return "";
    }
}

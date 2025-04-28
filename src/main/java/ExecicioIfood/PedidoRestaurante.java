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
    public boolean pagamentoValidado() {
        return estado.validarPagamento(this);
    }

    @Override
    public boolean preparando() {

        return estado.prepararPedido(this);
    }

    @Override
    public boolean entregando() {

        return estado.rotaDeEntrega(this);
    }

    @Override
    public boolean entregue() {

        return estado.finalizar(this);
    }

    @Override
    public boolean cancelado() {

        return estado.cancelar(this);
    }
}

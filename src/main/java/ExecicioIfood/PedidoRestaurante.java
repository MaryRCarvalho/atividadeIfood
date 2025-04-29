package ExecicioIfood;

import java.util.Observable;

public class PedidoRestaurante extends Observable implements IPedido{

    private String itemPedido;
    private PedidoEstado estado;

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public PedidoEstado getEstado() {
         return estado;
    }

    public void setItemPedido(String itemPedido){
        this.itemPedido = itemPedido;
    }

    public PedidoEstado getItemPedido() {
         return itemPedido;
    }

    private void notificarCliente() {
        setChanged();
        notifyObservers();
    }

    @Override
    public void pagamentoValidado() {
        boolean resultado = estado.validarPagamento(this);
        if resultado == true {
            notificarCliente()
        }
    }

    @Override
    public void preparando() {

        boolean resultado = estado.prepararPedido(this);
        if resultado == true {
            notificarCliente()
        }
    }

    @Override
    public void entregando() {

        boolean resultado = estado.rotaDeEntrega(this);
        if resultado == true {
            notificarCliente()
        }
    }

    @Override
    public void entregue() {
        boolean resultado = estado.finalizar(this);
        if resultado == true {
            notificarCliente()
        }
    }

    @Override
    public void cancelado() {

        boolean resultado = estado.cancelar(this);
        if resultado == true {
            notificarCliente()
        }
    }
}

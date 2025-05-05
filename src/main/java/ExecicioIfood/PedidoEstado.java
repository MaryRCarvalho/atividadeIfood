package ExecicioIfood;

public abstract class PedidoEstado {

    public abstract String getEstado();

    public boolean validarPagamento(IPedido pedido) {
        return false;
    }

    public boolean prepararPedido(IPedido pedido) {
        return false;
    }

    public boolean rotaDeEntrega(IPedido pedido) {
        return false;
    }

    public boolean entregue(IPedido pedido) {
        return false;
    }

    public boolean cancelar(IPedido pedido) {
        return false;
    }
}

package ExecicioIfood;

public abstract class PedidoEstado {

    public abstract String getEstado();

    public boolean validarPagamento(PedidoFactory pedido) {
        return false;
    }

    public boolean prepararPedido(PedidoFactory pedido) {
        return false;
    }

    public boolean rotaDeEntrega(PedidoFactory pedido) {
        return false;
    }

    public boolean finalizar(PedidoFactory pedido) {
        return false;
    }

    public boolean cancelar(PedidoFactory pedido) {
        return false;
    }
}

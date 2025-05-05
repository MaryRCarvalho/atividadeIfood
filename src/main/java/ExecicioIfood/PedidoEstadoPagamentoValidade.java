package ExecicioIfood;

public class PedidoEstadoPagamentoValidade extends PedidoEstado {

    private PedidoEstadoPagamentoValidade() {};
    private static PedidoEstadoPagamentoValidade instance = new PedidoEstadoPagamentoValidade();
    public static PedidoEstadoPagamentoValidade getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pagamento validado";
    }

    public boolean prepararPedido(IPedido pedido) {
        pedido.setEstado(PedidoEstadoSendoPreparado.getInstance());
        return true;
    }

    public boolean cancelar(IPedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }

}

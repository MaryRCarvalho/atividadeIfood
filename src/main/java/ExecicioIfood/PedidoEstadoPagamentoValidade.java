package ExecicioIfood;

public class PedidoEstadoPagamentoValidade {

    private PedidoEstadoPagamentoValidade() {};
    private static PedidoEstadoPagamentoValidade instance = new PedidoEstadoPagamentoValidade();
    public static PedidoEstadoPagamentoValidade getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pagamento validado";
    }

}

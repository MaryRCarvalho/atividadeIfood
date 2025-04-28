package ExecicioIfood;

public class PedidoEstadoEntregue {

    private PedidoEstadoEntregue() {};
    private static PedidoEstadoEntregue instance = new PedidoEstadoEntregue();
    public static PedidoEstadoEntregue getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedindo entregue";
    }
}

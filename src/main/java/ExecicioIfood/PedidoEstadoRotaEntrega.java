package ExecicioIfood;

public class PedidoEstadoRotaEntrega {
    private PedidoEstadoRotaEntrega() {};
    private static PedidoEstadoRotaEntrega instance = new PedidoEstadoRotaEntrega();
    public static PedidoEstadoRotaEntrega getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedindo em rota de entrega";
    }
}

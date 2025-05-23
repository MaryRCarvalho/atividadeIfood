package ExecicioIfood;

public class PedidoEstadoRotaEntrega extends PedidoEstado {
    private PedidoEstadoRotaEntrega() {};
    private static PedidoEstadoRotaEntrega instance = new PedidoEstadoRotaEntrega();
    public static PedidoEstadoRotaEntrega getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido em rota de entrega";
    }
    
    public boolean entregue(IPedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }

    public boolean cancelar(IPedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}

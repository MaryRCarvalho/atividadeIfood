package ExecicioIfood;

public class PedidoEstadoSendoPreparado {

    private PedidoEstadoSendoPreparado() {};
    private static PedidoEstadoSendoPreparado instance = new PedidoEstadoSendoPreparado();
    public static PedidoEstadoSendoPreparado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedido sendo preparado";
    }

    public boolean rotaDeEntrega(IPedido pedido) {
        pedido.setEstado(PedidoEstadoRotaEntrega.getInstance());
        return true;
    }

    public boolean cancelar(IPedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}

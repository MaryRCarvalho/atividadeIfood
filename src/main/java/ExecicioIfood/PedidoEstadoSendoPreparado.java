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
}

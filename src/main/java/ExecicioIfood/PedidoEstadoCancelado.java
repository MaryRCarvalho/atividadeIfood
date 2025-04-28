package ExecicioIfood;

public class PedidoEstadoCancelado {

    private PedidoEstadoCancelado() {};
    private static PedidoEstadoCancelado instance = new PedidoEstadoCancelado();
    public static PedidoEstadoCancelado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Pedindo cancelado";
    }
}

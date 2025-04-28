package ExecicioIfood;

public interface IPedido {

    String pagamentoValidado();
    String preparando();
    String entregando();
    String entregue();
    String cancelado();
}

package ExecicioIfood;

public interface IPedido {

    boolean pagamentoValidado();
    boolean preparando();
    boolean entregando();
    boolean entregue();
    boolean cancelado();
}

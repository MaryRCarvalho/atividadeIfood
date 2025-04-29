package ExecicioIfood;

public interface IPedido {

    void setEstado(PedidoEstado estado);
    void pagamentoValidado();
    void preparando();
    void entregando();
    void entregue();
    void cancelado();

}

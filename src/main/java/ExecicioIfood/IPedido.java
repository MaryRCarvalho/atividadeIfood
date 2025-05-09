package ExecicioIfood;

import java.util.Observer;

public interface IPedido {

    void setItemPedido(String itemPedido);
    void setEstado(PedidoEstado estado);
    PedidoEstado getEstado();
    void pagamentoValidado();
    void preparando();
    void entregando();
    void entregue();
    void cancelado();

    void addObserver(Observer cliente);
}

package ExecicioIfood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedidoTest {

    private IPedido pedido;
    private Cliente cliente;

    @BeforeEach
    void setUp(){
        cliente = new Cliente("Ana");
        pedido = PedidoFactory.obterPedido("PedidoRestaurante");
        pedido.setEstado(PedidoEstadoPagamentoValidade.getInstance());
        pedido.setItemPedido("Hamburger");
    }

    void deveNotificarCliente() {
        cliente.acompanhar(pedido);
        assertEquals("Pagamento validado", pedido.getEstado());
    }

    @Test
    void ValidarEmPreparoQuandoPagamentoValido(){
        pedido.preparando();
        assertEquals ("Pedido sendo preparado", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pedido sendo preparado", cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmPreparoQuandoPagamentoValido(){
        pedido.entregando();
        assertEquals ("Pagamento validado", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pagamento validado", cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarFinalizadoQuandoPagamentoValido(){
        pedido.entregue();
        assertEquals ("Pagamento validado", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pagamento validado", cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarCanceladoQuandoPagamentoValido(){
        pedido.cancelado();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pedido cancelado", cliente.getUltimaNotificacao());
    }
    
//fazer para todos os estados possíveis
}
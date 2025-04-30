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
        pedido.notificarCliente();
        assertEquals("Ana, seu pedido está: ", aluno.getUltimaNotificacao());
    }

    @Test
    void ValidarEmPreparoQuandoEmEntrega(){
        pedido.entregando();
        assertEquals ("Pedindo em rota de entrega", pedido.getEstado().getEstado());
    }

    @Test
    void ValidarFinalizadoQuandoEmEntrega(){
        pedido.entregue();
        assertEquals ("Pagamento validado", pedido.getEstado().getEstado());
    }

    @Test
    void ValidarCanceladoQuandoEmEntrega(){
        pedido.cancelado();
        assertEquals ("Pedindo cancelado", pedido.getEstado().getEstado());
    }
//fazer para todos os estados possíveis
}
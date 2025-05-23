package ExecicioIfood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    @Test
    void deveNotificarCliente() {
        cliente.acompanhar(pedido);
        assertEquals("Pagamento validado", pedido.getEstado());
    }

    @Test
    void ValidarPagamentoValidoQuandoPagamentoValido(){
        cliente.acompanhar(pedido);
        pedido.pagamentoValidado();
        assertEquals ("Pagamento validado", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmPreparoQuandoPagamentoValido(){
        cliente.acompanhar(pedido);
        pedido.preparando();
        assertEquals ("Pedido sendo preparado", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pedido sendo preparado", cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmEntregaQuandoPagamentoValido(){
        cliente.acompanhar(pedido);
        pedido.entregando();
        assertEquals ("Pagamento validado", pedido.getEstado().getEstado());
        assertNull (cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarFinalizadoQuandoPagamentoValido(){
        cliente.acompanhar(pedido);
        pedido.entregue();
        assertEquals ("Pagamento validado", pedido.getEstado().getEstado());
        assertNull (cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarCanceladoQuandoPagamentoValido(){
        cliente.acompanhar(pedido);
        pedido.cancelado();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pedido cancelado", cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarPagamentoValidoQuandoEmPreparo(){
        pedido.setEstado(PedidoEstadoSendoPreparado.getInstance());
        cliente.acompanhar(pedido);
        pedido.pagamentoValidado();
        assertEquals ("Pedido sendo preparado", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmPreparoQuandoEmPreparo(){
        pedido.setEstado(PedidoEstadoSendoPreparado.getInstance());
        cliente.acompanhar(pedido);
        pedido.preparando();
        assertEquals ("Pedido sendo preparado", pedido.getEstado().getEstado());
        assertNull (cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmEntregaQuandoEmPreparo(){
        pedido.setEstado(PedidoEstadoSendoPreparado.getInstance());
        cliente.acompanhar(pedido);
        pedido.entregando();
        assertEquals ("Pedido em rota de entrega", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pedido em rota de entrega", cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarFinalizadoQuandoEmPreparo(){
        pedido.setEstado(PedidoEstadoSendoPreparado.getInstance());
        cliente.acompanhar(pedido);
        pedido.entregue();
        assertEquals ("Pedido sendo preparado", pedido.getEstado().getEstado());
        assertNull (cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarCanceladoQuandoEmPreparo(){
        pedido.setEstado(PedidoEstadoSendoPreparado.getInstance());
        cliente.acompanhar(pedido);
        pedido.cancelado();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pedido cancelado", cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarPagamentoValidoQuandoEmEntrega(){
        pedido.setEstado(PedidoEstadoRotaEntrega.getInstance());
        cliente.acompanhar(pedido);
        pedido.pagamentoValidado();
        assertEquals ("Pedido em rota de entrega", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmPreparoQuandoEmEntrega(){
        pedido.setEstado(PedidoEstadoRotaEntrega.getInstance());
        cliente.acompanhar(pedido);
        pedido.preparando();
        assertEquals ("Pedido em rota de entrega", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmEntregaQuandoEmEntrega(){
        pedido.setEstado(PedidoEstadoRotaEntrega.getInstance());
        cliente.acompanhar(pedido);
        pedido.entregando();
        assertEquals ("Pedido em rota de entrega", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarFinalizadoQuandoEmEntrega(){
        pedido.setEstado(PedidoEstadoRotaEntrega.getInstance());
        cliente.acompanhar(pedido);
        pedido.entregue();
        assertEquals ("Pedido entregue", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pedido entregue", cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarCanceladoQuandoEmEntrega(){
        pedido.setEstado(PedidoEstadoRotaEntrega.getInstance());
        cliente.acompanhar(pedido);
        pedido.cancelado();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertEquals ("Ana, seu pedido está: Pedido cancelado", cliente.getUltimaNotificacao());
    }


    @Test
    void ValidarPagamentoValidoQuandoFinalizado(){
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        cliente.acompanhar(pedido);
        pedido.pagamentoValidado();
        assertEquals ("Pedido entregue", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmPreparoQuandoFinalizado(){
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        cliente.acompanhar(pedido);
        pedido.preparando();
        assertEquals ("Pedido entregue", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmEntregaQuandoFinalizado(){
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        cliente.acompanhar(pedido);
        pedido.entregando();
        assertEquals ("Pedido entregue", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarFinalizadoQuandoFinalizado(){
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        cliente.acompanhar(pedido);
        pedido.entregue();
        assertEquals ("Pedido entregue", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarCanceladoQuandoFinalizado(){
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        cliente.acompanhar(pedido);
        pedido.cancelado();
        assertEquals ("Pedido entregue", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }


    @Test
    void ValidarPagamentoValidoQuandoCancelado(){
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        cliente.acompanhar(pedido);
        pedido.pagamentoValidado();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmPreparoQuandoCancelado(){
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        cliente.acompanhar(pedido);
        pedido.preparando();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarEmEntregaQuandoCancelado(){
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        cliente.acompanhar(pedido);
        pedido.entregando();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarFinalizadoQuandoCancelado(){
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        cliente.acompanhar(pedido);
        pedido.entregue();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }

    @Test
    void ValidarCanceladoQuandoCancelado(){
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        cliente.acompanhar(pedido);
        pedido.cancelado();
        assertEquals ("Pedido cancelado", pedido.getEstado().getEstado());
        assertNull(cliente.getUltimaNotificacao());
    }
//fazer para todos os estados possíveis
}
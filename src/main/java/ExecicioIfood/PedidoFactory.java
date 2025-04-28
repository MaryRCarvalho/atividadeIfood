package ExecicioIfood;

public class PedidoFactory {

    public static IPedido obterServico(String pedido) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("ExecicioIfood.Servico" + pedido);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Pedido inexistente");
        }
        if (!(objeto instanceof IPedido)) {
            throw new IllegalArgumentException("Pedido inválido");
        }
        return (IPedido) objeto;
    }
}

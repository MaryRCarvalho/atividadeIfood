package ExecicioIfood;

public class PedidoFactory {

    public static IPedido obterPedido(String pedido) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("ExecicioIfood" + pedido);
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

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        FilaVenda fila_venda = new FilaVenda(1);

        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);

        int contador_vendas = 0;
        Loja loja1 = new Loja("A", contador_vendas);

        Fabricante fabricante = new Fabricante();
    }
}

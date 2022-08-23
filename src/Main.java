import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        FilaVenda fila_venda = new FilaVenda(100);

        Semaphore mutex = new Semaphore( 1 );
        Semaphore itens = new Semaphore( 0 );
        Semaphore espacos = new Semaphore( 100 );

        int contador_vendas = 0;
        Loja loja1 = new Loja("A", contador_vendas, 1, fila_venda, mutex, itens, espacos);

        Fabricante fabricante = new Fabricante(fila_venda, mutex, itens, espacos);

        loja1.start();
        fabricante.start();
    }
}
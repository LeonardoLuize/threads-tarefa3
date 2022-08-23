import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        FilaVenda fila_venda = new FilaVenda();
        FilaEntrega fila_entrega = new FilaEntrega();

        Semaphore mutex = new Semaphore( 1 );
        Semaphore itens = new Semaphore( 0 );

        Semaphore mutexEntrega = new Semaphore( 1 );
        Semaphore entregas = new Semaphore( 0 );
        Semaphore espacos = new Semaphore( 100 );

        int contador_vendas = 0;
        Loja loja1 = new Loja("A", contador_vendas, 1, fila_venda, mutex, itens);

        Fabricante fabricante = new Fabricante(fila_venda, mutex, itens, espacos);
        Transportadora transportadora = new Transportadora(fila_entrega, mutexEntrega, entregas, espacos);

        loja1.start();
        fabricante.start();
    }
}
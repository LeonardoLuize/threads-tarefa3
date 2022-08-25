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

        Loja loja1 = new Loja("Loja-A", contador_vendas, 1, fila_venda, mutex, itens);
        Loja loja2 = new Loja("Loja-B", contador_vendas, 2, fila_venda, mutex, itens);
        Loja loja3 = new Loja("Loja-C", contador_vendas, 3, fila_venda, mutex, itens);
        Loja loja4 = new Loja("Loja-D", contador_vendas, 4, fila_venda, mutex, itens);
        Loja loja5 = new Loja("Loja-E", contador_vendas, 5, fila_venda, mutex, itens);
        Loja loja6 = new Loja("Loja-F", contador_vendas, 6, fila_venda, mutex, itens);
        Loja loja7 = new Loja("Loja-G", contador_vendas, 7, fila_venda, mutex, itens);
        Loja loja8 = new Loja("Loja-H", contador_vendas, 8, fila_venda, mutex, itens);

        Fabricante fabricante1 = new Fabricante(1, "fabricante-1", fila_venda, fila_entrega, mutex, itens, espacos, mutexEntrega, entregas, 4);
        Fabricante fabricante2 = new Fabricante(2, "fabricante-2", fila_venda, fila_entrega, mutex, itens, espacos, mutexEntrega, entregas, 1);
        Fabricante fabricante3 = new Fabricante(3, "fabricante-3", fila_venda, fila_entrega, mutex, itens, espacos, mutexEntrega, entregas, 4);
        Fabricante fabricante4 = new Fabricante(4, "fabricante-4", fila_venda, fila_entrega, mutex, itens, espacos, mutexEntrega, entregas, 4);

        Transportadora transportadora1 = new Transportadora(fila_entrega, mutexEntrega, entregas, espacos, 10, 100, 200);
        Transportadora transportadora2 = new Transportadora(fila_entrega, mutexEntrega, entregas, espacos, 20, 400, 600);

        loja1.start();
        loja2.start();
        loja3.start();
        loja4.start();
        loja5.start();
        loja6.start();
        loja7.start();
        loja8.start();

        fabricante1.start();
        fabricante2.start();
        fabricante3.start();
        fabricante4.start();

        transportadora1.start();
        transportadora2.start();
    }
}
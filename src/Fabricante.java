<<<<<<< HEAD
public class Fabricante extends Thread{

    private FilaVenda fila_vendas;

    public Fabricante(FilaVenda fila_vendas){
        this.fila_vendas = fila_vendas;
=======
import java.util.concurrent.Semaphore;

public class Fabricante extends Thread{

    private FilaVenda fila_vendas;
    private FilaEntrega fila_entrega;
    private Semaphore mutex;
    private Semaphore itens;
    private Semaphore espacos;

    public Fabricante(FilaVenda fila_vendas, FilaEntrega fila_entrega, Semaphore mutex, Semaphore itens, Semaphore espacos){
        this.fila_vendas = fila_vendas;
        this.fila_entrega = fila_entrega;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
>>>>>>> b9dbc86b3d86dca3ec6f86d54e2e6befb8b4d22f
    }

    public void run(){
        while (true){
<<<<<<< HEAD
            fila_vendas.pop();
=======
            try{
                itens.acquire();
                mutex.acquire();

                System.out.println();
                Venda fabricado = fila_vendas.pop();
                System.out.println("Fabricado: " + fabricado.getIdVenda());
                Entrega ent = fila_entrega.append(ent);

                mutex.release();
                espacos.release();
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
>>>>>>> b9dbc86b3d86dca3ec6f86d54e2e6befb8b4d22f
        }
    }
}
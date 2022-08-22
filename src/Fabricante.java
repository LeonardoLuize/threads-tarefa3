import java.util.concurrent.Semaphore;

public class Fabricante extends Thread{

    private FilaVenda fila_vendas;
    private Semaphore mutex;
    private Semaphore itens;
    private Semaphore espacos;

    public Fabricante(FilaVenda fila_vendas, Semaphore mutex, Semaphore itens, Semaphore espacos){
        this.fila_vendas = fila_vendas;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
    }

    public void run(){
        while (true){
            try{
                itens.acquire();
                mutex.acquire();

                System.out.println();
                Venda fabricado = fila_vendas.pop();
                System.out.println("Fabricado: " + fabricado.getIdVenda());

                mutex.release();
                espacos.release();
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
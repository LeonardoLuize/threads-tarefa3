import java.util.Date;
import java.util.concurrent.Semaphore;

public class Fabricante extends Thread{

    private int fabricanteId;
    private String nome;
    private FilaVenda fila_vendas;
    private FilaEntrega fila_entrega;
    private Semaphore mutex;
    private Semaphore itens;
    private Semaphore entregas;
    private Semaphore mutexEntrega;
    private Semaphore espacos;
    private Semaphore limiteFabricante;

    public Fabricante(int fabricanteId, String nome, FilaVenda fila_vendas, FilaEntrega fila_entrega, Semaphore mutex, Semaphore itens, Semaphore espacos, Semaphore mutexEntrega, Semaphore entregas, int limite){
        this.fabricanteId = fabricanteId;
        this.nome = nome;
        this.fila_vendas = fila_vendas;
        this.fila_entrega = fila_entrega;
        this.mutex = mutex;
        this.mutexEntrega = mutexEntrega;
        this.itens = itens;
        this.entregas = entregas;
        this.espacos = espacos;
        this.limiteFabricante = new Semaphore(limite);
    }

    public void run(){
        while (true){
            try{
                espacos.acquire();
                itens.acquire();
                mutex.acquire();
                mutexEntrega.acquire();
                limiteFabricante.acquire();
                Fabricacao fabricacao = new Fabricacao(this, fila_vendas, fila_entrega);
                fabricacao.start();
                fabricacao.join();
                limiteFabricante.release();
                mutexEntrega.release();
                mutex.release();
                entregas.release();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public int getFabricanteId() {
        return fabricanteId;
    }
}
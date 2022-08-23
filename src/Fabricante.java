import java.util.concurrent.Semaphore;

public class Fabricante extends Thread{

    private String nome;
    private FilaVenda fila_vendas;
    private FilaEntrega fila_entrega;
    private Semaphore mutex;
    private Semaphore itens;
    private Semaphore entregas;
    private Semaphore mutexEntrega;
    private Semaphore espacos;

    public Fabricante(String nome, FilaVenda fila_vendas, FilaEntrega fila_entrega, Semaphore mutex, Semaphore itens, Semaphore espacos, Semaphore mutexEntrega, Semaphore entregas){
        this.nome = nome;
        this.fila_vendas = fila_vendas;
        this.fila_entrega = fila_entrega;
        this.mutex = mutex;
        this.mutexEntrega = mutexEntrega;
        this.itens = itens;
        this.entregas = entregas;
        this.espacos = espacos;
    }

    public void run(){
        while (true){
            try{
                espacos.acquire();
                itens.acquire();
                mutex.acquire();
                mutexEntrega.acquire();

                System.out.println();
                Venda fabricado = fila_vendas.pop();
                System.out.println("Fabricado: " + fabricado.getIdVenda());
                fila_entrega.append(new Entrega(this.nome, fabricado.getProduto()));

                mutexEntrega.release();
                mutex.release();
                entregas.release();
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public String getNome() {
        return nome;
    }
}
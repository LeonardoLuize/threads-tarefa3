import java.util.concurrent.Semaphore;

public class Transportadora extends Thread{

    private FilaEntrega fila_entrega;
    private Semaphore mutex;

    public Transportadora(FilaEntrega fila_entrega, Semaphore mutex){
        this.fila_entrega = fila_entrega;
        this.mutex = mutex;
    }

    public void run(){
        while (true){
            try{
                //itens.acquire();
                mutex.acquire();

                Venda fabricado = fila_entrega.pop();
                System.out.println("Fabricado: " + fabricado.getIdVenda());

                mutex.release();
                //espacos.release();
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

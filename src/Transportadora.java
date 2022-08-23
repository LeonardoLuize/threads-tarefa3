import java.util.concurrent.Semaphore;

public class Transportadora extends Thread{

    private FilaEntrega fila_entrega;
    private Semaphore mutex;
    private Semaphore entregas;
    private Semaphore espacos;

    public Transportadora(FilaEntrega fila_entrega, Semaphore mutex, Semaphore entregas, Semaphore espacos){
        this.fila_entrega = fila_entrega;
        this.mutex = mutex;
        this.entregas = entregas;
        this.espacos = espacos;
    }

    public void run(){
        while (true){
            try{
                entregas.acquire();
                mutex.acquire();

                Entrega fabricado = fila_entrega.pop();
                System.out.println("Entregue: " + fabricado.getIdEntrega());

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

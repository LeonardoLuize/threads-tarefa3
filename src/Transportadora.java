import java.util.concurrent.Semaphore;

public class Transportadora extends Thread{

    private FilaEntrega fila_entrega;
    private Semaphore mutexEntregas;
    private Semaphore entregas;
    private Semaphore espacos;

    public Transportadora(FilaEntrega fila_entrega, Semaphore mutexEntregas, Semaphore entregas, Semaphore espacos){
        this.fila_entrega = fila_entrega;
        this.mutexEntregas = mutexEntregas;
        this.entregas = entregas;
        this.espacos = espacos;
    }

    public void run(){
        while (true){
            try{
                entregas.acquire();
                mutexEntregas.acquire();

                Entrega fabricado = fila_entrega.pop();
                System.out.println("Entregue: " + fabricado.getIdEntrega());

                mutexEntregas.release();
                espacos.release();
                Thread.sleep(3000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

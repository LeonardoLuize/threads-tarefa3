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
                System.out.println("\nEntregue: " + fabricado.getIdEntrega());
                Transporte transporte = new Transporte();

                mutexEntregas.release();
                espacos.release();
                transporte.start();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

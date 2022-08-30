import java.util.Date;
import java.util.concurrent.Semaphore;

public class Transportadora extends Thread{

    private FilaEntrega fila_entrega;
    private Semaphore mutexEntregas;
    private Semaphore entregas;
    private Semaphore espacos;
    private Semaphore limiteTransporte;
    private int minTime;
    private int maxTime;

    public Transportadora(FilaEntrega fila_entrega, Semaphore mutexEntregas, Semaphore entregas, Semaphore espacos, int limite, int minTime, int maxTime){
        this.fila_entrega = fila_entrega;
        this.mutexEntregas = mutexEntregas;
        this.entregas = entregas;
        this.espacos = espacos;
        this.limiteTransporte = new Semaphore(limite);
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public void run(){
        while (true){
            try{
                entregas.acquire();
                mutexEntregas.acquire();
                Date t1 = new Date();

                Entrega fabricado = fila_entrega.pop();
                System.out.println("\nEntregue produto: " + fabricado.getProduto());
                System.out.println("IdEntrega: " + fabricado.getIdEntrega());
                System.out.println("fila_entrega: " + fila_entrega.imprimir());
                limiteTransporte.acquire();
                Transporte transporte = new Transporte(minTime, maxTime);
                transporte.start();
                transporte.join();
                Date t2 = new Date();
                System.out.println("Tempo de transporte: " + (t2.getSeconds()-t1.getSeconds()) + " segundos");
                mutexEntregas.release();
                espacos.release();
                limiteTransporte.release();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

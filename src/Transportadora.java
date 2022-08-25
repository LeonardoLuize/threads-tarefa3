import java.util.concurrent.Semaphore;

public class Transportadora extends Thread{

    private FilaEntrega fila_entrega;
    private Semaphore mutexEntregas;
    private Semaphore entregas;
    private Semaphore espacos;
    private Semaphore limiteTransporte;

    public Transportadora(FilaEntrega fila_entrega, Semaphore mutexEntregas, Semaphore entregas, Semaphore espacos, Semaphore limiteTransporte){
        this.fila_entrega = fila_entrega;
        this.mutexEntregas = mutexEntregas;
        this.entregas = entregas;
        this.espacos = espacos;
        this.limiteTransporte = limiteTransporte;
    }

    public void run(){
        while (true){
            try{
                entregas.acquire();
                mutexEntregas.acquire();

                Entrega fabricado = fila_entrega.pop();
                System.out.println("\nEntregue: " + fabricado.getIdEntrega());

                limiteTransporte.acquire();
                Transporte transporte = new Transporte();

                mutexEntregas.release();
                espacos.release();
                transporte.start();
                limiteTransporte.release();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

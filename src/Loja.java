import java.security.spec.ECField;
import java.util.concurrent.Semaphore;

public class Loja extends Thread{

    private String nomeLoja;
    private int contadorVendas;

    private int id;
    private FilaVenda fila_venda;

    private Semaphore mutex;
    private Semaphore itens;
    private Semaphore espacos;

    public Loja(String nomeLoja, int contadorVendas, int id, FilaVenda fila_venda, Semaphore mutex, Semaphore itens, Semaphore espacos) {
        this.nomeLoja = nomeLoja;
        this.contadorVendas = contadorVendas;
        this.id = id;
        this.fila_venda = fila_venda;
        this.mutex = mutex;
        this.itens = itens;
        this.espacos = espacos;
    }


    public void run(){
        while (true){
            try{
                espacos.acquire();
                mutex.acquire();

                Venda venda = new Venda(this, "A");
                fila_venda.append(venda);
                System.out.println("Vendendo: " + venda.getProduto() + " Loja: " + venda.getIdVenda());

                mutex.release();
                itens.release();
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
    }



    public String getNomeLoja() {
        return nomeLoja;
    }

    public int getContadorVendas() {
        return contadorVendas;
    }
}
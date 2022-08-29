import java.util.Random;
import java.util.concurrent.Semaphore;

public class Loja extends Thread{

    private String nomeLoja;
    private int[] contadorVendas;
    private int idLoja;
    private FilaVenda fila_venda;
    private Semaphore mutex;
    private Semaphore itens;
    private Semaphore contador;
    private Produto[] produtos;

    public Loja(String nomeLoja, int[] contadorVendas, int idLoja, FilaVenda fila_venda, Semaphore mutex, Semaphore itens, Semaphore contador) {
        this.nomeLoja = nomeLoja;
        this.contadorVendas = contadorVendas;
        this.idLoja = idLoja;
        this.fila_venda = fila_venda;
        this.mutex = mutex;
        this.itens = itens;
        this.produtos = new Produto[8];
        this.contador = contador;

        produtos[0] = new Produto("A", 1000, 3000);
        produtos[1] = new Produto("B", 1000, 3000);
        produtos[2] = new Produto("C", 1000, 3000);
        produtos[3] = new Produto("D", 1000, 3000);
        produtos[4] = new Produto("E", 1000, 3000);
        produtos[5] = new Produto("F", 1000, 3000);
        produtos[6] = new Produto("G", 1000, 3000);
        produtos[7] = new Produto("H", 1000, 3000);
    }

    public void run(){
        while (true){
            try{
                mutex.acquire();
                Random random = new Random();
                int randomIndex = random.nextInt(0,7);

                contador.acquire();
                contadorVendas[0]++;
                contador.release();

                Venda venda = new Venda(this, produtos[randomIndex], contadorVendas[0]);
                fila_venda.append(venda);
                System.out.println("\nVendendo Produto: " + venda.getProduto().getNome());
                System.out.println("da: " + nomeLoja);
                System.out.println("Contador venda: " + contadorVendas[0]);
                System.out.println("fila_venda: " + fila_venda.imprimir());

                mutex.release();
                itens.release();
                Random random2 = new Random();
                Thread.sleep(random2.nextInt(1000 * 10, 1000 * 150));
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public int getIdLoja(){
        return idLoja;
    }

    public int getContadorVendas() {
        return contadorVendas[0];
    }
}
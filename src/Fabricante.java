public class Fabricante extends Thread{

    private FilaVenda fila_vendas;

    public Fabricante(FilaVenda fila_vendas){
        this.fila_vendas = fila_vendas;
    }

    public void run(){
        while (true){
            fila_vendas.pop();
        }
    }
}
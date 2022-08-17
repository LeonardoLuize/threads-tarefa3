public class Loja extends Thread{

    private String nomeLoja;
    private int contadorVendas;

    private int id;
    private FilaVenda fila_venda;

    public Loja(String nomeLoja, int contadorVendas, int id, FilaVenda fila_venda) {
        this.nomeLoja = nomeLoja;
        this.contadorVendas = contadorVendas;
        this.id = id;
        this.fila_venda = fila_venda;
    }


    public void run(){
        while (true){
            Venda venda = new Venda(this, "A");
            fila_venda.append(venda);
        }
    }



    public String getNomeLoja() {
        return nomeLoja;
    }

    public int getContadorVendas() {
        return contadorVendas;
    }
}
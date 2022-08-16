public class Loja extends Thread{

    public String nomeLoja;
    public int contadorVendas;

    public Loja(String nomeLoja, int contadorVendas) {
        this.nomeLoja = nomeLoja;
        this.contadorVendas = contadorVendas;
    }

}
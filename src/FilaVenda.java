import java.util.ArrayList;

public class FilaVenda {
    private ArrayList<Venda> fila;
    private int contador;
    private int local;

    public FilaVenda(){
        this.fila = new ArrayList<Venda>();
        this.contador = 0;
        this.local = 0;
    }

    public void append(Venda venda){
        fila.add(venda);
        this.contador++;
    }

    public Venda pop(){
        Venda excluida = fila.get(local);
        fila.remove(local);
        contador++;

        return excluida;
    }

    public ArrayList<Venda> getFila() {
        return fila;
    }
}

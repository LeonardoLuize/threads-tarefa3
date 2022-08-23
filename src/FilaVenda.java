import java.util.ArrayList;

public class FilaVenda {
    private ArrayList<Venda> fila;
    private int contador;

    public FilaVenda(){
        this.fila = new ArrayList<Venda>();
        this.contador = 0;
    }

    public void append(Venda venda){
        fila.add(venda);
    }

    public Venda pop(){
        Venda excluida = fila.get(contador);
        fila.remove(contador);
        contador++;

        return excluida;
    }

    public ArrayList<Venda> getFila() {
        return fila;
    }
}

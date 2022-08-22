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
        contador++;
    }

    public Venda pop(){
        Venda excluida = fila.get(contador - 1);
        fila.remove(contador - 1);
        contador--;

        return excluida;
    }

    public ArrayList<Venda> getFila() {
        return fila;
    }
}

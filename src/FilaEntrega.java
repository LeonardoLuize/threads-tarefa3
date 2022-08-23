import java.util.ArrayList;

public class FilaEntrega {
    private ArrayList<Entrega> fila;
    private int contador;

    public FilaEntrega(){
        this.fila = new ArrayList<Entrega>();
        this.contador = 0;
    }

    public void append(Entrega entrega){
        fila.add(entrega);
    }

    public Entrega pop(){
        Entrega concluida = fila.get(contador - 1);
        fila.remove(contador - 1);
        contador++;

        return concluida;
    }

    public ArrayList<Entrega> getFila() {
        return fila;
    }
}

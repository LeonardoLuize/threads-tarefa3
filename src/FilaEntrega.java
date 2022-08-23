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
        Entrega concluida = fila.get(contador);
        fila.remove(contador);
        contador++;

        return concluida;
    }

    public ArrayList<Entrega> getFila() {
        return fila;
    }
}

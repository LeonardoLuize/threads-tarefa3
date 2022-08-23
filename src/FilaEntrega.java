import java.util.ArrayList;

public class FilaEntrega {
    private ArrayList<Entrega> fila;
    private int contador;
    private int local;

    public FilaEntrega(){
        this.fila = new ArrayList<Entrega>();
        this.local = 0;
    }

    public void append(Entrega entrega){
        fila.add(entrega);
        contador++;
    }

    public Entrega pop(){
        Entrega concluida = fila.get(local);
        fila.remove(local);

        return concluida;
    }

    public ArrayList<Entrega> getFila() {
        return fila;
    }
}

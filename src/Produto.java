import java.util.Random;

public class Produto {
    private String nome;
    private int tempoMin;
    private int tempoMax;

    public Produto(String nome, int tempoMin, int tempoMax){
        this.nome = nome;
        this.tempoMin = tempoMin;
        this.tempoMax = tempoMax;
    }

    public int generateRandomTime(){
        Random random = new Random();
        return random.nextInt(tempoMin,tempoMax);
    }

    public String getNome() {
        return nome;
    }

    public int getTempoMin() {
        return tempoMin;
    }

    public int getTempoMax() {
        return tempoMax;
    }
}

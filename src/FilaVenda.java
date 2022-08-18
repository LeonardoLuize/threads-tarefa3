public class FilaVenda {
    private Venda[] fila;
    private int tamanho;
    private int contador;

    public FilaVenda(int tamanho){
        this.fila = new Venda[tamanho];
        this.tamanho = tamanho;
        this.contador = 0;
    }

    public void append(Venda venda){
        if(contador == tamanho){
            return;
        }

        fila[contador] = venda;
        contador++;
    }

    public Venda pop(){
        if(contador == 0){
            return new Venda();
        }

        Venda excluida = fila[contador - 1];
        fila[contador - 1] = null;
        contador--;

        return excluida;
    }

    public Venda[] getFila() {
        return fila;
    }

    public void setFila(Venda[] fila) {
        this.fila = fila;
    }
}

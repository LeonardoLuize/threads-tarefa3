public class Venda {
    private String idVenda;
    private Produto produto;

    public Venda(Loja loja, Produto produto, int numVenda){
        this.idVenda = String.format("%s-%d-%s", produto.getNome(), numVenda, loja.getNomeLoja());
        this.produto = produto;
    }

    public Venda(){
    }

    @Override
    public String toString() {
        return idVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getIdVenda() {
        return idVenda;
    }
}

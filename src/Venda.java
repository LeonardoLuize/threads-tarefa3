public class Venda {
    private String idVenda;
    private Produto produto;

    public Venda(Loja loja, Produto produto, int numVenda){
        this.idVenda = String.format("%s-%d/%s/%d", produto.getNome(), numVenda, loja.getNomeLoja(), loja.getIdLoja());
        this.produto = produto;
    }

    public Venda(){
    }

    public Produto getProduto() {
        return produto;
    }

    public String getIdVenda() {
        return idVenda;
    }
}

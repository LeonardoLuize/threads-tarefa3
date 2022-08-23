public class Venda {
    private String idVenda;
    private Produto produto;

    public Venda(Loja loja, Produto produto){
        this.idVenda = String.format("%s/%s/%d", produto.getNome(), loja.getNomeLoja(), loja.getIdLoja());
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

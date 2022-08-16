public class Venda {
    private String idVenda;
    private String produto;

    public Venda(Loja loja, String produto){
        this.idVenda = String.format("%s/%d", loja.getNome(), loja.getId());
        this.produto = produto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }
}

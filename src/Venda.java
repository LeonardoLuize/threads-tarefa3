public class Venda {
    private String idVenda;
    private String produto;

    public Venda(Loja loja, String produto){
        this.idVenda = String.format("%s/%d", loja.getNome(), loja.getId());
        this.produto = produto;
    }
}

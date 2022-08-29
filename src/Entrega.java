public class Entrega {

    private String idEntrega;
    private String produto;

    public Entrega(String fabricante,String produto){

        this.idEntrega = String.format("%s/%s", fabricante, produto);
        this.produto = produto;

    }

    @Override
    public String toString() {
        return idEntrega;
    }

    public String getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(String idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}

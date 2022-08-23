public class Entrega {

    private String idEntrega;
    private String produto;



    public Entrega(Fabricante fabricante,String produto){

        this.idEntrega = String.format("%s/%d", fabricante.getidFabricante(), produto);
        this.produto = produto;

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

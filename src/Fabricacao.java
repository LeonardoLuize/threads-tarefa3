public class Fabricacao extends Thread{
    private Fabricante fabricante;
    private FilaVenda fila_venda;
    private FilaEntrega fila_entrega;

    public Fabricacao(Fabricante fabricante, FilaVenda fila_venda, FilaEntrega fila_entrega){
        this.fabricante = fabricante;
        this.fila_venda = fila_venda;
        this.fila_entrega = fila_entrega;
    }

    public void run() {
        try {
            Venda fabricado = fila_venda.pop();
            Thread.sleep(fabricado.getProduto().generateRandomTime(fabricante.getFabricanteId(), fabricado.getProduto().getProdutoId()));
            System.out.println("\nFabricado: " + fabricado.getProduto().getNome());
            System.out.println("IdVenda: " + fabricado.getIdVenda());
            System.out.println("fila_venda: " + fila_venda.imprimir());

            fila_entrega.append(new Entrega(fabricante.getNome(), fabricado.getIdVenda()));
            System.out.println("fila_entrega: " + fila_entrega.imprimir());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

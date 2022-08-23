import java.util.Random;

public class Produto {
    private String nome;
    private int tempoMin;
    private int tempoMax;

    private int[] temposMin1;
    private int[] temposMin2;
    private int[] temposMin3;
    private int[] temposMin4;

    private int[] temposMax1;
    private int[] temposMax2;
    private int[] temposMax3;
    private int[] temposMax4;

    public Produto(String nome, int tempoMin, int tempoMax){
        this.nome = nome;
        this.tempoMin = tempoMin;
        this.tempoMax = tempoMax;

        this.temposMin1 = new int[8];
        this.temposMin2 = new int[8];
        this.temposMin3 = new int[8];
        this.temposMin4 = new int[8];

        temposMin1[0] = 600;
        temposMin1[1] = 200;
        temposMin1[2] = 1000;
        temposMin1[3] = 400;
        temposMin1[4] = 800;
        temposMin1[5] = 1400;
        temposMin1[6] = 400;
        temposMin1[7] = 800;

        temposMin2[0] = 400;
        temposMin2[1] = 800;
        temposMin2[2] = 1200;
        temposMin2[3] = 800;
        temposMin2[4] = 200;
        temposMin2[5] = 1000;
        temposMin2[6] = 1000;
        temposMin2[7] = 600;

        temposMin3[0] = 1000;
        temposMin3[1] = 1200;
        temposMin3[2] = 400;
        temposMin3[3] = 600;
        temposMin3[4] = 400;
        temposMin3[5] = 400;
        temposMin3[6] = 1000;
        temposMin3[7] = 400;

        temposMin4[0] = 800;
        temposMin4[1] = 600;
        temposMin4[2] = 400;
        temposMin4[3] = 1000;
        temposMin4[4] = 1200;
        temposMin4[5] = 800;
        temposMin4[6] = 600;
        temposMin4[7] = 1200;

        this.temposMax1 = new int[8];
        this.temposMax2 = new int[8];
        this.temposMax3 = new int[8];
        this.temposMax4 = new int[8];

        temposMax1[0] = 1000;
        temposMax1[1] = 400;
        temposMax1[2] = 1200;
        temposMax1[3] = 600;
        temposMax1[4] = 1000;
        temposMax1[5] = 1600;
        temposMax1[6] = 600;
        temposMax1[7] = 1000;

        temposMax2[0] = 600;
        temposMax2[1] = 1000;
        temposMax2[2] = 1400;
        temposMax2[3] = 1000;
        temposMax2[4] = 400;
        temposMax2[5] = 1200;
        temposMax2[6] = 1200;
        temposMax2[7] = 800;

        temposMax3[0] = 1200;
        temposMax3[1] = 1400;
        temposMax3[2] = 600;
        temposMax3[3] = 800;
        temposMax3[4] = 600;
        temposMax3[5] = 600;
        temposMax3[6] = 1200;
        temposMax3[7] = 600;

        temposMax4[0] = 1000;
        temposMax4[1] = 800;
        temposMax4[2] = 600;
        temposMax4[3] = 1200;
        temposMax4[4] = 1400;
        temposMax4[5] = 1000;
        temposMax4[6] = 800;
        temposMax4[7] = 1400;
    }

    public int generateRandomTime(int fabricanteId, int produtoId){
        Random random = new Random();

        if(fabricanteId == 1) return random.nextInt(temposMin1[produtoId],temposMax1[produtoId]);
        if(fabricanteId == 2) return random.nextInt(temposMin2[produtoId],temposMax2[produtoId]);
        if(fabricanteId == 3) return random.nextInt(temposMin3[produtoId],temposMax3[produtoId]);
        if(fabricanteId == 4) return random.nextInt(temposMin4[produtoId],temposMax4[produtoId]);

        return 0;
    }

    public int getProdutoId(){
        if(nome.equals("A")) return 1;
        if(nome.equals("B")) return 2;
        if(nome.equals("C")) return 3;
        if(nome.equals("D")) return 4;
        if(nome.equals("E")) return 5;
        if(nome.equals("F")) return 6;
        if(nome.equals("G")) return 7;
        if(nome.equals("H")) return 8;

        return 1;
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

import java.util.Random;

public class Transporte extends Thread{
    private int minTime;
    private int maxTime;

    public Transporte(int minTime, int maxTime){
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public void run() {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(10 * minTime, 10 * maxTime));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

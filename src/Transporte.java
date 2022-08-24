public class Transporte extends Thread{
    public Transporte(){
    }

    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

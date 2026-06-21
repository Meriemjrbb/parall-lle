package TP5;
import java.util.concurrent.Semaphore;
import java.util.Random;

class Boulanger extends Thread {
    private final Panier panier;
    private final Semaphore farine;

    public Boulanger(Panier p, Semaphore f) {
        panier = p;
        farine = f;
    }

    public void run() {
        try {
            while (true) {
                farine.acquire(); // attendre farine
                panier.deposer(new Baguette());
                Thread.sleep(300);
                farine.release(); // rendre farine
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

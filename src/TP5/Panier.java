package TP5;
import java.util.concurrent.Semaphore;
import java.util.Random;

class Panier {
    private final Baguette[] panier;
    private int in = 0, out = 0;
    private final Semaphore empty, full, mutex;

    public Panier(int size) {
        panier = new Baguette[size];
        empty = new Semaphore(size);
        full = new Semaphore(0);
        mutex = new Semaphore(1);
    }

    public void deposer(Baguette b) throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        panier[in] = b;
        in = (in + 1) % panier.length;
        System.out.println("Boulanger a déposé une baguette.");
        mutex.release();
        full.release();
    }

    public Baguette retirer() throws InterruptedException {
        full.acquire();
        mutex.acquire();
        Baguette b = panier[out];
        out = (out + 1) % panier.length;
        System.out.println("Vendeur a pris une baguette.");
        mutex.release();
        empty.release();
        return b;
    }
}

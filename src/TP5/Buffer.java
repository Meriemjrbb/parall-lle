package TP5;

import java.util.concurrent.Semaphore;

class Buffer {
    private final int[] buffer;
    private int in = 0, out = 0;
    private final Semaphore empty, full, mutex;

    public Buffer(int size) {
        buffer = new int[size];
        empty = new Semaphore(size); // cases libres
        full = new Semaphore(0);     // cases occupées
        mutex = new Semaphore(1);    // exclusion mutuelle
    }

    public void append(int item) throws InterruptedException {
        empty.acquire();   // attendre une case libre
        mutex.acquire();   // entrer en section critique
        buffer[in] = item;
        in = (in + 1) % buffer.length;
        System.out.println("Produit: " + item);
        mutex.release();   // sortir de section critique
        full.release();    // signaler qu'une case est remplie
    }

    public int take() throws InterruptedException {
        full.acquire();    // attendre un élément disponible
        mutex.acquire();   // entrer en section critique
        int item = buffer[out];
        out = (out + 1) % buffer.length;
        System.out.println("Consommé: " + item);
        mutex.release();   // sortir de section critique
        empty.release();   // signaler qu'une case est libre
        return item;
    }
}
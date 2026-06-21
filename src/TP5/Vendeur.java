package TP5;
import java.util.concurrent.Semaphore;
import java.util.Random;

class Vendeur extends Thread {
    private final Panier panier;
    private final int nbClients;
    private final Random rand = new Random();

    public Vendeur(Panier p, int clients) {
        panier = p;
        nbClients = clients;
    }

    public void run() {
        try {
            for (int i = 0; i < nbClients; i++) {
                int demande = 1 + rand.nextInt(3); // client demande 1 à 3 baguettes
                for (int j = 0; j < demande; j++) {
                    panier.retirer();
                }
                Thread.sleep(500);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

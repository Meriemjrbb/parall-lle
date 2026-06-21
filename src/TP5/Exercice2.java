package TP5;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Exercice2 {
    public static void main(String[] args) {
        Panier panier = new Panier(10);
        Semaphore farine = new Semaphore(1); // un employé qui donne la farine

        // 4 boulangers
        for (int i = 0; i < 4; i++) new Boulanger(panier, farine).start();

        // 3 vendeurs avec chacun 5 clients
        for (int i = 0; i < 3; i++) new Vendeur(panier, 5).start();
    }
}

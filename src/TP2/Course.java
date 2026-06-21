package TP2;

public class Course {
    public static void main(String[] args) {
        // Création de 3 coureurs
        Coureur c1 = new Coureur("Coureur 1");
        Coureur c2 = new Coureur("Coureur 2");
        Coureur c3 = new Coureur("Coureur 3");

        // Démarrage de la course
        c1.start();
        c2.start();
        c3.start();

        try {
            // On attend que tous aient terminé
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La course est terminée !");
    }
}

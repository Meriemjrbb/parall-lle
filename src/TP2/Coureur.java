package TP2;

class Coureur extends Thread {
    private String nom;
    private int distance = 0;

    public Coureur(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        while (distance < 100) {
            distance += 1; // avancer d’un mètre
            System.out.println(nom + " : " + distance + "m");

            try {
                Thread.sleep(50); // petite pause pour voir la progression
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nom + " a terminé la course !");
    }
}
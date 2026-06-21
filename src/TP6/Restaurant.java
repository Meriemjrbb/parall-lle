package TP6;

class Restaurant {
    private int nombreDePlats = 0;
    private final int LIMITE = 5;

    // Méthode pour servir un plat
    synchronized void servirPlat() {
        while (nombreDePlats == 0) {
            try {
                wait(); // attendre qu'un plat soit préparé
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nombreDePlats--;
        System.out.println("Un plat a été servi. Plats restants: " + nombreDePlats);
        notifyAll(); // réveille les chefs
    }

    // Méthode pour préparer un plat
    synchronized void preparerPlat() {
        while (nombreDePlats == LIMITE) {
            try {
                wait(); // attendre qu'un plat soit servi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nombreDePlats++;
        System.out.println("Un plat a été préparé. Plats disponibles: " + nombreDePlats);
        notifyAll(); // réveille les serveurs
    }
}

// Classe Chef
class Chef extends Thread {
    private Restaurant restaurant;

    Chef(Restaurant r) {
        this.restaurant = r;
    }

    public void run() {
        while (true) {
            restaurant.preparerPlat();
            try {
                Thread.sleep(500); // temps de préparation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Classe Serveur
class Serveur extends Thread {
    private Restaurant restaurant;

    Serveur(Restaurant r) {
        this.restaurant = r;
    }

    public void run() {
        while (true) {
            restaurant.servirPlat();
            try {
                Thread.sleep(800); // temps de service
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Programme principal
class TestRestaurant {
    public static void main(String[] args) {
        Restaurant r = new Restaurant();
        new Chef(r).start();
        new Chef(r).start();
        new Serveur(r).start();
        new Serveur(r).start();
    }
}

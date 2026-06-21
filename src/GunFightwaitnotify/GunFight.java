package GunFightwaitnotify;

public class GunFight {

    private int bullets = 40;

    synchronized public void fire(int bulletsToBeFired) {

        String threadName = Thread.currentThread().getName();
        System.out.println(">>> [1] " + threadName + " - Début du tir avec " + bullets + " balles");

        for (int i = 1; i <= bulletsToBeFired; i++) {

            if (bullets == 0) {
                System.out.println(">>> [2] " + threadName + " - " + bullets + " balles restantes");
                System.out.println(">>> [3] " + threadName + " - Appel de wait() - JE M'ENDORS");
                System.out.println(">>> [4] " + threadName + " - Libération du verrou...\n");

                try {
                    wait(); // 🔓 libère le verrou ici
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(">>> [7] " + threadName + " - JE ME RÉVEILLE !");
                System.out.println(">>> [8] " + threadName + " - Reprise du tir avec " + bullets + " balles");
            }

            bullets--;
        }

        System.out.println(">>> [9] " + threadName + " - Fin du tir. Balles restantes : " + bullets + "\n");
    }

    synchronized public void reload() {

        String threadName = Thread.currentThread().getName();
        System.out.println(">>> [5] " + threadName + " - Début du rechargement");

        bullets += 40;

        System.out.println(">>> [6] " + threadName + " - Rechargement terminé ! Nouvelles balles : " + bullets);
        System.out.println(">>> [6b] " + threadName + " - Appel de notify() - JE RÉVEILLE LE TIREUR\n");

        notify(); // 🔔 réveille le thread en attente
    }
}


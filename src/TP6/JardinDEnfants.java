package TP6;

class JardinDEnfants {
    private int nombreDeBalancoires;

    JardinDEnfants(int nb) {
        this.nombreDeBalancoires = nb;
    }

    synchronized void utiliserBalancoire(int idEnfant) {
        while (nombreDeBalancoires == 0) {
            try {
                wait(); // attendre qu'une balançoire se libère
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        nombreDeBalancoires--;
        System.out.println("Enfant " + idEnfant + " utilise une balançoire. Restantes: " + nombreDeBalancoires);
    }

    synchronized void libererBalancoire(int idEnfant) {
        nombreDeBalancoires++;
        System.out.println("Enfant " + idEnfant + " a libéré une balançoire. Disponibles: " + nombreDeBalancoires);
        notifyAll(); // réveille les enfants en attente
    }
}

class Enfant extends Thread {
    private int id;
    private JardinDEnfants jardin;

    Enfant(int id, JardinDEnfants j) {
        this.id = id;
        this.jardin = j;
    }

    public void run() {
        jardin.utiliserBalancoire(id);
        try {
            Thread.sleep(1000); // temps sur la balançoire
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jardin.libererBalancoire(id);
    }
}

class TestJardin {
    public static void main(String[] args) {
        JardinDEnfants jardin = new JardinDEnfants(2); // 2 balançoires
        for (int i = 1; i <= 5; i++) {
            new Enfant(i, jardin).start();
        }
    }
}

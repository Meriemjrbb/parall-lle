package TP2;

public class TestThread {
	public static void main(String[] args) {
        MonThread t1 = new MonThread("Thread 1 tourne...", 1000);
        MonThread t2 = new MonThread("Thread 2 tourne...", 1500);

        t1.start();
        t2.start();

        try {
            Thread.sleep(6000); // laisser tourner 6 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // arrêter les threads
        t1.stopThread();
        t2.stopThread();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("l’exécution des threads est terminée");
    }

}
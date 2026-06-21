package GunFightwaitnotify;

public class WaitDemo extends Thread {

    public static void main(String[] args) {

        System.out.println("=== DÉBUT DU PROGRAMME ===\n");

        GunFight gf = new GunFight();

        Thread fireThread = new Thread() {
            @Override
            public void run() {
                gf.fire(60);
            }
        };
        fireThread.setName("Thread-TIREUR");

        Thread reloadThread = new Thread() {
            @Override
            public void run() {
                gf.reload();
            }
        };
        reloadThread.setName("Thread-RECHARGEUR");

        fireThread.start();
        reloadThread.start();

        System.out.println("=== THREADS LANCÉS ===\n");
    }
}

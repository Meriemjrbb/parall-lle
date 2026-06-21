package TP2;

class MonThread extends Thread {
    private String texte;
    private int delai;
    private volatile boolean running = true; // pour arrêter proprement

    public MonThread(String texte, int delai) {
        this.texte = texte;
        this.delai = delai;
    }

    @Override
    public void run() {
        try {
            while(running) { // boucle infinie contrôlée
                System.out.println(texte);
                Thread.sleep(delai);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopThread() {
        running = false;
    }
}

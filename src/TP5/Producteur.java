package TP5;

class Producteur extends Thread {
    private final Buffer buffer;
    public Producteur(Buffer b) { buffer = b; }
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.append(i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

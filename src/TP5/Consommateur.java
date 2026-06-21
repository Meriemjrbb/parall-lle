package TP5;

class Consommateur extends Thread {
    private final Buffer buffer;
    public Consommateur(Buffer b) { buffer = b; }
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.take();
                Thread.sleep(500);
            }
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

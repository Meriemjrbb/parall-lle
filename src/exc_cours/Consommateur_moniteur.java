package exc_cours;

public class Consommateur_moniteur extends Thread {
	private Stock_Propre stock;

    public Consommateur_moniteur(Stock_Propre stock) {
        this.stock = stock;
    }
	@Override
	public void run() {
		
		for(int i=0;i<20;i++) {
		stock.retraitArticle();
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			System.out.println("Thread Interrompu");
		}
		}
	}
	
}

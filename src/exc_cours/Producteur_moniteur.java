package exc_cours;

public class Producteur_moniteur extends Thread {
	 private Stock_Propre stock;

	    public Producteur_moniteur(Stock_Propre stock) {
	        this.stock = stock;
	    }
	@Override
	public void run() {
		
		for(int i=0;i<20;i++) {
		stock.ajoutArticle();
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			System.out.println("Thread Interrompu");
		}
		}
	}
	
}

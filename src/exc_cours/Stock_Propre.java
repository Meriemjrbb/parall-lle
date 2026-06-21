package exc_cours;

public class Stock_Propre {
	int stock=7;
	int max_stock=7;
	
	public synchronized void  ajoutArticle() {
		if(stock==max_stock) {
			try {
				System.out.println("Stock plein :Producteur attend");
				wait();
				
			}catch(InterruptedException e) {
				System.out.println("Stock plein : Producteur n'est pas en attente");
			}
		}
		stock++;
		System.out.println("Article ajouté au stock, stock="+stock);
		notifyAll();
	}
	
	public synchronized void retraitArticle() {
		if(stock==0) {
			try {
				System.out.println("Stock vide :Consommateur attend");
				wait();
				
			}catch(InterruptedException e) {
				System.out.println("Stock vide : Consommateur n'est pas en attente");
			}
		}
		stock--;
		System.out.println("Article retiré du stock, stock="+stock);
		notifyAll();
	}
	

}

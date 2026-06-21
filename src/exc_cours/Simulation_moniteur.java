package exc_cours;

public class Simulation_moniteur {
	public static void main(String [] args) {
		Stock_Propre stock = new Stock_Propre();
		Producteur_moniteur p= new Producteur_moniteur(stock);
		Consommateur_moniteur c= new Consommateur_moniteur(stock);
		
		p.start();
		c.start();
		try {
			p.join();
			c.join();
		}catch(InterruptedException e) {
			System.out.println("Thread Principal interrompu");
		}
		System.out.println("Programme terminé");
	}

}

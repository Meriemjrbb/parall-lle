package TP2;


//Classe Counter implémente Runnable => son code s'exécutera dans un thread
class Counter implements Runnable {
	  private String name;     
	  private int maxCount;   
	  
	  public Counter(String name, int maxCount) {
	    this.name = name;
	    this.maxCount = maxCount;
	  }

	  // Méthode exécutée quand on appelle start() sur le thread
	  public void run() {
	    // Boucle de comptage
	    for (int i = 1; i <= maxCount; i++) {
	      System.out.println(name + ": " + i);

	      // Petite pause pour ralentir l'affichage
	      // et mieux voir l'alternance entre les deux threads
	      try {
	        Thread.sleep(100); // 100 ms
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	}
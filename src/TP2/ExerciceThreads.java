package TP2;

public class ExerciceThreads {
	  public static void main(String[] args) {
	    // Nombre maximal à compter jusqu'à
	    int maxCount = 10;

	    // Création de deux threads
	    Thread thread1 = new Thread(new Counter("Thread 1", maxCount));
	    Thread thread2 = new Thread(new Counter("Thread 2", maxCount));

	    // Lancement des threads en parallèle
	    thread1.start();
	    thread2.start();
	  }
	}

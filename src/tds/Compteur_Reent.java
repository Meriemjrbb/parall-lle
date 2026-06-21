package tds;
import java.util.concurrent.locks.ReentrantLock;


public class Compteur_Reent {
	private int valeur=0;
	private final ReentrantLock lock=new ReentrantLock();
	public void incrementer() {
		lock.lock();
		try {
			valeur++;
			System.out.println(Thread.currentThread().getName()+"->valeur="+valeur);
			
		}finally {
			lock.unlock();
		}
		
	}
	public int getValeur() {
			return valeur;
		}

}
class ExempleReentLock{
	public static void main(String[] args) {
		Compteur_Reent compteur=new Compteur_Reent();
		Runnable tache=()->{
			for (int i=0;i<5;i++) {
				compteur.incrementer();
				try {
					Thread.sleep(100);
					
				}catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		};
		Thread t1=new Thread(tache,"thread1");
		Thread t2=new Thread(tache,"thread2");
		t1.start();
		t2.start();
		
		
		
	}
}

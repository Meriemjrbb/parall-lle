package Exercice1_TD;

public class Entre extends Thread{ 
    Jardin jardin; 
    int entrant; 
     
 
    public Entre(Jardin jardin) { 
        super(); 
        this.jardin = jardin; 
    } 
 
    public void run (){ 
        while (true){ 
            entrant = (int)(Math.random()* 10); 
            jardin.entrer(entrant); 
            System.out.println(entrant +"personnes entrees"); 
            try { 
                Thread.sleep(500); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
         
        } 
    } 
 
} 
 


package Exercice1_TD;

public class Sort extends Thread { 
    Jardin jardin; 
    int sortant; 
     
 
    public Sort(Jardin jardin) { 
        super(); 
        this.jardin = jardin; 
    } 
 
    public void run (){ 
        boolean b = true; 
        while (true){ 
            sortant = (int)(Math.random()* 5); 
            b = jardin.sortir(sortant); 
            if (b)  
            System.out.println(sortant +"personnes sorties"); 
            try { 
                Thread.sleep(500); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
        } 
    }
}

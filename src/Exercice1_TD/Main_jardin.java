package Exercice1_TD;

public class Main_jardin {

	 
    public static void main(String[] args) { 
        Jardin jardin = new Jardin(); 
        Entre en = new Entre(jardin); 
        Sort so = new Sort(jardin); 
         
        en.start(); 
        so.start(); 
         
        while (true){ 
            try { 
                Thread.sleep(1000); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            System.out.println(jardin.totale() +"personnes dans le jardin"); 
        } 
 
    } 
 
} 

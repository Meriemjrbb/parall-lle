package Exercice1_TD;

public class Jardin { 
    private int nbr_visiteurs; 
     
    synchronized public void entrer (int entrant) 
    { 
        nbr_visiteurs=nbr_visiteurs+entrant; 
        } 
     
    synchronized public boolean sortir (int sortant) 
    {    
        if (nbr_visiteurs > sortant){ 
        nbr_visiteurs=nbr_visiteurs-sortant; 
        return true; 
        } 
        else{ 
            nbr_visiteurs = 0; 
            return false; 
        }} 
     
    synchronized public int totale ()  
    { 
        return nbr_visiteurs; 
    } 
}

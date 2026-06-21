package TP5;

public class Exercice1 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5);
        new Producteur(buffer).start();
        new Consommateur(buffer).start();
    }
}

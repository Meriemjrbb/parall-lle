package TP4;

public class HotelReservationDemo {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(3); // Hôtel avec 3 chambres

        // Création de plusieurs clients
        Thread c1 = new Thread(new Customer(hotel, "Client1"));
        Thread c2 = new Thread(new Customer(hotel, "Client2"));
        Thread c3 = new Thread(new Customer(hotel, "Client3"));
        Thread c4 = new Thread(new Customer(hotel, "Client4"));
        Thread c5 = new Thread(new Customer(hotel, "Client5"));

        // Lancement des threads
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}

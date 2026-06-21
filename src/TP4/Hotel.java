package TP4;

class Hotel {
    private int availableRooms;

    public Hotel(int rooms) {
        this.availableRooms = rooms;
    }

    // Méthode synchronized pour réserver une chambre
    public synchronized void reserveRoom(String customerName) {
        if (availableRooms > 0) {
            availableRooms--;
            System.out.println(customerName + " a réservé une chambre. Chambres restantes: " + availableRooms);
        } else {
            System.out.println(customerName + " n'a pas pu réserver : plus de chambres disponibles.");
        }
    }

    // Méthode synchronized pour annuler une réservation
    public synchronized void cancelReservation(String customerName) {
        availableRooms++;
        System.out.println(customerName + " a annulé sa réservation. Chambres restantes: " + availableRooms);
    }
}

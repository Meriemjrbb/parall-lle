package TP4;

class Customer implements Runnable {
    private final Hotel hotel;
    private final String name;

    public Customer(Hotel hotel, String name) {
        this.hotel = hotel;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // Le client essaie de réserver
            hotel.reserveRoom(name);

            // Pause pour simuler une utilisation de la chambre
            Thread.sleep((int)(Math.random() * 1000));

            // Le client peut décider d'annuler
            if (Math.random() > 0.5) {
                hotel.cancelReservation(name);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
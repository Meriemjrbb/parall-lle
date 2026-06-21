package TP6;

class Customer {
    int amount = 10000; // solde initial

    // Méthode synchronisée pour retirer de l'argent
    synchronized void withdraw(int amount) {
        System.out.println("going to withdraw ... ");
        if (this.amount < amount) {
            // Si le solde est insuffisant, le thread attend un dépôt
            System.out.println("Less balance; waiting for deposit ... ");
            try {
                wait(); // met le thread en attente
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.amount -= amount; // retrait après réveil
        System.out.println("withdraw completed ... ");
    }

    // Méthode synchronisée pour déposer de l'argent
    synchronized void deposit(int amount) {
        System.out.println("going to deposit ... ");
        this.amount += amount; // ajout au solde
        System.out.println("deposit completed ... ");
        notify(); // réveille le thread en attente (withdraw)
    }
}

class Test {
    public static void main(String args[]) {
        final Customer c = new Customer();

        // Thread pour retirer
        new Thread() {
            public void run() {
                c.withdraw(15000);
            }
        }.start();

        // Thread pour déposer
        new Thread() {
            public void run() {
                c.deposit(10000);
            }
        }.start();
    }
}

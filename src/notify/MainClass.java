package notify;

class MainClass {

    public static void main(String[] args)

        throws InterruptedException

    {



    	Test_notifytout1 t1 = new Test_notifytout1();

    	Test_notifytout2 t2 = new Test_notifytout2(t1);

    	Test_notifytout3 t3 = new Test_notifytout3(t1);

        Thread t11 = new Thread(t1, "Thread-1");

        Thread t22 = new Thread(t2, "Thread-2");

        Thread t33 = new Thread(t3, "Thread-3");

        t11.start();

        t22.start();

        Thread.sleep(100);

        t33.start();

    }

}




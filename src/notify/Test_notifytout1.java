package notify;

public class Test_notifytout1 extends Thread{

	// Java program to illustrate the behaviour of notify() method

	    public void run()

	    {

	        synchronized (this)

	        {

	            System.out.println(

	                Thread.currentThread().getName()  + "...starts");

	            try {

	                this.wait();

	            }

	            catch (InterruptedException e) {

	                e.printStackTrace();

	            }

	            System.out.println(

	                Thread.currentThread().getName()  + "...notified");

	        }}}

	class Test_notifytout2 extends Thread {

		Test_notifytout1 t1;

	  

		Test_notifytout2(Test_notifytout1 t1){ 

	      this.t1 = t1; 

	    }

	    public void run()

	    {

	        synchronized (this.t1)

	        {

	            System.out.println(

	                Thread.currentThread().getName()   + "...starts");

	            try {

	                this.t1.wait();

	            }

	            catch (InterruptedException e) {

	                e.printStackTrace();

	            }

	            System.out.println(

	                Thread.currentThread().getName() + "...notified");

	        }

	    }

	}

	class Test_notifytout3 extends Thread {

		Test_notifytout1 t1;

		Test_notifytout3(Test_notifytout1 t1) { this.t1 = t1; }

	    public void run()

	    {

	        synchronized (this.t1)

	        {

	            System.out.println(

	                Thread.currentThread().getName()+ "...starts");

	            this.t1.notifyAll();

	            System.out.println(

	                Thread.currentThread().getName() + "...notified");

	        }

	    }

	}

	
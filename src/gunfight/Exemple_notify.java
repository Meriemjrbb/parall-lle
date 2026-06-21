package gunfight;

import java.io.*;

import java.util.*;

public class Exemple_notify {

public static void main(String[] args) {

Thread2 objB=new Thread2();

objB.start();

synchronized (objB) {

try {

System.out.println(

"Waiting for Thread 2 to complete...");

objB.wait();

} catch (InterruptedException e) {

e.printStackTrace();

System.out.println("Total is: " + objB.total);

}

}

}}


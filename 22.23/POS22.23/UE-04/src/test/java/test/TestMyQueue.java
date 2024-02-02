package test;

import spg.daten.Aufgabe;
import spg.daten.MyQueue;

public class TestMyQueue {
    public static void main(String[] args) {
        Aufgabe a0 = new Aufgabe("POS","00:25");
        Aufgabe a1 = new Aufgabe("Deutsch","0045");
        MyQueue my = new MyQueue();

        //test von enqueue
        if(my.enqueue(a0)==a0 && my.enqueue(a1)==a1){
            System.out.println("Test von Enqueue erfolgreich");
        }else {
            System.out.println("Test von Enqueue NICHT erfolgreich");
        }

        //test von dequeue
        if(my.dequeue()==a1 && my.dequeue()==a0){
            System.out.println("Test von dequeue erfolgreich");
        }else{
            System.out.println("Test von dequeue NICHT erfolgreich");
        }
    }
}
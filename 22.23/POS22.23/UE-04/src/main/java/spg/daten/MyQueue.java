package spg.daten;

import java.util.ArrayList;

public class MyQueue {
    public ArrayList<Aufgabe> aufgaben =new ArrayList<>();

    public Aufgabe enqueue(Aufgabe a){
        aufgaben.add(0,a);
        return a;
    }
    public Aufgabe dequeue(){
        return aufgaben.remove(0);
    }
}

package test;

import spg.daten.Aufgabe;
import spg.daten.MyStack;

public class TestStack {
    public static void main(String[] args) {
        MyStack test=new MyStack();
        Aufgabe a0=new Aufgabe("POS","02:30");
        Aufgabe a1=new Aufgabe("Englisch","06:60");
        Aufgabe a3=new Aufgabe("Paul","0230");

        //test von push
        if(test.push(a0)==a0 && test.push(a1)==a1){
            System.out.println("Test von Push erfolgreich");
        }else {
            System.out.println("Test von Push NICHT erfolgreich");
        }

        //test von pop
        if(test.pop()==a1 && test.pop()==a0){
            System.out.println("Test von Pop erfolgreich");
        }else {
            System.out.println("Test von Pop NICHT erfolgreich");
        }
        test.push(a3);
        //test von peek
        if(test.peek()==a3){
            System.out.println("Test von Peek erfolgreich");
        }else {
            System.out.println("Test von Peek NICHT erfolgreich");
        }
    }
}

package com.example.logik;

public class Rekursiev {

    public static void main(String[] args) {
        hanoi(1,'A','C','B');
    }
    public static void hanoi(int n,char von, char zu, char über){
        if (n==1){
            System.out.println("scheibe von "+von+" zu "+zu);
        }
        else {
            hanoi(n-1,von,über,zu);
            hanoi(1,von,zu,über);
            hanoi(n-1,über,zu,von);
        }
    }

    public static void smth(int h,char von, char zu, char über){
        if (h!=0) {
            System.out.println("von " + von + " nach " + zu);
            smth(h - 1, von, über, zu);
        }
    }


}

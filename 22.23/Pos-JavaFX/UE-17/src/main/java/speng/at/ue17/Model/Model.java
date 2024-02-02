package speng.at.ue17.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Model {
    private ArrayList<Rechnung> rechList;
    private ArrayList<Integer> toReach;
    private int counter;

    public Model (){
        rechList=new ArrayList<>();
        toReach=new ArrayList<>();
    }

    public void add(Rechnung re){
        rechList.add(re);
    }

    public void sort(){
        rechList.sort(Comparator.comparingInt(Rechnung::getErg));
    }

    @Override
    public String toString() {
        String s="";
        for (Rechnung r : rechList)
        {
            s+= r.toString()+"\n";
        }
        return s;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }
}

package spg.daten;

import java.util.ArrayList;
import java.util.Objects;

public class MyStack {
    private ArrayList<Object> stack=new ArrayList<>();

    public Aufgabe push(Aufgabe s){
                stack.add(s);
        return s;
    }
    public Object pop(){

        return stack.remove(stack.size()-1);
    }
    public Object peek(){
        return stack.get(stack.size()-1);
    }
}

package at.spenger.plfs3.model;

import at.spenger.plfs3.view.View;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.io.*;
import java.util.ArrayList;

public class Quiz {
    private int antworten;
    private ArrayList<Frage> fragen;


    public Quiz(){
        fragen=new ArrayList<>();
        antworten=0;
        read();
    }

    public void read() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("fragen.txt");
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(is));
            String s="";
            while ((s=bf.readLine())!=null){
                System.out.println("aaa");
                fragen.add(new Frage(s));

            }
        } catch (FileNotFoundException e) {
            // error message
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("das andere");
        }


    }

    public ArrayList<RadioButton> getAnswers(int index){
        if (index<fragen.size()) {
            return fragen.get(index).getAntworten();
        }
        else return null;
    }
    public String getQuestion(int index){
        if (index<fragen.size()) {
            return fragen.get(index).getFrage();
        }
        else return null;
    }
    public void incAnswer(){
        antworten++;
    }

    public void setAntwortFrage(int index,int value){
        fragen.get(index).setGegAntwort(value);
    }
    @Override
    public String toString() {
        String s = "";
        int x =0;
        for(int i=0; i<antworten;i++){
            s+=fragen.get(i).toString()+"\n";
            if (fragen.get(i).getGegAntwort()==fragen.get(i).getRichtigeAntwort()){
                x++;
            }
        }
        return s+"Zusammenfassung: "+x+" von "+antworten+" richtig";
    }
}

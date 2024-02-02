package at.spenger.plfs3.model;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.Random;

public class Frage {
    private String frage;
    private ArrayList<RadioButton> antworten;
    private int richtigeAntwort;
    private int gegAntwort;

    public Frage(String s){
        antworten=new ArrayList<>();
        init(s);
    }

    private void init(String s){
        String[] sAr = s.split(";");
        frage=sAr[0];
        for(int i = 1; i<sAr.length-1;i++){
            RadioButton btn= new RadioButton(sAr[i]);
            btn.setUserData(i);
            antworten.add(btn);
        }
        richtigeAntwort=Integer.parseInt((sAr[5]))+1;
    }

    public String getFrage() {
        return frage;
    }

    public void setGegAntwort(int gegAntwort) {
        this.gegAntwort = gegAntwort;
    }

    public int getGegAntwort() {
        return gegAntwort;
    }

    public int getRichtigeAntwort() {
        return richtigeAntwort;
    }

    public ArrayList<RadioButton> getAntworten() {
        return antworten;
    }

    @Override
    public String toString() {
        return "Frage: "+frage+", Richtig: "+richtigeAntwort+", Ihre Antwort: "+gegAntwort;
    }
}

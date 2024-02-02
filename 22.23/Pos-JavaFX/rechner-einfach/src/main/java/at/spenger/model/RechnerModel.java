package at.spenger.model;

import java.util.ArrayList;

public class RechnerModel {
    private double erg;
    private ArrayList<String> liste;

    public RechnerModel() {
        liste = new ArrayList<>();
    }

    public void add(String s) {
        liste.add(s);
    }
    public double getErg() {
        return erg;
    }

    public double add(double x, double y) {
        erg = x + y;
        return erg;
    }

    public double sub(double x, double y) {
        erg = x - y;
        return erg;
    }

    // besser
    public double calculate(double x, double y, String op) {
        return 0;
    }
}

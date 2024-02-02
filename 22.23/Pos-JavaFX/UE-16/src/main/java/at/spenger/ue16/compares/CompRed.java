package at.spenger.ue16.compares;

import at.spenger.ue16.fig.Fig2D;

import java.util.Comparator;

public class CompRed implements Comparator<Fig2D> {

    @Override
    public int compare(Fig2D o1, Fig2D o2) {
        return Double.compare(o1.getFarbe().getRed(),o2.getFarbe().getRed());
    }
}

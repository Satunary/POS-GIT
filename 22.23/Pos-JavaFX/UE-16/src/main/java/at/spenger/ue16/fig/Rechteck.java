package at.spenger.ue16.fig;

import at.spenger.ue16.ViewZeichnung;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Rechteck extends Fig2D{
    private double with;
    private double height;

    public Rechteck(double with, double height, double x, double y, Color farbe){
        super(x,y,farbe);
        setWith(with);
        setHeight(height);
    }

    public double getWith() {
        return with;
    }

    public void setWith(double with) {
        if (with<1){
            throw new IllegalArgumentException("With lower 1");
        }
        this.with = with;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height<1){
            throw new IllegalArgumentException("Height lower 1");
        }
        this.height = height;
    }

    @Override
    public double umfang() {
        return (2*with)+(2*height);
    }

    @Override
    public double flaeche() {
        return with*height;
    }

    @Override
    public void draw(ViewZeichnung view) {
        if (gc==null){
            gc=view.getGc();
        }
        gc.setFill(farbe);
       gc.fillRect(x,y,with,height);
    }

    @Override
    public String toString() {
        return "RE "+with+" "+height+" "+super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rechteck rechteck)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(rechteck.getWith(), getWith()) == 0 && Double.compare(rechteck.getHeight(), getHeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWith(), getHeight());
    }
}

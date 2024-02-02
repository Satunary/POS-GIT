package at.spenger.ue16.fig;

import at.spenger.ue16.ViewZeichnung;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Kreis extends Fig2D{
    private double radius;

    public Kreis(double radius,double x, double y, Color farbe){
        super(x,y,farbe);
        setRadius(radius);
    }



    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius<1){
            throw new IllegalArgumentException("Height lower 1");
        }
        this.radius = radius;
    }

    @Override
    public double umfang() {
        return 2*radius*3.14159265359;
    }

    @Override
    public double flaeche() {
        return 3.14159265359*(radius*radius);
    }

    @Override
    public void draw(ViewZeichnung view) {
        if (gc==null){
            gc=view.getGc();
        }
        gc.setFill(farbe);
        gc.fillOval(x,y,radius,radius);

    }

    @Override
    public String toString() {
        return "KR "+radius+" "+super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kreis kreis)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(kreis.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRadius());
    }
}

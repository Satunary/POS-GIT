package at.spenger.ue16.fig;

import at.spenger.ue16.ViewZeichnung;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public abstract class Fig2D {
    protected Color farbe;
    protected double x;
    protected double y;
    protected GraphicsContext gc;

    public Fig2D(double x,double y,Color farbe){
        setX(x);
        setY(y);
        setFarbe(farbe);
    }

    public Fig2D(String s){
        String[] temp = s.split(" ");
        try {
            setX(Integer.parseInt(temp[0]));
            setY(Integer.parseInt(temp[1]));
            setFarbe(Color.web(temp[2]));
        }catch (IllegalArgumentException e){

        }
    }

    public Fig2D(){
        setX(0);
        setY(0);
        setFarbe(Color.BLACK);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fig2D fig2D)) return false;
        return Double.compare(fig2D.x, x) == 0 && Double.compare(fig2D.y, y) == 0 && Objects.equals(farbe, fig2D.farbe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(farbe, x, y);
    }



    public Color getFarbe() {
        return farbe;
    }

    public void setFarbe(Color farbe) {
        if (farbe==null){
            throw new IllegalArgumentException("color null");
        }
        this.farbe = farbe;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if (x<0){
            throw new IllegalArgumentException("X is lower 0");
        }
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if (y<0){
            throw new IllegalArgumentException("Y is lower 0");
        }
        this.y = y;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public String toString(){
        return x+" "+y+" "+farbe;
    }

    public abstract double umfang();
    public abstract double flaeche();
    public abstract void draw(ViewZeichnung view);



}

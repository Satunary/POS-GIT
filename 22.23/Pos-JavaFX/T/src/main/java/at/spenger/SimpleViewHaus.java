package at.spenger;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class SimpleViewHaus extends Pane {
    public SimpleViewHaus() {
        //  Rectangle shape is created. The first two parameters are the x and y coordinates,
        // the following two are the width and height of the rectangle.
        Polygon tri = new Polygon();
        tri.getPoints().addAll(50.0,10.0,
                80.0,40.0,
                20.0,40.0);
        tri.setFill(Color.RED);

        Rectangle rect = new Rectangle(20, 40, 60, 40);
        rect.setFill(Color.CADETBLUE);

        Line line = new Line(90, 40, 230, 40);
        line.setStroke(Color.BLACK);

        Circle kreis = new Circle(150,150,60);
        kreis.setFill(Color.ORANGE);


        // All the three shapes are added to the root node.
        this.getChildren().addAll(rect, tri,kreis);
    }
}

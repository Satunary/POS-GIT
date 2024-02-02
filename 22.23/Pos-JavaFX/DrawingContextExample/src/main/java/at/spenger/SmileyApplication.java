package at.spenger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        initUI(primaryStage);
    }

    private void initUI(Stage stage) {
        BorderPane root = new BorderPane();

        Button b = new Button("Zeichne");
        b.setMaxWidth(Double.MAX_VALUE);

        root.setTop(b);

        Canvas canvas = new Canvas(400, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        b.setOnAction((event) -> drawSmiley(gc));

        Scene scene = new Scene(root, 400, 300, Color.WHITESMOKE);

        stage.setTitle("hallo");
        stage.setScene(scene);
        stage.show();
    }


    private static void drawSmiley(GraphicsContext gc) {
        gc.strokeOval(100, 50, 200, 200);
        gc.fillOval(155, 100, 10, 20);
        gc.fillOval(230, 100, 10, 20);
        gc.strokeArc(150, 160, 100, 50, 180, 180, ArcType.OPEN);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
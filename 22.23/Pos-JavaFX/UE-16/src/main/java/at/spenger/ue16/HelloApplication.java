package at.spenger.ue16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewZeichnung root = new ViewZeichnung();
        //root.getChildren().add(new Rectangle(0,0,20,30));
        Scene scene = new Scene(root, 700, 500);
        scene.setFill(Color.RED);
        stage.setResizable(false);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}


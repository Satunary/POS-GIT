package at.spenger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        initUISchach(stage);
    }


    private void initUIHaus(Stage stage) {
       //für die ausführung muss ober der name auf initUIHaus geändert werden
        SimpleViewHaus root = new SimpleViewHaus();
        Scene scene = new Scene(root, 250, 220, Color.WHITESMOKE);

        stage.setTitle("Haus");
        stage.setScene(scene);
        stage.show();
    }

    private void initUISchach(Stage stage) {
        // für die ausführung muss ober der name auf initUISchach geändert werden
        SimpleViewSchach root = new SimpleViewSchach();
        Scene scene = new Scene(root, 250, 220, Color.WHITESMOKE);

        stage.setTitle("Schach");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

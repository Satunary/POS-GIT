package at.spenger.demo2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        FormularView view = new FormularView();

        Scene scene = new Scene(view, 330, 140);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Schreibmaschiene");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
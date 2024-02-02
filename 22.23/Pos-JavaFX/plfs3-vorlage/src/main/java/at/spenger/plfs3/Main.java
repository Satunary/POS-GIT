package at.spenger.plfs3;


import at.spenger.plfs3.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        View view = new View();

        Scene scene = new Scene(view, 300, 400);

        primaryStage.setTitle("Quiz");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
package at.spenger;


import at.spenger.view.RechnerView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){

        RechnerView view = new RechnerView();

        Scene scene = new Scene(view, 300, 400);

        primaryStage.setTitle("Formular");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
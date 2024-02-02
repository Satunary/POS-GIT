package at.spenger.projekt1;

import at.spenger.projekt1.view.StartView;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;

public class HelloApplication extends Application {
    private Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        StartView root = new StartView(this);
        scene = new Scene(root,1000,800);

        stage.setResizable(false);
        stage.setTitle("daNight");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void setSceneView(Parent parent) {
        if (parent!=null){
            scene.setRoot(parent);
        }
    }

}
package at.spenger.projekt1.view;

import at.spenger.projekt1.HelloApplication;
import at.spenger.projekt1.controller.GeneralController;
import at.spenger.projekt1.model.Infosheet;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.InputStream;

public class TheEndView extends Pane {
    private Infosheet model;
    private HelloApplication stage;
    private GeneralController genCon;

    public TheEndView(HelloApplication stage){

        this.stage=stage;
        model = new Infosheet();
        genCon= new GeneralController(this,model,stage,"");
        init();
    }

    private void init(){

        BackgroundFill bg = new BackgroundFill(Color.BLACK,new CornerRadii(0),new Insets(0));
        this.setBackground(new Background(bg));

        Label textStuff = new Label();
        textStuff.setTextFill(Color.WHITE);
        textStuff.setLayoutX(450);
        textStuff.setLayoutY(350);
        textStuff.setText("You have survived the Night \n but what will await in the Morning?...");

        this.getChildren().add(textStuff);
    }

}

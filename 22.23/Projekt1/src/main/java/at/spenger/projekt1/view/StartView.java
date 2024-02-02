package at.spenger.projekt1.view;

import at.spenger.projekt1.HelloApplication;
import at.spenger.projekt1.controller.GeneralController;
import at.spenger.projekt1.model.Infosheet;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.InputStream;

public class StartView extends BorderPane {
    private Infosheet model;
    private HelloApplication stage;
    private GeneralController genCon;

    public StartView(HelloApplication stage){

        this.stage=stage;
        model = new Infosheet();
        genCon= new GeneralController(this,model,stage,"");
        init();
    }

    private void init(){
        initCenter();
    }

    private void initCenter(){
        Pane center = new Pane();
        InputStream startImg = this.getClass().getResourceAsStream("/background/start.png");
        Image titelScreen = new Image(startImg);
        BackgroundImage myBI= new BackgroundImage(titelScreen,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        center.setBackground(new Background(myBI));

        Button start = new Button("Start");
        start.setOnAction(new GeneralController(this,model,stage,"start"));
        start.setLayoutX(880);
        start.setLayoutY(730);
        center.getChildren().addAll(start);

        this.setCenter(center);
    }
}

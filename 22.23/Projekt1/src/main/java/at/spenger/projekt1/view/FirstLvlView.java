package at.spenger.projekt1.view;

import at.spenger.projekt1.HelloApplication;
import at.spenger.projekt1.controller.GeneralController;
import at.spenger.projekt1.controller.MouseCon;
import at.spenger.projekt1.model.Infosheet;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.InputStream;

public class FirstLvlView extends BorderPane {
    private Infosheet info;
    private HelloApplication stage;
    private GeneralController genCon;
    private Pane main;
    private Label stones;
    private Label stickFire;
    private Label stickSpeer;
    private Label firePlace;
    private Label fish;

    private Button item1;
    private Button item2;
    private Button item3;
    private Button item4;

    public FirstLvlView (Infosheet info, HelloApplication stage, GeneralController genCon){
        setInfo(info);
        setGenCon(genCon);
        setStage(stage);
        ini();
    }

    public void ini(){
        this.setCenter(initCen());

    }

    public Pane initCen(){

        main = new Pane();
        InputStream startImg = this.getClass().getResourceAsStream("/background/lvl1.png");
        Image titelScreen = new Image(startImg);
        BackgroundImage myBI= new BackgroundImage(titelScreen,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        main.setBackground(new Background(myBI));



        item1 = new Button();
        item1.setOnAction(new GeneralController(this,info,stage,"empty"));
        item1.setMinHeight(75);
        item1.setMinWidth(125);
        InputStream in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
        Image im = new Image(in);
        setBtnImg(1, im);

        item2 = new Button();
        item2.setOnAction(new GeneralController(this,info,stage,"empty"));
        item2.setMinHeight(75);
        item2.setMinWidth(125);
        in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
        im = new Image(in);
        setBtnImg(2, im);

        item3 = new Button();
        item3.setOnAction(new GeneralController(this,info,stage,"empty"));
        item3.setMinHeight(75);
        item3.setMinWidth(125);
        in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
        im = new Image(in);
        setBtnImg(3, im);

        item4 = new Button();
        item4.setOnAction(new GeneralController(this,info,stage,"empty"));
        item4.setMinHeight(75);
        item4.setMinWidth(125);
        in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
        im = new Image(in);
        setBtnImg(4, im);



        HBox butns = new HBox();
        butns.getChildren().addAll(item1,item2,item3,item4);
        butns.setSpacing(125);
        butns.setLayoutX(110);
        butns.setLayoutY(730);

        stones = new Label();
        stones.setLayoutX(504);
        stones.setLayoutY(553);
        in = this.getClass().getResourceAsStream("/items/stoneFull.png");
        im = new Image(in);
        ImageView imgV = new ImageView(im);
        stones.setGraphic(imgV);


        stickFire = new Label();
        stickFire.setLayoutX(622);
        stickFire.setLayoutY(632);
        in = this.getClass().getResourceAsStream("/items/stickFire.png");
        im = new Image(in);
        imgV = new ImageView(im);
        stickFire.setGraphic(imgV);


        stickSpeer = new Label();
        stickSpeer.setLayoutX(752);
        stickSpeer.setLayoutY(481);
        in = this.getClass().getResourceAsStream("/items/stickSpeer.png");
        im = new Image(in);
        imgV = new ImageView(im);
        stickSpeer.setGraphic(imgV);


        firePlace = new Label();
        firePlace.setLayoutX(526);
        firePlace.setLayoutY(689);
        in = this.getClass().getResourceAsStream("/items/fireEmpty.png");
        im = new Image(in);
        imgV = new ImageView(im);
        firePlace.setGraphic(imgV);


        fish = new Label();
        fish.setLayoutX(115);
        fish.setLayoutY(625);
        in = this.getClass().getResourceAsStream("/items/fishWater.png");
        im = new Image(in);
        imgV = new ImageView(im);
        fish.setGraphic(imgV);


        main.setOnMouseClicked(new MouseCon(this,info,stage));
        main.getChildren().addAll(butns,stones,stickFire,stickSpeer,firePlace,fish);
        return main;
    }



    public void removeStones(){
        main.getChildren().remove(stones);
    }

    public void removeStickFire(){
        main.getChildren().remove(stickFire);
    }

    public void removeStickSpeer(){
        main.getChildren().remove(stickSpeer);
    }

    public void removeFish(){
        main.getChildren().remove(fish);
    }

    public void setFirePlaceImg(Image im){
        ImageView imgV = new ImageView(im);
        firePlace.setGraphic(imgV);
    }
    public void fire(){
        if(info.getFirePlaceStatus()==1) {
            firePlace.setLayoutY(650);
        }else{
            firePlace.setLayoutX(515);
        }
    }

    public void setBtnImg(int num, Image im){
        BackgroundImage myBI= new BackgroundImage(im,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        switch (num){
            case 1:
                item1.setBackground(new Background(myBI));
                break;
            case 2:
                item2.setBackground(new Background(myBI));
                break;
            case 3:
                item3.setBackground(new Background(myBI));
                break;
            case 4:
                item4.setBackground(new Background(myBI));
        }
    }


    public void setItemCon(int num, String type){
        switch (num){
            case 1:
                item1.setOnAction(new GeneralController(this,info,stage,type));
                break;
            case 2:
                item2.setOnAction(new GeneralController(this,info,stage,type));
                break;
            case 3:
                item3.setOnAction(new GeneralController(this,info,stage,type));
                break;
            case 4:
                item4.setOnAction(new GeneralController(this,info,stage,type));
        }
    }

    public void setGenCon(GeneralController genCon) {
        if (genCon==null){
            System.out.println("genCon is null in firstlvl View");
        }
        this.genCon = genCon;
    }

    public void setInfo(Infosheet info) {
        if (info==null){
            System.out.println("info is null in Fistlvl View");
        }
        this.info = info;
    }

    public void setStage(HelloApplication stage) {
        if (stage==null){
            System.out.println("stage is null in Dialog View");
        }
        this.stage = stage;
    }


}

package at.spenger.projekt1.controller;

import at.spenger.projekt1.HelloApplication;
import at.spenger.projekt1.model.Infosheet;
import at.spenger.projekt1.view.FirstLvlView;
import at.spenger.projekt1.view.TheEndView;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.InputStream;

public class MouseCon implements EventHandler<MouseEvent> {

    private Infosheet model;
    private FirstLvlView view;
    private HelloApplication stage;


    public MouseCon(FirstLvlView view, Infosheet model, HelloApplication scene){
        setScene(scene);

        setModel(model);
        setView(view);
    }

    public void setModel(Infosheet model) {
        if (model!=null) {
            this.model = model;
        }
    }

    public void setView(FirstLvlView view) {
        if (view!=null) {
            this.view = view;
        }
    }

    public void setScene(HelloApplication scene) {
        if (scene!=null) {
            this.stage = scene;
        }
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        
        if(x>=504 && x<= 545 && y>= 553 && y<= 586 &&!model.isStones()){
            //stones
            InputStream in = this.getClass().getResourceAsStream("/items/btnStoneFull.png");
            Image im = new Image(in);
            view.setBtnImg(model.getFreeItem(),im);
            model.tookStones();
            view.setItemCon(model.getFreeItem(),"stones");
            model.setStonePos(model.getFreeItem());
            model.freeItemUp();
            view.removeStones();



        } else if (x>=622 && x<= 692 && y>= 632 && y<= 689 &&!model.isStickFire()) {
            //stickFire
            InputStream in = this.getClass().getResourceAsStream("/items/btnSticksFire.png");
            Image im = new Image(in);
            view.setBtnImg(model.getFreeItem(),im);
            model.tookStickFire();
            view.setItemCon(model.getFreeItem(),"stickFire");
            model.setStickFirePos(model.getFreeItem());
            model.freeItemUp();
            view.removeStickFire();



        } else if (x>=526 && x<= 629 && y>= 689 && y<= 750 ) {
            //firePlace
            String cur = model.getCurItem();
                if (model.getFirePlaceStatus()==0 && cur.equals("stickFire")){
                    InputStream in = this.getClass().getResourceAsStream("/items/fireWood.png");
                    Image im = new Image(in);
                    view.setFirePlaceImg(im);
                    model.firePlaceStatusInc();

                    view.setItemCon(model.getStickFirePos(),"");
                    in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
                    im = new Image(in);
                    view.setBtnImg(model.getStickFirePos(), im);


                } else if (model.getFirePlaceStatus()==1 && cur.equals("stones")) {
                    InputStream in = this.getClass().getResourceAsStream("/items/fireIgnite.png");
                    Image im = new Image(in);
                    view.setFirePlaceImg(im);
                    view.fire();

                    if(model.isSpeerComplete()){
                        view.setItemCon(model.getStonePos(),"");
                        in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
                        im = new Image(in);
                        view.setBtnImg(model.getStonePos(), im);
                    }else{
                        in = this.getClass().getResourceAsStream("/items/btnStoneSpeer.png");
                        im = new Image(in);
                        view.setBtnImg(model.getStonePos(), im);
                    }
                    model.firePlaceStatusInc();



                } else if (model.getFirePlaceStatus()==2 && cur.equals("fish")) {
                    InputStream in = this.getClass().getResourceAsStream("/items/fireFish.png");
                    Image im = new Image(in);
                    view.setFirePlaceImg(im);
                    model.firePlaceStatusInc();
                    view.fire();

                    view.setItemCon(model.getFishPos(),"");
                    in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
                    im = new Image(in);
                    view.setBtnImg(model.getFishPos(), im);

                    PauseTransition pause = new PauseTransition(Duration.millis(1000));
                    pause.setOnFinished(event -> {
                        stage.setSceneView(new TheEndView(stage));
                    });
                    pause.play();


                }



        } else if (x>=752 && x<= 882 && y>= 481 && y<= 617 &&!model.isStickSpeer()) {
            //stickSpeer
            InputStream in = this.getClass().getResourceAsStream("/items/btnStickSpeer.png");
            Image im = new Image(in);
            view.setBtnImg(model.getFreeItem(),im);
            model.tookStickSpeer();
            view.setItemCon(model.getFreeItem(),"stickSpeer");
            model.setSpeerPos(model.getFreeItem());

            model.freeItemUp();
            view.removeStickSpeer();



        } else if (x>=115 && x<= 181 && y>= 625 && y<= 691 &&!model.isFish()) {
            //fish
            if(model.getCurItem().equals("stickSpeer")&& model.isSpeerComplete()){
                InputStream in = this.getClass().getResourceAsStream("/items/btnFish.png");
                Image im = new Image(in);
                view.setBtnImg(model.getFreeItem(),im);
                model.tookFish();
                view.setItemCon(model.getFreeItem(),"fish");
                model.setFishPos(model.getFreeItem());
                model.freeItemUp();
                view.removeFish();

            }

        }



    }
}

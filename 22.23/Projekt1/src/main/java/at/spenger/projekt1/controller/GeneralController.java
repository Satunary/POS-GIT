package at.spenger.projekt1.controller;

import at.spenger.projekt1.HelloApplication;
import at.spenger.projekt1.model.Infosheet;
import at.spenger.projekt1.view.FirstLvlView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.InputStream;

public class GeneralController implements EventHandler<ActionEvent> {
    private Infosheet model;
    private Pane view;
    private HelloApplication stage;
    private String type;

    public GeneralController(Pane view, Infosheet model,HelloApplication scene,String type){
        setScene(scene);
        this.type=type;
        setModel(model);
        setView(view);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        FirstLvlView temp = null;
        if(view.getClass() == FirstLvlView.class) {
            temp = (FirstLvlView) view;
        }
        switch (type){
            case "start":
                stage.setSceneView(new FirstLvlView(model,stage,this));
                break;
            case "stones":
                if(temp!=null && model.getCurItem().equals("stickSpeer")){
                    InputStream in = this.getClass().getResourceAsStream("/items/btnStickSpeerFin.png");
                    Image im = new Image(in);
                    temp.setBtnImg(model.getSpeerPos(),im);
                    model.speerCompletion();
                    if(model.getFirePlaceStatus()>1){
                        temp.setItemCon(model.getStonePos(),"");
                        in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
                        im = new Image(in);
                        temp.setBtnImg(model.getStonePos(), im);

                    }else{
                        in = this.getClass().getResourceAsStream("/items/btnStoneFire.png");
                        im = new Image(in);
                        temp.setBtnImg(model.getStonePos(), im);
                    }

                }
                model.setCurItem("stones");


                break;
            case "stickFire":
                model.setCurItem("stickFire");

                break;
            case "stickSpeer":
                if(temp!=null && model.getCurItem().equals("stones")){
                    InputStream in = this.getClass().getResourceAsStream("/items/btnStickSpeerFin.png");
                    Image im = new Image(in);
                    temp.setBtnImg(model.getSpeerPos(),im);
                    model.speerCompletion();
                    if(model.getFirePlaceStatus()>1){
                        temp.setItemCon(model.getStonePos(),"");
                        in = this.getClass().getResourceAsStream("/items/btnEmpty.png");
                        im = new Image(in);
                        temp.setBtnImg(model.getStonePos(), im);

                    }else{
                        in = this.getClass().getResourceAsStream("/items/btnStoneFire.png");
                        im = new Image(in);
                        temp.setBtnImg(model.getStonePos(), im);
                    }

                }
                if(model.isSpeerComplete()){

                }else{

                }
                model.setCurItem("stickSpeer");

                break;
            case "fish":
                model.setCurItem("fish");

                break;
        }
    }


    public void setModel(Infosheet model) {
        if (model!=null) {
            this.model = model;
        }
    }

    public void setView(Pane view) {
        if (view!=null) {
            this.view = view;
        }
    }

    public void setScene(HelloApplication scene) {
        if (scene!=null) {
            this.stage = scene;
        }
    }
}

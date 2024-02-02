package speng.at.ue17;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import speng.at.ue17.Model.Model;

public class View extends BorderPane {
    private Model model;
    private Controller controller;
    private FlowPane center;
    private Pane bot;
    // images
    private Button w1;
    private Button w2;
    private Button w3;

    private TextArea ergTA;

    public View (){
        w1 = new Button();
        w2 = new Button();
        w3 = new Button();
        model= new Model();
        controller = new Controller("firstCast",this,model);
        center = new FlowPane();
        bot = new Pane();
        initGui();
    }

    public void initGui(){
       //center

        w1.setOnAction(new Controller("W1",this,model));


        w2.setOnAction(new Controller("W2",this,model));


        w3.setOnAction(new Controller("W3",this,model));

        center.getChildren().addAll(w1,w2,w3);
        this.setCenter(center);

        //bottom
        Button add = new Button("+");
        add.setOnAction(new Controller("ADD",this,model));
        add.setLayoutX(40);
        add.setLayoutY(-30);
        add.setPrefWidth(30);

        Button sub = new Button ("-");
        sub.setOnAction(new Controller("SUB",this,model));
        sub.setLayoutX(80);
        sub.setLayoutY(-30);
        sub.setPrefWidth(30);

        ergTA = new TextArea();
        ergTA.setMaxHeight(70);
        ergTA.setEditable(false);

        bot.getChildren().addAll(add,sub,ergTA);
        this.setBottom(bot);
    }

    public void updateErgTA(String inp){
        ergTA.setText(inp);
    }
    public void setImgW1(Image imgW1) {
        w1.setGraphic(new ImageView(imgW1));
    }
    public void setImgW2(Image imgW2) {
        w2.setGraphic(new ImageView(imgW2));
    }
    public void setImgW3(Image imgW3) {
        w3.setGraphic(new ImageView(imgW3));
    }

    public void disableW(int i){
        switch (i){
            case 1:
                w1.setDisable(true);
                break;
            case 2:
                w2.setDisable(true);
                break;
            case 3:
                w3.setDisable(true);
        }
    }
    public void enableW(int i){
        switch (i){
            case 1:
                w1.setDisable(false);
                break;
            case 2:
                w2.setDisable(false);
                break;
            case 3:
                w3.setDisable(false);
        }
    }
}

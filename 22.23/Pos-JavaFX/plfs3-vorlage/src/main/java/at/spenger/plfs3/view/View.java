package at.spenger.plfs3.view;


import at.spenger.plfs3.controller.Controller;
import at.spenger.plfs3.model.Quiz;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;


public class View extends BorderPane {


    private Controller controller;

    private boolean ended;
    private Quiz model;
    private Label question;
    private RadioButton rbFrage1;
    private RadioButton rbFrage2;
    private RadioButton rbFrage3;
    private RadioButton rbFrage4;
    private ToggleGroup tg;
    private int num;
    public View() {
        // In dieser Loesung: View erzeugt Model
          model = new Quiz();
       controller = new Controller(this, model,"");
        ended=false;

        initGui();
    }

    private void initGui() {

        setCenter(initCenter());
        setTop(iniTop());
        setBottom(initBot());
    }



    private BorderPane initCenter() {
        BorderPane bp = new BorderPane();
        question = new Label("Test");
        question.setAlignment(Pos.CENTER);
        question.setMinWidth(100);

        bp.setTop(question);

        final VBox vBox = new VBox();
        // Aussenabstand, z.B. zum Fensterrand
        vBox.setPadding(new Insets(10, 20, 10, 20));
        // Abstand Kompoenten in der VBox
        vBox.setSpacing(10);
        // Toggle group erzeugen
        tg = new ToggleGroup();

        // Radiobuttons erzeugen
        ArrayList<RadioButton> temp = model.getAnswers(0);
            rbFrage1=temp.get(0);
            rbFrage1.setToggleGroup(tg);
            rbFrage2=temp.get(1);
            rbFrage2.setToggleGroup(tg);
            rbFrage3=temp.get(2);
            rbFrage3.setToggleGroup(tg);
            rbFrage4=temp.get(3);
            rbFrage4.setToggleGroup(tg);

            setQuestion(model.getQuestion(0));
            num=0;
            vBox.getChildren().addAll(rbFrage1,rbFrage2,rbFrage3,rbFrage4);
        // Erzeugen des Layouts und Platzieren der Komponenten

        // Einzelne Komponente hinzufügen:


        bp.setCenter(vBox);

        return  bp;

    }
    private FlowPane iniTop(){
        FlowPane p = new FlowPane();
        Label lb = new Label("Dateiname:    ");

        TextField tfIn = new TextField();


        Button btnLoad = new Button("Laden");
        btnLoad.setOnAction(new Controller(this,model,"load"));

        p.getChildren().addAll(lb,tfIn,btnLoad);
        return p;
    }

    private FlowPane initBot(){
        FlowPane p = new FlowPane();
        Button btnNext = new Button("Nächste Frage");
        btnNext.setOnAction(new Controller(this,model,"next"));

        Button btnEnd = new Button("Ende");
        btnEnd.setOnAction(new Controller(this,model,"end"));

        p.getChildren().addAll(btnNext,btnEnd);
        return p;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
    public void setQuestion(String s) {
        question.setText(s);
    }

    public void update(ArrayList<RadioButton> temp){
        rbFrage1.setText(temp.get(0).getText());
        rbFrage2.setText(temp.get(1).getText());
        rbFrage3.setText(temp.get(2).getText());
        rbFrage4.setText(temp.get(3).getText());
    }

    public int getAnswer(){
        return (int) tg.getSelectedToggle().getUserData();
    }

    public void end(){
        ended=true;
    }
    public boolean getEnded(){
        return ended;
    }
}

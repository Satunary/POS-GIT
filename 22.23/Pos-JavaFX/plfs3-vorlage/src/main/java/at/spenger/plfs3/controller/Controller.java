package at.spenger.plfs3.controller;


import at.spenger.plfs3.model.Quiz;
import at.spenger.plfs3.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller implements EventHandler<ActionEvent> {
    private boolean ended;
    private View view;
    private Quiz model;
    private String type;

    public Controller(View view, Quiz model,String type){
        this.view=view;
        this.model=model;
        this.type=type;
        this.ended=false;
    }

    @Override
    public void handle(ActionEvent event) {
        switch (type){
            case "load":
                load();
                break;
            case "next":
                next();
                break;
            case "end":
                end();
                break;
            default:
        }
    }

    private void load(){

    }

    private void next(){
        if (view.getEnded()) {

        }else {
            view.setNum(view.getNum()+1);
            int i = view.getNum();
            if (model.getAnswers(i) != null) {
                view.update(model.getAnswers(i));
                view.setQuestion(model.getQuestion(i));
                model.incAnswer();
                model.setAntwortFrage(i-1, view.getAnswer());

            } else {
                end();
            }
        }
    }

    private void end(){
        if(view.getEnded()){

        }else {
            model.incAnswer();
            model.setAntwortFrage(view.getNum()-1, view.getAnswer());
            System.out.println(model.toString());
            view.end();
        }

    }
}

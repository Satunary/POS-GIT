package at.spenger.memory.controler;

import at.spenger.memory.model.MemoryCard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import at.spenger.memory.view.MainView;


public class Controler implements EventHandler<ActionEvent> {
    private MainView view;
    private MemoryCard model;
    private String type;

    public Controler(MainView view, MemoryCard model, String type){

    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}

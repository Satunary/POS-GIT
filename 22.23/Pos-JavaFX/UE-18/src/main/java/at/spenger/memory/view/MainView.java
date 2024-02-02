package at.spenger.memory.view;

import at.spenger.memory.model.MemoryCard;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainView extends BorderPane {

	private MemoryCard last;
	private MemoryCard last2;
	private Integer count;
	String name = "Max";
	Stage primaryStage;

	public MainView(Stage primaryStage) {
		this.primaryStage = primaryStage;
		init(); 
	}

	public void init() {
		count=0;
		primaryStage.setTitle(" MEMORY (" + name + ")");
		
		setTop(getTopPane());
		setCenter(getCenterPane());
	}

	public MenuBar getTopPane() {
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Spiel");
		MenuItem item1 = new MenuItem("Benutzerangabe");
		MenuItem item2 = new MenuItem("Zeilen");

		menu.getItems().addAll(item1, item2);
		menuBar.getMenus().add(menu);
		return menuBar;
	}

	public FlowPane getCenterPane() {
		FlowPane f = new FlowPane();
		f.setPadding(new Insets(10));
		Random r = new Random();
		Integer[] in = new Integer[8];
		for(int i =0;i<8;i++){
			in[i]=2;
		}

		for (int i =0; i<16; i++){
			int temp = r.nextInt(8);
			while (in[temp]==0){
				temp=r.nextInt(8);
			}
			MemoryCard m = new  MemoryCard("img"+temp+".png");
			m.setView(this);
			m.setValue(temp);
			in[temp]--;

			f.getChildren().add(m);
		}

		return f;
	}

	public MemoryCard getLast() {
		return last;
	}

	public void setLast(MemoryCard last) {
		this.last = last;
	}

	public MemoryCard getLast2() {
		return last2;
	}

	public void setLast2(MemoryCard last2) {
		this.last2 = last2;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	public void sleep(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}

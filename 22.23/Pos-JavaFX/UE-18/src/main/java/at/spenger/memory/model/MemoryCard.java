package at.spenger.memory.model;

import at.spenger.memory.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MemoryCard extends Button {
	private ImageView defaultImg;
	private ImageView img;
	private MainView view;
	private Integer value;
	private int col;
	private int row;
	public MemoryCard(String bild) {
		super();
		var defaultImgTmp = new Image(getClass().getResourceAsStream("/img/kartenruecken.jpg"));
		defaultImg = new ImageView(defaultImgTmp);
		defaultImg.setFitHeight(100);
		defaultImg.setFitWidth(100);
		this.setGraphic(defaultImg);
		var imgTmp = new Image(getClass().getResourceAsStream("/img/"+bild));
		img =  new ImageView(imgTmp);
		img.setFitHeight(100);
		img.setFitWidth(100);


		this.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					pruef();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
	
	public void setView(MainView view){
		this.view=view;
	}
	public void umdrehen()
	{

		if(this.getGraphic().equals(defaultImg))
		{
			this.setGraphic(img);
		}
		else
		{
			this.setGraphic(defaultImg);
		}


	}


	
	public void hide()
	{
		this.setDisable(true);
	}

	private void pruef() throws InterruptedException {

		if(view.getCount()!=null && view.getCount()==0){
			view.setLast(this);
			view.setCount(1);
			umdrehen();
		}else {
			if(view.getCount()!=null && view.getCount()==1){
				view.setLast2(this);
				view.setCount(2);
				umdrehen();

			} else if (view.getCount()==2) {
				umdrehen();

				if(view.getLast().getValue().equals(view.getLast2().getValue()) && !(view.getLast2().equals(view.getLast()))){
					view.getLast().hide();
					view.getLast2().hide();

				}else{
					view.getLast().umdrehen();
					view.getLast2().umdrehen();
				}
				view.setLast(this);
				view.setCount(1);

			}
		}
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + ((defaultImg == null) ? 0 : defaultImg.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + row;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemoryCard other = (MemoryCard) obj;
		if (col != other.col)
			return false;
		if (defaultImg == null) {
			if (other.defaultImg != null)
				return false;
		} else if (!defaultImg.equals(other.defaultImg))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}

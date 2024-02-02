package at.spenger;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;


public class SimpleViewSchach extends Pane {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;
    private static final int BOARD_SIZE = 320;

    public SimpleViewSchach() {
        for (int x = 0, c = 0; x < BOARD_SIZE; x = x + WIDTH, c++) {
            for (int y = 0; y < BOARD_SIZE; y = y + HEIGHT) {
                if (c % 2 == 0) {
                    Rectangle rect = new Rectangle(x, y, WIDTH, HEIGHT);
                    this.getChildren().add(rect);
                }

                c++;
            }
        }
    }
}

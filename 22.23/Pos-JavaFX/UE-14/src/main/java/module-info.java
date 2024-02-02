module at.spenger.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens at.spenger.demo2 to javafx.fxml;
    exports at.spenger.demo2;
}
module at.spenger.memory {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.spenger.memory to javafx.fxml;
    exports at.spenger.memory;
}
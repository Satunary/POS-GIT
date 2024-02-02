module at.spenger.ue16 {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.spenger.ue16 to javafx.fxml;
    exports at.spenger.ue16;
}
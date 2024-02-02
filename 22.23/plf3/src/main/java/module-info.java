module spenger.at.plf3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens spenger.at.plf3 to javafx.fxml;
    exports spenger.at.plf3;
}
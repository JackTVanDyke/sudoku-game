module com.vandyke.sudokugame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.vandyke.sudokugame to javafx.fxml;
    exports com.vandyke.sudokugame;
}
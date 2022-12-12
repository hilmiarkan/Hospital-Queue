module com.example.hospital {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens com.example.hospital to javafx.fxml;
    exports com.example.hospital;
}
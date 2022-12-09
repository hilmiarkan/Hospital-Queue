package com.example.hospital;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PopUpAntrianKosongPetugasController implements Initializable {



    public void openHomepagePetugasScene(ActionEvent actionEvent) throws IOException {

        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("HomepagePetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Node THISFCKNSTAGENODE = ((Node) actionEvent.getSource()).getParent().getParent().getParent();

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(.3), THISFCKNSTAGENODE);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeOut.play();

        fadeOut.setOnFinished((e) -> {
            primaryStage.setScene(InvoiceScene);
            primaryStage.show();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
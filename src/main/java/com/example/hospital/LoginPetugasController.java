package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPetugasController implements Initializable {

    public void openHomepageScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    public void openHomepagePetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("HomepagePetugas.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database database = Database.getInstance();
    }
}
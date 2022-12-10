package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomepageController implements Initializable {

    @FXML
    private Label antrianPoliMata;
    @FXML
    private Label antrianPoliJantung;
    @FXML
    private Label antrianPoliBedah;

    public void openFormAntriScene(ActionEvent actionEvent) throws IOException {

        FXMLLoader Loader = new FXMLLoader(getClass().getResource("FormAntri.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    public void openLoginPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("LoginPetugas.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Database database = Database.getInstance();

        Queue queuePoliMata = database.getQueuePoliMata();
        Object objMata = queuePoliMata.getnItems();

        Queue queuePoliJantung = database.getQueuePoliJantung();
        Object objJantung = queuePoliJantung.getnItems();

        Queue queuePoliBedah = database.getQueuePoliBedah();
        Object objBedah = queuePoliBedah.getnItems();

        if (queuePoliMata.isEmpty()) {
            antrianPoliMata.setText("A00");
        } else if (objMata.getNoantrian() >= 10) {
            antrianPoliMata.setText("A" + objMata.getNoantrian());
        } else {
            antrianPoliMata.setText("A0" + objMata.getNoantrian());
        }

        if (queuePoliJantung.isEmpty()) {
            antrianPoliJantung.setText("B00");
        } else if (objJantung.getNoantrian() >= 10) {
            antrianPoliJantung.setText("B" + objJantung.getNoantrian());
        } else {
            antrianPoliJantung.setText("B0" + objJantung.getNoantrian());
        }

        if (queuePoliBedah.isEmpty()) {
            antrianPoliBedah.setText("C00");
        } else if (objBedah.getNoantrian() >= 10) {
            antrianPoliBedah.setText("C" + objBedah.getNoantrian());
        } else {
            antrianPoliBedah.setText("C0" + objBedah.getNoantrian());
        }

    }
}
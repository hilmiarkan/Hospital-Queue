package com.example.hospital;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HomepageController implements Initializable {

    @FXML
    private Label antrianPoliMata;
    @FXML
    private Label antrianPoliJantung;
    @FXML
    private Label antrianPoliBedah;
    @FXML
    private Button button_buatantrian;

//
//    String NavHoverStyle = "-fx-font-size: 18pt; -fx-font-weight: bold; -fx-background-color: blue;";
//
//    Timeline NavTimeline = new Timeline(
//            new KeyFrame(Duration.ZERO, new KeyValue(button_buatantrian.styleProperty(), "")),
//            new KeyFrame(Duration.seconds(1), new KeyValue(button_buatantrian.styleProperty(), NavHoverStyle))
//    );
    @FXML
    void hoverNav(MouseEvent event) {
//        NavTimeline.play();
    }
    @FXML
    void unhoverNav(MouseEvent event) {
//        NavTimeline.stop();
        // Set the button's style to the original value defined in the first key frame of the timeline
//        button_buatantrian.setStyle(NavTimeline.getKeyFrames().get(0).getValues().get(0).getEndValue());
    }

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
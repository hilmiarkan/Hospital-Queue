package com.example.hospital;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HomepagePetugasController implements Initializable {

    Database database = Database.getInstance();
    @FXML
    private HBox alerta;
    @FXML
    private Label antrianPoliMata;
    @FXML
    private Label antrianPoliJantung;
    @FXML
    private Label antrianPoliBedah;
    @FXML
    private AnchorPane popup;
    @FXML
    private AnchorPane popuplogout;
    @FXML
    private VBox home;
    Boolean apakah_alert_active = false;

    public void openLoginPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("LoginPetugas.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    public void openFormAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("FormAntriPetugas.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    public void openLihatAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("LihatAntriPetugas.fxml"));
        Parent Page = Loader.load();
        Scene Scene = new Scene(Page, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(Scene);
    }

    @FXML
    void panggilPoliJantung(ActionEvent event) throws IOException {
        if(database.queuePoliJantung.isEmpty()){
            FadeTransition fade = new FadeTransition();
            popup.setVisible(true);
            fade.setNode(popup);
            fade.setDuration(Duration.millis(200));
//            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setCycleCount(1);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
            home.setEffect(new GaussianBlur(14));
        }
        database.deQueue("Poli Jantung", event);

        setUp();
    }

    @FXML
    void panggilPoliBedah(ActionEvent event) throws IOException {

        if(database.queuePoliBedah.isEmpty()){
            FadeTransition fade = new FadeTransition();
            popup.setVisible(true);
            fade.setNode(popup);
            fade.setDuration(Duration.millis(200));
//            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setCycleCount(1);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
            home.setEffect(new GaussianBlur(14));
        }
        database.deQueue("Poli Bedah", event);
        setUp();
    }

    public void closeAlerta() {
        TranslateTransition moveOut = new TranslateTransition();
        moveOut.setNode(alerta);
        moveOut.setDuration(Duration.millis(200));
        moveOut.setCycleCount(1);
        moveOut.setByX(270);
        moveOut.play();
        apakah_alert_active = false;
    }

    public void openAlerta() {
        TranslateTransition moveIn = new TranslateTransition();
        moveIn.setNode(alerta);
        moveIn.setDuration(Duration.millis(150));
        moveIn.setCycleCount(1);
        moveIn.setByX(-270);
        moveIn.play();
        apakah_alert_active = true;
//        moveIn.setOnFinished(e -> {
//            Timeline timeline = new Timeline(new KeyFrame(
//                    Duration.seconds(7),
//                    event -> closeAlerta()
//            ));
//            timeline.play();
//        });
    }

    public void openPopUpLogOut() {
        FadeTransition fade = new FadeTransition();
        popuplogout.setVisible(true);
        fade.setNode(popuplogout);
        fade.setDuration(Duration.millis(200));
//            fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setCycleCount(1);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
        home.setEffect(new GaussianBlur(14));
    }

    @FXML
    void backlogout(ActionEvent event) throws IOException {

        FadeTransition fade = new FadeTransition();
        fade.setNode(popuplogout);
        fade.setDuration(Duration.millis(150));
        fade.setCycleCount(1);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        home.setEffect(null);
        fade.setOnFinished(e -> {
            popuplogout.setVisible(false);
        });
    }

    void setUp() {
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

    @FXML
    void back(ActionEvent event) throws IOException {

        FadeTransition fade = new FadeTransition();
        fade.setNode(popup);
        fade.setDuration(Duration.millis(150));
        fade.setCycleCount(1);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
        home.setEffect(null);
        fade.setOnFinished(e -> {
            popup.setVisible(false);
        });
    }

    @FXML
    void panggilPoliMata(ActionEvent event) throws IOException {

        if(database.queuePoliMata.isEmpty()){
//            if (apakah_alert_active) {
//                TranslateTransition moveOut = new TranslateTransition();
//                moveOut.setNode(alerta);
//                moveOut.setDuration(Duration.millis(200));
//                moveOut.setCycleCount(1);
//                moveOut.setByX(270);
//                moveOut.play();
//                apakah_alert_active = false;
//                moveOut.setOnFinished(e -> {
//                    openAlerta();
//                });
//            } else {
//                openAlerta();
//            }
            FadeTransition fade = new FadeTransition();
            popup.setVisible(true);
            fade.setNode(popup);
            fade.setDuration(Duration.millis(200));
//            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setCycleCount(1);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(0);
            fade.setToValue(1);
            fade.play();
            home.setEffect(new GaussianBlur(14));
        }

        database.deQueue("Poli Mata", event);
        setUp();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        popup.setVisible(false);
        popuplogout.setVisible(false);
        setUp();
    }
}
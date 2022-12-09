package com.example.hospital;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
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
    Boolean apakah_alert_active = false;

    public void openHomepageScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openFormAntriScene(ActionEvent actionEvent) throws IOException {

        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("FormAntri.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openHomepagePetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("HomepagePetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openLoginPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("LoginPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openFormAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("FormAntriPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openLihatAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("LihatAntriPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openInvoiceScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
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
        }
        database.deQueue("Poli Mata", event);
        setUp();
    }

    @FXML
    void panggilPoliJantung(ActionEvent event) throws IOException {
        if(database.queuePoliJantung.isEmpty()){
        }
        database.deQueue("Poli Jantung", event);

        setUp();
    }

    @FXML
    void panggilPoliBedah(ActionEvent event) throws IOException {

        if(database.queuePoliBedah.isEmpty()){
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
        moveIn.setDuration(Duration.millis(200));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUp();
    }
}
package com.example.hospital;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FormAntriController implements Initializable {

    @FXML
    private HBox alerta;

    private Scene PopUpAntrianPenuhScene;

    public void setPopUpAntrianPenuhScene(Scene scene) {
        PopUpAntrianPenuhScene = scene;
    }

    public void openPopUpAntrianPenuhScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(PopUpAntrianPenuhScene);
    }

    @FXML
    private TextField noantrian;
    @FXML
    private TextField nama;
    @FXML
    private ComboBox poli;
    @FXML
    private ComboBox dokter;
    @FXML
    private DatePicker tanggal;

    String jenisTerpilih = "";
    String lokasi_invoice = "umum";
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

    public void closeAlerta() {
        TranslateTransition moveOut = new TranslateTransition();
        moveOut.setNode(alerta);
        moveOut.setDuration(Duration.millis(200));
        moveOut.setCycleCount(1);
        moveOut.setByX(420);
        moveOut.play();
        apakah_alert_active = false;
    }

    public void openAlerta() {
        TranslateTransition moveIn = new TranslateTransition();
        moveIn.setNode(alerta);
        moveIn.setDuration(Duration.millis(200));
        moveIn.setCycleCount(1);
        moveIn.setByX(-420);
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

    public void openInvoiceScene(ActionEvent actionEvent) throws IOException {
        Database database = Database.getInstance();
        Queue queue = database.getQueuePoliMata();
        Queue queuePoliJantung = database.getQueuePoliJantung();
        Queue queuePoliBedah = database.getQueuePoliBedah();

//        InvoiceController invoice = new InvoiceController();
//        invoice.setUp(noantrian, nama, poli, dokter, tanggal, jenis, antri);

        if (this.nama.getText().equals("") || this.poli.getValue() == "Pilih poli" || this.poli.getValue() == null || this.dokter.getValue() == "Pilih dokter" || this.dokter.getValue() == null || this.tanggal.getValue() == null || jenisTerpilih.equals("")) {
            TranslateTransition moveIn = new TranslateTransition();
            if (apakah_alert_active) {
                TranslateTransition moveOut = new TranslateTransition();
                moveOut.setNode(alerta);
                moveOut.setDuration(Duration.millis(200));
                moveOut.setCycleCount(1);
                moveOut.setByX(420);
                moveOut.play();
                apakah_alert_active = false;
                moveOut.setOnFinished(e -> {
                    openAlerta();
                });
            } else {
                openAlerta();
            }



        } else {
            int noantrian = 0, antri = 0;
            String nama, poli, dokter, tanggal, jenis;

            nama = this.nama.getText();
            poli = this.poli.getValue().toString();
            dokter = this.dokter.getValue().toString();
            tanggal = this.tanggal.getValue().toString();
            jenis = this.jenisTerpilih;

            if (poli.equals("Poli Mata")) {
                noantrian = queue.getNoAntrian();
                antri = queue.getAntri();
            } else if (poli.equals("Poli Jantung")) {
                noantrian = queuePoliJantung.getNoAntrian();
                antri = queuePoliJantung.getAntri();
            } else if (poli.equals("Poli Bedah")) {
                noantrian = queuePoliBedah.getNoAntrian();
                antri = queuePoliBedah.getAntri();
            }

            database.enQueue(noantrian, nama, poli, dokter, tanggal, jenis, actionEvent, lokasi_invoice);

//            if (queue.isFull()) {
//                System.out.println("Poli Mata Penuh");
//            } else {
//                System.out.println("Telah masuk Antrian => (" + jenis + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
//                database.enQueue(noantrian, nama, poli, dokter, tanggal, jenis, actionEvent);
//
//                FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
//                Parent InvoicePage = InvoiceLoader.load();
//                Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
//                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//                primaryStage.setScene(InvoiceScene);
//            }
        }

//        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
//        Parent InvoicePage = InvoiceLoader.load();
//        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
//
//
//        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//        primaryStage.setScene(InvoiceScene);
//        FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
//        fadeIn.setFromValue(0);
//        fadeIn.setToValue(1);
//        fadeIn.setCycleCount(1);
//
//        fadeIn.play();
    }

    public void poliTelahTerpilih(ActionEvent actionEvent) {
        if (poli.getValue().equals("Poli Mata")) {
            dokter.setDisable(false);
            dokter.getItems().clear();
            dokter.getItems().addAll("Dr. Suluri", "Dr. Hilmi", "Dr. Arkan");
        } else if (poli.getValue().equals("Poli Jantung")) {
            dokter.setDisable(false);
            dokter.getItems().clear();
            dokter.getItems().addAll("Dr. Suci");
        } else if (poli.getValue().equals("Poli Bedah")) {
            dokter.setDisable(false);
            dokter.getItems().clear();
            dokter.getItems().addAll("Dr. Doc", "Dr. Dia");
        }
    }

    public void memilihBPJS(ActionEvent actionEvent) {
        jenisTerpilih = "BPJS";
    }

    public void memilihUmum(ActionEvent actionEvent) {
        jenisTerpilih = "Umum";
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        poli.getItems().clear();
        poli.getItems().addAll("Poli Mata", "Poli Jantung", "Poli Bedah");
        dokter.setDisable(true);

//        Database database = Database.getInstance();
//        Queue queue = database.getQueue();
//
//        noantrian.setText(String.valueOf(queue.getNoAntrian()));
    }
}
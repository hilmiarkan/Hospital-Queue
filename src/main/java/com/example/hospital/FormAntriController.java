package com.example.hospital;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    @FXML
    private AnchorPane popup;
    @FXML
    private VBox home;
    @FXML
    private VBox receipt;
    @FXML
    private Label viewNo;
    @FXML
    private Label viewNama;
    @FXML
    private Label viewPoli;
    @FXML
    private Label viewTgl;
    @FXML
    private Label viewJenis;
    @FXML
    private Label viewDokter;
    @FXML
    private Label viewAntri;
    @FXML
    private RadioButton radiobpjs;
    @FXML
    private RadioButton radioumum;

    String jenisTerpilih = "";
    String lokasi_invoice = "umum";
    Boolean apakah_alert_active = false;

    public void openHomepageScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
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
    }

    public void openPopUp() {
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
    void closeReceipt(ActionEvent event) throws IOException {
        TranslateTransition moveOut = new TranslateTransition();
        moveOut.setNode(receipt);
        moveOut.setDuration(Duration.millis(1000));
        moveOut.setCycleCount(1);
        moveOut.setByY(620);
        moveOut.play();

        moveOut.setOnFinished(e -> {
            receipt.setVisible(false);
        });
    }

    private void openReceipt() {
        Database database = Database.getInstance();
        int noantrian, antri;
        String nama, poli, dokter, tanggal, jenis;

        if (database.getPoliTerakhir().equals("Poli Mata")) {
            Queue queue = database.getQueuePoliMata();
            Object last = queue.lastAdded();

            noantrian = queue.getNoAntrian()-1;
            nama = last.getNama();
            poli = last.getPoli();
            dokter = last.getDokter();
            tanggal = last.getTanggal();
            jenis = last.getJenis();
            antri = queue.getAntri();

            viewNo.setText(String.valueOf(noantrian));
            viewNama.setText(nama);
            viewPoli.setText(poli);
            viewDokter.setText(dokter);
            viewTgl.setText(tanggal);
            viewJenis.setText(jenis);
            viewAntri.setText(String.valueOf(antri) + " Orang");
        } else if (database.getPoliTerakhir().equals("Poli Jantung")) {
            Queue queue = database.getQueuePoliJantung();
            Object last = queue.lastAdded();

            noantrian = queue.getNoAntrian()-1;
            nama = last.getNama();
            poli = last.getPoli();
            dokter = last.getDokter();
            tanggal = last.getTanggal();
            jenis = last.getJenis();
            antri = queue.getAntri();

            viewNo.setText(String.valueOf(noantrian));
            viewNama.setText(nama);
            viewPoli.setText(poli);
            viewDokter.setText(dokter);
            viewTgl.setText(tanggal);
            viewJenis.setText(jenis);
            viewAntri.setText(String.valueOf(antri) + " Orang");
        } else if (database.getPoliTerakhir().equals("Poli Bedah")) {
            Queue queue = database.getQueuePoliBedah();
            Object last = queue.lastAdded();

            noantrian = queue.getNoAntrian()-1;
            nama = last.getNama();
            poli = last.getPoli();
            dokter = last.getDokter();
            tanggal = last.getTanggal();
            jenis = last.getJenis();
            antri = queue.getAntri();

            viewNo.setText(String.valueOf(noantrian));
            viewNama.setText(nama);
            viewPoli.setText(poli);
            viewDokter.setText(dokter);
            viewTgl.setText(tanggal);
            viewJenis.setText(jenis);
            viewAntri.setText(String.valueOf(antri) + " Orang");
        }

        receipt.setVisible(true);
        TranslateTransition moveIn = new TranslateTransition();
        moveIn.setNode(receipt);
        moveIn.setDuration(Duration.millis(1000));
        moveIn.setCycleCount(1);
        moveIn.setByY(-620);
        moveIn.play();

        PauseTransition pause = new PauseTransition(Duration.millis(900));
        pause.play();
        pause.setOnFinished(e -> {
            this.nama.setText("");
//            this.poli.getSelectionModel().clearSelection();
//            this.poli.setPromptText("Pilih Poli");
//            this.dokter.getSelectionModel().clearSelection();
//            this.dokter.setDisable(true);
            this.tanggal.setValue(null);
            this.radiobpjs.setSelected(false);
            this.radioumum.setSelected(false);
        });
    }

    public void openInvoiceScene(ActionEvent actionEvent) throws IOException {
        Database database = Database.getInstance();
        Queue queuePoliMata = database.getQueuePoliMata();
        Queue queuePoliJantung = database.getQueuePoliJantung();
        Queue queuePoliBedah = database.getQueuePoliBedah();

        if (this.nama.getText().equals("") || this.poli.getValue() == "Pilih poli" || this.poli.getValue() == null || this.dokter.getValue() == "Pilih dokter" || this.dokter.getValue() == null || this.tanggal.getValue() == null || jenisTerpilih.equals("")) {
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
                if (queuePoliMata.isFull()) {
                    openPopUp();
                } else {
                    noantrian = queuePoliMata.getNoAntrian();
                    database.enQueue(noantrian, nama, poli, dokter, tanggal, jenis, actionEvent, lokasi_invoice);
                    openReceipt();
                }
            } else if (poli.equals("Poli Jantung")) {
                if (queuePoliJantung.isFull()) {
                    openPopUp();
                } else {
                    noantrian = queuePoliJantung.getNoAntrian();
                    database.enQueue(noantrian, nama, poli, dokter, tanggal, jenis, actionEvent, lokasi_invoice);
                    openReceipt();
                }
            } else if (poli.equals("Poli Bedah")) {
                if (queuePoliBedah.isFull()) {
                    openPopUp();
                } else {
                    noantrian = queuePoliBedah.getNoAntrian();
                    database.enQueue(noantrian, nama, poli, dokter, tanggal, jenis, actionEvent, lokasi_invoice);
                    openReceipt();
                }
            }
        }
    }

    public void poliTelahTerpilih(ActionEvent actionEvent) {
        if (poli.getValue() == null) {
            dokter.setDisable(true);
            dokter.setPromptText("Pilih Dokter");
        } else if (poli.getValue().equals("Poli Mata")) {
            dokter.setDisable(false);
            dokter.getItems().clear();
            dokter.getItems().addAll("drg. Sukmarani, M.S.S.");
        } else if (poli.getValue().equals("Poli Jantung")) {
            dokter.setDisable(false);
            dokter.getItems().clear();
            dokter.getItems().addAll("dr. Suci, M.Biomed", "dr. Pandu, Sp.PD.");
        } else if (poli.getValue().equals("Poli Bedah")) {
            dokter.setDisable(false);
            dokter.getItems().clear();
            dokter.getItems().addAll("dr. Sadiman, Sp.B.", "dr. Faris, Sp.B.", "dr. Yusuf, Sp.B.");
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
        popup.setVisible(false);
        receipt.setVisible(false);
        poli.getItems().addAll( "Poli Mata", "Poli Jantung", "Poli Bedah");
        dokter.setDisable(true);
    }
}
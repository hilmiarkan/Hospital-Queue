package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FormAntriPetugasController implements Initializable {

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

    public void openHomepageScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openFormAntriScene(ActionEvent actionEvent) throws IOException {

        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("FormAntri.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openHomepagePetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("HomepagePetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openLoginPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("LoginPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openFormAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("FormAntriPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openLihatAntriPetugasScene(ActionEvent actionEvent) throws IOException {
        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("LihatAntriPetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
    }

    public void openInvoicePetugasScene(ActionEvent actionEvent) throws IOException {
        Database database = Database.getInstance();
        QueuePoliMata queuePoliMata = database.getQueuePoliMata();
        QueuePoliJantung queuePoliJantung = database.getQueuePoliJantung();

        int noantrian = 0, antri = 0;
        String nama, poli, dokter, tanggal, jenis;

//        noantrian = Integer.parseInt(this.noantrian.getText());
        if (this.poli.getValue().equals("Poli Mata")) {
            noantrian = queuePoliMata.getNoAntrian();
            antri = queuePoliMata.getAntri();
        } else if (this.poli.getValue().equals("Poli Jantung")) {
            noantrian = queuePoliJantung.getNoAntrian();
            antri = queuePoliJantung.getAntri();
        }

        nama = this.nama.getText();
        poli = this.poli.getValue().toString();
        dokter = this.dokter.getValue().toString();
        tanggal = this.tanggal.getValue().toString();
        jenis = this.jenisTerpilih;

        System.out.println("Telah masuk Antrian => (" + jenisTerpilih + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);

//        database.enQueue(noantrian, nama, poli, dokter, tanggal, jenis);

//        InvoiceController invoice = new InvoiceController();
//        invoice.setUp(noantrian, nama, poli, dokter, tanggal, jenis, antri);

        FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
        Parent InvoicePage = InvoiceLoader.load();
        Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(InvoiceScene);
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
    }
}
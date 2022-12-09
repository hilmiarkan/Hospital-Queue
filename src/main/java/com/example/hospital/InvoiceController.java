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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InvoiceController implements Initializable {

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
    private VBox receipt;

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

    int noantrian, antri;
    String nama, poli, dokter, tanggal, jenis;

    public void setUp(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis, int antri) {
        this.noantrian = noantrian;
        this.nama = nama;
        this.poli = poli;
        this.dokter = dokter;
        this.tanggal = tanggal;
        this.jenis = jenis;
        this.antri = antri;
        System.out.println(this.noantrian + this.nama);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println(this.noantrian + this.nama);
//        InvoiceController in = new InvoiceController();
//        viewNo.setText(String.valueOf(in.noantrian));
//        viewNama.setText(in.nama);
//        viewPoli.setText(in.poli);
//        viewDokter.setText(in.dokter);
//        viewTgl.setText(in.tanggal);
//        viewJenis.setText(in.jenis);
//        viewAntri.setText(String.valueOf(in.antri));
//        setUp(noantrian,nama,poli,dokter,tanggal,jenis,antri);
        Database database = Database.getInstance();
        int noantrian, antri;
        String nama, poli, dokter, tanggal, jenis;

        if (database.getPoliTerakhir().equals("Poli Mata")) {
            QueuePoliMata queue = database.getQueuePoliMata();
            ObjectPoliMata last = queue.lastAdded();

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
            QueuePoliJantung queue = database.getQueuePoliJantung();
            ObjectPoliJantung last = queue.lastAdded();

            noantrian = last.getNoantrian();
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
            QueuePoliBedah queue = database.getQueuePoliBedah();
            ObjectPoliBedah last = queue.lastAdded();

            noantrian = last.getNoantrian();
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

        TranslateTransition moveIn = new TranslateTransition();
        moveIn.setNode(receipt);
        moveIn.setDuration(Duration.millis(1200));
        moveIn.setCycleCount(1);
        moveIn.setByY(-600);
        moveIn.play();
    }
}
package com.example.hospital;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public final class Database {

    Queue queuePoliMata = new Queue(2);
    Queue queuePoliJantung = new Queue(2);
    Queue queuePoliBedah = new Queue(2);
    private final static Database okeoce = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return okeoce;
    }

    private String poliTerakhir;
    private String invoiceTerakhir;


    public void enQueue(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis, ActionEvent actionEvent, String invoice) throws IOException {
        poliTerakhir = poli;
        invoiceTerakhir = invoice;
        if (poli.equals("Poli Mata")) {
                this.queuePoliMata.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                System.out.println("Telah masuk Antrian => (" + jenis + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);

        } else if (poli.equals("Poli Jantung")) {
                this.queuePoliJantung.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                System.out.println("Telah masuk Antrian => (" + jenis + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);

        } else if (poli.equals("Poli Bedah")) {
//            if (queuePoliBedah.isFull()) {
//                System.out.println("Antrian poli bedah sudah penuh");
//                if(invoiceTerakhir == "petugas") {
//                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("PopUpAntrianPenuhPetugas.fxml"));
//                    Parent Page = Loader.load();
//                    Scene Scene = new Scene(Page, 1200, 700);
//
//                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//                    primaryStage.setScene(Scene);
//                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), Page);
//                    fadeIn.setFromValue(0);
//                    fadeIn.setToValue(1);
//                    fadeIn.setCycleCount(1);
//
//                    fadeIn.play();
//                } else if (invoiceTerakhir == "umum") {
//                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("PopUpAntrianPenuh.fxml"));
//                    Parent Page = Loader.load();
//                    Scene Scene = new Scene(Page, 1200, 700);
//
//                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//                    primaryStage.setScene(Scene);
//                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), Page);
//                    fadeIn.setFromValue(0);
//                    fadeIn.setToValue(1);
//                    fadeIn.setCycleCount(1);
//
//                    fadeIn.play();
//                }

//            } else {
                this.queuePoliBedah.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                System.out.println("Telah masuk Antrian => (" + jenis + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
//                if(invoiceTerakhir == "petugas") {
//                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
//                    Parent Page = Loader.load();
//                    Scene Scene = new Scene(Page, 1200, 700);
//                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//                    primaryStage.setScene(Scene);
//                } else if (invoiceTerakhir == "umum") {
//                    FXMLLoader Loader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
//                    Parent Page = Loader.load();
//                    Scene Scene = new Scene(Page, 1200, 700);
//                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//                    primaryStage.setScene(Scene);
//                }

//            }
        }
    }

    public boolean deQueue(String jenis, ActionEvent actionEvent) throws IOException {
        boolean dequeued = false;
        if (jenis.equals("Poli Mata")) {
            if (queuePoliMata.isEmpty()) {
                dequeued = false;
//                FXMLLoader Loader = new FXMLLoader(getClass().getResource("PopUpAntrianKosongPetugas.fxml"));
//                Parent Page = Loader.load();
//                Scene Scene = new Scene(Page, 1200, 700);
//
//                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
//                primaryStage.setScene(Scene);
//                FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), Page);
//                fadeIn.setFromValue(0);
//                fadeIn.setToValue(1);
//                fadeIn.setCycleCount(1);
//
//                fadeIn.play();
            } else {
                this.queuePoliMata.remove();
                dequeued =  true;
            }
        } else if (jenis.equals("Poli Jantung")) {
            if (queuePoliJantung.isEmpty()) {
                dequeued =  false;
            } else {
                this.queuePoliJantung.remove();
                dequeued =  true;
            }
        } else if (jenis.equals("Poli Bedah")) {
            if (queuePoliBedah.isEmpty()) {
                dequeued =  false;
            } else {
                this.queuePoliBedah.remove();
                dequeued =  true;
            }
        }
        return dequeued;
    }

    public String getPoliTerakhir() {
        return poliTerakhir;
    }

    public Queue getQueuePoliMata() {
        return queuePoliMata;
    }

    public Queue getQueuePoliJantung() {
        return queuePoliJantung;
    }

    public Queue getQueuePoliBedah() {
        return queuePoliBedah;
    }
}
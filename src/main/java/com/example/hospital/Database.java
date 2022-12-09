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

    QueuePoliMata queuePoliMata = new QueuePoliMata(2);
    QueuePoliJantung queuePoliJantung = new QueuePoliJantung(2);
    QueuePoliBedah queuePoliBedah = new QueuePoliBedah(2);
    private final static Database INSTANCE = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    private String poliTerakhir;
    private String invoiceTerakhir;


    public void enQueue(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis, ActionEvent actionEvent, String invoice) throws IOException {
        poliTerakhir = poli;
        invoiceTerakhir = invoice;
        if (poli.equals("Poli Mata")) {
            if (queuePoliMata.isFull()) {
                System.out.println("Poli Mata Penuh");
                if(invoiceTerakhir == "petugas") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianPenuhPetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);


                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);
                    fadeIn.setCycleCount(1);

                    fadeIn.play();
                } else if (invoiceTerakhir == "umum") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianPenuh.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);


                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);
                    fadeIn.setCycleCount(1);

                    fadeIn.play();
                }

            } else {
                System.out.println("Telah masuk Antrian => (" + jenis + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
                //inserHashTable -> Antrian Semua poli -> View Semua poli petugas

                if(invoiceTerakhir == "petugas") {
                    this.queuePoliMata.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                } else if (invoiceTerakhir == "umum") {
                    this.queuePoliMata.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                }

            }
        } else if (poli.equals("Poli Jantung")) {
//            this.queuePoliJantung.insert(noantrian, nama, poli, dokter, tanggal, jenis);
            if (queuePoliJantung.isFull()) {
                System.out.println("Poli Mata Penuh");
                if(invoiceTerakhir == "petugas") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianPenuhPetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);


                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);
                    fadeIn.setCycleCount(1);

                    fadeIn.play();
                } else if (invoiceTerakhir == "umum") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianPenuh.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);


                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);
                    fadeIn.setCycleCount(1);

                    fadeIn.play();
                }

            } else {
                System.out.println("Telah masuk Antrian => (" + jenis + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
                //inserHashTable -> Antrian Semua poli -> View Semua poli petugas

                if(invoiceTerakhir == "petugas") {
                    this.queuePoliJantung.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                } else if (invoiceTerakhir == "umum") {
                    this.queuePoliJantung.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                }

            }
        } else if (poli.equals("Poli Bedah")) {
//            this.queuePoliBedah.insert(noantrian, nama, poli, dokter, tanggal, jenis);
            if (queuePoliBedah.isFull()) {
                System.out.println("Poli Mata Penuh");
                if(invoiceTerakhir == "petugas") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianPenuhPetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);


                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);
                    fadeIn.setCycleCount(1);

                    fadeIn.play();
                } else if (invoiceTerakhir == "umum") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianPenuh.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);


                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                    FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                    fadeIn.setFromValue(0);
                    fadeIn.setToValue(1);
                    fadeIn.setCycleCount(1);

                    fadeIn.play();
                }

            } else {
                System.out.println("Telah masuk Antrian => (" + jenis + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
                //inserHashTable -> Antrian Semua poli -> View Semua poli petugas

                if(invoiceTerakhir == "petugas") {
                    this.queuePoliBedah.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                } else if (invoiceTerakhir == "umum") {
                    this.queuePoliBedah.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                }

            }
        }
    }

    public void deQueue(String jenis) {
        if (jenis.equals("Poli Mata")) {
            if (queuePoliMata.isEmpty()) {
                System.out.println("Antrian Kosong");
            } else {
                this.queuePoliMata.remove();
            }
        } else if (jenis.equals("Poli Jantung")) {
            if (queuePoliJantung.isEmpty()) {
                System.out.println("Antrian Kosong");
            } else {
                this.queuePoliJantung.remove();
            }
        } else if (jenis.equals("Poli Bedah")) {
            if (queuePoliBedah.isEmpty()) {
                System.out.println("Antrian Kosong");
            } else {
                this.queuePoliBedah.remove();
            }
        }
    }

    public String getPoliTerakhir() {
        return poliTerakhir;
    }

    public QueuePoliMata getQueuePoliMata() {
        return queuePoliMata;
    }

    public QueuePoliJantung getQueuePoliJantung() {
        return queuePoliJantung;
    }

    public QueuePoliBedah getQueuePoliBedah() {
        return queuePoliBedah;
    }
}
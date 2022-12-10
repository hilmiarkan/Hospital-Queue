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
                this.queuePoliMata.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                if(invoiceTerakhir == "petugas") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                } else if (invoiceTerakhir == "umum") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                }
            }
        } else if (poli.equals("Poli Jantung")) {
            if (queuePoliJantung.isFull()) {
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
                this.queuePoliJantung.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                if(invoiceTerakhir == "petugas") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                } else if (invoiceTerakhir == "umum") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                }
            }
        } else if (poli.equals("Poli Bedah")) {
            if (queuePoliBedah.isFull()) {
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
                this.queuePoliBedah.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                if(invoiceTerakhir == "petugas") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("InvoicePetugas.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                } else if (invoiceTerakhir == "umum") {
                    FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
                    Parent InvoicePage = InvoiceLoader.load();
                    Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                    Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    primaryStage.setScene(InvoiceScene);
                }

            }
        }
    }

    public void deQueue(String jenis, ActionEvent actionEvent) throws IOException {
        if (jenis.equals("Poli Mata")) {
            if (queuePoliMata.isEmpty()) {
                FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianKosongPetugas.fxml"));
                Parent InvoicePage = InvoiceLoader.load();
                Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(InvoiceScene);
                FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(1);
                fadeIn.setCycleCount(1);

                fadeIn.play();
            } else {
                this.queuePoliMata.remove();
            }
        } else if (jenis.equals("Poli Jantung")) {
            if (queuePoliJantung.isEmpty()) {
                FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianKosongPetugas.fxml"));
                Parent InvoicePage = InvoiceLoader.load();
                Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(InvoiceScene);
                FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(1);
                fadeIn.setCycleCount(1);

                fadeIn.play();
            } else {
                this.queuePoliJantung.remove();
            }
        } else if (jenis.equals("Poli Bedah")) {
            if (queuePoliBedah.isEmpty()) {
                FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("PopUpAntrianKosongPetugas.fxml"));
                Parent InvoicePage = InvoiceLoader.load();
                Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);

                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(InvoiceScene);
                FadeTransition fadeIn = new FadeTransition(Duration.seconds(.3), InvoicePage);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(1);
                fadeIn.setCycleCount(1);

                fadeIn.play();
            } else {
                this.queuePoliBedah.remove();
            }
        }
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
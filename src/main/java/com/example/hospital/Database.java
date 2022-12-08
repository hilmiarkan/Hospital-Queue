package com.example.hospital;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class Database {

    QueuePoliMata queuePoliMata = new QueuePoliMata(3);
    QueuePoliJantung queuePoliJantung = new QueuePoliJantung(20);
    QueuePoliBedah queuePoliBedah = new QueuePoliBedah(20);
    private final static Database INSTANCE = new Database();

    private Database() {
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    private String poliTerakhir;

    public void enQueue(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis, ActionEvent actionEvent) throws IOException {
        poliTerakhir = poli;
        if (poli.equals("Poli Mata")) {
            if (queuePoliMata.isFull()) {
                System.out.println("Poli Mata Penuh");
            } else {
                System.out.println("Telah masuk Antrian => (" + jenis + " " + poli + ")No Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
                //inserHashTable -> Antrian Semua poli -> View Semua poli petugas
                this.queuePoliMata.insert(noantrian, nama, poli, dokter, tanggal, jenis);
                FXMLLoader InvoiceLoader = new FXMLLoader(getClass().getResource("Invoice.fxml"));
                Parent InvoicePage = InvoiceLoader.load();
                Scene InvoiceScene = new Scene(InvoicePage, 1200, 700);
                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.setScene(InvoiceScene);
            }
        } else if (poli.equals("Poli Jantung")) {
            this.queuePoliJantung.insert(noantrian, nama, poli, dokter, tanggal, jenis);
        } else if (poli.equals("Poli Bedah")) {
            this.queuePoliBedah.insert(noantrian, nama, poli, dokter, tanggal, jenis);
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
package com.example.hospital;


import javafx.event.ActionEvent;

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
            System.out.println("Telah masuk Antrian => (" + poli + " " + jenis + ")\t\tNo Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
        } else if (poli.equals("Poli Jantung")) {
            this.queuePoliJantung.insert(noantrian, nama, poli, dokter, tanggal, jenis);
            System.out.println("Telah masuk Antrian => (" + poli + " " + jenis + ")\tNo Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
        } else if (poli.equals("Poli Bedah")) {
            this.queuePoliBedah.insert(noantrian, nama, poli, dokter, tanggal, jenis);
            System.out.println("Telah masuk Antrian => (" + poli + " " + jenis + ")\tNo Antrian: " + noantrian + ", Nama: " + nama + ", Dokter: " + dokter + ", Tanggal: " + tanggal);
        }
    }

    public void deQueue(String jenis) throws IOException {
        if (jenis.equals("Poli Mata")) {
            System.out.println("Antrian " + queuePoliMata.getnItems().getNoantrian() + " Silahkan Menuju " + queuePoliMata.getnItems().getPoli());
            this.queuePoliMata.remove();
        } else if (jenis.equals("Poli Jantung")) {
            System.out.println("Antrian " + queuePoliJantung.getnItems().getNoantrian() + " Silahkan Menuju " + queuePoliJantung.getnItems().getPoli());
            this.queuePoliJantung.remove();
        } else if (jenis.equals("Poli Bedah")) {
            System.out.println("Antrian " + queuePoliBedah.getnItems().getNoantrian() + " Silahkan Menuju " + queuePoliBedah.getnItems().getPoli());
            this.queuePoliBedah.remove();
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
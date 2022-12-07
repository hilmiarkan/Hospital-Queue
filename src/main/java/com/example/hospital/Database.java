package com.example.hospital;



public final class Database {

    QueuePoliMata queuePoliMata = new QueuePoliMata(20);
    QueuePoliJantung queuePoliJantung = new QueuePoliJantung(20);
    private final static Database INSTANCE = new Database();

    private Database() {}

    public static Database getInstance() {
        return INSTANCE;
    }

    private String poliTerakhir;
    public void enQueue(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis) {
        poliTerakhir=poli;
        if (poli.equals("Poli Mata")) {
            this.queuePoliMata.insert(noantrian, nama, poli, dokter, tanggal, jenis);
        } else if (poli.equals("Poli Jantung")) {
            this.queuePoliJantung.insert(noantrian, nama, poli, dokter, tanggal, jenis);
        }
    }

    public void deQueue(){
        this.queuePoliMata.remove();
    }

    public String getPoliTerakhir(){
        return poliTerakhir;
    }

    public QueuePoliMata getQueuePoliMata() {
            return queuePoliMata;
    }

    public QueuePoliJantung getQueuePoliJantung() {
        return queuePoliJantung;
    }
}
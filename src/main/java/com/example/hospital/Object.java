package com.example.hospital;

public class Object {

    private int noantrian;
    private String nama, poli, dokter, tanggal, jenis;

    public Object(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis) {
        this.noantrian = noantrian;
        this.nama = nama;
        this.poli = poli;
        this.dokter = dokter;
        this.tanggal = tanggal;
        this.jenis = jenis;

    }

    public int getNoantrian(){
        return this.noantrian;
    }

    public String getNama(){
        return this.nama;
    }

    public String getPoli(){
        return this.poli;
    }

    public String getDokter(){
        return this.dokter;
    }

    public String getTanggal(){
        return this.tanggal;
    }

    public String getJenis(){
        return this.jenis;
    }
}

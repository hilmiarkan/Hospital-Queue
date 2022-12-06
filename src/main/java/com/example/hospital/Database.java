package com.example.hospital;



public final class Database {

    Queue queue = new Queue(11);
    private final static Database INSTANCE = new Database();

    private Database() {}

    public static Database getInstance() {
        return INSTANCE;
    }

    public void enQueue(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis) {
        this.queue.insert(noantrian, nama, poli, dokter, tanggal, jenis);
    }

    public void deQueue(){
        this.queue.remove();
    }

    public Queue getQueue() {
        return queue;
    }
}
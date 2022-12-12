package com.example.hospital;

public class Queue {
    private int maxSize, front, rear, nItems, antrian;
    private Object[] queArray;

    public Queue(int size) {
        this.maxSize = size;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        antrian = 0;
    }

    public void insert(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = new Object(noantrian, nama, poli, dokter, tanggal, jenis);
        antrian++;
        nItems++;
    }

    public Object remove() {
        Object temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }

    public Object lastAdded() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public Object getnItems() {
        return queArray[front];
    }

    public int getNoAntrian() {
        return antrian + 1;
    }

    public int getAntri() {
        return nItems - 1;
    }

    public Object[] toArray() {
        Object[] array = new Object[nItems];
        for (int i = 0; i < nItems; i++) {
            array[i] = queArray[(front + i) % maxSize];
        }
        return array;
    }
}

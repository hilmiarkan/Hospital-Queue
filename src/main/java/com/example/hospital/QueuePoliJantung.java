package com.example.hospital;

//import static com.sun.beans.introspect.ClassInfo.clear;

class QueuePoliJantung {

    private int maxSize, front, rear, nItems,antrian;
    private ObjectPoliJantung[] queArray;

    public QueuePoliJantung(int size) {
        this.maxSize = size;
        queArray = new ObjectPoliJantung[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        antrian = 0;
    }

    public void insert(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = new ObjectPoliJantung(noantrian, nama, poli, dokter, tanggal, jenis);
        antrian++;
        nItems++;
    }

    public ObjectPoliJantung remove() {
        ObjectPoliJantung temp = queArray[front++]; //10
        if (front == maxSize) {
            front = 0;
        }
        nItems--; //1
        return temp;
    }

//    public void removeSpecific(Antrian antrianToRemove) {
//        Antrian[] array = toArray();
//        clear();
//        for (Antrian antrian : array) {
//            if (!antrian.equals(antrianToRemove)) {
//                insert(antrian);
//            }
//        }
//    }

    public ObjectPoliJantung peekFront() {
        return queArray[front];
    }

    public ObjectPoliJantung lastAdded() {
        return queArray[nItems-1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public ObjectPoliJantung getnItems() {
        return queArray[front];
    }

    public int getNoAntrian() {
        return antrian+1;
    }

    public int getAntri() {
        return nItems;
    }

    public ObjectPoliJantung[] toArray() {
        ObjectPoliJantung[] array = new ObjectPoliJantung[nItems];
        for (int i = 0; i < nItems; i++) {
            array[i] = queArray[(front + i) % maxSize];
        }
        return array;
    }
}
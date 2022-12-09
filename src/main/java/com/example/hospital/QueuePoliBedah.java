package com.example.hospital;

//import static com.sun.beans.introspect.ClassInfo.clear;

class QueuePoliBedah {

    private int maxSize, front, rear, nItems, antrian;
    private ObjectPoliBedah[] queArray;

    public QueuePoliBedah(int size) {
        this.maxSize = size;
        queArray = new ObjectPoliBedah[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        antrian = 0;
    }

    public void insert(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = new ObjectPoliBedah(noantrian, nama, poli, dokter, tanggal, jenis);
        antrian++;
        nItems++;
    }

    public ObjectPoliBedah remove() {
        ObjectPoliBedah temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
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

    public ObjectPoliBedah peekFront() {
        return queArray[front];
    }

    public ObjectPoliBedah lastAdded() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public ObjectPoliBedah getnItems() {
        return queArray[front];
    }

    public int getNoAntrian() {
        return antrian + 1;
    }

    public int getAntri() {
        return nItems-1;
    }

    public ObjectPoliBedah[] toArray() {
        ObjectPoliBedah[] array = new ObjectPoliBedah[nItems];
        for (int i = 0; i < nItems; i++) {
            array[i] = queArray[(front + i) % maxSize];
        }
        return array;
    }
}
package com.example.hospital;

public class HashPoli {
    private ObjectSemuaPoli[] hashArray;
    private int size, num;

    public HashPoli(int size) {
        this.size = size;
        hashArray = new ObjectSemuaPoli[size];
    }

//    public void displayTable() {
//        System.out.println("Table : ");
//        for (int j = 0; j < size; j++) {
//            if (hashArray[j] != null) {
//                System.out.println(" | " + j + "\t | " + hashArray[j].getKey() + " |");
//            } else {
//                System.out.println(" | " + j + "\t | -- |");
//            }
//        }
//        System.out.println();
//    }

    public int hashFunc(int key) {
        return key % size;
    }

//    public void insert(int noantrian, String nama, String poli, String dokter, String tanggal, String jenis) {
//        ObjectSemuaPoli item = new ObjectSemuaPoli(noantrian,nama,poli,dokter,tanggal,jeniss);
//        int key = item.getKey();
//        int hashVal = hashFunc(key);
//        int x = hashFunc(key);
//        num = 0;
//        while (hashArray[hashVal] != null) {
//            num++;
//            hashVal = (x + num * num) % size;
////            ++hashVal;
////            hashVal %= size;
//        }
//        hashArray[hashVal] = item;
//    }

//    public Data delete(int key) {
//        int hashVal = hashFunc(key);
//        int x = hashFunc(key);
//        num = 0;
//        while (hashArray[hashVal] != null) {
//            if (hashArray[hashVal].getKey() == key) {
//                Data temp = hashArray[hashVal];
//                hashArray[hashVal] = null;
//                return temp;
//            }
//            num++;
//            hashVal = (x + num * num) % size;
////            ++hashVal;
////            hashVal %= size;
//        }
//        return null;
//    }
//
//    public ObjectSemuaPoli find(int key) {
//        int hashVal = hashFunc(key);
//        int x = hashFunc(key);
//        num = 0;
//        while (hashArray[hashVal] != null) {
//            if (hashArray[hashVal].getKey() == key) {
//                return hashArray[hashVal];
//            }
//            num++;
//            hashVal = (x + num * num) % size;
////            ++hashVal;
////            hashVal %= size;
//        }
//        return null;
//    }
}

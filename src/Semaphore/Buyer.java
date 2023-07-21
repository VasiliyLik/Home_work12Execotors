package Semaphore;

import Enums.ProductSet;

import java.util.concurrent.Semaphore;

public class Buyer implements Runnable {
    Semaphore sem; //семафор, ограничивающий число покупателей
    int id;        //условный номер покупателя

    public Buyer(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try {
            sem.acquire();    //Запрашиваем у семафора разрешение на выполнение
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Покупатель " + id + " подходит к свободной кассе");

        // покупатель обслуживается
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Покупатель " + id + " обслужен, купил: " + ProductSet.randomSet());
        sem.release();


    }
}


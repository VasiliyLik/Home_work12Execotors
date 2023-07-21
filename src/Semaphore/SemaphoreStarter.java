package Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreStarter {
    public static void doSemaphore() {
        //Задаём количество разрешений на выполнение потока
        // т.е. одновременно будет выполняться указанное количество из всех потоков, в нашем случае - кассы
        Semaphore sem = new Semaphore(2);

        //запускаем 10-х покупателей в магазин, каждому даём номер i
        for (int i = 1; i <= 10; i++) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.submit(new Buyer(sem, i));
            executorService.shutdown();
        }
    }
}


package BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueStarter {
    public static void doBlockingQueue() {
        //Creating BlockingQueue of size 3
        BlockingQueue<Buyer> queue = new ArrayBlockingQueue<>(3);
        //Creating Threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new ProduceBuyers(queue));
        executorService.submit(new CashDeskService(queue));
        executorService.shutdown();
    }
}

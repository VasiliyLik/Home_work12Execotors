package BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class ProduceBuyers implements Runnable {
    private final BlockingQueue<Buyer> queue;

    public ProduceBuyers(BlockingQueue<Buyer> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        //produce buyers
        for (int i = 1; i <= 10; i++) {
            Buyer name = new Buyer("" + i);
            try {
                Thread.sleep(1000);
                queue.put(name);
                System.out.println("Покупатель " + name.getName() + " подошел на кассу");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit name
        Buyer name = new Buyer("END");
        try {
            queue.put(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

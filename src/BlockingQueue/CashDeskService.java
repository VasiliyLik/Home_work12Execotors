package BlockingQueue;

import Enums.ProductSet;

import java.util.concurrent.BlockingQueue;

@SuppressWarnings("BusyWait")
public class CashDeskService implements Runnable {
    private final BlockingQueue<Buyer> queue;

    public CashDeskService(BlockingQueue<Buyer> q){
        this.queue=q;
    }

    @Override
    public void run() {
        try{
            Buyer name;
            // ожидание сообщения об окончании очереди (consuming messages until exit message is received)
            while(!(name = queue.take()).getName().equals("END")){
                Thread.sleep(2000);
                System.out.println("Покупатель " + name.getName() + " обслужен, купил: " + ProductSet.randomSet());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}

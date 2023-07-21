package ReentrantLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReentrantLockStarter {
    public static void doReentrantLock() {

        Store store = new Store(3); // количество касс, указано 3, при этом в массиве начинается с 1 -го

        List<Buyer> buyers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) { // количество покупателей, начинается с 1, чтобы номера касс начинались с 1
            buyers.add(new Buyer("Buyer " + i, store));
        }

        // стартуем работу наших независимых покупателей
        for (Buyer buyer1 : buyers) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            executorService.submit(new Buyer(buyer1.name, store));
            executorService.shutdown();
        }
    }
}

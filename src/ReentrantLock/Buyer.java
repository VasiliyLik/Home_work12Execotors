package ReentrantLock;


import Enums.ProductSet;

//класс Buyer - заранее не знает, в какую из касс он пойдет, поэтому становиться в кассу он будет через класс Store
class Buyer extends Thread {
    public final String name;
    private final Store store;

    Buyer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " ищет кассу");
            Thread.sleep((long) (Math.random() * 2000) + 500);
            //    System.out.println("поиск товара завершился: " + name);//    System.out.println("Готовимся обслужить: " + name);

            Store.CashDesk cashDesks;
            do {
                cashDesks = store.tryLockCashDesk();
                Thread.sleep(2000);
            } while (cashDesks == null);
            // now we get cashDesks. let`s take off!!!

            try {
                System.out.println("Обслуживается: " + name + " в кассе " + cashDesks.name);
                Thread.sleep((long) (Math.random() * 2000) + 500);
                System.out.println("Обслужен: " + name + ", купил: " + ProductSet.randomSet());

            } finally {
                store.unlockCashDesk(cashDesks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

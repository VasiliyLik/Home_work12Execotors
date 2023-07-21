package ReentrantLock;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Для управления разделяемыми ресурсами создадим контейнер (класс Store), который выдаст "наружу" только необходимый минимум,
// позволяющий занять кассу и освободить её
class Store {
    private final List<CashDesk> cashDesks = new ArrayList<>(); // все кассы магазина

    Store(int cashDeskCount) { // создаем в конструкторе и распоряжаемся сами
        for (int i = 1; i < cashDeskCount; i++) {
            cashDesks.add(new CashDesk("cashDesk " + i));
        }
    }

    //два основных метода tryLockCashDesk и unlockCashDesk отвечают за получение (первой из свободных) и высвобождение кассы
    @Nullable
    public Store.CashDesk tryLockCashDesk() {
        CashDesk result = null;
        for (CashDesk cd : cashDesks) {
            if (cd.tryLock()) {
                result = cd;
                break;
            }
        }
        if (result != null) System.out.println("Касса " + result.name + " занята");
        return result;
    }

    public void unlockCashDesk(@NotNull Store.CashDesk cashDesk) {
        cashDesk.unlock();
        System.out.println("Касса " + cashDesk.name + " свободна");
    }

    static class CashDesk {
        public final String name;
        private final Lock lock = new ReentrantLock(); // касса "сама" следит за возможностью её занять.

        CashDesk(String name) {
            this.name = name;
        }

        private boolean tryLock() {
            return lock.tryLock();
        }

        private void unlock() {
            lock.unlock();
        }
    }
}

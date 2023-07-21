import ReentrantLock.ReentrantLockStarter;
import Semaphore.SemaphoreStarter;
import BlockingQueue.BlockingQueueStarter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Выбери вариант реализации программы: 1 - ReentrantLock; 2 - Semaphore; 3 - BlockingQueue");
        Scanner scanner = new Scanner(System.in);
        int choice;
        choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Запуск программы с использованием ReentrantLock");
            Thread.sleep(2000);
            ReentrantLockStarter.doReentrantLock();
        }
        if (choice == 2) {
            System.out.println("Запуск программы с использованием Semaphore");
            Thread.sleep(2000);
            SemaphoreStarter.doSemaphore();
        }
        if (choice == 3) {
            System.out.println("Запуск программы с использованием BlockingQueue");
            Thread.sleep(2000);
            BlockingQueueStarter.doBlockingQueue();
        }
    }
}

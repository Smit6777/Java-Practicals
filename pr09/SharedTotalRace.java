import java.util.concurrent.atomic.AtomicLong;

class SharedTotal {
    long total = 0;

    void add(long value) {
        total += value;
    }

    synchronized void synchronizedAdd(long value) {
        total += value;
    }
}

public class SharedTotalRace {
    public static void main(String[] args) throws InterruptedException {
        int size = 100000;
        int threads = 4;
        int[] numbers = new int[size];

        long expected = 0;

        for (int i = 0; i < size; i++) {
            numbers[i] = i + 1;
            expected += numbers[i];
        }

        SharedTotal wrong = new SharedTotal();
        Thread[] t = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            final int start = i * size / threads;
            final int end = (i + 1) * size / threads;

            t[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    wrong.add(numbers[j]);
                }
            });

            t[i].start();
        }

        for (Thread thread : t) {
            thread.join();
        }

        System.out.println("Wrong result: " + wrong.total);
        System.out.println("Expected result: " + expected);

        SharedTotal fixed = new SharedTotal();

        long startTime = System.nanoTime();

        for (int i = 0; i < threads; i++) {
            final int start = i * size / threads;
            final int end = (i + 1) * size / threads;

            t[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    fixed.synchronizedAdd(numbers[j]);
                }
            });

            t[i].start();
        }

        for (Thread thread : t) {
            thread.join();
        }

        long syncTime = System.nanoTime() - startTime;

        AtomicLong atomicTotal = new AtomicLong();

        startTime = System.nanoTime();

        for (int i = 0; i < threads; i++) {
            final int start = i * size / threads;
            final int end = (i + 1) * size / threads;

            t[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    atomicTotal.addAndGet(numbers[j]);
                }
            });

            t[i].start();
        }

        for (Thread thread : t) {
            thread.join();
        }

        long atomicTime = System.nanoTime() - startTime;

        System.out.println("Synchronized result: " + fixed.total);
        System.out.println("AtomicLong result: " + atomicTotal.get());
        System.out.println("Synchronized time: " + syncTime + " ns");
        System.out.println("AtomicLong time: " + atomicTime + " ns");
    }
}
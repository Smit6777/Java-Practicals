class Counter {
    int count = 0;

    void increment() {
        int temp = count;
        Thread.yield();
        count = temp + 1;
    }

    synchronized void synchronizedIncrement() {
        count++;
    }
}

public class CounterRace {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        int threads = 10;
        int increments = 10000;

        Thread[] t = new Thread[threads];

        for (int i = 0; i < threads; i++) {
            t[i] = new Thread(() -> {
                for (int j = 0; j < increments; j++) {
                    counter.increment();
                }
            });
            t[i].start();
        }

        for (Thread thread : t) {
            thread.join();
        }

        System.out.println("Without synchronization: " + counter.count);
        System.out.println("Expected: " + (threads * increments));

        counter.count = 0;

        for (int i = 0; i < threads; i++) {
            t[i] = new Thread(() -> {
                for (int j = 0; j < increments; j++) {
                    counter.synchronizedIncrement();
                }
            });
            t[i].start();
        }

        for (Thread thread : t) {
            thread.join();
        }

        System.out.println("With synchronization: " + counter.count);
    }
}
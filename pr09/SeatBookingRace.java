class Cinema {
    private int seatsLeft = 5;

    void bookWithoutSync(String name) {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            seatsLeft--;
            System.out.println(name + " booked a seat.");
        } else {
            System.out.println(name + " failed.");
        }
    }

    synchronized void book(String name) {
        if (seatsLeft > 0) {
            seatsLeft--;
            System.out.println(name + " booked a seat.");
        } else {
            System.out.println(name + " failed.");
        }
    }

    int getSeatsLeft() {
        return seatsLeft;
    }
}

public class SeatBookingRace {
    public static void main(String[] args) throws InterruptedException {

        Cinema cinema1 = new Cinema();
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int id = i + 1;

            threads[i] = new Thread(() -> {
                cinema1.bookWithoutSync("User " + id);
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Seats left without synchronization: "
                + cinema1.getSeatsLeft());

        System.out.println();

        Cinema cinema2 = new Cinema();

        for (int i = 0; i < 10; i++) {
            final int id = i + 1;

            threads[i] = new Thread(() -> {
                cinema2.book("User " + id);
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Seats left with synchronization: "
                + cinema2.getSeatsLeft());
    }
}
 public class CinemaShow {

    private String title;
    private int seatsAvailable;
    private final int capacity;

    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        seatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable = seatsAvailable - n;
            totalBooked = totalBooked + n;
            return true;
        }
        return false;
    }

    void cancel(int n) {
        seatsAvailable = seatsAvailable + n;

        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }

    public static void main(String[] args) {

        CinemaShow c1 = new CinemaShow("Movie", 50);

        System.out.println(c1.book(20));
        System.out.println("Seats = " + c1.getSeatsAvailable());

        System.out.println(c1.book(40));
        System.out.println("Seats = " + c1.getSeatsAvailable());

        c1.cancel(10);
        System.out.println("Seats = " + c1.getSeatsAvailable());

        System.out.println("Total Booked = " + CinemaShow.getTotalBooked());
    }
}
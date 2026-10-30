abstract class Media {
    private String title;
    private int daysLate;

    public Media(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysLate() {
        return daysLate;
    }

    abstract double computeLateFee();
}

class Book extends Media {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double computeLateFee() {
        // 2 rupees per day
        return getDaysLate() * 2.0;
    }
}

class DVD extends Media {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double computeLateFee() {
        // 5 rupees per day
        return getDaysLate() * 5.0;
    }
}

class Magazine extends Media {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    double computeLateFee() {
        // Flat fee of 10 if late, plus 1 rupee per day
        return getDaysLate() > 0 ? (10.0 + getDaysLate() * 1.0) : 0.0;
    }
}

public class LateFeeDemo {
    public static void main(String[] args) {
        Media[] returnedBatch = {
            new Book("Clean Code", 4),
            new DVD("Inception", 2),
            new Magazine("Tech Today", 3),
            new Book("Effective Java", 0)
        };

        double totalFees = 0;
        System.out.println("--- Library Late Fee Assessment ---");
        for (Media m : returnedBatch) {
            double fee = m.computeLateFee();
            totalFees += fee;
            System.out.printf("%s (%s): %d day(s) late -> Fee: Rs. %.2f%n",
                    m.getClass().getSimpleName(), m.getTitle(), m.getDaysLate(), fee);
        }

        System.out.printf("%nTotal Late Fees Collected: Rs. %.2f%n", totalFees);
    }
}

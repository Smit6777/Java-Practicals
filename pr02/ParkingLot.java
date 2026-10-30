 public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    void park(String type) {

        if (type.equals("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
            } else {
                System.out.println("Full");
            }

        } else if (type.equals("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
            } else {
                System.out.println("Full");
            }
        }
    }

    void leave(String type) {

        if (type.equals("two") && twoWheelers > 0) {
            twoWheelers--;
        }

        if (type.equals("four") && fourWheelers > 0) {
            fourWheelers--;
        }
    }

    public static void main(String[] args) {

        ParkingLot p = new ParkingLot(2, 1);

        p.park("two");
        p.park("two");
        p.park("two");

        p.park("four");
        p.park("four");

        p.leave("two");

        System.out.println("Two Wheelers = " + p.twoWheelers);
        System.out.println("Four Wheelers = " + p.fourWheelers);
        System.out.println("Revenue = " + revenue);
    }
}
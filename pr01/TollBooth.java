import java.util.Scanner;

public class TollBooth {
    record Vehicle(String number, String type) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {
            System.out.print("Enter vehicle number (or 'done' to finish): ");
            String number = scanner.next();
            if (number.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike, car, truck): ");
            String type = scanner.next().toLowerCase();

            Vehicle vehicle = new Vehicle(number, type);

            int toll = switch (vehicle.type()) {
                case "bike" -> {
                    bikeCount++;
                    yield 20;
                }
                case "car" -> {
                    carCount++;
                    yield 50;
                }
                case "truck" -> {
                    truckCount++;
                    yield 150;
                }
                default -> {
                    System.out.println("Unknown vehicle type! No toll added.");
                    yield 0;
                }
            };

            totalToll += toll;
        }

        System.out.println("\nTotal toll: " + totalToll);

        String mostFrequent = "None";
        int maxCount = 0;

        if (bikeCount > maxCount) { maxCount = bikeCount; mostFrequent = "bike"; }
        if (carCount > maxCount) { maxCount = carCount; mostFrequent = "car"; }
        if (truckCount > maxCount) { maxCount = truckCount; mostFrequent = "truck"; }

        System.out.println("Most frequent: " + mostFrequent);
        scanner.close();
    }
}
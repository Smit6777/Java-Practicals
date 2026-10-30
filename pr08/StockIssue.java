import java.util.*;

class OutOfStockException extends Exception {

    int shortfall;

    OutOfStockException(String message, int shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {

    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {

    HashMap<String, Integer> stock = new HashMap<>();

    Warehouse() {
        stock.put("Laptop", 5);
        stock.put("Mouse", 10);
        stock.put("Keyboard", 3);
    }

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than 0");
        }

        if (!stock.containsKey(item)) {
            throw new OutOfStockException(
                    "Item not available", qty);
        }

        int available = stock.get(item);

        if (qty > available) {

            int shortfall = qty - available;

            throw new OutOfStockException(
                    "Not enough stock", shortfall);
        }

        stock.put(item, available - qty);

        System.out.println(
                qty + " " + item + " issued successfully.");
    }
}

public class StockIssue {

    public static void main(String[] args) {

        Warehouse w = new Warehouse();

        String[] items = {
                "Laptop",
                "Mouse",
                "Keyboard",
                "Laptop"
        };

        int[] quantities = {
                2,
                15,
                0,
                10
        };

        for (int i = 0; i < items.length; i++) {

            try {

                System.out.println(
                        "\nRequest: " + items[i] +
                                " - " + quantities[i]);

                w.issue(items[i], quantities[i]);

            } catch (OutOfStockException e) {

                System.out.println(
                        "Out of stock. Shortfall = "
                                + e.getShortfall());
            } catch (InvalidQuantityException e) {

                System.out.println(
                        "Invalid quantity: "
                                + e.getMessage());
            }
        }

        System.out.println("\nAll requests processed.");
    }
}
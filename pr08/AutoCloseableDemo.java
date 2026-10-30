class MyResource implements AutoCloseable {

    void useResource() {
        System.out.println("Resource is being used.");
    }

    public void close() {
        System.out.println("Resource is closed.");
    }
}

public class AutoCloseableDemo {

    public static void main(String[] args) {

        try (MyResource r = new MyResource()) {

            r.useResource();

            System.out.println("An error is coming...");
            throw new Exception("Original error occurred");

        } catch (Exception e) {

            System.out.println(
                    "Error: " + e.getMessage());
        }
    }
}
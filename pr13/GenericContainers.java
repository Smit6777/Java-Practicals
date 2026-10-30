class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class GenericContainers {

    public static <T> T firstElement(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {
        Box<String> name = new Box<>();
        name.set("Smit");

        Box<Integer> number = new Box<>();
        number.set(25);

        Pair<String, Integer> student = new Pair<>("Smit", 52);

        String[] names = { "Smit", "dev", "mahek" };
        Integer[] numbers = { 10, 20, 30 };

        System.out.println("Name: " + name.get());
        System.out.println("Number: " + number.get());
        System.out.println("Student Name: " + student.getFirst());
        System.out.println("Student ID: " + student.getSecond());
        System.out.println("First Name: " + firstElement(names));
        System.out.println("First Number: " + firstElement(numbers));
    }
}
class GenericStack<T> {
    private Object[] items;
    private int top;

    public GenericStack(int size) {
        items = new Object[size];
        top = -1;
    }

    public void push(T value) {
        if (top == items.length - 1) {
            System.out.println("Stack is full");
            return;
        }

        items[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }

        T value = (T) items[top];
        items[top] = null;
        top--;

        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class GenericStackDemo {
    public static void main(String[] args) {
        GenericStack<String> names = new GenericStack<>(5);
        names.push("Smit");
        names.push("divy");

        System.out.println("Removed Name: " + names.pop());

        GenericStack<Integer> numbers = new GenericStack<>(5);
        numbers.push(10);
        numbers.push(20);

        System.out.println("Removed Number: " + numbers.pop());
        System.out.println("Removed Number: " + numbers.pop());
        System.out.println("Removed Number: " + numbers.pop());
    }
}
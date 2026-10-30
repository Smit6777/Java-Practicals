import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}

class MyTests {
    @Run
    public void testAddition() {
        System.out.println("Addition test passed");
    }

    @Run
    public void testSubtraction() {
        System.out.println("Subtraction test passed");
    }

    public void normalMethod() {
        System.out.println("This should not run");
    }

    @Run
    public void testMultiplication() {
        System.out.println("Multiplication test passed");
    }
}

public class MiniTestRunner {
    public static void main(String[] args) throws Exception {
        MyTests tests = new MyTests();
        int count = 0;

        for (Method method : tests.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(Run.class)) {
                method.invoke(tests);
                count++;
            }
        }
        System.out.println("Total tests run: " + count);
    }
}

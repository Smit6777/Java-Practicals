
interface Switchable {
    void on();

    void off();

    default void toggle() {
        System.out.println("default method ....");
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan ON");
    }

    public void off() {
        System.out.println("Fan OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light ON");
    }

    public void off() {
        System.out.println("Light OFF");
    }
}

@FunctionalInterface
interface Permission {
    boolean allow(Switchable device, int hour);
}

public class RemoteControlDemo {
    public static void main(String[] args) {
        Switchable[] devices = { new Fan(), new Light() };

        for (Switchable s : devices) {
            s.toggle();
            s.on();
            s.off();
        }

        Permission p1 = new Permission() {
            public boolean allow(Switchable d, int hour) {
                return hour >= 6 && hour <= 22; // allow daytime
            }
        };

        Permission p2 = (d, hour) -> hour % 2 == 0;

        System.out.println("Anonymous class check: " + p1.allow(new Fan(), 10));
        System.out.println("Lambda check: " + p2.allow(new Light(), 11));
    }
}

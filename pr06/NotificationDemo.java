@FunctionalInterface
interface Notifier {
    void send(String msg);
}

// Marker interface
interface Urgent {
}

// Concrete class implementing both Notifier and Urgent
class UrgentSmsNotifier implements Notifier, Urgent {
    @Override
    public void send(String msg) {
        System.out.println("URGENT SMS: " + msg);
    }
}

public class NotificationDemo {
    public static void main(String[] args) {
        Notifier email = (msg) -> System.out.println("Email: " + msg);
        Notifier sms = (msg) -> System.out.println("SMS: " + msg);
        Notifier urgentSms = new UrgentSmsNotifier();

        Notifier[] senders = { email, sms, urgentSms };

        for (Notifier n : senders) {
            n.send("Meeting scheduled at 4 PM");
            if (n instanceof Urgent) {
                // Send twice for senders marked urgent
                n.send("[REPEAT PRIORITY] Meeting scheduled at 4 PM");
            }
            System.out.println("---");
        }
    }
}

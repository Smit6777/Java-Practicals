import java.util.Scanner;

public class ChatFilter {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice Hello there",
            "10:06 bob Hi Alice, how are you?",
            "bad_line_without_enough_parts",
            "10:08 charlie hello everyone! Good morning.",
            "10:10 alice bye"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword to search: ");
        String keyword = "hello"; // default keyword if running non-interactively
        if (sc.hasNextLine()) {
            String entered = sc.nextLine().trim();
            if (!entered.isEmpty()) {
                keyword = entered;
            }
        }
        System.out.println("Searching for: \"" + keyword + "\"");

        String lowerKeyword = keyword.toLowerCase();
        int matches = 0;
        StringBuilder report = new StringBuilder();

        for (String line : logs) {
            String[] parts = line.split(" ", 3);
            if (parts.length < 3) {
                // skip malformed line
                continue;
            }

            String time = parts[0];
            String user = parts[1];
            String message = parts[2];

            if (message.toLowerCase().contains(lowerKeyword)) {
                matches++;
                report.append(time).append(" ").append(user).append(": ").append(message).append("\n");
            }
        }

        System.out.println("Matches: " + matches);
        System.out.println("Report:\n" + report);
        sc.close();
    }
}

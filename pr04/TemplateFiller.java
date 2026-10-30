import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFiller {
    public static void main(String[] args) {
        String template = "Dear {name}, order {id} ships {date}.";
        String[] names = { "name", "id" };
        String[] values = { "Riya", "A07" };

        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(template);

        StringBuilder filled = new StringBuilder();
        while (matcher.find()) {
            String placeholder = matcher.group(1);
            String replacement = "[?]";

            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(placeholder)) {
                    replacement = values[i];
                    break;
                }
            }
            matcher.appendReplacement(filled, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(filled);

        System.out.println("Template: " + template);
        System.out.println("Filled:   " + filled.toString());
    }
}

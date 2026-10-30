public class PasswordChecker {

    public static String strength(String pw) {
        if (pw == null) return "Weak";

        boolean ruleLength = pw.length() >= 8;
        boolean ruleUpper = pw.matches(".*[A-Z].*");
        boolean ruleDigit = pw.matches(".*[0-9].*");
        boolean ruleSpecial = pw.matches(".*[^a-zA-Z0-9].*");

        int passed = 0;
        if (ruleLength) passed++;
        if (ruleUpper) passed++;
        if (ruleDigit) passed++;
        if (ruleSpecial) passed++;

        System.out.println("Checking: \"" + pw + "\"");
        System.out.println(" - Length >= 8: " + ruleLength);
        System.out.println(" - Uppercase:   " + ruleUpper);
        System.out.println(" - Digit:       " + ruleDigit);
        System.out.println(" - Special:     " + ruleSpecial);
        System.out.println(" - Rules passed: " + passed + "/4");

        if (passed <= 1) {
            return "Weak";
        } else if (passed <= 3) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        String[] testPasswords = {
            "abc",
            "password",
            "Pass1234",
            "Abcd1234!"
        };

        for (String pw : testPasswords) {
            String result = strength(pw);
            System.out.println("Result: " + result);
            System.out.println("-----------------------------------");
        }
    }
}

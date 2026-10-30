import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    @MaxLength(20)
    String username;

    @NotBlank
    @MaxLength(30)
    String email;

    @NotBlank
    @MaxLength(15)
    String password;

    SignupForm(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

class Validator {
    static List<String> validate(Object obj)
            throws IllegalAccessException {
        List<String> errors = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object fieldValue = field.get(obj);
            String value = fieldValue == null
                    ? null
                    : fieldValue.toString();

            if (field.isAnnotationPresent(NotBlank.class)) {
                if (value == null || value.trim().isEmpty()) {
                    errors.add(field.getName() + " must not be blank");
                }
            }

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength max = field.getAnnotation(MaxLength.class);
                if (value != null && value.length() > max.value()) {
                    errors.add(field.getName() + " must not exceed "
                            + max.value() + " characters");
                }
            }
        }
        return errors;
    }
}

public class FormValidator {
    public static void main(String[] args)
            throws IllegalAccessException {
        SignupForm form = new SignupForm(
                "", "student@example.com",
                "thispasswordiswaytoolong");

        List<String> errors = Validator.validate(form);
        if (errors.isEmpty()) {
            System.out.println("Form is valid.");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
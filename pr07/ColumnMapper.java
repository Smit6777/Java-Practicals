import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {
    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "email")
    String email;

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Email: " + email;
    }
}

public class ColumnMapper {
    static Student mapRow(String[] headers, String[] data)
            throws Exception {
        if (headers.length != data.length) {
            throw new IllegalArgumentException(
                    "Header and data lengths do not match");
        }

        Student student = new Student();

        for (Field field : Student.class.getDeclaredFields()) {
            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }

            Column column = field.getAnnotation(Column.class);
            String columnName = column.name();
            int index = -1;

            for (int i = 0; i < headers.length; i++) {
                if (headers[i].trim().equals(columnName)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                throw new IllegalArgumentException(
                        "Missing column: " + columnName);
            }

            field.setAccessible(true);
            String value = data[index].trim();

            if (field.getType() == String.class) {
                field.set(student, value);
            } else if (field.getType() == int.class) {
                field.setInt(student, Integer.parseInt(value));
            }
        }
        return student;
    }

    public static void main(String[] args) throws Exception {
        String[] headers = { "email", "name", "age" };
        String[] data = { "smitmakwana6777@gmail.com", "Smit", "19" };

        Student student = mapRow(headers, data);
        System.out.println(student);
    }
}

import java.io.*;

public class SaveLoad {
    static class Student implements Serializable {
        int id;
        String name;
        transient String password;

        Student(int id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        void display() {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Password: " + password);
        }
    }

    public static void main(String[] args) throws Exception {
        Student[] students = {
                new Student(1, "Smit", "abc123"),
                new Student(2, "Rahul", "xyz456")
        };

        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("students.dat"));

        out.writeObject(students);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("students.dat"));

        Student[] loaded = (Student[]) in.readObject();
        in.close();

        for (Student s : loaded) {
            s.display();
            System.out.println();
        }
    }
}
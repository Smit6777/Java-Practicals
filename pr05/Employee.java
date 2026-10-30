public abstract class Employee {
    String name;
    int id;

    Employee(String n, int i) {
        name = n;
        id = i;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double fixed;

    FullTime(String n, int i, double f) {
        super(n, i);
        fixed = f;
    }

    double monthlySalary() {
        return fixed;
    }
}

class PartTime extends Employee {
    int hours;
    double rate;

    PartTime(String n, int i, int h, double r) {
        super(n, i);
        hours = h;
        rate = r;
    }

    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(String n, int i, double s) {
        super(n, i);
        stipend = s;
    }

    double monthlySalary() {
        return stipend;
    }
}

class PayrollTest {
    public static void main(String[] args) {
        Employee[] staff = {
                new FullTime("Alice", 101, 40000),
                new PartTime("Bob", 102, 80, 200),
                new Intern("Charlie", 103, 5000)
        };

        double total = 0;

        for (Employee e : staff) {
            double sal = e.monthlySalary();
            System.out.print(e.name + " Salary = " + sal);
            if (e instanceof Intern) {
                System.out.print(" [Intern]");
            }
            System.out.println();
            total += sal;
        }

        System.out.println("Total Salary = " + total);
    }
}

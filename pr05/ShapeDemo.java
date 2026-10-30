abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle(r=" + radius + ", area=" + String.format("%.2f", area()) + ")";
    }
}

class Rectangle extends Shape {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double area() {
        return length * breadth;
    }

    @Override
    public String toString() {
        return "Rectangle(l=" + length + ", b=" + breadth + ", area=" + String.format("%.2f", area()) + ")";
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle(b=" + base + ", h=" + height + ", area=" + String.format("%.2f", area()) + ")";
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 8),
            new Circle(3),
            new Rectangle(2, 5)
        };

        double totalArea = 0;
        Shape largestShape = shapes[0];

        System.out.println("--- Calculating Shape Areas Polymorphically ---");
        for (Shape s : shapes) {
            double a = s.area();
            totalArea += a;
            System.out.println(s + " -> Area: " + String.format("%.2f", a) + " | Running Total: " + String.format("%.2f", totalArea));

            if (a > largestShape.area()) {
                largestShape = s;
            }
        }

        System.out.println("\nTotal Area of all shapes: " + String.format("%.2f", totalArea));
        System.out.println("Largest Shape: " + largestShape + " with area " + String.format("%.2f", largestShape.area()));
    }
}

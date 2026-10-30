import java.util.Objects;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class DistinctPoints {
    public static void main(String[] args) {
        Point[] points = {
            new Point(1, 2),
            new Point(3, 4),
            new Point(1, 2),
            new Point(5, 6),
            new Point(3, 4)
        };

        int distinctCount = 0;
        for (int i = 0; i < points.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (points[i].equals(points[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                distinctCount++;
            }
        }

        System.out.println("Points:");
        for (Point p : points) {
            System.out.println(p);
        }
        System.out.println("Distinct: " + distinctCount);
    }
}

import java.util.Objects;

class Fraction {
    private int num;
    private int den;

    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public Fraction(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        int g = gcd(num, den);
        if (den < 0) {
            g = -g;
        }
        this.num = num / g;
        this.den = den / g;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction other = (Fraction) obj;
        return this.num == other.num && this.den == other.den;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }
}

public class FractionDemo {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 6);
        Fraction f4 = new Fraction(3, 4);

        System.out.println("f1 (1/2): " + f1);
        System.out.println("f2 (2/4): " + f2);
        System.out.println("f3 (3/6): " + f3);
        System.out.println("f4 (3/4): " + f4);

        System.out.println("f1 equals f2? " + f1.equals(f2));
        System.out.println("f1 equals f3? " + f1.equals(f3));
        System.out.println("f1 equals f4? " + f1.equals(f4));
    }
}

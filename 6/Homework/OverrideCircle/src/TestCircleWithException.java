import java.util.Scanner;

public class TestCircleWithException {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int radius = in.nextInt();
        try {
            CircleWithException circle = new CircleWithException(radius);

            System.out.printf("The area of the circle is:%.2f", circle.findArea());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class CircleWithException {
    private double radius;

    public CircleWithException(double newRadius) {
        setRadius(newRadius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) throws IllegalArgumentException {
        if (newRadius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        } else {
            radius = newRadius;
        }
    }

    public double findArea() {
        return radius * radius * 3.14159;
    }
}
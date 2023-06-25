public class DifferentShapeCalcArea {

    public static void main(String[] args) {
        displayObject(new Triangle(3, 4, 5));
        displayObject(new Rectangle(5, 9));
        displayObject(new Circle(7));
    }

    //displayObject方法
    public static void displayObject(Shape obj) {
        if (obj instanceof Triangle) {
            System.out.println(obj.area());
        } else if (obj instanceof Rectangle) {
            System.out.println(obj.perimeter());
        } else if (obj instanceof Circle) {
            System.out.println(obj.area());
            System.out.println(obj.perimeter());
        }
    }
}

abstract class Shape {
    public abstract double area();

    public abstract double perimeter();
}

class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

class Circle extends Shape {
    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return Math.PI * r * r;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * r;
    }
}
public class ShapeTriangleTest {

    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub
        Triangle t = new Triangle(3, 4, 5);
        System.out.println(t.area());
        System.out.println(t.perimeter());
    }
}

abstract class Shape {
    private String name;

    public Shape() {

    }

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double perimeter();
    public abstract double area();
}

class Triangle extends Shape {
    double a, b, c;

    public Triangle() {
        super();
        //  TODO  Auto-generated  constructor  stub
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public Triangle(String name) {
        super(name);
        //  TODO  Auto-generated  constructor  stub
    }

    public Triangle(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = perimeter() * 0.5;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
     public double perimeter() {
        return a + b + c;
     }
}

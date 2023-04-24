public class ShapeTest {

    public static void main(String[] args) {

        Rectangle r = new Rectangle();
        System.out.println(r.area() + "," + r.perimeter());
        Circle c = new Circle();
        System.out.println(c.area() + "," + c.perimeter());

        Shapes s = r;
        s = c;

        r = new Rectangle(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        System.out.println(r.area() + "," + r.perimeter());

        c = new Circle(Double.parseDouble(args[2]));
        System.out.println(c.area() + "," + c.perimeter());

    }

}

class Shapes {
    double area() {
        return 0;
    }

    double perimeter() {
        return 0;
    }
}

class Rectangle extends Shapes {
    double length = 1;
    double width = 1;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {

    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

class Circle extends Shapes {
    double radius = 1;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {

    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}
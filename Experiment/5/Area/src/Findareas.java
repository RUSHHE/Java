public class Findareas {
    public static void main(String[] agrs) {
        Figure f = new Figure(Double.parseDouble(agrs[0]), Double.parseDouble(agrs[1]));
        Rectangle r = new Rectangle(Double.parseDouble(agrs[2]), Double.parseDouble(agrs[3]));
        Figure figref;
        figref = f;
        System.out.println("Area is :" + figref.area());
        figref = r;
        System.out.println("Area is :" + figref.area());
    }
}

class Figure {
    private final double width;
    private final double height;

    public Figure(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        System.out.println("Inside area for figure.");
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}

class Rectangle extends Figure {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public double area() {
        System.out.println("Inside area for rectangle.");
        return getWidth() * getHeight();
    }
}
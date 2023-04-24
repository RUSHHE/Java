import java.util.Scanner;
//interface  IA
interface IA {
    double Pi = 3.14;//题干错了，不是PI是Pi

    double area();
}

//interface  IB
interface IB {
    void setColor(String c);
}

//interface  IC
interface IC extends IA,IB {
    double volume();//题干是void，题目错了
}

class Cylinder implements IC {
    private double radius;
    private double height;
    private String color;

    public Cylinder(double radius, double height, String color) {
        this.radius = radius;
        this.height = height;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double area() {
        return Pi * radius * radius;
    }

    @Override
    public double volume() {
        return (Pi * radius * radius * height);
    }

    @Override
    public String toString() {
        return "radius:" + radius + ",height:" + height + ",color:" + color;
    }
}

public class Test4 {
    public static void main(String[] args) {
        int h, r;
        String color;
        Scanner sc = new Scanner(System.in);

        color = sc.nextLine();

        r = sc.nextInt();
        h = sc.nextInt();

        Cylinder cy1 = new Cylinder(r, h, color);
        System.out.println(cy1.area());

        System.out.println(cy1.volume());

        System.out.println(cy1.toString());

        IB ib = cy1;
        ib.setColor("red");
        IA ia = cy1;
        System.out.println(ia.area());
        IC ic = cy1;
        System.out.println(ic.volume());

        System.out.println(cy1.toString());

    }
}
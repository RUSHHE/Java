import java.util.Scanner;

/*
 *  interface  Geometry
 */
interface Geometry {
    double getArea();
}

//Math.PI
public class Test {
    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub

        int w, h, ph, r;
        Scanner sc = new Scanner(System.in);

        w = sc.nextInt();
        h = sc.nextInt();
        ph = sc.nextInt();
        r = sc.nextInt();

        Pillar pillar;
        Geometry bottom;


        bottom = new Rect(w, h);  //接口实现方法
        pillar = new Pillar(bottom, ph);
        System.out.println("Rect  bottom  Pillar  volume:" + pillar.Volume());

        bottom = new Circle(r);
        pillar = new Pillar(bottom, ph);
        System.out.println("Circle  bottom  Pillar  volume:" + pillar.Volume());
    }

}

/*
 *  class  Pillar
 */
class Pillar {
    Geometry bottom;
    double height;

    public Pillar(Geometry bottom, double height) {
        this.bottom = bottom;
        this.height = height;
    }

    public double Volume() {
        return bottom.getArea() * this.height;
    }
}

/*
 *  class  Circle
 */
class Circle implements Geometry {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

/*
 *  class  Rect
 */
class Rect implements Geometry {
    double wide;
    double height;

    public Rect(double wide, double height) {
        this.wide = wide;
        this.height = height;
    }

    public double getArea() {
        return wide * height;
    }
}
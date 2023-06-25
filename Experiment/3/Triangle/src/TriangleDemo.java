import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class TriangleDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner input = new Scanner(System.in, "UTF-8");
        PrintStream out = new PrintStream(System.out, false, "UTF-8");
        out.println("请输入三角形的三个顶点坐标：");
        double[] coord = new double[6];
        for (int i = 0; i < coord.length; i++) {
            if (i % 2 == 0) {
                out.print("第" + i / 2 + "个顶点的横坐标是：");
            } else {
                out.print("第" + (i - 1) / 2 + "个顶点的纵坐标是：");
            }
            coord[i] = input.nextDouble();
        }
        Point p1 = new Point(coord[0], coord[1]);
        Point p2 = new Point(coord[2], coord[3]);
        Point p3 = new Point(coord[4], coord[5]);
        Triangle t = new Triangle(p1, p2, p3);
        if (t.isTriangle()) {
            out.println("三角形的周长是：" + t.perimeter());
            out.println("三角形的面积是：" + t.area());
        } else
            out.println("这三个点无法组成三角形。");
    }
}

class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
}

class Triangle {
    private final Point p1;
    private final Point p2;
    private final Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        super();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public boolean isTriangle() {
        double side1;
        double side2;
        double side3;
        side1 = p1.distance(p2);
        side2 = p1.distance(p3);
        side3 = p2.distance(p3);
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }

    /**
     * 三角形的周长
     *
     * @return 如果不能组成三角形则返回-1
     * 如果可以组成三角形则返回三角形周长
     */
    public double perimeter() {
        if (isTriangle()) {
            return p1.distance(p2) + p1.distance(p3) + p2.distance(p3);
        }
        return -1;
    }

    /**
     * 三角形的面积
     *
     * @return 如果不能组成三角形，则返回-1；
     * 如果可以组成三角形，则用海伦公式计算三角形的面积
     */
    public double area() {
        //不用秦九韶不爱国(doge
        if (isTriangle()) {
            double p = perimeter() / 2;
            return Math.sqrt(p * (p - p1.distance(p2)) * (p - p1.distance(p3)) * (p - p2.distance(p3)));
        }
        return -1;
    }
}
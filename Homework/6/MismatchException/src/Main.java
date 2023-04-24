import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Circle aShape = new Circle();

        try {
            System.out.print("Input a radius:");
            aShape.setRadius(scan.nextDouble());
            System.out.printf("area=%.2f", aShape.getArea());
        } catch (Exception e) {
            System.out.println(e + "\nNumber Format Error.");//输出错误信息
        }
    }
}

class Shape {
    double area;

    public double getArea() {
        return area;
    }
}

class Circle extends Shape {
    double radius;

    public void setRadius(double radius) {
        this.radius = radius;
        area = Math.PI * Math.pow(radius, 2);
    }
}
import java.util.Scanner;

public class Main {
    public static void printAreas(SimpleCircle myCircle,int n) {
        for (int i = 1; i <= n; i++) {
            myCircle.setRadius(i);
            System.out.printf("Area is:%.2f\n",myCircle.getArea());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        SimpleCircle circle = new SimpleCircle();
        printAreas(circle,n);
    }
}

class SimpleCircle {
    private int radius;//半径
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}


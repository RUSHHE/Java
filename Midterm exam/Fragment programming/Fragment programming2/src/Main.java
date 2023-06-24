/**
 * 给方法传递对象参数。
 * 【问题描述】设计一个static方法printAreas(），包含2个参数，一个是SimpleCircle类类型, 用于计算面积，一个是int类型，表示输出的次数。在main（）方法中调用printAreas(）方法，实现输出。
 * 3
 * 4.0
 * 【样例输出】
 * Input times:
 * Input radius:
 * Area is:50.27
 * Area is:50.27
 * Area is:50.27
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input times:");//别忘了提示哦
        int n = scan.nextInt();

        System.out.print("Input radius:");
        double r = scan.nextDouble();

        SimpleCircle myCircle = new SimpleCircle(r);
        printAreas(myCircle, n);
    }

    //定义printAreas()方法
    static void printAreas(SimpleCircle myCircle, double n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("Area is:%.2f\n", myCircle.getArea());
        }
    }
}

//定义SimpleCircle类
class SimpleCircle {
    double radius;

    public SimpleCircle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}


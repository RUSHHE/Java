/**
 * 矩形类应用
 * 【问题描述】
 * 实现Rectangle类。类定义如下:
 * ●属性width和height的类型为double，分别表示矩形的宽和高。width和height的默认值都为1.0。
 * ●定义一个无参构造方法。
 * ●定义一个指定width和height值的构造方法。
 * ●定义一个getArea()的方法，返回该矩形的面积（double类型）。
 * ●定义一个getPerimeter()的方法，返回周长（double类型）。
 * ●分别定义对应的get和set方法修改和访问width和height。
 * 编写一个测试程序，创建一个Rectangle对象，按顺序分别输入width和height。程序分别调用相应方法按顺序显示矩形的宽、高、面积和周长。
 * 【输入形式】控制台
 * 【输出形式】控制台
 * 【样例输入】
 * 5
 * 5
 * 样例输出】
 * 5.0
 * 5.0
 * 25.0
 * 20.0
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Rectangle rectangle = new Rectangle(scan.nextDouble(), scan.nextDouble());

        System.out.printf("%.1f\n", rectangle.getWidth());
        System.out.printf("%.1f\n", rectangle.getHeight());
        System.out.printf("%.1f\n", rectangle.getArea());
        System.out.printf("%.1f\n", rectangle.getPerimeter());
    }
}

class Rectangle {
    double width;
    double height;

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getPerimeter() {
        if (getArea() == 0) { //哪里有一根线的周长要乘二的啊
            return getWidth() + getHeight();
        }
        return 2 * (getWidth() + getHeight());
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}


/**
 * 多态编程
 * 【问题描述】
 * 按以下要求编写程序
 * (1) 编写Animal接口，接口中声明run() 方法
 * (2) 定义Bird类和Fish类实现Animal接口
 * Bird中的run方法打印"Bird is flying...",Fish中的run方法打印"Fish is swimming..."
 * (3) 编写Bird类和Fish类的测试程序，并调用其中的run()方法，通过输入Bird和Fish，分别调用Bird类和Fish类中的run()方法。
 * 【输入形式】
 * Bird
 * 【输出形式】
 * Bird is flying...
 * 【样例输入】
 * Fish
 * 【样例输出】
 * Fish is swimming...
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        switch (scan.next()) {
            case "Bird":
                new Bird().run();
                break;
            case "Fish":
                new Fish().run();
                break;
            default:
                System.out.println("Input error!");
        }
    }
}

interface Animal {
    void run();
}

class Bird implements Animal {
    @Override
    public void run() {
        System.out.println("Bird is flying...");
    }
}

class Fish implements Animal {
    @Override
    public void run() {
        System.out.println("Fish is swimming...");
    }
}


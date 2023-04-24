/**
 * 编写程序，计算n=10000,20000,...,100000时pi的值。求pi的近视值公式如下：
 * pi=4*（1-1/3+1/5-1/7+1/9-1/11+1/13+...+1/(2n-1))
 * 要求使用循环计算n不同值时的pi的值。
 */
import java.util.Scanner;

public class Main {
    //计算Pi的方法
    public static double cal_Pi(int n) {
        double pi = 0;
        for (int i = 1; i <= n; i++) {
            pi += Math.pow(-1, i + 1) * 1 / (2 * i - 1);
        }
        pi *= 4;
        return pi;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a number(10000-100000):");
        int n = scan.nextInt();
        if (!(n >= 10000 && n <= 100000)) {
            System.out.println("The input data is out of range!");
            System.exit(1);
        }
        System.out.println("PI=" + cal_Pi(n));
    }
}
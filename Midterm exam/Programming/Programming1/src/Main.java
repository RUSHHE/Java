/**
 * 计算课程平均成绩。
 * 【问题描述】输入学生人数，输入每个人的课程成绩，计算课程平均成绩。
 * 【样例输入】
 * 5
 * 77 88 27 65 52
 * 【样例输出】The average score is:61.8
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        if (n == 0) { //别忘了结果不能除以零，期中考就在这犯错了
            System.out.println("The average score is:0");
            System.exit(0);
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scan.nextInt();
        }

        System.out.printf("The average score is:%.1f", sum / n);
    }
}


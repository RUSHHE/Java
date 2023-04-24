import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] score = new double[n];

        //录入数据，并记录最大最小值
        int max = 0, min = 0;//记录最大值最小值的编号
        for (int i = 0; i < n; i++) {
            score[i] = scan.nextDouble();
            if (i != 0) {
                if (score[max] < score[i]) {
                    max = i;
                }
                if (score[min] > score[i]) {
                    min = i;
                }
            }
        }

        //计算平均值
        double avg = 0;//avg是平均值
        for (int i = 0; i < n; i++) {
            if (i == max || i == min) {
                continue;
            }
            avg += score[i];
        }
        avg /= n-2;
        System.out.printf("average score:%.2f",avg);
    }
}
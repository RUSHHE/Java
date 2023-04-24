import java.util.Scanner;

public class Main {
    public static boolean isPrime(int num) {
        boolean sign = false;//其实写的不完整，有的数既不是素数又不是合数

        int i;//循环系数放在外面，后面还要用
        for (i = 2; i < num; i++) {
            if (num % i == 0) {
                break;//能给整除就直接不用判断了
            }
        }

        if (num == i) {
            sign = true;//一直不能整除就是合数
        }
        return sign;
    }

    /*Thx to ChatGPT
     *感恩！
     */
    public static int reverse(int num) {
        int newNum = 0;
        while (num != 0) {
            newNum = newNum * 10 + num % 10;//递推，一步一步升位
            num /= 10;//原数降位
        }
        return newNum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();//求的非回文素数数量
        int[] primeNum = new int[n];

        //求非回文素数
        int i = 0, sign = 0;
        while (sign < n) {
            if ((isPrime(i) && isPrime(reverse(i))) && i != reverse(i)) {
                primeNum[sign++] = i;
            }
            i++;
        }

        //输出
        for (int j = 0; j < n; j++) {
            System.out.print(primeNum[j] + " ");
            if ((j + 1) % 10 == 0) {
                System.out.print("\n");
            }
        }
    }
}
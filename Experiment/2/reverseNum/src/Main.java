import java.util.Scanner;

public class Main {
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

        System.out.println(reverse(scan.nextInt()));
    }
}
import java.util.Scanner;

public class Main {
    public static void reverse(int number) {
        while (number / 10 != 0) {
            System.out.print(number % 10);
            number /= 10;
        }
        System.out.print(number);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        reverse(n);
    }
}
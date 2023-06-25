import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double degree = scan.nextDouble();
        System.out.printf("F:%.2f C:%.2f", degree, (degree - 32) * (5d / 9d));
    }
}
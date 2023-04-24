import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("leg:");
        int leg = scan.nextInt();

        System.out.println("head:");
        int head = scan.nextInt();

        for (int i = 0, j = head - i; i <= head || j >= 0; i++, j--) {//i是只因，j是兔兔
            if (i * 2 + j * 4 == leg) {
                System.out.printf("chick=%d,hare=%d", i, j);
                System.exit(0);
            }
        }
        System.out.println("input error.");
    }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numerator = scan.nextInt();
        int denominator = scan.nextInt();
        String out = Double.toString((double) numerator/denominator);
        System.out.println(""+out);
    }
}
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double l,w;//l是长，w是宽
        Scanner scan = new Scanner(System.in);
        l = scan.nextDouble();
        w = scan.nextDouble();
        double square = l*w;
        System.out.printf("The area is:%.2f",square);
    }
}
import java.util.Scanner;

public class Main {
    public static int cube(int n) {
        return (int) Math.pow(n, 3);
    }

    public static float cube(float n) {
        return (float) Math.pow(n, 3);
    }

    public static double cube(double n) {
        return Math.pow(n, 3);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please input a int number a:");
        int a = scan.nextInt();
        System.out.println("invoke int cube()");
        System.out.println("Cube of a is:" + cube(a));

        System.out.println("Please input a float number b:");
        float b = scan.nextFloat();
        System.out.println("invoke float cube()");
        System.out.println("Cube of b is:" + cube(b));

        System.out.println("Please input a double number c:");
        double c = scan.nextDouble();
        System.out.println("invoke double cube()");
        System.out.println("Cube of c is:" + cube(c));
    }
}
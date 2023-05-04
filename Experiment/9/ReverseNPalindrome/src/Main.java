import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("enter a string:");
        String string = scan.nextLine();
        System.out.println("reverse is:" + reverse(string));
        System.out.println("ispalindrome:" + isPalindrome(string));
    }

    public static String reverse(String s) {
        StringBuilder reverseString = new StringBuilder(s);

        return reverseString.reverse().toString();
    }

    public static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }
}
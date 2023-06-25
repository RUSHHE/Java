import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        int sign = 0, max = 0;
        for (int i = 0; i == 0 || arr.get(i - 1) != 0; i++) {
            arr.add(scan.nextInt());
            if (i == 0 && arr.get(i) == 0) {
                System.out.println("Only 0 is inputed.");
                System.exit(0);
            }

            if (arr.get(i) > max) {
                max = arr.get(i);
                sign = 1;
            } else if (arr.get(i) == max) {
                sign++;
            }
        }

        System.out.println("max is:" + max);
        System.out.println("The count of the max number is:" + sign);
    }
}
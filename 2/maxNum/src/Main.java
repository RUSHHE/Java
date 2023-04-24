import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        int sign = 0,max = 0;
        for (int i = 0; i == 0 || arr.get(i-1) != 0; i++) {
            int temp = scan.nextInt();
            if (i == 0 && temp == 0){
                System.out.println("Only 0 is inputed.");
                System.exit(1);
            }
            else {
                arr.add(temp);
                if (arr.get(i) > max){
                    max = arr.get(i);
                    sign = 1;
                } else if (arr.get(i) == max) {
                    sign++;
                }
            }
        }
        System.out.println("max is:" + max);
        System.out.println("The count of the max number is:" + sign);
    }
}
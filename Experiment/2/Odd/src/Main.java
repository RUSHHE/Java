import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stNum = scan.nextInt();
        int ndNum = scan.nextInt();
        if (stNum > ndNum) {
            int temp;
            temp = stNum;
            stNum = ndNum;
            ndNum = temp;
        }
        int oddAddResult = 0;
        for (int i = stNum; i <= ndNum; i++) {
            if (i % 2 == 0) {
                continue;
            }
            oddAddResult += i;
        }
        System.out.println(oddAddResult);
    }
}
/**
 * 第三版代码
 */

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        System.out.println("Enter n: ");
        int n = scan.nextInt();

        System.out.println("Enter n numbers: ");
        for (int i = 0; i < n; i++) {
            linkedHashSet.add(scan.nextInt());
        }

        System.out.println("The number of distinct values is " + linkedHashSet.size());
        for (int i : linkedHashSet) {
            System.out.print(i + " ");
        }
    }
}
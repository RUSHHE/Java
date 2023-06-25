/**
 * 第二版代码
 */

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();//动态数组

        System.out.println("Enter n: ");
        int n = scan.nextInt();

        System.out.println("Enter n numbers: ");
        for (int i = 0; i < n; i++) {
            arr.add(scan.nextInt());
        }

        //遍历动态数组，删除重复数字
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (Objects.equals(arr.get(i), arr.get(j))){
                    arr.remove(j);
                    j--;
                }
            }
        }

        System.out.println("The number of distinct values is " + arr.size());
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
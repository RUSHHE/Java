/**
 * 第一版代码
 */

import java.util.Scanner;

public class Main1 {
    public static int[] delete_Repeat_Num(int[] arr) {
        int[] flag = new int[arr.length];//创建一个标记数组
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    flag[j] = 1;//重复数字在标记数组里标记为1
                }
            }
        }

        int flatSum = 0;
        //增强for循环，可以找到重复数字的个数
        for (int i : flag) {
            flatSum += i;
        }

        int[] newArr = new int[arr.length - flatSum];//精简后的数组
        int index = 0;//新数组的下标
        for (int i = 0; i < arr.length; i++) {
            if (flag[i] == 0) {
                newArr[index++] = arr[i];//把不重复的数复制过来
            }
        }

        return newArr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter n: ");//数组的成员数量n
        int n = scan.nextInt();

        System.out.println("Enter n numbers: ");
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scan.nextInt();
        }

        int[] newNum = delete_Repeat_Num(num);
        System.out.println("The number of distinct values is " + newNum.length);
        for (int i : newNum) {
            System.out.print(i + " ");
        }
    }
}
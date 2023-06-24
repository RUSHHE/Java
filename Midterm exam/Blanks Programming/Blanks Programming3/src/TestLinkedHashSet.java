/**
 * 输入字符串“how are you?how do you do.”后，下列程序的运行结果是     how are you how do you do      【 正确答案: how are you do】
 * //说明split函数的功能是按照中括号里面的单个字符进行分割，返回分割后的多个字符串。
 */

import java.util.*;
public class TestLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();//LinkHashSet
        input(set);
        for (String s : set) {
            System.out.print(s + " ");
        }
    }

    public static void input(LinkedHashSet<String> hs) {
        Scanner sc = new Scanner(System.in);
        String names = sc.nextLine();
        String[] nameArray = names.split("[.? ]");
        hs.addAll(Arrays.asList(nameArray));
    }
}
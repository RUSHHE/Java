import java.util.Scanner;

public class Work6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        StringBuilder sb = new StringBuilder("");

        // 初始化当前字符和计数器
        char current = str.charAt(0);
        int count = 1;
        // 遍历字符串中的每个字符
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i + 1) == str.charAt(i)) {
                // 如果下一个字符与当前字符相同，则计数器加1
                count++;
            } else if (count == 1) {
                // 如果计数器为1，则只添加当前字符
                sb.append(current);
                current = str.charAt(i + 1);
            } else {
                // 否则，添加当前字符和计数器
                sb.append(current).append(count);
                current = str.charAt(i + 1);
                count = 1;
            }
        }
        // 处理最后一个字符
        if (count == 1) sb.append(current);
        else sb.append(current).append(count);

        System.out.println(sb.toString());
    }
}
/**
 * 往文本文件temp20.txt中写入n整数，然后从文件中读出来，并计算。其结果为：     Total is 50      【 正确答案: 50】
 * //说明：StringTokenizer类功能说明
 * //StringTokenizer(String str) ：构造一个用来解析 str 的 StringTokenizer 对象。java 默认的分隔符是空格("")、制表符(\t)、换行符(\n)、回车符(\r)。
 * //boolean hasMoreTokens()：返回是否还有分隔符。
 * //String nextToken()：返回从当前位置到下一个分隔符的字符串。
 */

import java.io.*;
import java.util.StringTokenizer;

public class TestPrintWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("temp20.txt");
        PrintWriter output = new PrintWriter(new FileWriter(file));
        for (int i = 0; i < 5; i++) {
            output.print(i * 5 + " ");
        }
        output.close();
        BufferedReader input = new BufferedReader(new FileReader("temp20.txt"));
        int total = 0;
        String line;
        while ((line = input.readLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line);
            while (tokens.hasMoreTokens())
                total += Integer.parseInt(tokens.nextToken());
        }
        System.out.println("Total is " + total);
        input.close();
    }
}

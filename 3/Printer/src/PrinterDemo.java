import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

class Printer {
    final int maxSpeed = 21;
    final int lineMaxWords = 20;
    PrintStream out;
    int status;
    String brand;
    int printedWords;

    {
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            e.printStackTrace();
        }
    }

    /**
     * 向控制台输出回车符
     */
    void carriageReturn() {
        //添加处理代码
        out.print("\r");
        printedWords = 0;
    }

    /**
     * 向控制台输出换行符
     */
    void newLine() {
        //添加处理代码
        out.print("\n");
        printedWords = 0;
    }

    /**
     * 向控制台输入字符  如果当前行已经达到最大输出字符数-1，则输出后进行回车换行，当前行输入字符数清0；否则输出字符，当前行输入字符数加1
     *
     * @param c 待输出的字符
     */
    void print(char c) {
        //添加处理代码
        if (printedWords > lineMaxWords - 1) {
            carriageReturn();
            newLine();
        }
        out.print(c);
        printedWords++;
    }

    /**
     * 向控制台输出字符串
     *
     * @param s 待输出的字符串
     */
    void print(String s) {
        //添加处理代码
        for (char i : s.toCharArray()) {
            out.print(i);
        }
    }
}

public class PrinterDemo {

    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub
        Printer p = new Printer();
        p.brand = "HP";
        p.status = 1;
        p.printedWords = 0;
        p.print('A');
        p.print("我和我的祖国");
        p.print("我和我的祖国一刻也不能分割。" +
                "无论我走到哪里都流出一首赞歌。" +
                "我歌唱每一座高山我歌唱每一条河，" +
                "袅袅炊烟小小村落路上一道辙，" +
                "你用你那母亲的脉搏和我诉说。" +
                "我的祖国和我像海和浪花一朵，" +
                "浪是海的赤子海是那浪的依托，" +
                "每当大海在微笑我就是笑的旋涡。" +
                "我分担着海的忧愁分享海的欢乐，" +
                "永远给我碧浪清波心中的歌，" +
                "啦啦…永远给我碧浪清波心中的歌。");
    }

}
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
/*
根据孙悟空把毫毛变猴子的故事，编写一个多线程程序模拟孙悟空，创建若干个猴子。每个猴子创建出来后自报姓名。
  */

public class WuKong {

    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub
        print("俺老孙在此，妖怪休要猖狂！变……\n");
        for (int i = 0; i < 10; i++) {
            new Monkey("猴爷爷" + i).start();
        }
        print("孩儿们，上……\n");
    }

    private static void print(String message) {
        PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8);
        ps.print(message);
    }
}

class Monkey extends Thread {

    private PrintStream out;
    String name;

    {
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            e.printStackTrace();
        }
    }

    public Monkey(String name) {
        this.name = name;
    }

    //嗨害嗨，来啦
    @Override
    public void run() {
        out.print(name + " 来了！\n");
    }
}

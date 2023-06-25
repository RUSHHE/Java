import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

class SingletonScanner {
    private static SingletonScanner singletonScanner;
    private final Scanner input;

    private SingletonScanner() {
        input = new Scanner("System.in");
    }

    public static SingletonScanner getInstance() {
        if (singletonScanner == null) {
            singletonScanner = new SingletonScanner();
        }
        return singletonScanner;
    }

    public Scanner getInput() {
        return input;
    }
}

public class SingletonScannerDemo {
    private static PrintStream out;

    static {
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SingletonScanner sScanner01 = SingletonScanner.getInstance();
        SingletonScanner sScanner02 = SingletonScanner.getInstance();

        Scanner input01 = sScanner01.getInput();
        Scanner input02 = sScanner02.getInput();

        if (sScanner01 == sScanner02) {
            out.println("sScanner01和sScanner02,它们是同一个对象");
        } else {
            out.println("sScanner01和sScanner02,它们不是同一个对象");
        }

        {
            SingletonScanner sScanner03 = SingletonScanner.getInstance();
            if (sScanner01 == sScanner03) {
                out.println("sScanner01和sScanner03,它们是同一个对象");
            } else {
                out.println("sScanner01和sScanner03,它们不是同一个对象");
            }
        }

        if (sScanner01 == sScanner02) {
            out.println("sScanner01和sScanner02,它们是同一个对象");
        } else {
            out.println("sScanner01和sScanner02,它们不是同一个对象");
        }

        //思考：下面的语句解除注释，能够运行。执行并观察结果，说明原因。
//                if(sScanner01  ==  sScanner03){
//                        System.out.println("sScanner01和sScanner03,它们是同一个对象");
//                }else{
//                        System.out.println("sScanner01和sScanner03,它们不是同一个对象");
//                }

        if (input01 == input02) {
            out.println("input01和input02,它们指向同一个对象。");
        } else {
            out.println("input01和input02,它们指向不同的对象。");
        }

        input01.close();

        if (input01 == input02) {
            out.println("input01和input02,它们指向同一个对象。");
        } else {
            out.println("input01和input02,它们指向不同的对象。");
        }

        //思考：下面的语句解除注释，能够运行。执行并观察结果，说明原因。
        //input02.next();
    }
}
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class CalcDemo {
    private static PrintStream out;
    private static Scanner input;

    static {
        input = new Scanner(System.in);
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //  TODO  Auto-generated  method  stub
        oneBitFullAdder();
        threeBitFullAdder();
    }

    private static void oneBitFullAdder() {
        Calculator myCalculator = new Calculator();
        myCalculator.add(0, 1, 0);
        myCalculator.setDisplay(true);
        myCalculator.add(1, 1, myCalculator.getCarry());
    }

    private static void threeBitFullAdder() {
        Calculator firstCalc = new Calculator();
        Calculator secondCalc = new Calculator();
        Calculator thirdCalc = new Calculator();
        firstCalc.setDisplay(false);
        secondCalc.setDisplay(false);
        thirdCalc.setDisplay(false);
        out.println("三位全加器运算");
        out.print("输入第1个二进制数（如101）：");

        int first = input.nextInt();
        out.print("输入第2个二进制数（如011）：");
        int second = input.nextInt();
        if (first / 1000 != 0 || second / 1000 != 0) {
            out.println("输入的数据不是三位数，请检查。");
            return;
        }
        int firstTopDigit, firstSecondDigit, firstLowDigit;
        int secondTopDigit, secondSecondDigit, secondLowDigit;

        firstTopDigit = first / 100 % 10;
        firstSecondDigit = first / 10 % 10;
        firstLowDigit = first % 10;

        secondTopDigit = second / 100 % 10;
        secondSecondDigit = second / 10 % 10;
        secondLowDigit = second % 10;

        if (firstTopDigit > 1 || firstSecondDigit > 1 || firstLowDigit > 1 ||
                secondTopDigit > 1 || secondSecondDigit > 1 || secondLowDigit > 1) {
            out.println("输入的数据不是二进制数表示。提示：输入数据的每一位仅能使用0或1");
            return;
        }

        firstCalc.add(firstLowDigit, secondLowDigit, 0);
        secondCalc.add(firstSecondDigit, secondSecondDigit, firstCalc.getCarry());
        thirdCalc.add(firstTopDigit, secondTopDigit, secondCalc.getCarry());
        out.println("c3" + "\t" + "s3" + "\t" + "s2" + "\t" + "s1");
        out.println(thirdCalc.getCarry() + "\t" + thirdCalc.getNumber() + "\t" + secondCalc.getNumber() + "\t" + firstCalc.getNumber());
    }
}

class Calculator {
    //你早说这个是除二取余法就不用这么麻烦了QAQ
    int number;
    int carry;
    //包含一个number表示本位值，包含一个carry表示进位
    boolean isDisplay;
    PrintStream out;//为了实现在CG中输出中文，需要将标准的输出流进行转换，请大家使用这个out对象进行输出，具体使用同System.out

    {
        try {
            out = new PrintStream(System.out, false, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //  TODO  Auto-generated  catch  block
            //e.printStackTrace();
        }
    }

    public void add(int i, int j, int k) {
        int sum = i + j + k;
        number = sum % 2;
        carry = sum / 2;
        if (isDisplay) {
            display();
        }
    }

    public int getNumber() {
        return number;
    }

    public int getCarry() {
        return carry;
    }

    public void setDisplay(boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public void display() {
        out.println("\t0\t1");
        out.println("\t^\t^");
        out.println("\t|\t|");
        out.println("--------------------------------");
        out.println("|                              |");
        out.println("|               &              |");
        out.println("|                              |");
        out.println("--------------------------------");
        out.println("\t^\t^\t^");
        out.println("\t|\t|\t|");
        out.println("\t1\t1\t0");
    }
}
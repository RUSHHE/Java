import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        PrintStream out = new PrintStream(System.out, false, "UTF-8");
        Scanner sc = new Scanner(System.in);
//                System.out.println("我们测试100000个随机数的排序时间。\n将在输入第1个任意字符开始排序计时。");
        out.println("我们测试100000个随机数的排序时间。\n将在输入第1个任意字符开始排序计时。");
        StopWatch sw = new StopWatch();

        int[] numbers = new int[100000];
        //添加代码，使用java.util.Random为numbers产生随机数
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(10000);
        }
        sc.next();
        sw.start();
        //添加代码，采用你熟悉的排序算法，对numbers中的数进行排序，要求从小到大排序
        for (int i = 0; i < numbers.length; i++) {
            int min = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[min] > numbers[j]){
                    min = j;
                }
            }
            int temp;
            temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
        }
        sw.stop();

        out.println((checkOrder(numbers) ? "排序成功" : "排序不成功") + ",此次排序一共花费了：" + sw.getElapsedTime() + "毫秒");
    }

    private static boolean checkOrder(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1])
                return false;
        }
        return true;
    }
}
/**
 * 计时器类
 * 要求包含startTime表示计时开始时间，endTime表示计时结束时间
 * start和end方法分别用于记录开始和结束时间
 * getElapsedTime方法用于计算startTime到endTime之间的间隔时间，得到一个毫秒值
 *
 * @author XXX
 */
class StopWatch{
    private long startTime;
    private long endTime;
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void stop(){
        endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime - startTime;
    }
}

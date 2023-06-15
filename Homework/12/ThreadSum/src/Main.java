public class Main {
    public static final int THREAD_NUM = 10;

    public static void main(String[] args) throws InterruptedException {
//        Scanner scan = new Scanner(System.in);
//        int num = scan.nextInt();
        int num = 100;
        int interval = num / THREAD_NUM;
        int remainder = num % THREAD_NUM;
        CalcSum[] calcSum = new CalcSum[THREAD_NUM];
        Thread[] threads = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            //计算每个任务的起始值和结束值，考虑到余数的情况
            int start = interval * i + 1 + Math.min(i, remainder);
            int end = interval * (i + 1) + Math.min(i + 1, remainder);
            //使用构造方法传入起始值和结束值
            calcSum[i] = new CalcSum(start, end);
            threads[i] = new Thread(calcSum[i]);
            threads[i].start();
        }
        //定义一个变量存储最终结果
        int result = 0;
        //循环等待所有线程结束，并累加每个任务的结果
        for (int i = 0; i < THREAD_NUM; i++) {
            //等待当前线程结束
            threads[i].join();
            //累加当前任务的结果
            result += calcSum[i].getResult();
            System.out.println(threads[i].getName() + ":" + calcSum[i].getResult());
        }
        //打印最终结果
        System.out.println("result:" + result);
    }
}

class CalcSum implements Runnable {
    private final int start;

    private final int end;

    private int result;

    //定义一个构造方法，传入起始值和结束值，并赋值给变量
    public CalcSum(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        result = 0;
        for (int i = start; i <= end; i++) {
            result += i;
        }
    }

    public int getResult() {
        return result;
    }
}
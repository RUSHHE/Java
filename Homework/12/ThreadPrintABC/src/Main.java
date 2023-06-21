import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        //创建一个ReentrantLock对象，使用公平锁
        ReentrantLock lock = new ReentrantLock(true);
        //创建三个Runnable对象，分别对应A、B、C线程
        Runnable a = new PrintTask('A', lock);
        Runnable b = new PrintTask('B', lock);
        Runnable c = new PrintTask('C', lock);
        //启动三个线程
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }
}

class PrintTask implements Runnable {

    private final char threadName;
    private final ReentrantLock lock;

    //定义一个静态变量，表示当前应该执行的线程
    private static char currentThread = 'A';

    //定义一个构造方法，传入线程名称和锁对象
    public PrintTask(char threadName, ReentrantLock lock) {
        this.threadName = threadName;
        this.lock = lock;
    }

    @Override
    public void run() {
        //循环10次
        for (int i = 0; i < 10; i++) {
            //获取锁
            lock.lock();
            try {
                //如果当前线程与当前应该执行的线程不一致，就让出锁，并等待一段时间
                while (threadName != currentThread) {
                    lock.unlock();
                    Thread.sleep(10);
                    lock.lock();
                }
                //打印当前线程的名称，并根据名称改变当前应该执行的线程
                System.out.print(threadName);
                switch (threadName) {
                    case 'A':
                        currentThread = 'B';
                        break;
                    case 'B':
                        currentThread = 'C';
                        break;
                    case 'C':
                        currentThread = 'A';
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //释放锁
                lock.unlock();
            }
        }
    }
}
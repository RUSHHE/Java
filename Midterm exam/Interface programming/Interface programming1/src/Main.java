/**
 * 接口ToDrink的实现和测试
 * 定义一个ToDrink接口，接口中包含void drink()方法，Baby、Adult、YoungPeople类分别实现该接口。
 * 在测试方法中生成这三个类的对象，并依次调用他们的drink方法，drink的内容来自于命令行参数
 * 第1个参数提供给Baby，第2个参数提供给YoungPeople，第3个参数提供给Adult
 * 样例（命令行参数：mike water tea）
 * mike...
 * water...
 * tea...
 */
interface ToDrink {
    void drink();
}

public class Main {
    public static void main(String[] args) {
        new Baby(args[0]).drink();
        new YoungPeople(args[1]).drink();
        new Adult(args[2]).drink();
    }
}

class Baby implements ToDrink {
    private final String Drinking;

    public Baby(String Drinking) {
        this.Drinking = Drinking;
    }

    @Override
    public void drink() {
        System.out.println(Drinking + "...");
    }
}

class YoungPeople implements ToDrink {
    private final String Drinking;

    public YoungPeople(String Drinking) {
        this.Drinking = Drinking;
    }
    @Override
    public void drink() {
        System.out.println(Drinking + "...");
    }
}

class Adult implements ToDrink {
    private final String Drinking;

    public Adult(String Drinking) {
        this.Drinking = Drinking;
    }
    @Override
    public void drink() {
        System.out.println(Drinking + "...");
    }
}
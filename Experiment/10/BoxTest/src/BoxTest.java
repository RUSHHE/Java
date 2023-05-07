/**
 *程序形参 123 tom
 */
//Box  class
class Box<T> {
    T box;

    public void add(T box) {
        this.box = box;
    }

    public T get() {
        return box;
    }
}

public class BoxTest {

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(Integer.valueOf(args[0])));
        stringBox.add(new String(args[1]));

        System.out.printf("Integer  is  :%d\n", integerBox.get());
        System.out.printf("String  is  :%s\n", stringBox.get());
    }

}
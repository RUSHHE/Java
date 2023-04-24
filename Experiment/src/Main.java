public class Main {
    int m = 5;
    public void some(int x) {
        m = x;
    }

    public static void main(String[] args) {
        new Demo().some(7);
    }
}

class Demo extends Main {
    int m = 8;
    public void some(int x) {
        super.some(x);
        System.out.println(m);
    }
}
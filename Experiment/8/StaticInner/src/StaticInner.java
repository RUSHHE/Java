public class StaticInner {

    public static void main(String[] args) {
        StaticInner out = new StaticInner();

        Inner obj = new Inner();  //  需要创建外部类实例

        obj.print(1);

        out.method1();

    }

    public void method1() {
        Inner obj = new Inner();  //  不需要创建外部类实例
        obj.print(2);
    }

    static class Inner {
        public void print(int a) {
            System.out.println("NotStaticInner " + a);
        }
    }
}

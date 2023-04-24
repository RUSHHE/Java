interface Polygon {
    void display();
}

public class AnonymousDemo {

    public static void main(String[] args) {
        //  创建的匿名类继承了  Polygon  接口

//        Polygon p1 = () -> System.out.println("In Anonymous Interface");
        Polygon p1 = new Polygon() {
            @Override
            public void display() {
                System.out.println("In Anonymous Interface");
            }
        };
        p1.display();
    }
}

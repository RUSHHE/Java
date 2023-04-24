class Polygon {
    public void display() {
        System.out.println("In Polygon");
    }
}

public class AnonymousDemo {

    public static void main(String[] args) {

        Polygon p = new Polygon();
        p.display();

        //  创建的匿名类继承了  Polygon  类
        Polygon p1 = new Polygon() {
            public void display() {
                System.out.println("In Anonymous Class");
            }
        };

        p1.display();
    }
}
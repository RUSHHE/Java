abstract class Water {
    public abstract void drink();

    public abstract String toString();
}

//class  Nongfu  and  class  Wahaha
class Nongfu extends Water {
    @Override
    public void drink() {
        System.out.print("I like Nongfu");
    }

    @Override
    public String toString() {
        return "Nongfu";
    }
}

class Wahaha extends Water {
    @Override
    public void drink() {
        System.out.print("I like Wahaha");
    }

    @Override
    public String toString() {
        return "Wahaha";
    }
}

public class WaterTest {
    public static void main(String[] args) {
        Water[] wine = new Water[2];
        wine[0] = new Nongfu();
        wine[1] = new Wahaha();

        m(wine[0]);
        m(wine[1]);
    }

    public static void m(Water water) {
        water.drink();
        System.out.println("--My water is:" + water);//省略了toString
    }
}
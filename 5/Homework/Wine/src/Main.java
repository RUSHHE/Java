public class Main {
    public static void main(String[] args) {
        Wine[] wine = new Wine[2];
        wine[0] = new JNC();
        wine[1] = new WLY();

        m(wine[0]);
        m(wine[1]);
    }

    public static void m(Wine wine) {
        wine.drink();
        //这输出格式错了0^0
        if (wine instanceof JNC) {
            System.out.println("--My wine is:" + wine);//省略了toString
        } else if (wine instanceof WLY) {
            System.out.println("--My  wine  is:" + wine);//省略了toString
        }
    }
}

abstract class Wine {
    public abstract void drink();
    public abstract String toString();
}

class JNC extends Wine {
    @Override
    public void drink() {
        System.out.print("Wine:JNC");
    }

    @Override
    public String toString() {
        return "JNC";
    }
}

class WLY extends Wine {
    @Override
    public void drink() {
        System.out.print("Wine:WLY");
    }

    @Override
    public String toString() {
        return "WLY";
    }
}
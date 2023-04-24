import java.util.Scanner;

public class ExceptionDemo {
    public static void efun(int r) throws MyException {
        if (r < 0) {
            throw new MyException(r);
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        try {
            efun(r);
            System.out.println("radius is: " + r);
        } catch (MyException e) {
            System.out.println(e.toString());
        } finally {
            System.out.println("Exception is processed");
        }
    }

}

class MyException extends Exception {
    int r;
    public MyException(int r) {
        this.r = r;
    }

    public String toString() {
        return "MyException:" + r;
    }
}
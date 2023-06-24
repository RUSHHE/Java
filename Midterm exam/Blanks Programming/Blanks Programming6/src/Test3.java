/**
 * 6
 */
public class Test3 {
    public static void main(String[] args) {
        int i = 5;
        while (i <= 5) {
            xMethod(i);
            i++;
        }
    }
    public static void xMethod(int i) {
        int num = 1;

        for (int j = 0; j < i; j++) {
            System.out.print(num + " ");
            num *= 3;
        }
        System.out.println();
    }
}

import java.util.ArrayList;

class Solution {
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        ArrayList<Integer> fib = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                fib.add(1);
                if (n == 1 || n == 2) {
                    return 1;
                }
            }else if (i >= 3) {
                fib.add(fib.get(0) + fib.get(1));
                fib.remove(0);
            }
        }
        return (fib.get(1) % 1000000007);
    }
    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}


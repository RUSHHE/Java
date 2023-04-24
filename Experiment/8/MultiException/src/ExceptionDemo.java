class DivDemo {
    int div(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        int[] arr = new int[a];
        System.out.println(arr[10]);
        return a / b;
    }
}

public class ExceptionDemo {

    public static void main(String[] args) {
        DivDemo d = new DivDemo();
        int type = Integer.parseInt(args[0]);
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        try {
            if (type < 0) {
                //  add  throw  Exception
                throw new Exception("NegativeException");
            }
            int x = d.div(a, b);
            System.out.println("x=" + x);
        } catch (ArithmeticException e) {//  add  two  catch
            System.out.println("ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (Exception e) {//  add  catch
            System.out.println(e.toString());
        } finally {
            System.out.println("Over");
        }
    }
}
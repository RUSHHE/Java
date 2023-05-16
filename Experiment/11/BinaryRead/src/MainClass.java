import java.io.*;


public class MainClass {
    public static void write(String[] args, String fileName) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));

            for (String str : args) {
                out.writeInt(Integer.valueOf(str));
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //public  static  void  read(String  fileName)
    public static void read(String fileName) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(fileName));
            int sum = 0;

            while (in.available() > 0) {
                sum += in.readInt();
            }

            System.out.println("The sum is:" + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write(args, "test.dat");
        read("test.dat");
    }
}
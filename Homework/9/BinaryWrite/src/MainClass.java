import java.io.*;

public class MainClass {

    //public static void write(String[] args,String fileName)
    public static void write(String[] args, String fileName) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
            for (String i : args) {
                out.writeInt(Integer.parseInt(i));
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(String fileName) {

        int sum = 0;
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(fileName));
            while (in.available() > 0) {
                sum += in.readInt();
            }
            System.out.println("The  sum  is:" + sum);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write(args, "test.dat");
        read("test.dat");

    }
}

import java.io.*;

public class FileReadAndWrite {

    public static void main(String[] args) {
        write(args);
        read("test.txt");

    }
    //public  static  void  read(String  filename)
    public static void read(String filename) {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void write(String[] args) {

        try {
            FileWriter writer = new FileWriter("test.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            for (int i = 0; i < args.length; i++) {
                bw.write(args[i] + '\n');
            }

            bw.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

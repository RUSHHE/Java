import  java.io.BufferedReader;
import  java.io.BufferedWriter;
import  java.io.FileNotFoundException;
import  java.io.FileReader;
import  java.io.FileWriter;
import  java.io.IOException;
import java.util.Arrays;

public  class  FileReadAndWrite{

    public  static  void  main(String[]  args)  {
        write(args);

        try  {
            //  read  file  content  from  file
            FileReader  reader  =  new  FileReader("test.txt");
            BufferedReader  br  =  new  BufferedReader(reader);
            String  str  =  null;
            while  ((str  =  br.readLine())  !=  null)  {
                System.out.println(str);
            }
            br.close();
            reader.close();
        }  catch  (IOException  e)  {
            e.printStackTrace();
        }
    }


    public  static  void  write(String[]  args)  {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));

            for (String str : args) {
                bw.write(str + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

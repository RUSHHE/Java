import java.io.*;
import java.net.Socket;

public class MultiClientSocket {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            socket = new Socket("127.0.0.1", 4567);
            System.out.println("Socket=" + socket);

            //用于发送给server端的信息
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            //用于接收Server端发来的信息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //注意首先向服务端发送消息,再接收服务端返回的休息,不要写反了
            pw.println("howdy ");
            pw.flush();
            //flush()一般用于处理中时需要将数据立即写出。将缓冲区的内容输出

            String str = br.readLine();
            System.out.println("拿到server返回的消息:" + str);
            pw.println("END");
            pw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                System.out.println("close......");

                if (br != null) {
                    br.close();
                }

                if (pw != null) {
                    pw.close();
                }

                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
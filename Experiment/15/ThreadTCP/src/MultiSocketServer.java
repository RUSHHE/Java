import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务器接收代码

public class MultiSocketServer {
    public static void main(String[] args) {
        ServerSocket s = null;
        Socket socket = null;

        try {
            s = new ServerSocket(4567);
            System.out.println("ServerSocket Start:" + s);

            //等待请求,此方法会一直阻塞,直到获得请求才往下走
            socket = s.accept();
            System.out.println("得到客户端地址:" + socket.getInetAddress());

            //调用线程类
            new ServerSocketThread(socket).start();
        } catch (Exception e) {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

//服务器线程服务类

class ServerSocketThread extends Thread {
    private final Socket socket;
    private BufferedReader br = null;
    private PrintWriter pw = null;
    //声明构造函数,接收客户端请求socket
    public ServerSocketThread(Socket s) {
        this.socket = s;
    }
    @Override
    public void run() {
        while(true) {
            try {
                //注意此处得到的socket的输入流为socket的输入流即上方的(private final Socket socket; )
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //向客户端返回消息的PrintWriter对象
                pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                String str = br.readLine();
                if(str.equals("END")){
                br.close();
                pw.close();
                socket.close();
                break;
                }
                System.out.println("Client Socket Message:" + str);
                pw.println("Message Received");
                pw.flush();
            } catch (Exception e) {
                try {
                    br.close();
                    pw.close();
                    socket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }
}
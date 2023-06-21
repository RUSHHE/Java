import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UdpSenderDemo {

    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(8808);

        //准备数据：使用System.in从控制台读取

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        //循环发送数据

        while (true) {

            String data = reader.readLine();

            byte[] datas = data.getBytes();//转换成字节

            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6677));

            socket.send(packet);

            if (data.equals("bye")) {
                break;
            }
        }
        socket.close();
    }
}